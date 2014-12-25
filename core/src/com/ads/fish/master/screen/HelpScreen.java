package com.ads.fish.master.screen;

import com.ads.fish.master.Assets;
import com.ads.fish.master.Master;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Administrator on 2014/9/1.
 */
public class HelpScreen extends OtherScreen {
    private Image readmeImage;
    private BaseScreen baseScreen;

    private HelpScreen(Master game) {
        super(game);
        readmeImage = new Image(Assets.readme);
        float imageW = Assets.WIDTH * 20 / 21;
        float height = imageW * 1.6f;
        float maxH = Assets.HEIGHT - 2 * Assets.TOPBAR_HEIGHT;
        readmeImage.setBounds((Assets.WIDTH - imageW) / 2, Assets.TOPBAR_HEIGHT, imageW, Math.min(maxH, height));
    }

    public HelpScreen(Master game, BaseScreen ms) {
        this(game);
        baseScreen = ms;
    }

    @Override
    public void show() {
        if (!isShow()) {
            super.show();
            addActor(readmeImage);
            returnBtn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    Assets.playSound(Assets.btnSound);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    getMaster().setScreen(baseScreen);
                    super.touchUp(event, x, y, pointer, button);
                }
            });
            setShow(true);
        } else {
            Gdx.input.setInputProcessor(getStage());
            setStarNum();
        }
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (!isBackFlag()) {
                baseScreen.setBackFlag(true);
                getMaster().setScreen(baseScreen);
                return;
            }
        } else {
            setBackFlag(false);
        }
        super.render(delta);
    }

    public void setBaseScreen(BaseScreen baseScreen) {
        this.baseScreen = baseScreen;
    }
}
