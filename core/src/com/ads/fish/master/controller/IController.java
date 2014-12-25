package com.ads.fish.master.controller;

import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Administrator on 2014/7/4.
 */
public abstract class IController extends Group {
    public static final String AREA_CTRL = "a";
    public static final String CHALLENGE_CTRL = "b";
    public static final String PIECE_CTRL = "c";

    public abstract void handler();
}
