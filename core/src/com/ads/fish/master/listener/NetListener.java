package com.ads.fish.master.listener;

import com.ads.fish.master.Assets;
import com.ads.fish.master.actors.Area;
import com.ads.fish.master.actors.Net;
import com.ads.fish.master.controller.AreaController;
import com.ads.fish.master.controller.IController;
import com.ads.fish.master.controller.NetController;
import com.ads.fish.master.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * Created by Administrator on 2014/7/4.
 */
public class NetListener extends GestureDetector.GestureAdapter {
    private Stage stage;
    private GameScreen gameScreen;
    private Vector3 touchPoint;
    private Area area;
    private AreaController areaCtrl;
    private NetController netCtrl;
    private SnapshotArray<Actor> nets;
    private Net downNet;

    public NetListener(Stage stage, GameScreen gs) {
        this.stage = stage;
        gameScreen = gs;
        touchPoint = new Vector3();
        areaCtrl = (AreaController) stage.getRoot().findActor(IController.AREA_CTRL);
        area = areaCtrl.getArea();
        netCtrl = (NetController) stage.getRoot().findActor(IController.PIECE_CTRL);
        nets = netCtrl.getChildren();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        downNet = null;
        if (!gameScreen.isSuspend()) {
            stage.getCamera().unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            Net topNet = area.getTopNet();
            if (topNet != null) {
                Rectangle bounds = new Rectangle(topNet.getX(), topNet.getY(), topNet.getWidth(), topNet.getHeight());
                if (bounds.contains(touchPoint.x, touchPoint.y)) {
                    downNet = topNet;
                }
            }
            if (downNet == null) {
                for (int i = 0; i < 8; i++) {
                    Net net = (Net) nets.get(i);
                    Rectangle bounds = new Rectangle(net.getX(), net.getY(), net.getWidth(), net.getHeight());
                    if (!net.isCover() && bounds.contains(touchPoint.x, touchPoint.y)) {
                        downNet = net;
                        break;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if (!gameScreen.isSuspend()) {
            stage.getCamera().unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0)); // 坐标转化
            Net topNet = area.getTopNet();
            if (topNet != null) {
                Rectangle bounds = new Rectangle(topNet.getX(), topNet.getY(), topNet.getWidth(), topNet.getHeight());
                if (bounds.contains(touchPoint.x, touchPoint.y)) {
                    topNet.changeOrientation();//快速点击改变块方位
                    net2pool(topNet);
                    Assets.playSound(Assets.btnSound);
                }
            }
        }
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (downNet != null) {
            float x1 = downNet.getX() + deltaX;
            float y1 = downNet.getY() - deltaY;
            if (x1 > 0 && y1 > 0) {
                downNet.setPosition(x1, y1);
            }
        }
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        press();
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        press();
        return true;
    }

    private void press() {
        if (downNet != null) {
            stage.getCamera().unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0)); // 坐标转化
            Rectangle areaBound = areaCtrl.getBounds();
            Rectangle netBound = netCtrl.getBounds();
            if (areaBound.contains(touchPoint.x, touchPoint.y)) {
                net2pool(downNet);
                area.addNet(downNet);
            } else if (netBound.contains(touchPoint.x, touchPoint.y)) {
                area.removeNet(downNet);
                downNet.return2Raw();
            } else {
                if (downNet.getWidth() == Assets.NET_SIZE) {
                    downNet.return2Raw();
                } else if (downNet.getWidth() == Assets.NET_BIG_SIZE) {
                    net2pool(downNet);
                }
            }
        }
    }

    private void net2pool(Net net) {
        net.setCover(true);
        net.setBounds(Assets.NET_X, Assets.NET_Y - Assets.POOL_SIZE, Assets.POOL_SIZE, Assets.POOL_SIZE);
    }
}
