package com.ads.fish.master.screen;

import com.ads.fish.master.Assets;
import com.ads.fish.master.Master;
import com.ads.fish.master.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


/**
 * Created by Ads on 2014/6/22.
 */
public class MainScreen extends BaseScreen {
    private Master puzzle;
    private LevelScreen levelScreen;
    private SettingScreen settingScreen;
    private HelpScreen helpScreen;
    private boolean touchBack = true;

    public MainScreen(Master p) {
        super(p);
        puzzle = p;
        levelScreen = new LevelScreen(p);
        settingScreen = new SettingScreen(p);
        helpScreen = new HelpScreen(p, this);
    }

    @Override
    public void show() {
        if (!isShow()) {
            super.show();
            Image bg = new Image(Assets.startBg);
            bg.setBounds(0, 0, Assets.WIDTH, Assets.HEIGHT);
            addActor(bg);
            Image theme = new Image(Assets.theme);
            float themeSize = Assets.WIDTH * 3 / 4;
            theme.setBounds((Assets.WIDTH - themeSize) / 2, Assets.HEIGHT / 2, themeSize, themeSize);

            float playSize = Assets.WIDTH / 3;
            float spaceSize = Assets.WIDTH / 13;
            float btnPlayX = (Assets.WIDTH - playSize) / 2;
            float otherX = spaceSize;
            float otherSize = spaceSize * 2;
            float btnPlayY = Assets.HEIGHT / 3;
            ImageButton playBtn = new ImageButton(new TextureRegionDrawable(Assets.playBtn), new TextureRegionDrawable(Assets.playBtnDown));
            playBtn.setBounds(btnPlayX, btnPlayY, playSize, playSize);
            ImageButton helpBtn = new ImageButton(new TextureRegionDrawable(Assets.help), new TextureRegionDrawable(Assets.help));
            float y = btnPlayY - 1.5f * otherSize;
            helpBtn.setBounds(otherX, y, otherSize, otherSize);
            ImageButton settingBtn = new ImageButton(new TextureRegionDrawable(Assets.setting), new TextureRegionDrawable(Assets.setting));
            settingBtn.setBounds(4 * otherX, y, otherSize, otherSize);
            ImageButton storeBtn = new ImageButton(new TextureRegionDrawable(Assets.buy), new TextureRegionDrawable(Assets.buy));
            storeBtn.setBounds(7 * otherX, y, otherSize, otherSize);
            ImageButton exitBtn = new ImageButton(new TextureRegionDrawable(Assets.exit), new TextureRegionDrawable(Assets.exit));
            exitBtn.setBounds(10 * otherX, y, otherSize, otherSize);

            playBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    levelScreen.setLevel(Settings.unlockGateNum / 12);
                    puzzle.setScreen(levelScreen);
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            settingBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    puzzle.setScreen(settingScreen);
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            helpBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    puzzle.setScreen(helpScreen);
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            exitBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    puzzle.getPEvent().exit(MainScreen.this);
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            storeBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    puzzle.getPEvent().pay();
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            addActor(theme);
            addActor(playBtn);
            addActor(settingBtn);
            addActor(helpBtn);
            addActor(exitBtn);
            addActor(storeBtn);
            removeLayerBg();
            setShow(true);
        } else {
            Gdx.input.setInputProcessor(getStage());
        }
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
        getStage().dispose();
        Assets.assetManager.dispose();
    }

    @Override
    public void render(float delta) {
        if (touchBack && Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (!isBackFlag()) {
                touchBack = false;
                puzzle.getPEvent().exit(MainScreen.this);
            }
        } else {
            setBackFlag(false);
        }
        super.render(delta);
    }

    public HelpScreen getHelpScreen() {
        return helpScreen;
    }

    public LevelScreen getLevelScreen() {
        return levelScreen;
    }

    public void setTouchBack(boolean touchBack) {
        this.touchBack = touchBack;
    }
}
