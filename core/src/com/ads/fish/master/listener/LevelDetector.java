package com.ads.fish.master.listener;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Administrator on 2014/8/2.
 */
public class LevelDetector extends GestureDetector {

    private Stage stage;

    public LevelDetector(Stage stage, GestureListener listener) {
        super(listener);
        this.stage = stage;
    }
}
