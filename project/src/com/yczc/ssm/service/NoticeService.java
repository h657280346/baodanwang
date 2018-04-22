package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Notice;


public interface NoticeService {
	public boolean addNotice(Notice notice) throws Exception;
	public List<Notice> findAllNotice() throws Exception;
	public List<Notice> getNotice(int num) throws Exception;
	public Notice findNoticeById(String id) throws Exception;
	public boolean updateNotice(Notice notice) throws Exception;
	public boolean deleteNotice(String id) throws Exception;
	public int count() throws Exception;

}
