package com.yczc.ssm.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Carousel;
import com.yczc.ssm.pojo.Success;
import com.yczc.ssm.service.CarouselService;
import com.yczc.ssm.util.Address;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 轮播
 * @author liu_yeye
 *
 */
@Controller
public class CarouselController {
	@Autowired
	private CarouselService carouselService=null;
	

	/**
	  * 查找所有轮播
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/carouselShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Carousel> carousels = carouselService.findAllCarousel();
		 req.setAttribute("carousels", carousels);
		 req.getRequestDispatcher("./carousel/index.jsp").forward(req, rep);
	 }

	 /**
	  * 根据id获取轮播
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findCarouselById")
	 public void findcarouselById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Carousel carousel = carouselService.findCarouselById(id);
		req.setAttribute("carousel", carousel);
		req.getRequestDispatcher("./carousel/update.jsp").forward(req, rep);
	 }
	 /**	
	  * 保存轮播
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/carouselAdd")
	public void add(@RequestParam("myPhoto") MultipartFile file,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = GetID.getUUID();
		String title = req.getParameter("title");
		String introduce = req.getParameter("introduce");
		introduce = introduce.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Integer priority = Integer.valueOf(req.getParameter("priority"));
		String videourl = req.getParameter("videourl");
		String imgpath = saveFile(file);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("title", title);
		map.put("introduce", introduce);
		map.put("priority", priority);
		map.put("videourl", videourl);
		map.put("img", imgpath);
		Carousel carousel = (Carousel) AutomaticObjectUtil.newInstance(map, Carousel.class);
		carouselService.addCarousel(carousel);
		rep.sendRedirect("./carouselShow.action");
	}
	/**
	 * 保存上传文件
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file) {
        String path = null;
		if (!file.isEmpty()) {
            try {
            	StringTokenizer st = new StringTokenizer(file.getOriginalFilename(), ".");
            	String later = null;
            	while(st.hasMoreTokens()) {
            		later = st.nextToken();
            	}
            	String time = System.currentTimeMillis()+"";
                path = ResourceBundle.getBundle("conn").getString("savepath")+ "\\upload\\img\\"+time+"."+later;
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
                path = Address.address + "/upload/img/"+time+"."+later;
                return path;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	 /**
	  * 更新轮播
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/carouselUpdate")
	public void update(@RequestParam("myPhoto") MultipartFile file,HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String introduce = req.getParameter("introduce");
		introduce = introduce.replaceFirst(ResourceBundle.getBundle("conn").getString("savepath"), "");
		Integer priority = Integer.valueOf(req.getParameter("priority"));
		String videourl = req.getParameter("videourl");
		String imgpath  = saveFile(file);
		if(imgpath==null){
			imgpath  = req.getParameter("picture");
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("title", title);
		map.put("introduce", introduce);
		map.put("priority", priority);
		map.put("videourl", videourl);
		map.put("img", imgpath);
		Carousel carousel = (Carousel) AutomaticObjectUtil.newInstance(map, Carousel.class);
		carouselService.updateCarousel(carousel);
		rep.sendRedirect("./carouselShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/carouselDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					carouselService.deleteCarousel(did);
				}
			}
		}else {
			carouselService.deleteCarousel(id);
		}
		rep.sendRedirect("./carouselShow.action");
	}
	@RequestMapping(value="/skipCarousel")
	public String skipCarousel() {
		return "../carousel/add";
	}
}
