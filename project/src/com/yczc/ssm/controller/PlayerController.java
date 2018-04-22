package com.yczc.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Player;
import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.service.PlayerService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 球员
 * @author liu_yeye
 *
 */
@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService playerService = null;
	/**
	  * 查找所有球员
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/playerShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Player> players = playerService.getAllPlayer();
		 req.setAttribute("players", players);
		 req.getRequestDispatcher("./player/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取球员
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findPlayerById")
	 public void findPlayerById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Player player = playerService.getPlayerById(id);
		req.setAttribute("player", player);
		req.getRequestDispatcher("./player/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存球员
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/playerAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Player.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(), GetID.getUUID());
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Player player =(Player) AutomaticObjectUtil.newInstance(map, Player.class);
		playerService.addPlayer(player);
		rep.sendRedirect("./playerShow.action");
	}
	 /**
	  * 更新球员
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/playerUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Player.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(),  req.getParameter(entry.getKey()));
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Player player =(Player) AutomaticObjectUtil.newInstance(map, Player.class);
		playerService.updatePlayer(player);
		rep.sendRedirect("./playerShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/playerDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					playerService.deletePlayer(did);
				}
			}
		}else {
			playerService.deletePlayer(id);
		}
		rep.sendRedirect("./playerShow.action");
	}
	@RequestMapping(value="/skipPlayer")
	public String skipPlayer() {
		return "../player/add";
	}

}
