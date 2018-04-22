package com.baodanwang.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baodanwang.pojo.Homeimage;
import com.baodanwang.service.HomeImageService;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@Controller
public class HomeImageController {

	@Autowired
	private HomeImageService homeImageService;

	@ResponseBody
	@RequestMapping(value = "/getHomeImage", method = RequestMethod.POST)
	public JSON getHomeImage(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Homeimage homeimage = homeImageService.getHomeImage();
		String image = homeimage.getHomeImage();
		homeimage.setHomeImage("http://7vnk87.natappfree.cc/baodanwang" + image);
		return JSONObject.fromObject(homeimage);
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadHomeImage", method = RequestMethod.POST)
	public JSON uploadHomeImage(HttpServletRequest req, HttpServletResponse rep,
			@RequestParam("homeImage") MultipartFile file) throws Exception {
		String filePath = req.getServletContext().getRealPath("upload");
		String filename = file.getOriginalFilename();
		File targetFile = new File(filePath, filename);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 文件路径
		String path = "/upload/" + filename;
		Homeimage homeImage = new Homeimage();
		homeImage.setHomeImage(path);
		homeImageService.setHomeImage(homeImage);
		JSONObject result = new JSONObject();
		result.put("filePath", path);
		return result;
	}
}
