package com.yczc.ssm.pojo;

import java.io.Serializable;

public class Yuezhan implements Serializable {
    private String id;

    private String openid;

    private String matchid;

    private String cancelnotes;

    private String sharenotes;

    private String identity;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public String getCancelnotes() {
        return cancelnotes;
    }

    public void setCancelnotes(String cancelnotes) {
        this.cancelnotes = cancelnotes == null ? null : cancelnotes.trim();
    }

    public String getSharenotes() {
        return sharenotes;
    }

    public void setSharenotes(String sharenotes) {
        this.sharenotes = sharenotes == null ? null : sharenotes.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", matchid=").append(matchid);
        sb.append(", cancelnotes=").append(cancelnotes);
        sb.append(", sharenotes=").append(sharenotes);
        sb.append(", identity=").append(identity);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}