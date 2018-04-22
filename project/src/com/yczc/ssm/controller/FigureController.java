package com.yczc.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.pojo.Figure;
import com.yczc.ssm.pojo.Highlights;
import com.yczc.ssm.pojo.Interesting;
import com.yczc.ssm.pojo.Success;
import com.yczc.ssm.service.HighlightsService;
import com.yczc.ssm.service.InterestingService;
import com.yczc.ssm.service.SuccessService;

@Controller
public class FigureController {
	
	@Autowired
	private HighlightsService highService = null;
	@Autowired
	private InterestingService intereService = null;
	@Autowired
	private SuccessService successService = null;
	
	@RequestMapping(value="/figureAll",produces="text/html;charset=UTF-8")
	 public @ResponseBody String  findAll() throws Exception {
		List all = new ArrayList();
		for (Success success : successService.findSuccessByFigure()) {
			all.add(success);
		}
		for (Interesting interesting : intereService.findInterestingByFigure()) {
			all.add(interesting);
		}
		for (Highlights highlights : highService.findHighlightsByFigure()) {
			all.add(highlights);
		}
		
		return JSON.toJSONString(all);
	 }
//	@RequestMapping(value="/skipFigure")
//	public String skipFigure(HttpServletRequest req,HttpServletResponse rep) throws Exception {
//		List<Figure> figures = figureService.findAllFigure();
//		req.setAttribute("figure1", figures.get(0));
//		req.setAttribute("figure2", figures.get(1));
//		req.setAttribute("figure3", figures.get(2));
//		req.setAttribute("figure4", figures.get(3));
//		return "../figure/add";
//	}
//	@RequestMapping(value="/figureUpadte")
//	public void add(@RequestParam("myPhoto1") MultipartFile file1,@RequestParam("myPhoto2") MultipartFile file2,@RequestParam("myPhoto3") MultipartFile file3,@RequestParam("myPhoto4") MultipartFile file4,HttpServletRequest req,HttpServletResponse rep) throws Exception {
//		String path1 = null;
//		String path2 = null;
//		String path3 = null;
//		String path4 = null;
//		path1 = saveFile(file1);
//		path2 = saveFile(file2);
//		path3 = saveFile(file3);
//		path4 = saveFile(file4);
//		if(path1!=null) {
//			Figure figure = new Figure();
//			figure.setId(0);
//			figure.setImg(path1);
//			figureService.updateFigure(figure);
//		}
//		if(path2!=null) {
//			Figure figure = new Figure();
//			figure.setId(1);
//			figure.setImg(path2);
//			figureService.updateFigure(figure);
//		}
//		if(path3!=null) {
//			Figure figure = new Figure();
//			figure.setId(2);
//			figure.setImg(path3);
//			figureService.updateFigure(figure);
//		}
//		if(path4!=null) {
//			Figure figure = new Figure();
//			figure.setId(3);
//			figure.setImg(path4);
//			figureService.updateFigure(figure);
//		}
//
//		rep.sendRedirect("./skipFigure.action");
//	}
//	/**
//	 * 保存上传文件
//	 * @param file
//	 * @return
//	 */
//	private String saveFile(MultipartFile file) {
//        String path = null;
//		if (!file.isEmpty()) {
//            try {
//            	StringTokenizer st = new StringTokenizer(file.getOriginalFilename(), ".");
//            	String later = null;
//            	while(st.hasMoreTokens()) {
//            		later = st.nextToken();
//            	}
//            	String time = System.currentTimeMillis()+"";
//                path = servletContext.getRealPath("") + File.separator + "upload\\img\\"+time+"."+later;
//                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
//                path = Address.address + "/upload/img/"+time+"."+later;
//                return path;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
}
