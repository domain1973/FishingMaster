package com.ads.fish.master;

import com.ads.fish.master.screen.MainScreen;
import com.badlogic.gdx.Game;

public class Master extends Game {
    private MainScreen mainScreen;
    private PEvent pEvent;

    public Master() {
    }

    public Master(PEvent pe) {
        pEvent = pe;
    }

    @Override
    public void create() {
        Assets.load();
        mainScreen = new MainScreen(this);
        setScreen(mainScreen);
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public PEvent getPEvent() {
        return pEvent;
    }
}
