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

import com.baodanwang.pojo.Stores;
import com.baodanwang.service.StoresService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class storeController {
	@Autowired
	private StoresService storesService;

	@ResponseBody
	@RequestMapping(value = "/storeList", method = RequestMethod.POST)
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
		List<Stores> stores = new ArrayList<Stores>();
		List<Stores> currentStores = new ArrayList<Stores>();
		if (search.equals("true")) {
			String searchField = req.getParameter("searchField");
			String searchString = req.getParameter("searchString");
			stores = storesService.searchStore(searchField, searchString, sidx, sord);
		} else {
			stores = storesService.getStoreList(sidx, sord);

		}
		for (int i = 0; i < stores.size(); i++) {
			if (i >= (Integer.parseInt(page) - 1) * Integer.parseInt(rows)
					&& i < Integer.parseInt(page) * Integer.parseInt(rows)) {
				currentStores.add(stores.get(i));
			}
		}
		JSONArray ja = JSONArray.fromObject(currentStores);
		int totalPages = 0;
		if (stores.size() <= Integer.parseInt(rows)) {
			totalPages = 1;
		} else {
			totalPages = stores.size() / Integer.parseInt(rows) + 1;
		}
		String data = "{\"page\":\"" + page + "\"," + "\"totalPages\":\"" + totalPages + "\"," + "\"records\":\""
				+ stores.size() + "\"," + "\"rows\":" + ja.toString() + "}";
		datas = JSONObject.fromObject(data);
		return datas;
	}

	@RequestMapping(value = "/updataStore", method = RequestMethod.POST)
	public void updataUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("UTF-8");
		rep.setCharacterEncoding("UTF-8");
		String idstr = req.getParameter("id");
		String oper = req.getParameter("oper");
		if(oper.equals("del")) {
			String[] ids = idstr.split(",");
			for (String id : ids) {
				storesService.deleteStore(id);
			}
		}else {
			String storeName = req.getParameter("storeName");
			String storeTel = req.getParameter("storeTel");
			String storeWechatid = req.getParameter("storeWechatid");
			String storeAddress = req.getParameter("storeAddress");
			String storeAddressdetail = req.getParameter("storeAddressdetail");
			String storePickupsite = req.getParameter("storePickupsite");
			String balance = req.getParameter("balance");
			String storePickupsitedetail = req.getParameter("storePickupsitedetail");
			String storeId = req.getParameter("storeId");
			Stores stores = storesService.getStore(storeId);
			if (storeName != null) {
				stores.setStoreId(storeName);
			}
			if (storeTel != null) {
				stores.setStoreTel(storeTel);
			}
			if (storeWechatid != null) {
				stores.setStoreWechatid(storeWechatid);
			}
			if (storeAddress != null) {
				stores.setStoreAddress(storeAddress);
			}
			if (storePickupsite != null) {
				stores.setStorePickupsite(storePickupsite);
			}
			if(storeAddressdetail!=null) {
				stores.setStoreAddressdetail(storeAddressdetail);
			}
			if(balance!=null) {
				stores.setBalance(balance);
			}
			if(storePickupsitedetail!=null) {
				stores.setStorePickupsitedetail(storePickupsitedetail);
			}
			storesService.upDataStore(stores);
		}
	}
}
