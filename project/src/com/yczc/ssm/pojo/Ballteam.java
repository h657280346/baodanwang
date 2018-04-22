package com.yczc.ssm.pojo;

import java.io.Serializable;

public class Ballteam implements Serializable {
    private String id;

    private String openid;

    private String team;

    private String area;

    private String abbreviation;

    private String teamimg;

    private String teamdate;

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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    public String getTeamimg() {
        return teamimg;
    }

    public void setTeamimg(String teamimg) {
        this.teamimg = teamimg == null ? null : teamimg.trim();
    }

    public String getTeamdate() {
        return teamdate;
    }

    public void setTeamdate(String teamdate) {
        this.teamdate = teamdate == null ? null : teamdate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", team=").append(team);
        sb.append(", area=").append(area);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", teamimg=").append(teamimg);
        sb.append(", teamdate=").append(teamdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}