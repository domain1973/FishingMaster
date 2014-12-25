package com.ads.fish.master.actors;

import com.ads.fish.master.Assets;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Administrator on 2014/7/5.
 */
public class Gate extends ImageButton {

    public Gate(Drawable imageUp, int id) {
        super(imageUp);
        float gateBtnSize = Assets.WIDTH / 5;
        float gateBtnSpace = Assets.WIDTH / 25;
        float y_off = Assets.HEIGHT / 3;
        float hspace = Assets.HEIGHT / 6;
        setPosition((id % 4 + 1) * gateBtnSpace + id % 4 * gateBtnSize, Assets.HEIGHT - y_off - id / 4 * hspace);
    }
}
