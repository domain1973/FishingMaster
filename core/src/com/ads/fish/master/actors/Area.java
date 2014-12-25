package com.ads.fish.master.actors;

import com.ads.fish.master.Assets;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/6.
 */
public class Area extends Image {
    private List<Net> nets;

    /**
     *
     *
     */
    public Area() {
        super(Assets.areaBg);
        nets = new ArrayList<Net>();
        setBounds(0, Assets.HEIGHT - Assets.WIDTH - Assets.TOPBAR_HEIGHT, Assets.WIDTH, Assets.WIDTH);
    }

    public List<Net> getNets() {
        return nets;
    }

    public Net getTopNet() {
        if (nets.size() == 0) {
            return null;
        }
        return nets.get(nets.size() - 1);

    }

    public void addNet(Net net) {
        if (!nets.contains(net)) {
            nets.add(net);
        }
    }

    public void clearAllNet() {
        nets.clear();
    }

    public void removeNet(Net net) {
        if (nets.contains(net)) {
            nets.remove(net);
        }
    }

}
