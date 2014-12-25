package com.ads.fish.master.actors;

import com.ads.fish.master.Assets;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Administrator on 2014/7/4.
 */
public class Net extends Image {
    private boolean cover;
    private int orientation;
    private int id;
    private float x = 0;
    private float y = 0;
    private float netSize;

    public Net(int netId) {
        super(Assets.nets[netId]);
        id = netId;
        setOrigin(Assets.POOL_SIZE / 2, Assets.POOL_SIZE / 2);
        return2BeginArea();
    }

    public void return2BeginArea() {
        netSize = Assets.NET_SIZE;
        float top = Assets.HEIGHT - 11 * Assets.WIDTH / 8 - Assets.TOPBAR_HEIGHT;
        float left = 0;
        switch (id) {
            case 0:
                x = left;
                y = top;
                break;
            case 1:
                x = left + netSize;
                y = top;
                break;
            case 2:
                x = left + 2 * netSize;
                y = top;
                break;
            case 3:
                x = left + 3 * netSize;
                y = top;
                break;
            case 4:
                x = left;
                y = top - netSize;
                break;
            case 5:
                x = left + netSize;
                y = top - netSize;
                break;
            case 6:
                x = left + 2 * netSize;
                y = top - netSize;
                break;
            case 7:
                x = left + 3 * netSize;
                y = top - netSize;
                break;
        }
        return2Raw();
    }

    public void return2Raw() {
        setBounds(x, y, netSize, netSize);
        setRotation(0);
        orientation = 0;
        cover = false;
    }

    public void changeOrientation() {
        if (orientation == 3) {
            orientation = 0;
        } else {
            orientation++;
        }
        setRotation(orientation * 90);
    }

    public boolean isCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public int getOrientation() {
        return orientation;
    }
}
