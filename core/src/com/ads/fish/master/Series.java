package com.ads.fish.master;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Administrator on 2014/9/27.
 */
public class Series {
    private Image image;

    private String name;

    private String detail;

    private String url;

    public Image getImage() {
        return image;
    }

    public Series setImage(Image image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public Series setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Series setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Series setUrl(String url) {
        this.url = url;
        return this;
    }
}
