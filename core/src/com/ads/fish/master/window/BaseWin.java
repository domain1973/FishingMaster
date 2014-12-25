package com.ads.fish.master.window;

import com.ads.fish.master.Assets;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * Created by Administrator on 2014/7/30.
 */
public class BaseWin extends Window {

    protected Image layerBg;

    public BaseWin(String title, WindowStyle style) {
        super(title, style);
        layerBg = new Image(Assets.layerBg);
        layerBg.setBounds(0, 0, Assets.WIDTH, Assets.HEIGHT);
    }

    public Image getLayerBg() {
        return layerBg;
    }
}
