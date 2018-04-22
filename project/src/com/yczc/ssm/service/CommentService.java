package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Comment;

public interface CommentService {
	public boolean isComment(String openid,String gameid) throws Exception;
	public List<Comment> getCommentsByMatchid(String matchid) throws Exception;
	public List<Comment> getCommentsByTeamId(String teamid) throws Exception;
	public boolean addComment(Comment comment) throws Exception;
	public List<Comment> findAllComment() throws Exception;
	public Comment findCommentById(String id) throws Exception;
	public boolean updateComment(Comment comment) throws Exception;
	public boolean deleteComment(String id) throws Exception;
	public int count() throws Exception;
}
