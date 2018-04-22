package com.yczc.ssm.pojo;

import java.io.Serializable;

public class Contest implements Serializable {
    private String id;

    private String pteamid;

    private String mteamid;

    private String popenid;

    private String mopenid;

    private String date;

    private String time;

    private String week;

    private String postdate;

    private String lng;

    private String lat;

    private String adress;

    private String contact;

    private Integer person;

    private String clothing;

    private String turf;

    private String cost;

    private Integer ensure;

    private Integer award;

    private String notes;

    private String status;

    private String reasons;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPteamid() {
        return pteamid;
    }

    public void setPteamid(String pteamid) {
        this.pteamid = pteamid == null ? null : pteamid.trim();
    }

    public String getMteamid() {
        return mteamid;
    }

    public void setMteamid(String mteamid) {
        this.mteamid = mteamid == null ? null : mteamid.trim();
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate == null ? null : postdate.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public String getClothing() {
        return clothing;
    }

    public void setClothing(String clothing) {
        this.clothing = clothing == null ? null : clothing.trim();
    }

    public String getTurf() {
        return turf;
    }

    public void setTurf(String turf) {
        this.turf = turf == null ? null : turf.trim();
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost == null ? null : cost.trim();
    }

    public Integer getEnsure() {
        return ensure;
    }

    public void setEnsure(Integer ensure) {
        this.ensure = ensure;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons == null ? null : reasons.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pteamid=").append(pteamid);
        sb.append(", mteamid=").append(mteamid);
        sb.append(", popenid=").append(popenid);
        sb.append(", mopenid=").append(mopenid);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", week=").append(week);
        sb.append(", postdate=").append(postdate);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", adress=").append(adress);
        sb.append(", contact=").append(contact);
        sb.append(", person=").append(person);
        sb.append(", clothing=").append(clothing);
        sb.append(", turf=").append(turf);
        sb.append(", cost=").append(cost);
        sb.append(", ensure=").append(ensure);
        sb.append(", award=").append(award);
        sb.append(", notes=").append(notes);
        sb.append(", status=").append(status);
        sb.append(", reasons=").append(reasons);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contest other = (Contest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}