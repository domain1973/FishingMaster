package com.ads.fish.master.controller;

import com.ads.fish.master.Assets;
import com.ads.fish.master.actors.Net;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * Created by Administrator on 2014/7/4.
 */
public class NetController extends IController {
    private static final int NET_NUM = 8;
    private Rectangle bounds;

    public NetController(String name) {
        setName(name);
        for (int i = 0; i < NET_NUM; i++) {
            Net net = new Net(i);
            addActor(net);
            if (i == 4) {
                bounds = new Rectangle(net.getX(), net.getY(), Assets.WIDTH, Assets.WIDTH / 2);
            }
        }
    }

    @Override
    public void handler() {
        SnapshotArray<Actor> actors = getChildren();
        for (int i = 0; i < actors.size; i++) {
            Actor actor = actors.get(i);
            Net piece = (Net) actor;
            piece.return2BeginArea();
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
