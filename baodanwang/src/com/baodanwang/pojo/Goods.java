package com.baodanwang.pojo;

public class Goods {
    private String goodId;

    private String storeId;

    private String goodName;

    private String goodShowstatus;

    private String goodPrice;

    private String goodAdvanceprice;

    private String goodDescribe;

    private String goodAddtime;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodShowstatus() {
        return goodShowstatus;
    }

    public void setGoodShowstatus(String goodShowstatus) {
        this.goodShowstatus = goodShowstatus == null ? null : goodShowstatus.trim();
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice == null ? null : goodPrice.trim();
    }

    public String getGoodAdvanceprice() {
        return goodAdvanceprice;
    }

    public void setGoodAdvanceprice(String goodAdvanceprice) {
        this.goodAdvanceprice = goodAdvanceprice == null ? null : goodAdvanceprice.trim();
    }

    public String getGoodDescribe() {
        return goodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe == null ? null : goodDescribe.trim();
    }

    public String getGoodAddtime() {
        return goodAddtime;
    }

    public void setGoodAddtime(String goodAddtime) {
        this.goodAddtime = goodAddtime == null ? null : goodAddtime.trim();
    }
}