package com.baodanwang.pojo;

public class Users {
    private String userId;

    private String userOpenid;

    private String userAvatarurl;

    private String userNickname;

    private String userWechatid;

    private String userTel;

    private String userAddress;

    private String userAddtime;

    private String userRealname;

    private String userAddressdetail;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public String getUserAvatarurl() {
        return userAvatarurl;
    }

    public void setUserAvatarurl(String userAvatarurl) {
        this.userAvatarurl = userAvatarurl == null ? null : userAvatarurl.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserWechatid() {
        return userWechatid;
    }

    public void setUserWechatid(String userWechatid) {
        this.userWechatid = userWechatid == null ? null : userWechatid.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserAddtime() {
        return userAddtime;
    }

    public void setUserAddtime(String userAddtime) {
        this.userAddtime = userAddtime == null ? null : userAddtime.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserAddressdetail() {
        return userAddressdetail;
    }

    public void setUserAddressdetail(String userAddressdetail) {
        this.userAddressdetail = userAddressdetail == null ? null : userAddressdetail.trim();
    }
}