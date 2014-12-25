package com.ads.fish.master.listener;

import com.ads.fish.master.Answer;
import com.ads.fish.master.actors.Area;
import com.ads.fish.master.actors.Net;
import com.ads.fish.master.controller.AreaController;
import com.ads.fish.master.controller.IController;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/4.
 */
public class NetDetector extends GestureDetector {
    private Stage stage;

    /**
     * Creates a new GestureDetector with default values: halfTapSquareSize=20, tapCountInterval=0.4f, longPressDuration=1.1f,
     * maxFlingDelay=0.15f.
     *
     * @param listener
     */
    public NetDetector(Stage stage, GestureListener listener) {
        super(listener);
        this.stage = stage;
    }

    public boolean isPass(int gateNum) {
        AreaController areaCtrl = (AreaController) stage.getRoot().findActor(IController.AREA_CTRL);
        Area area = areaCtrl.getArea();
        if (area.getTopNet() == null) {
            return false;
        }
        List<Net> pieces = area.getNets();
        List<Integer> noCovers = new ArrayList<Integer>();
        Integer[][] C = Answer.CHALLENGES.get(gateNum);
        for (int i = 0; i < C.length; i++) {
            Integer t = C[i][1];
            if (!isCover(t, pieces)) {
                noCovers.add(t);
            }
        }
        Integer[] answers = Answer.VALUES.get(gateNum);
        if (answers.length == noCovers.size()) {
            for (Integer answer : answers) {
                if (noCovers.contains(answer)) {
                    noCovers.remove(answer);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean isCover(int c, List<Net> pieces) {
        for (Net piece : pieces) {
            Integer[] T = Answer.TS.get(piece.getId())[piece.getOrientation()];
            for (int i = 0; i < T.length; i++) {
                if (T[i] == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
