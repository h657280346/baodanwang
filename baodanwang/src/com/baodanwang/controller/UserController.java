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

import com.baodanwang.pojo.Users;
import com.baodanwang.service.UsersService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class UserController {

	@Autowired
	private UsersService usersService;

	@ResponseBody
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public JSON UserList(HttpServletRequest req, HttpServletResponse rep) throws Exception {
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
		List<Users> users = new ArrayList<Users>();
		List<Users> currentUser = new ArrayList<Users>();
		if (search.equals("true")) {
			String searchField = req.getParameter("searchField");
			String searchString = req.getParameter("searchString");
			users = usersService.searchUser(searchField, searchString, sidx, sord);
		} else {
			users = usersService.getUserList(sidx, sord);

		}
		for (int i = 0; i < users.size(); i++) {
			if (i >= (Integer.parseInt(page) - 1) * Integer.parseInt(rows)
					&& i < Integer.parseInt(page) * Integer.parseInt(rows)) {
				currentUser.add(users.get(i));
			}
		}
		JSONArray ja = JSONArray.fromObject(currentUser);
		int totalPages = 0;
		if (users.size() <= Integer.parseInt(rows)) {
			totalPages = 1;
		} else {
			totalPages = users.size() / Integer.parseInt(rows) + 1;
		}
		String data = "{\"page\":\"" + page + "\"," + "\"totalPages\":\"" + totalPages + "\"," + "\"records\":\""
				+ users.size() + "\"," + "\"rows\":" + ja.toString() + "}";
		datas = JSONObject.fromObject(data);
		return datas;
	}

	@RequestMapping(value = "/updataUser", method = RequestMethod.POST)
	public void updataUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("UTF-8");
		rep.setCharacterEncoding("UTF-8");
		String idstr = req.getParameter("id");
		String[] ids = idstr.split(",");
		for (String id : ids) {
			usersService.deleteUser(id);
		}
	}
}
