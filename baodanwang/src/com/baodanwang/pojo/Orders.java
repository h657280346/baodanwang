package com.baodanwang.pojo;

public class Orders {
    private String orderId;

    private String bulkId;

    private String orderStatus;

    private String orderAddress;

    private String orderTel;

    private String orderName;

    private String orderWechatid;

    private String orderTotalprice;

    private String userId;

    private String storeId;

    private String orderNotes;

    private String orderAddressdetail;

    private String orderAddtime;

    private String orderPickupway;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getBulkId() {
        return bulkId;
    }

    public void setBulkId(String bulkId) {
        this.bulkId = bulkId == null ? null : bulkId.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel == null ? null : orderTel.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderWechatid() {
        return orderWechatid;
    }

    public void setOrderWechatid(String orderWechatid) {
        this.orderWechatid = orderWechatid == null ? null : orderWechatid.trim();
    }

    public String getOrderTotalprice() {
        return orderTotalprice;
    }

    public void setOrderTotalprice(String orderTotalprice) {
        this.orderTotalprice = orderTotalprice == null ? null : orderTotalprice.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes == null ? null : orderNotes.trim();
    }

    public String getOrderAddressdetail() {
        return orderAddressdetail;
    }

    public void setOrderAddressdetail(String orderAddressdetail) {
        this.orderAddressdetail = orderAddressdetail == null ? null : orderAddressdetail.trim();
    }

    public String getOrderAddtime() {
        return orderAddtime;
    }

    public void setOrderAddtime(String orderAddtime) {
        this.orderAddtime = orderAddtime == null ? null : orderAddtime.trim();
    }

    public String getOrderPickupway() {
        return orderPickupway;
    }

    public void setOrderPickupway(String orderPickupway) {
        this.orderPickupway = orderPickupway == null ? null : orderPickupway.trim();
    }
}