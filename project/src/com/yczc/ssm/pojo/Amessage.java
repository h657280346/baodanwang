package com.yczc.ssm.pojo;

import java.io.Serializable;

public class Amessage implements Serializable {
    private String id;

    private String popenid;

    private String mopenid;

    private String gameid;

    private String date;

    private String time;

    private String content;

    private String status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPopenid() {
        return popenid;
    }

    public void setPopenid(String popenid) {
        this.popenid = popenid == null ? null : popenid.trim();
    }

    public String getMopenid() {
        return mopenid;
    }

    public void setMopenid(String mopenid) {
        this.mopenid = mopenid == null ? null : mopenid.trim();
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", popenid=").append(popenid);
        sb.append(", mopenid=").append(mopenid);
        sb.append(", gameid=").append(gameid);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}