package com.ads.fish.master.screen;

import com.ads.fish.master.Assets;
import com.ads.fish.master.Master;
import com.ads.fish.master.Series;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


/**
 * Created by Administrator on 2014/8/10.
 */
public class AdGameScreen extends BaseScreen {
    private float margin = Assets.WIDTH / 15;
    private float seriesW = margin * 2.5f;
    private float seriesH = seriesW;
    private BaseScreen baseScreen;

    public AdGameScreen(Master game, BaseScreen bs) {
        super(game);
        baseScreen = bs;
    }

    @Override
    public void show() {
        if (!isShow()) {
            super.show();
            createBtns();
            createAdLabel();
            for (int i = 0; i < Assets.seriesList.size(); i++) {
                final Series series = Assets.seriesList.get(i);
                Image image = series.getImage();
                ImageButton seriesBtn = new ImageButton(image.getDrawable(), image.getDrawable(), image.getDrawable());
                seriesBtn.addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y,
                                             int pointer, int button) {
                        Assets.playSound(Assets.btnSound);
                        getMaster().getPEvent().install(series);
                        return true;
                    }
                });
                float x = i % 4 * seriesW + (i % 4 + 1) * margin;
                float y = getY_bar() - (i / 4 + 1) * seriesH - (i / 4 + 2) * margin;
                seriesBtn.setBounds(x, y, seriesW, seriesH);
                addActor(seriesBtn);
            }
            setListens();
            setShow(true);
        } else {
            Gdx.input.setInputProcessor(getStage());
        }
        if (Assets.seriesList.size() == 0) {
            getMaster().getPEvent().netSlowInfo();
        }
    }

    private void createAdLabel() {
        String str = "爱迪精品";
        BitmapFont font = getOtherFont();
        Label l = new Label(str, new Label.LabelStyle(font, Color.WHITE));
        float w = font.getBounds(str).width;
        l.setBounds((Assets.WIDTH - w) / 2, getY_bar(), Assets.TOPBAR_HEIGHT, Assets.TOPBAR_HEIGHT);
        addActor(l);
    }

    private void setListens() {
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
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            baseScreen.setBackFlag(true);
            getMaster().setScreen(baseScreen);
        }
        super.render(delta);
    }
}
