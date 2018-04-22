package com.yczc.ssm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthScrollBarUI;

import org.apache.log4j.chainsaw.Main;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yczc.ssm.controller.Step2.Token;
import com.yczc.ssm.controller.Step2.Token.DataToken;
import com.yczc.ssm.pojo.About;
import com.yczc.ssm.pojo.Amessage;
import com.yczc.ssm.pojo.Ballteam;
import com.yczc.ssm.pojo.Carousel;
import com.yczc.ssm.pojo.Comment;
import com.yczc.ssm.pojo.Contest;
import com.yczc.ssm.pojo.Nmessage;
import com.yczc.ssm.pojo.Notice;
import com.yczc.ssm.pojo.Player;
import com.yczc.ssm.pojo.Subscriber;
import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;
import com.yczc.ssm.util.HttpRequestor;

/***
 * 获取数据
 * 
 * @author liu_yeye
 * 
 */
@Controller
public class QueryController {
	private final static String key = ResourceBundle.getBundle("conn").getString("mapkey"); 
	private String clientId="Rg50JOtW9LLr9TNzAhvX";
	private String clientSecret="ORuJITY2SUjRYnFLMe2ElgOq5jnlFHCSmDWZ8IGg";
	/**
	 * 小程序获取轮播
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCarousel", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getCarousel() throws Exception {
		List<Carousel> carousels = Service.carouselService.getCarousel(4);
		return JSON.toJSONString(carousels);
	}

	/**
	 * 小程序获取公告
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getNotice", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getNotice() throws Exception {
		List<Notice> notices = Service.noticeService.getNotice(1);
		return JSON.toJSONString(notices);
	}
	/**
	 * 小程序获取关于
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAbout", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getAbout() throws Exception {
		List<About> abouts = Service.aboutService.getAllAbout();
		System.out.println(abouts.get(0));
		return JSON.toJSONString(abouts.get(0));
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
	 * 搜索赛事
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getContestBySearch", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getContestBySearch(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String  require = req.getParameter("require");
		String mylng = Service.lat ;
		String mylat = Service.lng ;
		// 腾讯"NRIBZ-OFHHR-DZMWB-W5EIN-FQXME-E5FC2";
		// String key = "80358a522fe2c8e38b356cd243ddc8fe";
		List<Map> contestMapList = new ArrayList<Map>();
		String status = "等待约战";
		List<Contest> contestList = Service.contestService
				.getContestByStatus(status);
		Map<String,Object> teamMap = new HashMap<String, Object>();
		Token token = JSON.parseObject(accessToken(), Token.class); 
		System.out.println(token);
		//球队map
		for (Contest contest : contestList){
			 if(!teamMap.containsKey(contest.getPopenid())){
				 String softball = get_softball(token.getData().getAccessToken(), contest.getPopenid(), contest.getPteamid());
				JSONObject obj = JSONObject.parseObject(softball);
				 JSONObject softballObj = JSONObject.parseObject(obj.getString("data"));
				teamMap.put(contest.getPopenid(),softballObj.get("title"));
			 }
		}
		 Iterator<Map.Entry<String,Object>> it = teamMap.entrySet().iterator(); 
		 while(it.hasNext()){  
	         Map.Entry<String,Object> entry = it.next();  
	         if(!require.contains((String)entry.getValue())){
	        	 it.remove();
	         }
	    }  
		for (Contest contest : contestList) {
			if(!teamMap.containsKey(contest.getPopenid())){
				continue;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gameid", contest.getId());
			map.put("date", contest.getDate());
			map.put("time", contest.getTime());
			map.put("week", contest.getWeek());
			map.put("postdate", contest.getPostdate());
			map.put("adress", contest.getAdress());
			map.put("cost", contest.getCost());
			map.put("person", contest.getPerson());
			map.put("popenid", contest.getPopenid());
			map.put("pteamid", contest.getPteamid());
			String requestUrl = "http://restapi.amap.com/v3/distance?origins="
					+ contest.getLng() + "," + contest.getLat()
					+ "&destination=" + mylng + "," + mylat
					+ "&type=0&output=json&key=" + key;
			String resJson = new HttpRequestor().doGet(requestUrl);
			JSONObject obj = JSONObject.parseObject(resJson);
			if (((String) obj.get("status")).equals("1")) {
				JSONArray results = (JSONArray) obj.get("results");
				JSONObject element = (JSONObject) results.get(0);
				String dis = String.valueOf(element.get("distance"));
				BigDecimal b = new BigDecimal(dis);
				String distance=null;
				if (b.compareTo(new BigDecimal(1000)) >= 0) {
					distance = String
							.valueOf(Math.round(b.doubleValue() * 1.0 / 100d) / 10d)+ "km";	
				} else {
					distance = b + "m";
				}
				map.put("distance", distance);
				map.put("sort", dis);
				contestMapList.add(map);
			}
		}
		Collections.sort(contestMapList, new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				Map<String, Object> map1 = (Map<String, Object>) o1;
				Map<String, Object> map2 = (Map<String, Object>) o2;
				String distance1 = ((String) map1.get("sort"));
				String distance2 = ((String) map2.get("sort"));
				if (new BigDecimal(distance1).compareTo(new BigDecimal(
						distance2)) < 0) {
					return -1;
				}
				return 1;
			}
		});
		return JSON.toJSONString(contestMapList);
	 }
	/**
	 * 获取首页赛事
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getContestIndex", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getContestIndex(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String mylng = appendNum(req.getParameter("mylng"));
		String mylat = appendNum(req.getParameter("mylat"));
		if (mylng != null && mylat != null) {
			Service.lat = mylat;
			Service.lng = mylng;
		} else {
			mylat = Service.lat;
			mylng = Service.lng;
		}
		// 腾讯"NRIBZ-OFHHR-DZMWB-W5EIN-FQXME-E5FC2";
		// String key = "80358a522fe2c8e38b356cd243ddc8fe";
		List<Map> contestMapList = new ArrayList<Map>();
		String status = "等待约战";
		List<Contest> contestList = Service.contestService
				.getContestByStatus(status);
		for (Contest contest : contestList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gameid", contest.getId());
			map.put("date", contest.getDate());
			map.put("time", contest.getTime());
			map.put("week", contest.getWeek());
			map.put("postdate", contest.getPostdate());
			map.put("adress", contest.getAdress());
			map.put("cost", contest.getCost());
			map.put("person", contest.getPerson());
			map.put("popenid", contest.getPopenid());
			map.put("pteamid", contest.getPteamid());
			String requestUrl = "http://restapi.amap.com/v3/distance?origins="
					+ contest.getLng() + "," + contest.getLat()
					+ "&destination=" + mylng + "," + mylat
					+ "&type=0&output=json&key=" + key;
			String resJson = new HttpRequestor().doGet(requestUrl);
			JSONObject obj = JSONObject.parseObject(resJson);
			if (((String) obj.get("status")).equals("1")) {
				JSONArray results = (JSONArray) obj.get("results");
				JSONObject element = (JSONObject) results.get(0);
				String dis = String.valueOf(element.get("distance"));
				BigDecimal b = new BigDecimal(dis);
				String distance=null;
				if (b.compareTo(new BigDecimal(1000)) >= 0) {
					distance = String
							.valueOf(Math.round(b.doubleValue() * 1.0 / 100d) / 10d)+ "km";	
				} else {
					distance = b + "m";
				}
				map.put("distance", distance);
				map.put("sort", dis);
				contestMapList.add(map);
			}
		}
		Collections.sort(contestMapList, new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				Map<String, Object> map1 = (Map<String, Object>) o1;
				Map<String, Object> map2 = (Map<String, Object>) o2;
				String distance1 = ((String) map1.get("sort"));
				String distance2 = ((String) map2.get("sort"));
				if (new BigDecimal(distance1).compareTo(new BigDecimal(
						distance2)) < 0) {
					return -1;
				}
				return 1;
			}
		});
		return JSON.toJSONString(contestMapList);
	}

	/**
	 * 获取赛事详情
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getContestDetail", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getContestDetail(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String id = req.getParameter("id");
		String openid = req.getParameter("openid");
		String mylat = Service.lat;
		String mylng = Service.lng;
		Contest contest = Service.contestService.getContestById(id);
		String identity = null;
		if(openid.equals(contest.getPopenid())){
			identity = "p";
		} 
		if(openid.equals(contest.getMopenid())){
			identity = "m";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> contestmap =AutomaticObjectUtil.objectToMap(contest);
		contestmap.remove("id");
		String requestUrl = "http://restapi.amap.com/v3/distance?origins="
				+ contest.getLng() + "," + contest.getLat()
				+ "&destination=" + mylng + "," + mylat
				+ "&type=0&output=json&key=" + key;
		String resJson = new HttpRequestor().doGet(requestUrl);
		JSONObject obj = JSONObject.parseObject(resJson);
		if (((String) obj.get("status")).equals("1")) {
			JSONArray results = (JSONArray) obj.get("results");
			JSONObject element = (JSONObject) results.get(0);
			String dis = String.valueOf(element.get("distance"));
			BigDecimal b = new BigDecimal(dis);
			String distance=null;
			if (b.compareTo(new BigDecimal(1000)) >= 0) {
				distance = String
						.valueOf(Math.round(b.doubleValue() * 1.0 / 100d) / 10d)+ "km";	
			} else {
				distance = b + "m";
			}
			contestmap.put("distance", distance);
			contestmap.put("sort", dis);
		}
		contestmap.put("gameid", contest.getId());
		String status = null;
		if(contest.getStatus().equals("等待约战")){
			status = "0";
		} else if(contest.getStatus().equals("约战成功")){
			if(compareToTime(contest.getDate()+" "+contest.getTime())){
				status = "2";
			}else status = "1";
		}else if(contest.getStatus().equals("等待取消")){
			status = "1";
		} else {
			status = "3";
		}
		contestmap.put("status", status);
		map.put("contest", contestmap);
		if(identity!=null&&(status.equals("1")||status.equals("2"))){
			List<Player> players = Service.playerService.getPlayerByMatchid(contest.getId());
			Map<String, Object> pmap = null;
			List<Map> list = new ArrayList<Map>();
			for(Player player : players){
				pmap = new HashMap<String, Object>();
				pmap.put("playeTime", player.getTime());
				pmap.put("playerIdentity", player.getIdentity());
				pmap.put("playerStatus", player.getStatus());
				pmap.put("playerNickName", player.getNickname());
				pmap.put("playerAvatarUrl", player.getLogourl());
				list.add(pmap);
			}
			map.put("players", list);
		}
		return JSON.toJSONString(map);
	}

	/**
	 * 获取详情评论
	 * 参数{teamid}
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping(value = "/getMyComment", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getMyComment(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String  teamid = req.getParameter("teamid");
		List<Contest> contestList = Service.contestService.getContestByTeamid(teamid);
		List<Map> list  = new ArrayList<Map>();
		for(Contest contest:contestList){
			List<Comment> comments = Service.commentService
					.getCommentsByMatchid(contest.getId());
			for (Comment c : comments) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("commentid", c.getId());
				m.put("commentstar", c.getStar());
				m.put("commentdetail", c.getDetail());
				String[] other = c.getOther().split(" ");
				m.put("commentother", other);
				m.put("openid", c.getOpenid());
				list.add(m);
			}
		}
		return JSON.toJSONString(list);
	}

	private boolean compareToTime(String endTime) {
		// 构造日期格式yyyy-MM-NN HH:mm:ss
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		boolean flag = false;
		try {
			Date end = formatter.parse(endTime);
			Date now = formatter.parse(formatter.format(new Date()));
			if (end.compareTo(now) < 0) {
				flag = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 获取我发布的约战 identity = p
	 * 
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMyYuzhanByOpenid", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getMyYuzhanByOpenid(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String openid = req.getParameter("openid");
		String identity = "p";
		String mylng = req.getParameter("mylng");
		String mylat = req.getParameter("mylat");
		if (mylng != null && mylat != null) {
			Service.lat = mylat;
			Service.lng = mylng;
		} else {
			mylat = Service.lat;
			mylng = Service.lng;
		}
		List<Map> list = new ArrayList<Map>();
		List<Yuezhan> yuezhans = Service.yuezhanService
				.getYuezhanByOpenidAndIdentity(openid, identity);
		if (yuezhans != null) {
			for (Yuezhan yuezhan : yuezhans) {
				Map<String, Object> map = new HashMap<String, Object>();
				Contest contest = Service.contestService.getContestById(yuezhan
						.getMatchid());
				if(!contest.equals("已删除")){
					map.put("gameid", contest.getId());
					map.put("date", contest.getDate());
					map.put("time", contest.getTime());
					map.put("week", contest.getWeek());
					map.put("postdate", contest.getPostdate());
					map.put("adress", contest.getAdress());
					map.put("cost", contest.getCost());
					map.put("person", contest.getPerson());
					map.put("popenid", contest.getPopenid());
					map.put("pteamid", contest.getPteamid());
					String status = null;
					if(contest.getStatus().equals("等待约战")){
						status = "0";
					} else if(contest.getStatus().equals("约战成功")){
						if(compareToTime(contest.getDate()+" "+contest.getTime())){
							status = "2";
						}else status = "1";
					} else if(contest.getStatus().equals("等待取消")){
						status = "1";
					}else {
						status = "3";
					}
					map.put("status", status);
					if (contest.getMopenid() != null && contest.getMteamid() != null) {
							map.put("mteamid", contest.getMteamid());
							map.put("mopenid", contest.getMopenid());
					}
					int comment=0;
					//是否评论
					if(Service.commentService.isComment(openid, contest.getId())){
						comment = -1;
					}
					map.put("comment", comment);
					String requestUrl = "http://restapi.amap.com/v3/distance?origins="
							+ contest.getLng()
							+ ","
							+ contest.getLat()
							+ "&destination="
							+ mylng
							+ ","
							+ mylat
							+ "&type=0&output=json&key=" + key;
					String resJson = new HttpRequestor().doGet(requestUrl);
					JSONObject obj = JSONObject.parseObject(resJson);
					if (((String) obj.get("status")).equals("1")) {
						JSONArray results = (JSONArray) obj.get("results");
						JSONObject element = (JSONObject) results.get(0);
						String dis = String.valueOf(element.get("distance"));
						BigDecimal b = new BigDecimal(dis);
						if (b.compareTo(new BigDecimal(1000)) >= 0) {
							String distance = String.valueOf(Math.round(b
									.doubleValue() * 1.0 / 100d) / 10d);
							map.put("distance", distance + "km");
						} else {
							map.put("distance", b + "m");
						}
						map.put("sort", dis);
						list.add(map);
					}
				}
			}
			Collections.sort(list, new Comparator<Map>() {
				@Override
				public int compare(Map o1, Map o2) {
					Map<String, Object> map1 = (Map<String, Object>) o1;
					Map<String, Object> map2 = (Map<String, Object>) o2;
					String status1 = ((String) map1.get("status"));
					String status2 = ((String) map2.get("status"));
					String distance1 = ((String) map1.get("sort"));
					String distance2 = ((String) map2.get("sort"));
					if (status1.equals("1")) {
						if (status2.equals("0")) {
							return -1;
						} else if (status2.equals("1")) {
							if (new BigDecimal(distance1)
									.compareTo(new BigDecimal(distance2)) < 0) {
								return -1;
							}
							return 1;
						}
					} else if (status1.equals("0")) {
						if (status2.equals("1")) {
							return 1;
						} else if (status2.equals("0")) {
							if (new BigDecimal(distance1)
									.compareTo(new BigDecimal(distance2)) < 0) {
								return -1;
							}
							return 1;
						}
					}else if (status1.equals("2")) {
						return -1;
					}
					return 1;
				}
			});
		}
		return JSON.toJSONString(list);
	}

	/**
	 * 获取我的应战 identity = m
	 * 
	 * @param req
	 * @param rep
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getOtherYuzhanByOpenid", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getOtherYuzhanByOpenid(HttpServletRequest req,
			HttpServletResponse rep) throws Exception {
		String openid = req.getParameter("openid");  
		String identity = "m";
		String mylng = req.getParameter("mylng");
		String mylat = req.getParameter("mylat");
		if (mylng != null && mylat != null) {
			Service.lat = mylat;
			Service.lng = mylng;
		} else {
			mylat = Service.lat;
			mylng = Service.lng;
		}
		List<Map> list = new ArrayList<Map>();
		List<Yuezhan> yuezhans = Service.yuezhanService
				.getYuezhanByOpenidAndIdentity(openid, identity);
		if (yuezhans != null) {
			for (Yuezhan yuezhan : yuezhans) {
				Map<String, Object> map = new HashMap<String, Object>();
				Contest contest = Service.contestService.getContestById(yuezhan
						.getMatchid());
				if(!contest.equals("已删除")){
					map.put("gameid", contest.getId());
					map.put("date", contest.getDate());
					map.put("time", contest.getTime());
					map.put("week", contest.getWeek());
					map.put("postdate", contest.getPostdate());
					map.put("adress", contest.getAdress());
					map.put("cost", contest.getCost());
					map.put("person", contest.getPerson());
					map.put("popenid", contest.getPopenid());
					map.put("pteamid", contest.getPteamid());
					map.put("status", contest.getStatus());
					if (contest.getMopenid() != null && contest.getMteamid() != null) {
						map.put("mteamid", contest.getMteamid());
						map.put("mopenid", contest.getMopenid());
					}
					String status = null;
					if(contest.getStatus().equals("等待约战")){
						status = "0";
					} else if(contest.getStatus().equals("约战成功")){
						if(compareToTime(contest.getDate()+" "+contest.getTime())){
							status = "2";
						}else status = "1";
					}else if(contest.getStatus().equals("等待取消")){
						status = "1";
					} else {
						status = "3";
					}
					int comment=0;
					//是否评论
					if(Service.commentService.isComment(openid, contest.getId())){
						comment = -1;
					}
					map.put("comment", comment);
					map.put("status", status);
					String requestUrl = "http://restapi.amap.com/v3/distance?origins="
							+ contest.getLng()
							+ ","
							+ contest.getLat()
							+ "&destination="
							+ mylng
							+ ","
							+ mylat
							+ "&type=0&output=json&key=" + key;
					String resJson = new HttpRequestor().doGet(requestUrl);
					JSONObject obj = JSONObject.parseObject(resJson);
					if (((String) obj.get("status")).equals("1")) {
						JSONArray results = (JSONArray) obj.get("results");
						JSONObject element = (JSONObject) results.get(0);
						String dis = String.valueOf(element.get("distance"));
						BigDecimal b = new BigDecimal(dis);
						if (b.compareTo(new BigDecimal(1000)) >= 0) {
							String distance = String.valueOf(Math.round(b
									.doubleValue() * 1.0 / 100d) / 10d);
							map.put("distance", distance + "km");
						} else {
							map.put("distance", b + "m");
						}
						map.put("sort", dis);
						list.add(map);
					}
				}
			}
			Collections.sort(list, new Comparator<Map>() {
				@Override
				public int compare(Map o1, Map o2) {
					Map<String, Object> map1 = (Map<String, Object>) o1;
					Map<String, Object> map2 = (Map<String, Object>) o2;
					String status1 = ((String) map1.get("status"));
					String status2 = ((String) map2.get("status"));
					String distance1 = ((String) map1.get("sort"));
					String distance2 = ((String) map2.get("sort"));
					if (status1.equals("2")) {
						if (status2.equals("1")) {
							return -1;
						} else if (status2.equals("2")) {
							if (new BigDecimal(distance1)
									.compareTo(new BigDecimal(distance2)) < 0) {
								return -1;
							}
							return 1;
						}
					} else if (status1.equals("1")) {
						if (status2.equals("2")) {
							return 1;
						} else if (status2.equals("1")) {
							if (new BigDecimal(distance1)
									.compareTo(new BigDecimal(distance2)) < 0) {
								return -1;
							}
							return 1;
						}
					}else if (status1.equals("2")) {
						return -1;
					}
					return 1;
				}
			});
		}
		return JSON.toJSONString(list);
	}
	@RequestMapping(value = "/getMyMessage", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String getMyMessage(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String openid = req.getParameter("openid");
		String status = "0";
		Map<String,Object> map = new HashMap<String,Object>();
		List<Amessage> yuezhanamessage = Service.amessageService.getAmessageByMopenidAndStatus(openid,status); 
		Iterator<Amessage> it = yuezhanamessage.iterator();
		List<Amessage> cancelAmessage = new ArrayList<Amessage>();
		while(it.hasNext()){
			Amessage message = it.next();
			if(message.getContent().contains("申请取消")){
				cancelAmessage.add(message);
				it.remove();
			}
		}
		List<Nmessage> nmessage = new ArrayList<Nmessage>();
		if(!Service.nmessageService.getNmessageByOpenid(openid)){
			List<Notice> notices = Service.noticeService.findAllNotice();
			for(Notice notice : notices){
				Nmessage n = new Nmessage();
				n.setId(GetID.getUUID());
				 Date now = new Date();
				 n.setDate(getDateFormat(now));
				 n.setTime(getTimeFormat(now));
				 n.setOpenid(openid);
				 n.setNoticeid(notice.getId());
				 n.setStatus(status);
				 Service.nmessageService.addNmessage(n);
				 nmessage.add(n);
			}
		}else{
			nmessage = Service.nmessageService.getNmessageByOpenidAndStatus(openid,status);
		}
		List<Map> nmessagelist = new ArrayList<Map>();
		for(Nmessage nmsg :nmessage){
			Notice notice = Service.noticeService.findNoticeById(nmsg.getNoticeid());
			Map<String,Object> nmessagemap = AutomaticObjectUtil.objectToMap(nmsg);
			nmessagemap.put("noticecontent", notice.getTitle());
			nmessagelist.add(nmessagemap);
		}
		Collections.sort(yuezhanamessage, new Comparator<Amessage>() {
			@Override
			public int compare(Amessage o1, Amessage o2) {
				Amessage map1 = (Amessage) o1;
				Amessage map2 = (Amessage) o2;
				String date1 = (String) (map1.getDate());
				String date2 = (String)( map2.getDate());
				String time1 = (String) (map1.getTime());
				String time2 = (String) (map2.getTime());
				return compare_date(date1+" "+time1,date2+" "+time2);
			}
		});
		Collections.sort(cancelAmessage, new Comparator<Amessage>() {
			@Override
			public int compare(Amessage o1, Amessage o2) {
				Amessage map1 = (Amessage) o1;
				Amessage map2 = (Amessage) o2;
				String date1 = (String) (map1.getDate());
				String date2 = (String)( map2.getDate());
				String time1 = (String) (map1.getTime());
				String time2 = (String) (map2.getTime());
				return compare_date(date1+" "+time1,date2+" "+time2);
			}
		});
		Collections.sort(nmessagelist, new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				String date1 = (String) (o1.get("date"));
				String date2 = (String)(o2.get("date"));
				String time1 = (String)(o1.get("time"));
				String time2 = (String) (o2.get("time"));
				return compare_date(date1+" "+time1,date2+" "+time2);
			}
		});
		map.put("yuezhanamessage", yuezhanamessage);
		map.put("cancelamessage", cancelAmessage);
		map.put("nmessage", nmessagelist);
		return JSON.toJSONString(map);
	}

	private String accessToken() {
        String value="clientId="+clientId+"&clientSecret="+clientSecret;
		return sendGet("http://wx.5izuqiu.cn/api/V2/user/access_token", value);
	}
	private String get_softball(String accessToken,String userId,String softballId){
		String value="userId="+userId+"&"
        		+ "softballId"+softballId+"&"
        		+ "accessToken="+accessToken;
		return sendPost("http://wx.5izuqiu.cn/api/V2/softball/get_softball", value);
	}
	/**
	 * 向指定 URL 发送POST方法的请求
	 * @param url  发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	/**
 	* 向指定URL发送GET方法的请求
 	* @param url   发送请求的URL
 	* @param param  请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
 	* @return URL 所代表远程资源的响应结果
	*/
	private static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("contentType", "utf-8");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public static class Token{
		
		
		@Override
		public String toString() {
			return "Token [status=" + status + ", status_code=" + status_code + ", status_reason=" + status_reason
					+ ", data=" + data + "]";
		}

		public boolean status;
		
		public int status_code;
		
		public String status_reason;
		
		public DataToken data;
		
		public Token(){}
		
		public static class DataToken{
			
			public String accessToken;

			public String tokenType;
			
			public int expiresIn;
			
			public DataToken(){}
			
			public String getAccessToken() {
				return accessToken;
			}

			public void setAccessToken(String accessToken) {
				this.accessToken = accessToken;
			}

			public String getTokenType() {
				return tokenType;
			}

			public void setTokenType(String tokenType) {
				this.tokenType = tokenType;
			}

			public int getExpiresIn() {
				return expiresIn;
			}

			public void setExpiresIn(int expiresIn) {
				this.expiresIn = expiresIn;
			}

			@Override
			public String toString() {
				return "DataToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn
						+ "]";
			}
			
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public int getStatus_code() {
			return status_code;
		}

		public void setStatus_code(int status_code) {
			this.status_code = status_code;
		}

		public String getStatus_reason() {
			return status_reason;
		}

		public void setStatus_reason(String status_reason) {
			this.status_reason = status_reason;
		}

		public DataToken getData() {
			return data;
		}

		public void setData(DataToken data) {
			this.data = data;
		}
	}
	
	private  String getDateFormat(Date date) {
		  final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd";
		  DateFormat timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		  return timeFormat.format(date);
	}
	private  String getTimeFormat(Date date) {
		  final String TIME_DEFAULT_FORMAT = "HH:mm";
		  DateFormat timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		  return timeFormat.format(date);
	}
	private  int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
           if(dt1.compareTo(dt2)==0) 
        	   return -1;
           return -dt1.compareTo(dt2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
