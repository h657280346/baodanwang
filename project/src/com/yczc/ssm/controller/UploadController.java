package com.yczc.ssm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Amessage;
import com.yczc.ssm.pojo.Ballteam;
import com.yczc.ssm.pojo.Comment;
import com.yczc.ssm.pojo.Contest;
import com.yczc.ssm.pojo.Nmessage;
import com.yczc.ssm.pojo.Player;
import com.yczc.ssm.pojo.Reward;
import com.yczc.ssm.pojo.Subscriber;
import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/***
 * 上传数据
 * @author liu_yeye
 *
 */
@Controller
public class UploadController {
	
	private  String codeEncoding(String text){  
        String result = text;  
        try {  
            result = new String(text.getBytes("iso-8859-1"), "utf-8");  
        } catch (Exception e) {  
            System.err.println("中文转码失败！");  
            e.printStackTrace();  
        }   
        return result;  
    }  
	private  String getDateFormat(Date date) {
		final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		return dateFormat.format(date);
	}
	private  String getDateTimeFormat(Date date) {
		  final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm";
		  DateFormat timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		  return timeFormat.format(date);
	}
	private  String getTimeFormat(Date date) {
		  final String TIME_DEFAULT_FORMAT = "HH:mm";
		  DateFormat timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		  return timeFormat.format(date);
	}
	private String getWeekFormat(Date date){
		 SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		 return  dateFm.format(date);
	}
	private  String appendNum(String num){
		int length = 6;
		String numend = num.split("\\.")[1];
		StringBuffer sb = new StringBuffer(numend);
		char a = '0';
		for(int i=0;i<length-numend.length();i++){
			sb.append(a );
		}
		return num.split("\\.")[0]+"."+sb.toString();	
	}
	/**
	 * 发布赛事
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="/uploadUpdateContest",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadUpdateContest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		   req.setCharacterEncoding("utf-8");
			rep.setCharacterEncoding("utf-8");
		   Map<String, Object> map = new HashMap<String, Object>();	
		    map.put("id",req.getParameter("id") );
			map.put("pteamid", req.getParameter("pteamid"));
			map.put("popenid", req.getParameter("popenid"));
			map.put("date", req.getParameter("date"));
			map.put("week", req.getParameter("week"));
			map.put("time", req.getParameter("time"));
			map.put("postdate", getDateTimeFormat(new Date()));
			map.put("lng", appendNum(req.getParameter("lng")));
			map.put("lat",  appendNum(req.getParameter("lat")));
			map.put("adress", (req.getParameter("adress")));
			map.put("contact",  (req.getParameter("contact")));
			Integer person = Integer.valueOf(req.getParameter("person"));
			map.put("person", person);
			map.put("clothing",  (req.getParameter("clothing")));
			map.put("turf",  (req.getParameter("turf")));
			map.put("cost", req.getParameter("cost"));
			Integer ensure = Integer.valueOf(req.getParameter("ensure"));
			map.put("ensure",ensure);
			Integer award = Integer.valueOf(req.getParameter("award"));
			map.put("award", award);
			map.put("notes", (req.getParameter("notes")));
			map.put("status", "等待约战");
			map.put("reasons", null);
			Contest contest =(Contest) AutomaticObjectUtil.newInstance(map, Contest.class);
			int result = -1;
			map = new HashMap<String, Object>();
			if(Service.contestService.updateContest(contest)){
				Reward reward = Service.rewardService.getAllReward().get(0);
				result = 0; 
				map.put("award", reward.getAward());
			} 
			map.put("result", result);
			return JSON.toJSONString(map);
	 }
	/**
	 * 发布赛事
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="/uploadContest",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadContest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		   req.setCharacterEncoding("utf-8");
			rep.setCharacterEncoding("utf-8");
		   Map<String, Object> map = new HashMap<String, Object>();	
		   String id = GetID.getUUID();
		    map.put("id",id );
			map.put("pteamid", req.getParameter("pteamid"));
			map.put("popenid", req.getParameter("popenid"));
			map.put("date", req.getParameter("date"));
			map.put("week", req.getParameter("week"));
			map.put("time", req.getParameter("time"));
			map.put("postdate", getDateTimeFormat(new Date()));
			map.put("lng", appendNum(req.getParameter("lng")));
			map.put("lat",  appendNum(req.getParameter("lat")));
			map.put("adress", (req.getParameter("adress")));
			map.put("contact",  (req.getParameter("contact")));
			Integer person = Integer.valueOf(req.getParameter("person"));
			map.put("person", person);
			map.put("clothing",  (req.getParameter("clothing")));
			map.put("turf",  (req.getParameter("turf")));
			map.put("cost", req.getParameter("cost"));
			Integer ensure = Integer.valueOf(req.getParameter("ensure"));
			map.put("ensure",ensure);
			Integer award = Integer.valueOf(req.getParameter("award"));
			map.put("award", award);
			map.put("notes", (req.getParameter("notes")));
			map.put("status", "等待约战");
			map.put("reasons", null);
			Contest contest =(Contest) AutomaticObjectUtil.newInstance(map, Contest.class);
			int result = -1;
			Yuezhan yuezhan = new Yuezhan();
			yuezhan.setId(GetID.getUUID());
			yuezhan.setIdentity("p");
			yuezhan.setMatchid(id);
			yuezhan.setOpenid((String) map.get("popenid"));
			yuezhan.setNumber(person);
			map = new HashMap<String, Object>();
			if(Service.contestService.addContest(contest)&&Service.yuezhanService.addYuezhan(yuezhan)){
				Reward reward = Service.rewardService.getAllReward().get(0);
				result = 0; 
				map.put("award", reward.getAward());
			} 
			map.put("result", result);
			return JSON.toJSONString(map);
	 }
	 /**
	  * 申请约战
	  */
	 @RequestMapping(value="/uploadYuezhan",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadYuezhan(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String matchid = (req.getParameter("matchid"));
		String mopenid = (req.getParameter("openid"));
		String mteamid = (req.getParameter("teamid"));
		Contest contest = Service.contestService.getContestById(matchid);
		int result = -1;
		if(contest!=null){
			contest.setMopenid(mopenid);
			contest.setMteamid(mteamid);
			contest.setStatus("约战成功");
			Yuezhan yuezhan = new Yuezhan();
			yuezhan.setId(GetID.getUUID());
			yuezhan.setOpenid(mopenid);
			yuezhan.setMatchid(matchid);
			yuezhan.setIdentity("m");
			yuezhan.setNumber(contest.getPerson());
			Amessage msg = new Amessage();
			msg.setId(GetID.getUUID());
			msg.setPopenid(contest.getMopenid());
			msg.setMopenid(contest.getPopenid());
			msg.setGameid(contest.getId());
			Date now = new Date();
			msg.setDate(getDateFormat(now));
			msg.setTime(getTimeFormat(now));
			msg.setStatus("0");
			msg.setContent("足球俱乐部已向你应战!");
			if(Service.contestService.updateContest(contest)&&Service.yuezhanService.addYuezhan(yuezhan)&&Service.amessageService.addAmessage(msg)){
				result = 0;
//				Subscriber s = Service.subscriberService.getSubscriberByOpenId(contest.getPopenid());
//				if(s.getSuccess() == null){
//					s.setSuccess(1);
//				} else s.setSuccess(s.getSuccess()+1);
//				Service.subscriberService.updateSubscriber(s);
			}
		}
		return JSON.toJSONString(result);
	 }
	 /**
	  * 修改约战
	  */
	 @RequestMapping(value="/uploadUpdateYuezhan",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadUpdateYuezhan(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String id = (req.getParameter("id"));
		 Contest contest = Service.contestService.getContestById(id);
		 int result = -1;
		 if(contest != null){
			 Map<String,Object> map =new HashMap<String, Object>();
			   map.put("id", id);
			    Contest newcontest = new Contest();
			    newcontest.setId(id);
			    newcontest.setPteamid((req.getParameter("pteamid")));
			    newcontest.setPopenid((req.getParameter("popenid")));
			    newcontest.setDate((req.getParameter("date")));
			    newcontest.setWeek( (req.getParameter("week")));
			    newcontest.setTime( (req.getParameter("time")));
			    newcontest.setLng( (req.getParameter("lng")));
			    newcontest.setLat( (req.getParameter("lat")));
			    newcontest.setAdress( (req.getParameter("adress")));
			    newcontest.setContact( (req.getParameter("contact")));
				Integer person = Integer.valueOf(req.getParameter("person"));
				newcontest.setPerson(person);
				newcontest.setClothing((req.getParameter("clothing")));
				newcontest.setTurf( (req.getParameter("turf")));
				newcontest.setCost( (req.getParameter("cost")));
				Integer ensure = Integer.valueOf(req.getParameter("ensure"));
				newcontest.setEnsure( ensure);
				Integer award = Integer.valueOf(req.getParameter("award"));
				newcontest.setAward(award);
				newcontest.setNotes( (req.getParameter("notes")));
				newcontest.setStatus( (req.getParameter("status")));
				 newcontest.setReasons( (req.getParameter("reasons")));
			 if(!Service.contestService.updateContest(newcontest)){
				 return JSON.toJSONString(result);
			 }
			 result = 0;
		 }
		 return JSON.toJSONString(result);
	 }
	 /**
	  * 删除约战
	  */
	 @RequestMapping(value="/uploadDeleteYuezhan",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadDeleteYuezhan(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String id = (req.getParameter("id"));
		 Contest contest = Service.contestService.getContestById(id);
		 int result = -1;
		 if(contest != null){
			 List<Yuezhan> yuezhans = Service.yuezhanService.getYuezhanByMatchid(id);
			 //删除约占
			 for(Yuezhan yuezhan :yuezhans){
				 yuezhan.setIdentity("已删除");
				 if(!Service.yuezhanService.updateYuezhan(yuezhan)){
					 return JSON.toJSONString(result);
				 }
			 }
			 //删除球员
			 List<Player> players =Service.playerService.getPlayerByMatchid(id);
			 for(Player player :players){
				Service.playerService.deletePlayer(player.getId());
			 }
			 //删除消息
			 List<Amessage> amessagelist=Service.amessageService.getAmessageByGameid(id);
			 for(Amessage amessage :amessagelist){
					Service.amessageService.deleteAmessage(amessage.getId());
				 }
			 contest.setStatus("已删除");
			 if(!Service.contestService.updateContest(contest)){
				 return JSON.toJSONString(result);
			 }
			 result = 0;
		 }
		 return JSON.toJSONString(result);
	 }
	 /**
	  * 取消约战
	  */
	 @RequestMapping(value="/uploadCancelYuezhan",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadCancelYuezhan(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String id = (req.getParameter("id"));
		 String popenid = req.getParameter("popenid");
		 String mopenid = req.getParameter("mopenid");
		 Contest contest = Service.contestService.getContestById(id);
		 int result = -1;
		 if(Service.amessageService.isAmessage(popenid, mopenid, id)){
			 result = -2;
			 return JSON.toJSONString(result);
		 }
		 if(contest != null){
//			 List<Yuezhan> yuezhans = Service.yuezhanService.getYuezhanByMatchidAndIdentity(id,"m");
//			 for(Yuezhan yuezhan :yuezhans){
//				 if(!Service.yuezhanService.deleteYuezhan(yuezhan.getId())){
//					 return JSON.toJSONString(result);
//				 }
//			 }
//			 List<Player> players =Service.playerService.getPlayerByMatchid(id);
//			 for(Player player :players){
//				Service.playerService.deletePlayer(player.getId());
//			 }
//			 contest.setStatus("等待约战");
//			 if(!Service.contestService.updateContest(contest)){
//				 return JSON.toJSONString(result);
//			 }
			 contest.setStatus("等待取消");
			 Amessage amessage = new Amessage();
			 amessage.setId(GetID.getUUID());
			 Date now = new Date();
			 amessage.setDate(getDateFormat(now));
			 amessage.setTime(getTimeFormat(now));
			 amessage.setPopenid(popenid);
			 amessage.setMopenid(mopenid);
			 amessage.setGameid(id);
			 amessage.setContent("足球俱乐部申请取消和你在"+contest.getDate()+"地点为"+contest.getAdress()+"的约战!");
			 amessage.setStatus("0");
			 if(Service.contestService.updateContest(contest) && Service.amessageService.addAmessage(amessage)){
				 result = 0;
			 }	
		 }
		 return JSON.toJSONString(result);
	 }
	 /**
	  * 删除公告
	  */
	 @RequestMapping(value="/uploadDeleteNmessage",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadDeleteNmessage(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String nmessageid =req.getParameter("nmessageid");
		 Nmessage nmessage = Service.nmessageService.getNmessageById(nmessageid);
		 nmessage.setStatus("1");
		 int result = -1;
		 if(nmessage!=null &&  Service.nmessageService.updateNmessage(nmessage)){
			 result = 0;
		 }
		return  JSON.toJSONString(result);
	 }
	 /**
	  * 请求回应消息已读
	  */
	 @RequestMapping(value="/uploadAmessage",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadAmessage(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String amessageid =req.getParameter("amessageid");
		 Amessage amessage = Service.amessageService.getAmessageById(amessageid);
		 amessage.setStatus("1");
		 int result = -1;
		 if(amessage!=null &&  Service.amessageService.updateAmessage(amessage)){
			 result = 0;
		 }
		return  JSON.toJSONString(result);
	 }
	 /**
	  * 取消回应
	  */
	 @RequestMapping(value="/uploadAnswerCancelYuezhan",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadAnswerCancelYuezhan(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		 String id = (req.getParameter("gameid"));
		 String answer = req.getParameter("answer");
		 String amessageid =req.getParameter("amessageid");
		 Contest contest = Service.contestService.getContestById(id);
		 int result = -1;
		 if(contest != null){
//			 List<Yuezhan> yuezhans = Service.yuezhanService.getYuezhanByMatchidAndIdentity(id,"m");
//			 for(Yuezhan yuezhan :yuezhans){
//				 if(!Service.yuezhanService.deleteYuezhan(yuezhan.getId())){
//					 return JSON.toJSONString(result);
//				 }
//			 }
//			 List<Player> players =Service.playerService.getPlayerByMatchid(id);
//			 for(Player player :players){
//				Service.playerService.deletePlayer(player.getId());
//			 }
//			 contest.setStatus("等待约战");
//			 if(!Service.contestService.updateContest(contest)){
//				 return JSON.toJSONString(result);
//			 }
			 if(answer!=null && !answer.equals("")){
				 String response = null;
				 if(answer.equals("y")){
					 response = "同意了你的取消约战";
					 contest.setStatus("等待约战");
					 contest.setMopenid(null);
					 contest.setMteamid(null);
					 List<Yuezhan> yuezhans = Service.yuezhanService.getYuezhanByMatchidAndIdentity(id,"m");
					 for(Yuezhan yuezhan :yuezhans){
						 yuezhan.setIdentity("已取消");
						 if(Service.contestService.updateContestByStatus(contest)&&Service.yuezhanService.updateYuezhan(yuezhan)){
							 result = 0;
						 }
						 break;
					 }	
				 } else if((answer.equals("n"))){
					 result = 1;
					 response = "拒绝了你的取消约战";
					 contest.setStatus("约战成功");
					 if(Service.contestService.updateContest(contest)){
						 result = 0;
					 }
				 }
				 Amessage amessage = Service.amessageService.getAmessageById(amessageid);
				 amessage.setStatus("1");
				 Service.amessageService.updateAmessage(amessage);
				 Amessage amessageresponse = new Amessage();
				 amessageresponse.setId(GetID.getUUID());
				 Date now = new Date();
				 amessageresponse.setDate(getDateFormat(now));
				 amessageresponse.setTime(getTimeFormat(now));
				 amessageresponse.setGameid(id);
				 amessageresponse.setPopenid(amessage.getMopenid());
				 amessageresponse.setMopenid(amessage.getPopenid());
				 amessageresponse.setContent(response);
				 amessageresponse.setStatus("0");
				 Service.amessageService.addAmessage(amessageresponse);
			 }
		 }
		 return JSON.toJSONString(result);
	 }
	 /**
	  * 评论约战
	  */
	 @RequestMapping(value="/uploadComment",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadComment(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String openid = (req.getParameter("openid"));
		String matchid = (req.getParameter("matchid"));
		String teamid = (req.getParameter("teamid"));
		String star = (req.getParameter("star"));
		String detail = (req.getParameter("detail"));
		String other = (req.getParameter("other"));
		Comment comment = new Comment();
		comment.setId(GetID.getUUID());
		comment.setOpenid(openid);
		comment.setTeamid(teamid);
		comment.setMatchid(matchid);
		comment.setStar(star);
		comment.setDetail(detail);
		comment.setOther(other);
		int result = -1;
		Map<String,Object> map = new HashMap<String, Object>();
		if(Service.commentService.isComment(openid, matchid)){
			result = -2;
		}else{
			if(Service.commentService.addComment(comment)){
				result = 0;
				Reward reward = Service.rewardService.getAllReward().get(0); 
				map.put("award", reward.getAward());
			}
		}
		map.put("result", result);
		 return JSON.toJSONString(map);
	 }
	 /**
	  * 添加球员
	  */
	 @RequestMapping(value="/uploadNewPlayer",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  uploadNewPlayer(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String id = GetID.getUUID();
		String openid = (req.getParameter("openid"));
		String person = (req.getParameter("person"));
		String time = (getDateTimeFormat((new Date())));
		String matchid = (req.getParameter("matchid"));
		String nickName = req.getParameter("nickName");
		String avatarUrl = req.getParameter("avatarUrl");
		String notes = (req.getParameter("notes"));
		String  identity = (req.getParameter("identity"));
		String status = (req.getParameter("status"));
		String result = "-1";
		if(!Service.playerService.isPlayerByOpenidAndMatchid(openid, matchid)){
			    Player player = new Player();
				player.setId(id);
				player.setOpenid(openid);
				player.setNickname(nickName);
				player.setLogourl(avatarUrl);
				player.setTime(time);
				player.setMatchid(matchid);
				player.setIdentity(identity);
				player.setStatus(status);
				player.setNotes(notes);
				if(Service.playerService.addPlayer(player)){
					result="0";
				}
		}else{
			List<Player> players = Service.playerService.getPlayerByOpenidAndMatchid(openid, matchid);
			if(players!=null && players.size()!=0){
				for(Player player:players){
					if(player.getStatus()!=null&&!player.getStatus().equals(status)){
						player.setStatus(status);
						 if(Service.playerService.updatePlayer(player)){
							 result = "0";
							 break;
						 }
					}
				}
			}
			else {
				result = "-2";
			}
		}
		return JSON.toJSONString(result);
	 } 
	 
}
