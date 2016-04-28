package com.example.zhaozhiwen.heartbeatapplication;

import java.io.Serializable;

/**
 * Created by zhaozhiwen on 2016/4/27.
 */
public class FocusItemModel implements Serializable{
    private String itemTitle;
    private String itemContent;
    private String itemImage;
    private String binner;
    private String smallicon;
    private String smallTitle;
    private String smallContent;

    public FocusItemModel( String itemTitle, String itemContent, String itemImage, String binner, String smallicon, String smallTitle, String smallContent) {
        this.itemTitle = itemTitle;
        this.itemContent = itemContent;
        this.itemImage = itemImage;
        this.binner = binner;
        this.smallicon = smallicon;
        this.smallTitle = smallTitle;
        this.smallContent = smallContent;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public String getSmallContent() {
        return smallContent;
    }

    public void setSmallContent(String smallContent) {
        this.smallContent = smallContent;
    }

    public String getBinner() {
        return binner;
    }

    public void setBinner(String binner) {
        this.binner = binner;
    }

    public String getSmallicon() {
        return smallicon;
    }

    public void setSmallicon(String smallicon) {
        this.smallicon = smallicon;
    }
    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

}
