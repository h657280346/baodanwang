package com.baodanwang.pojo;

public class Bulksandgoods {
    private String bgId;

    private String goodId;

    private String bulkId;

    private String goodLimite;

    public String getBgId() {
        return bgId;
    }

    public void setBgId(String bgId) {
        this.bgId = bgId == null ? null : bgId.trim();
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getBulkId() {
        return bulkId;
    }

    public void setBulkId(String bulkId) {
        this.bulkId = bulkId == null ? null : bulkId.trim();
    }

    public String getGoodLimite() {
        return goodLimite;
    }

    public void setGoodLimite(String goodLimite) {
        this.goodLimite = goodLimite == null ? null : goodLimite.trim();
    }
}