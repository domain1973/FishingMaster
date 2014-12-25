package com.ads.fish.master.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ads.fish.master.Answer;
import com.ads.fish.master.Master;
import com.ads.fish.master.Settings;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import net.youmi.android.AdManager;
import net.youmi.android.spot.SpotManager;

public class AndroidLauncher extends AndroidApplication {
    private PEventImpl pEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        pEvent = new PEventImpl(this);
        initialize(new Master(pEvent), config);
        loadGameConfig();
        if (Settings.adManager) {
            AdManager.getInstance(this).init("8a07bc49c7547523", "e93c8fd55e9f13ba", false);
            SpotManager.getInstance(this).loadSpotAds();
            SpotManager.getInstance(this).setSpotOrientation(SpotManager.ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onDestroy() {
        SpotManager.getInstance(this).unregisterSceenReceiver();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        //如果不调用此方法，则按home键的时候会出现图标无法显示的情况。
        SpotManager.getInstance(this).disMiss(false);
        super.onStop();
    }

    public void spot() {
        if (Settings.adManager) {
            SpotManager.getInstance(this).showSpotAds(this);
        }
    }

    private void loadGameConfig() {
        SharedPreferences sharedata = getSharedPreferences("data", Context.MODE_PRIVATE);
        Settings.musicEnabled = sharedata.getBoolean("music", true);
        Settings.soundEnabled = sharedata.getBoolean("sound", true);
        Settings.unlockGateNum = sharedata.getInt("passNum", 0);
        Settings.helpNum = sharedata.getInt("helpNum", 0);
        Answer.gateStars.clear();
        String[] split = sharedata.getString("starNum", "0").split("[,]");
        for (String starNum : split) {
            if (!"".equals(starNum)) {
                Answer.gateStars.add(Integer.parseInt(starNum));
            }
        }
        Settings.adManager = sharedata.getBoolean("adManager", true);
    }
}
