package com.ads.fish.master.screen;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Assets;
import com.ads.fish.master.Settings;
import com.ads.fish.master.actors.Gate;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.List;

/**
 * Created by Administrator on 2014/6/22.
 */
public class GateScreen extends OtherScreen {
    private LevelScreen levelScreen;
    private GameScreen gameScreen;
    private Gate[] gates;
    private int level;

    public GateScreen(LevelScreen ls) {
        super(ls.getMaster());
        levelScreen = ls;
        level = ls.getLevel();
        gameScreen = new GameScreen(this);
        gates = new Gate[Answer.GATE_MAX];
    }

    @Override
    public void show() {
        if (!isShow()) {
            super.show();
            buildGateImage(level);
            returnBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    getMaster().setScreen(levelScreen);
                    return true;
                }
            });
            setShow(true);
        } else {
            Gdx.input.setInputProcessor(getStage());
            setStarNum();
        }
    }

    @Override
    protected String getStarNumInfo() {
        int starNum = 0;
        int fromIndex = level * Answer.GATE_MAX;
        int s = Answer.gateStars.size();
        int toIndex = fromIndex + Answer.GATE_MAX;
        if (s < toIndex) {
            toIndex = s;
        }
        List<Integer> sub = Answer.gateStars.subList(fromIndex, toIndex);
        for (Integer num : sub) {
            starNum = starNum + num;
        }
        return starNum + "/36";
    }

    public void buildGateImage(final int lv) {
        if (lv < Assets.LEVEL_MAX) {
            for (Gate gate : gates) {
                if (gate != null) {
                    gate.remove();
                }
            }
            level = lv;
            float gateBtnSize = Assets.WIDTH / 5;
            for (int i = 0; i < Answer.GATE_MAX; i++) {
                final int gateNum = lv * Answer.GATE_MAX + i;
                TextureRegion gateTRegion = null;
                if (Settings.unlockGateNum >= gateNum || gateNum == 0) {
                    int num = Answer.gateStars.get(gateNum);
                    switch (num) {
                        case 0:
                            gateTRegion = Assets.gate_0star;
                            break;
                        case 1:
                            gateTRegion = Assets.gate_1star;
                            break;
                        case 2:
                            gateTRegion = Assets.gate_2star;
                            break;
                        case 3:
                            gateTRegion = Assets.gate_3star;
                            break;
                    }
                } else {
                    gateTRegion = Assets.gate_lock;
                }
                TextureRegionDrawable imageUp = new TextureRegionDrawable(gateTRegion);
                imageUp.setMinWidth(gateBtnSize);
                imageUp.setMinHeight(gateBtnSize);
                Gate gate = new Gate(imageUp, i);
                gate.addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y,
                                             int pointer, int button) {
                        Assets.playSound(Assets.btnSound);
                        if (gateNum <= Settings.unlockGateNum) {
                            gameScreen.setGateNum(gateNum);
                            getMaster().setScreen(gameScreen);
                        }
                        return true;
                    }
                });
                gates[i] = gate;
                addActor(gate);
            }
        }
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (!isBackFlag()) {
                levelScreen.setBackFlag(true);
                getMaster().setScreen(levelScreen);
                return;
            }
        } else {
            setBackFlag(false);
        }
        super.render(delta);
    }
}
