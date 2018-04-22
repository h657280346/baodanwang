package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.CommentMapper;
import com.yczc.ssm.pojo.Comment;
import com.yczc.ssm.pojo.CommentExample;
import com.yczc.ssm.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper = null;

	@Override
	public List<Comment> getCommentsByTeamId(String teamid) throws Exception{
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andTeamidEqualTo(teamid);
		List<Comment> comments = commentMapper.selectByExample(example);
		if(comments == null){
			return null;
		}
		return comments;
	}
	@Override
	public boolean isComment(String openid,String gameid) throws Exception {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(gameid);
		criteria.andOpenidEqualTo(openid);
		List<Comment> comments = commentMapper.selectByExample(example);
		if(comments!=null&&comments.size()!=0){
			return true;
		}
		return false;
	}
	@Override
	public boolean addComment(Comment comment) throws Exception {
		if(commentMapper.insertSelective(comment)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> findAllComment() throws Exception {
		return commentMapper.selectByExample(null);
	}

	@Override
	public Comment findCommentById(String id) throws Exception {
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateComment(Comment comment) throws Exception {
		if(commentMapper.updateByPrimaryKeySelective(comment)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteComment(String id) throws Exception {
		if(commentMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		return commentMapper.countByExample(null);
	}

	@Override
	public List<Comment> getCommentsByMatchid(String matchid) throws Exception {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andMatchidEqualTo(matchid);
		List<Comment> comments = commentMapper.selectByExample(example);
		return comments;
	}

}
