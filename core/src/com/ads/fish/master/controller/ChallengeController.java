package com.ads.fish.master.controller;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Assets;
import com.ads.fish.master.actors.Challenge;

/**
 * Created by Administrator on 2014/7/5.
 */
public class ChallengeController extends IController {
    private Challenge challenge;
    private int level;
    private int gateNum;

    public ChallengeController(int lv, int num, String name) {
        setName(name);
        level = lv;
        gateNum = num;
        challenge = new Challenge(num);
        addActor(challenge);
    }

    @Override
    public void handler() {
        challenge.remove();
        gateNum++;
        if (Answer.isLasterSmallGate(gateNum)) {
            level++;
        }
        if (level < Assets.LEVEL_MAX) {
            challenge = new Challenge(gateNum);
            addActor(challenge);
        }
    }

    public void buildChallenge(int lv, int num) {
        level = lv;
        gateNum = num;
        challenge.remove();
        challenge = new Challenge(gateNum);
        addActor(challenge);
    }

    public int getGateNum() {
        return gateNum;
    }
}
