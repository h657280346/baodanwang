package com.yczc.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yczc.ssm.pojo.Comment;
import com.yczc.ssm.service.CommentService;
import com.yczc.ssm.util.AutomaticObjectUtil;
import com.yczc.ssm.util.GetID;

/**
 * 评论
 * @author liu_yeye
 *
 */
@Controller
public class CommentController {
	@Autowired
	private  CommentService commentService = null;
	
	/**
	  * 查找所有评论
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/commentShow")
	 public void show(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		 List<Comment> comments = commentService.findAllComment();
		 req.setAttribute("comments", comments);
		 req.getRequestDispatcher("./comment/index.jsp").forward(req, rep);
	 }
	 /**
	  * 根据id获取评论
	  * @param req
	  * @param rep
	  * @throws Exception
	  */
	 @RequestMapping(value="/findCommentById")
	 public void findCommentById(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = req.getParameter("id");
		Comment comment = commentService.findCommentById(id);
		req.setAttribute("comment", comment);
		req.getRequestDispatcher("./comment/update.jsp").forward(req, rep);
	 }
	 /**
	  * 保存评论
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/commentAdd")
	public void add(HttpServletRequest req,HttpServletResponse rep) throws Exception {
	   
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Comment.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(), GetID.getUUID());
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Comment comment =(Comment) AutomaticObjectUtil.newInstance(map, Comment.class);
		commentService.addComment(comment);
		rep.sendRedirect("./commentShow.action");
	}
	 /**
	  * 更新约战
	  * @param req
	  * @param rep
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/commentUpdate")
	public void update(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Entry<String, Object> entry: AutomaticObjectUtil.getFieldsName(Comment.class).entrySet()){
			if(entry.getKey().equals("id")){
				map.put(entry.getKey(),  req.getParameter(entry.getKey()));
			}else if(entry.getValue() == Integer.class){
				Integer i = Integer.valueOf(req.getParameter(entry.getKey()));
				map.put(entry.getKey(), i);
			} else {
				map.put(entry.getKey(), req.getParameter(entry.getKey()));
			}
		}
		Comment comment =(Comment) AutomaticObjectUtil.newInstance(map, Comment.class);
		commentService.updateComment(comment);
		rep.sendRedirect("./commentShow.action");
	}
	/**
	 * 删除
	 * @param req
	 * @param rep
	 * @throws Exception
	 */
	@RequestMapping(value="/commentDelete")
	public void delete(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String id = null;
		id = req.getParameter("id");
		if(id.contains(",")) {
			String[] ids = id.split(",");
			for (String did : ids) {
				if(did!=null&&!did.equals("")) {
					commentService.deleteComment(did);
				}
			}
		}else {
			commentService.deleteComment(id);
		}
		rep.sendRedirect("./commentShow.action");
	}
	@RequestMapping(value="/skipComment")
	public String skipComment() {
		return "../comment/add";
	}

}
