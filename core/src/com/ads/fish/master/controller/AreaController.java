package com.ads.fish.master.controller;

import com.ads.fish.master.Assets;
import com.ads.fish.master.actors.Area;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * Created by Administrator on 2014/7/6.
 */
public class AreaController extends IController {
    private Area area;
    private Rectangle bounds;

    public AreaController(String name) {
        setName(name);
        area = new Area();
        buildArea();
    }

    public void buildArea() {
        if (area != null) {
            area.remove();
        }
        area = new Area();
        addActor(area);
        //area有效区域
        bounds = new Rectangle(Assets.NET_X, Assets.NET_Y - Assets.POOL_SIZE, Assets.POOL_SIZE, Assets.POOL_SIZE);
    }


    public Rectangle getBounds() {
        return bounds;
    }

    public Area getArea() {
        return area;
    }

    public void clearAllNet() {
        area.clearAllNet();
    }

    @Override
    public void handler() {
        SnapshotArray<Actor> actors = getChildren();
        for (Actor actor : actors) {
            Area area = (Area) actor;
            area.clearAllNet();
        }
    }
}
