package com.ads.fish.master.actors;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Assets;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Administrator on 2014/7/5.
 */
public class Challenge extends Group {

    public Challenge(int gateNum) {
        float x = Assets.NET_X;
        float y = Assets.NET_Y - Assets.FISH_SIZE;
        float size = Assets.FISH_SIZE;
        Integer[][] quizs = Answer.CHALLENGES.get(gateNum);
        for (int i = 0; i < quizs.length; i++) {
            Integer pos = quizs[i][0];
            Integer bmpId = quizs[i][1];
            Image image = new Image(Assets.fishs[bmpId]);
            int xcount = pos % 5;
            int ycount = pos / 5;
            image.setBounds(x + xcount * size, y - ycount * size, size, size);
            addActor(image);
        }
        Integer[] answers = Answer.VALUES.get(gateNum);
        for (int i = 0; i < answers.length; i++) {
            Integer bmpId = answers[i];
            Image image = new Image(Assets.fishs[bmpId]);
            image.setBounds(Assets.ANSWER_X, y - i * size, size, size);
            addActor(image);
        }
        BitmapFont font = Assets.otherFont;
        BitmapFont.TextBounds bounds = font.getBounds("00");
        Label.LabelStyle style = new Label.LabelStyle(font, Color.YELLOW);
        Label label = new Label((gateNum + 1) + "", style);
        label.setPosition(Assets.ANSWER_X + bounds.width, Assets.GATENUM_Y - bounds.height / 2);
        addActor(label);
    }
}
