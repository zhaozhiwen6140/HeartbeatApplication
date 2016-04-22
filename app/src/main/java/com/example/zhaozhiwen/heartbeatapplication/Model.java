package com.example.zhaozhiwen.heartbeatapplication;

/**
 * Created by zhaozhiwen on 2016/4/14.
 */
public class Model {

    public static final int BigFrame=1;
    public static final int SmallFrame=2;

    private String title;
    private String binner;
    private String icon;
    private String packageSize;
    private int itemType;

    public Model(String title, String binner, String icon, String packageSize, int itemType) {
        this.title = title;
        this.binner=binner;
        this.icon = icon;
        this.packageSize = packageSize;
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBinner() {
        return binner;
    }

    public void setBinner(String binner) {
        this.binner = binner;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    @Override
    public String toString() {
        return "Model{" +
                "title='" + title + '\'' +
                ", binner='" + binner + '\'' +
                ", icon='" + icon + '\'' +
                ", packageSize=" + packageSize +
                ", itemType=" + itemType +
                '}';
    }
}
