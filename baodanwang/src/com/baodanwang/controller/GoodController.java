package com.baodanwang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baodanwang.pojo.Goods;
import com.baodanwang.pojo.Videoandimages;
import com.baodanwang.service.GoodsService;
import com.baodanwang.service.VideoAndImageService;
import com.baodanwang.util.GoodUtilBean;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class GoodController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private VideoAndImageService videoAndImageService;

	@ResponseBody
	@RequestMapping(value = "/goodList", method = RequestMethod.POST)
	public JSON GoodList(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		// page : "page", // 表示请求页码的参数名称
		// rows : "rows", // 表示请求行数的参数名称
		// search : "search", // 表示是否是搜索请求的参数名称
		// id : "id", // 表示当在编辑数据模块中发送数据时，使用的id的名称
		// editoper : "edit", // 当在edit模式中提交数据时，操作的名称
		// addoper : "add", // 当在add模式中提交数据时，操作的名称
		// deloper : "del", // 当在delete模式中提交数据时，操作的名称
		req.setCharacterEncoding("UTF-8");
		rep.setCharacterEncoding("UTF-8");
		String rows = req.getParameter("rows");
		String page = req.getParameter("page");
		String search = req.getParameter("search");
		String sord = req.getParameter("sord");
		String sidx = req.getParameter("sidx");
		JSONObject datas = null;
		List<Goods> goods = new ArrayList<Goods>();
		List<Goods> currentGoods = new ArrayList<Goods>();
		List<GoodUtilBean> goodData = new ArrayList<GoodUtilBean>();
		if (search.equals("true")) {
			String searchField = req.getParameter("searchField");
			String searchString = req.getParameter("searchString");
			goods = goodsService.searchGood(searchField, searchString, sidx, sord);
		} else {
			goods = goodsService.getGoodList(sidx, sord);
		}
		for (int i = 0; i < goods.size(); i++) {
			if (i >= (Integer.parseInt(page) - 1) * Integer.parseInt(rows)
					&& i < Integer.parseInt(page) * Integer.parseInt(rows)) {
				currentGoods.add(goods.get(i));
			}
		}
		for (int i = 0; i < currentGoods.size(); i++) {
			GoodUtilBean googbean = new GoodUtilBean(currentGoods.get(i).getGoodId(), currentGoods.get(i).getStoreId(),
					currentGoods.get(i).getGoodName(), currentGoods.get(i).getGoodShowstatus(),
					currentGoods.get(i).getGoodPrice(), currentGoods.get(i).getGoodAdvanceprice(),
					currentGoods.get(i).getGoodDescribe(), currentGoods.get(i).getGoodAddtime());
			List<Videoandimages> videoAndImage = videoAndImageService
					.getVideoandimagesList(currentGoods.get(i).getGoodId());
			String video = "";
			String image = "";
			for (int j = 0; j < videoAndImage.size(); j++) {
				if (videoAndImage.get(j).getType().equals("image")) {
					image = image + videoAndImage.get(j).getType() + '!' + videoAndImage.get(j).getVideoImages() + ",";
				} else {
					video = video + videoAndImage.get(j).getType() + '!' + videoAndImage.get(j).getVideoImages() + ",";
				}
			}
			if(image.length()>0) {
				image = image.substring(0,image.length()-1);
			}
			if(video.length()>0) {
				video = video.substring(0,video.length()-1);
			}
			googbean.setImage(image);
			googbean.setVideo(video);
			goodData.add(googbean);
		}
		JSONArray ja = JSONArray.fromObject(goodData);
		int totalPages = 0;
		if (goods.size() <= Integer.parseInt(rows)) {
			totalPages = 1;
		} else {
			totalPages = goods.size() / Integer.parseInt(rows) + 1;
		}
		String data = "{\"page\":\"" + page + "\"," + "\"totalPages\":\"" + totalPages + "\"," + "\"records\":\""
				+ goods.size() + "\"," + "\"rows\":" + ja.toString() + "}";
		datas = JSONObject.fromObject(data);
		return datas;
	}

	@RequestMapping(value = "/updataGood", method = RequestMethod.POST)
	public void updataGood(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("UTF-8");
		rep.setCharacterEncoding("UTF-8");
		String idstr = req.getParameter("id");
		String[] ids = idstr.split(",");
		for (String id : ids) {
			goodsService.deleteGood(id);
		}
	}
}