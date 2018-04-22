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

import com.baodanwang.pojo.Bulks;
import com.baodanwang.service.BulksService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class BulkController {

	@Autowired
	private BulksService bulksService;
	
	@ResponseBody
	@RequestMapping(value = "/bulkList", method = RequestMethod.POST)
	public JSON BulkList(HttpServletRequest req, HttpServletResponse rep) throws Exception {
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
		List<Bulks> bulks = new ArrayList<Bulks>();
		List<Bulks> currentBulks = new ArrayList<Bulks>();
		if (search.equals("true")) {
			String searchField = req.getParameter("searchField");
			String searchString = req.getParameter("searchString");
			bulks = bulksService.searchBulk(searchField, searchString, sidx, sord);
		} else {
			bulks = bulksService.getBulkList(sidx, sord);

		}
		for (int i = 0; i < bulks.size(); i++) {
			if (i >= (Integer.parseInt(page) - 1) * Integer.parseInt(rows)
					&& i < Integer.parseInt(page) * Integer.parseInt(rows)) {
				currentBulks.add(bulks.get(i));
			}
		}
		JSONArray ja = JSONArray.fromObject(currentBulks);
		int totalPages = 0;
		if (bulks.size() <= Integer.parseInt(rows)) {
			totalPages = 1;
		} else {
			totalPages = bulks.size() / Integer.parseInt(rows) + 1;
		}
		String data = "{\"page\":\"" + page + "\"," + "\"totalPages\":\"" + totalPages + "\"," + "\"records\":\""
				+ bulks.size() + "\"," + "\"rows\":" + ja.toString() + "}";
		datas = JSONObject.fromObject(data);
		return datas;
	}

	@RequestMapping(value = "/updataBulk", method = RequestMethod.POST)
	public void updataBulk(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("UTF-8");
		rep.setCharacterEncoding("UTF-8");
		String idstr = req.getParameter("id");
		String[] ids = idstr.split(",");
		for (String id : ids) {
			bulksService.deleteBulk(id);
		}
	}
}
