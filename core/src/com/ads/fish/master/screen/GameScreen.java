package com.ads.fish.master.screen;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Assets;
import com.ads.fish.master.Settings;
import com.ads.fish.master.actors.Area;
import com.ads.fish.master.controller.AreaController;
import com.ads.fish.master.controller.ChallengeController;
import com.ads.fish.master.controller.IController;
import com.ads.fish.master.controller.NetController;
import com.ads.fish.master.listener.NetDetector;
import com.ads.fish.master.listener.NetListener;
import com.ads.fish.master.window.ResultWin;
import com.ads.fish.master.window.SupsendWin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2014/6/24.
 */
public class GameScreen extends BaseScreen {
    private ScheduledExecutorService executorGateEnd;
    private ScheduledExecutorService executStarCount;
    private ScheduledExecutorService executTime;

    private ParticleEffect effect;
    private GateScreen gateScreen;
    private AreaController areaCtrl;
    private NetController pieceCtrl;
    private ChallengeController challengeCtrl;
    private NetDetector netDetector;
    private SupsendWin supsendWin;
    private InputMultiplexer multiplexer;
    private Actor[] pieces;
    private String timeStr;
    private Label labTime;
    private Label labCount;

    private boolean openResultWin;
    private boolean isPass;
    private boolean isSuspend;
    private boolean isUsedHelp;
    private boolean isUsingHelp;
    private int level;
    private int gateNum;
    private int areaId;
    private int seconds;
    private int starNum;
    private float c_top;
    private Label.LabelStyle yellowStyle;
    private Label.LabelStyle redStyle;
    private Label.LabelStyle whiteStyle;

    public GameScreen(GateScreen gs) {
        super(gs.getMaster());
        gateNum = -1;
        gateScreen = gs;
        executorGateEnd = Executors.newSingleThreadScheduledExecutor();
        isUsingHelp = true;
        yellowStyle = new Label.LabelStyle(getOtherFont(), Color.YELLOW);
        redStyle = new Label.LabelStyle(getOtherFont(), Color.RED);
        whiteStyle = new Label.LabelStyle(getQuizFont(), Color.WHITE);
    }

    @Override
    public void show() {
        if (!isShow()) {
            super.show();
            timeStr = "00:00";
            areaCtrl = new AreaController(IController.AREA_CTRL);
            addActor(areaCtrl);
            pieceCtrl = new NetController(IController.PIECE_CTRL);
            addActor(pieceCtrl); // 添加块组到舞台
            pieces = pieceCtrl.getChildren().begin();
            createTopBar();
            addLabels();
            challengeCtrl = new ChallengeController(level, gateNum, IController.CHALLENGE_CTRL);
            addActor(challengeCtrl);
            initEffect();
            createTimer();
            removeLayerBg();
            setShow(true);
        }
        multiplexer = new InputMultiplexer(); // 多输入接收器
        netDetector = new NetDetector(getStage(), new NetListener(getStage(), GameScreen.this));
        multiplexer.addProcessor(netDetector); // 添加手势识别
        multiplexer.addProcessor(getStage()); // 添加舞台
        Gdx.input.setInputProcessor(multiplexer); // 设置多输入接收器为接收器
    }

    private void buildNewGate(int num) {
        int lv = num / Answer.GATE_MAX;
        if (lv < Assets.LEVEL_MAX) {
            if (gateNum != -1 && num != gateNum) {
                refreshGame();
                if (challengeCtrl != null) {
                    challengeCtrl.buildChallenge(lv, num);
                }
                if (areaCtrl != null) {
                    areaCtrl.buildArea();
                }
            }
        }
        gateNum = num;
        level = lv;
    }

    private void createTopBar() {
        super.createBtns();
        ImageButton sos = new ImageButton(new TextureRegionDrawable(Assets.light));
        sos.setBounds(Assets.WIDTH - 3 * Assets.TOPBAR_HEIGHT, getY_bar(), Assets.TOPBAR_HEIGHT, Assets.TOPBAR_HEIGHT);
        sos.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (Settings.helpNum > 0) {
                    getMaster().getPEvent().sos(GameScreen.this);
                } else {
                    getMaster().getPEvent().invalidateSos();
                }
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(sos);

        ImageButton share = new ImageButton(new TextureRegionDrawable(Assets.barShare));
        share.setBounds(Assets.WIDTH - 2 * Assets.TOPBAR_HEIGHT, getY_bar(), Assets.TOPBAR_HEIGHT, Assets.TOPBAR_HEIGHT);
        share.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                getMaster().getPEvent().share();
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(share);

        ImageButton suspend = new ImageButton(new TextureRegionDrawable(Assets.suspend));
        suspend.setBounds(Assets.WIDTH - Assets.TOPBAR_HEIGHT, getY_bar(), Assets.TOPBAR_HEIGHT, Assets.TOPBAR_HEIGHT);
        suspend.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                suspendTimer();
                supsendWin = new SupsendWin(GameScreen.this, level);
                addActor(supsendWin);
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(suspend);

        returnBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gateScreen.buildGateImage(level);
                getMaster().setScreen(gateScreen);
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    private void addLabels() {
        BitmapFont font = getOtherFont();
        BitmapFont.TextBounds bounds = font.getBounds("00");
        labTime = new Label("", yellowStyle);
        labTime.setPosition(Assets.TOPBAR_HEIGHT, Assets.HEIGHT - Assets.TOPBAR_HEIGHT / 2);
        addActor(labTime);
        float w = bounds.width;
        labCount = new Label("", redStyle);
        labCount.setPosition(Assets.WIDTH - 3 * Assets.TOPBAR_HEIGHT - w / 3, Assets.HEIGHT - Assets.TOPBAR_HEIGHT / 2);
        addActor(labCount);

        String s = "按下面的规则,移动左上侧数字到右上侧九宫格中.";
        BitmapFont quizFont = getQuizFont();
        bounds = quizFont.getBounds(s);
        Label c = new Label(s, whiteStyle);
        c_top = Assets.HEIGHT - Assets.WIDTH - Assets.TOPBAR_HEIGHT - bounds.height;
        c.setPosition(0, c_top);
        addActor(c);
    }

    private void initEffect() {
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("data/test.p"), Gdx.files.internal("data/"));
    }

    private void changeStar() {
        Assets.playSound(Assets.starSound);
        executStarCount = Executors.newSingleThreadScheduledExecutor();
        executStarCount.scheduleAtFixedRate(new Runnable() {
            public void run() {
                areaId++;
                if (areaId < 6) {
                    Assets.playSound(Assets.starSound);
                }
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (!isSuspend && isClosedResultWin()) {
                gateScreen.setBackFlag(true);
                gateScreen.buildGateImage(level);
                getMaster().setScreen(gateScreen);
                return;
            }
        }
        super.render(delta);
        handleHelp();
        handlePass();
        labTime.setText(timeStr);
        labCount.setText(Settings.helpNum + "");
    }

    private void handleHelp() {
        if (isUsedHelp) {
            if (isUsingHelp) {
                changeStar();
                reset();
                isUsingHelp = false;
            }
            if (areaId < 6) {
                int temp = areaId;//防止定时器修改值不同步
                Area area = (Area) areaCtrl.getChildren().get(areaId);
                getBatch().begin();
                effect.setPosition(area.getX() + area.getWidth() / 2, area.getY() + area.getHeight() / 2);
                effect.draw(getBatch(), Gdx.graphics.getDeltaTime());
                getBatch().end();
                Integer[] answers = Answer.VALUES.get(gateNum);
                Integer pieceId = answers[temp];
            } else {
                isUsedHelp = false;
                areaId = 0;
                executStarCount.shutdown();
                multiplexer.addProcessor(netDetector); // 添加手势识别
                multiplexer.addProcessor(getStage());
            }
        }
    }

    private void reset() {
        areaId = 0;
        areaCtrl.handler();
        pieceCtrl.handler();
    }

    private void handlePass() {
        if (!isPass) {
            Gdx.input.setInputProcessor(multiplexer);
            handleGate();
        }
        if (openResultWin) {
            computerStarNum();
            addActor(new ResultWin(this, starNum));
            openResultWin = false;
            if (starNum == 0) {
                getMaster().getPEvent().spotAd();
            }
        }
    }

    private boolean isClosedResultWin() {
        Array<Actor> actors = getStage().getActors();
        for (Actor actor : actors) {
            if (actor instanceof ResultWin) {
                return false;
            }
        }
        return true;
    }

    private void computerStarNum() {
        int[] timeLevel = Answer.timeLevels.get(level);
        if (timeLevel[0] < seconds && timeLevel[1] >= seconds) {
            starNum = 1;
        } else if (timeLevel[1] < seconds && timeLevel[2] >= seconds) {
            starNum = 2;
        } else if (timeLevel[2] < seconds && timeLevel[3] >= seconds) {
            starNum = 3;
        } else {
            starNum = 0;
        }
        if (Answer.gateStars.size() > challengeCtrl.getGateNum()) {//可能重玩
            if (starNum > 0) {
                Answer.gateStars.set(challengeCtrl.getGateNum(), starNum);
            }
        } else {
            Answer.gateStars.add(starNum);
        }
    }

    private void handleGate() {
        if (seconds < 0) {//game over
            Gdx.input.setInputProcessor(null);
            executTime.shutdown();
            openResultWin = true; //关卡结束
            isPass = true;
        } else if (netDetector.isPass(challengeCtrl.getGateNum())) {
            Gdx.input.setInputProcessor(null);
            executTime.shutdown();
            Runnable runner = new Runnable() {
                public void run() {
                    openResultWin = true; //关卡结束
                }
            };
            executorGateEnd.schedule(runner, 1500, TimeUnit.MILLISECONDS);
            areaCtrl.clearAllNet();
            isPass = true;
        }
    }

    private void suspendTimer() {
        isSuspend = true;
    }

    public void resumeTimer() {
        isSuspend = false;
    }

    private void createTimer() {
        isSuspend = false;
        seconds = Answer.timeLevels.get(level)[3];
        labTime.setStyle(yellowStyle);
        executTime = Executors.newSingleThreadScheduledExecutor();
        executTime.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!isSuspend) {
                    seconds--; //
                    if (seconds < 15) {
                        if (seconds % 2 == 0) {
                            labTime.setStyle(redStyle);
                        } else {
                            labTime.setStyle(yellowStyle);
                        }
                    }
                    buildTimeStr();
                }
            }

            private void buildTimeStr() {
                String str0 = "%d";
                String str1 = "%d";
                int minute = seconds / 60;
                int second = seconds % 60;
                if (seconds < 0) {
                    second = 0;
                }
                if (minute < 10) {
                    str0 = "0%d";
                }
                if (second < 10) {
                    str1 = "0%d";
                }
                timeStr = String.format("倒计时" + str0 + ":" + str1, minute, second);
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void pause() {
    }

    public void return2init() {
        isPass = false;
        if (!executTime.isShutdown()) {
            executTime.shutdown();
        }
        createTimer();
    }

    public void refreshGame() {
        return2init();
        pieceCtrl.handler();
    }

    public void useSos() {
        multiplexer.removeProcessor(netDetector);
        multiplexer.removeProcessor(getStage());
        isUsingHelp = true;
        isUsedHelp = true;
        pieceCtrl.handler();
    }

    public void setGateNum(int num) {
        buildNewGate(num);
        gateNum = num;
    }

    public boolean isSuspend() {
        return isSuspend;
    }

    public GateScreen getGateScreen() {
        return gateScreen;
    }
}
