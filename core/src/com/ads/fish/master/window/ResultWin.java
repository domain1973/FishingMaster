package com.ads.fish.master.window;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Assets;
import com.ads.fish.master.Master;
import com.ads.fish.master.Settings;
import com.ads.fish.master.controller.AreaController;
import com.ads.fish.master.controller.ChallengeController;
import com.ads.fish.master.controller.IController;
import com.ads.fish.master.controller.NetController;
import com.ads.fish.master.screen.GameScreen;
import com.ads.fish.master.screen.LevelScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2014/7/20.
 */
public class ResultWin extends BaseWin {
    float win_H;
    private GameScreen gameScreen;
    private float space;
    private Image[] star_nulls;
    private Image[] stars;
    private ScheduledExecutorService executStarCount;
    private ParticleEffect effect;
    private int starIndex;
    private int starNum;
    private boolean exeTimer = false;
    private boolean end = false;
    private ImageButton gateBtn;
    private ImageButton refresh;
    private ImageButton next;
    private Group group;
    private ChallengeController challengeCtrl;

    public ResultWin(GameScreen gs, int num) {
        super(Answer.TITLES[num], new Window.WindowStyle(gs.getGameFont(), Color.WHITE, new TextureRegionDrawable(
                Assets.resultBg)));
        starNum = num;
        gameScreen = gs;
        create();
    }

    public void create() {
        float btnSize = Assets.WIDTH / 6;
        gameScreen.getStage().addActor(layerBg);
        win_H = btnSize * 4;
        float win_Y = (Assets.HEIGHT - win_H) / 2;
        setBounds(0, win_Y, Assets.WIDTH, win_H);
        space = Assets.WIDTH / 5;
        addButtons();
        addListeners();
        addStars();
        addActor(gateBtn);
        addActor(refresh);
        if (starNum > 0) {
            addActor(next);
        }
        initEffect();
        group = gameScreen.getStage().getRoot();
        challengeCtrl = (ChallengeController) group.findActor(IController.CHALLENGE_CTRL);
    }

    private void addButtons() {
        float btn_size = space;
        gateBtn = new ImageButton(new TextureRegionDrawable(Assets.gate), new TextureRegionDrawable(Assets.gate));
        float y = win_H / 6;
        gateBtn.setBounds(btn_size, y, btn_size, btn_size);
        refresh = new ImageButton(new TextureRegionDrawable(Assets.refresh), new TextureRegionDrawable(Assets.refresh));
        refresh.setBounds(2 * btn_size, y, btn_size, btn_size);
        next = new ImageButton(new TextureRegionDrawable(Assets.next), new TextureRegionDrawable(Assets.next));
        next.setBounds(3 * btn_size, y, btn_size, btn_size);
    }

    private void addListeners() {
        gateBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (starNum > 0) {//时间已到,回关卡时,不能更新状态
                    int nextGateNum = updateGateNum();
                    gameScreen.getGateScreen().buildGateImage((nextGateNum - 1) / Answer.GATE_MAX);
                } else {
                    gameScreen.getGateScreen().buildGateImage((Settings.unlockGateNum - 1) / Answer.GATE_MAX);
                }
                layerBg.remove();
                ResultWin.this.remove();
                gameScreen.refreshGame();
                gameScreen.getMaster().setScreen(gameScreen.getGateScreen());
                super.touchUp(event, x, y, pointer, button);
            }
        });
        refresh.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                int t = challengeCtrl.getGateNum();
                if (Answer.gateStars.size() > t) {//原则:重玩星星个数置成0
                    Answer.gateStars.set(t, 0);
                }
                layerBg.remove();
                gameScreen.refreshGame();
                ResultWin.this.remove();
                super.touchUp(event, x, y, pointer, button);
            }
        });
        next.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                Assets.playSound(Assets.btnSound);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                layerBg.remove();
                ((NetController) group.findActor(IController.PIECE_CTRL)).handler();
                int nextGateNum = updateGateNum();
                ResultWin.this.remove();
                gameScreen.return2init();
                if (Answer.isLasterSmallGate(nextGateNum)) {
                    int lv = nextGateNum / Answer.GATE_MAX;
                    Master puzzle = gameScreen.getMaster();
                    LevelScreen levelScreen = puzzle.getMainScreen().getLevelScreen();
                    levelScreen.setLevel(lv);
                    puzzle.setScreen(levelScreen);
                }
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    private int updateGateNum() {
        ((AreaController) group.findActor(IController.AREA_CTRL)).handler();
        challengeCtrl.handler();
        int nextGateNum = challengeCtrl.getGateNum();
        gameScreen.setGateNum(nextGateNum);
        if (nextGateNum > Settings.unlockGateNum) {
            Settings.unlockGateNum = nextGateNum;
        }
        if (Answer.gateStars.size() <= nextGateNum) {
            Answer.gateStars.add(0);
        }
        gameScreen.getMaster().getPEvent().save();
        return nextGateNum;
    }

    private void initEffect() {
        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("data/test.p"), Gdx.files.internal("data/"));
    }

    private void addStars() {
        float starW = space;
        float v = (Assets.WIDTH - starW) / 2;
        star_nulls = new Image[3];
        stars = new Image[3];
        float y1 = win_H / 2;
        for (int i = 0; i < 3; i++) {
            star_nulls[i] = new Image(Assets.star_null);
            stars[i] = new Image(Assets.star);
            int t = i - 1;
            float x1 = v + t * starW;
            star_nulls[i].setBounds(x1, y1, starW, starW);
            stars[i].setBounds(x1, y1, starW, starW);
            addActor(star_nulls[i]);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (starNum > 0) {
            if (!end) {
                if (!exeTimer) {
                    changeStar();
                    exeTimer = true;
                }
                if (starIndex < starNum) {
                    Image star = stars[starIndex];
                    float space = star.getWidth() / 2;
                    effect.setPosition(star.getX() + getX() + space, star.getY() + getY() + space);
                    effect.draw(batch, Gdx.graphics.getDeltaTime());
                    addActor(star);
                } else {
                    end = true;
                    executStarCount.shutdown();
                    Gdx.input.setInputProcessor(gameScreen.getStage());
                }
            }
        } else {
            Gdx.input.setInputProcessor(gameScreen.getStage());
        }
    }

    private void changeStar() {
        Assets.playSound(Assets.starSound);
        executStarCount = Executors.newSingleThreadScheduledExecutor();
        executStarCount.scheduleAtFixedRate(new Runnable() {
            public void run() {
                starIndex++;
                if (starIndex < starNum) {
                    Assets.playSound(Assets.starSound);
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}
