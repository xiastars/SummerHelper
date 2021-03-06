package com.summer.demo.ui.module.fragment.share;

public class ShareItemInfo {

    private String name;
    private int resId;
    private int type;

    public ShareItemInfo() {

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ShareItemInfo(String name, int resId, int type) {
        this.name = name;
        this.type = type;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
