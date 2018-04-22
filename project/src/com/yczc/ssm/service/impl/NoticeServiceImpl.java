package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.NoticeMapper;
import com.yczc.ssm.pojo.Notice;
import com.yczc.ssm.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper = null;
	@Override
	public boolean addNotice(Notice notice) throws Exception {
		boolean flag = noticeMapper.addNotice(notice);
		return flag;
	}

	@Override
	public List<Notice> findAllNotice() throws Exception {
		return noticeMapper.findAllNotice();
	}

	@Override
	public Notice findNoticeById(String id) throws Exception {
		return noticeMapper.findNoticeById(id);
	}

	@Override
	public boolean updateNotice(Notice notice) throws Exception {
		return noticeMapper.updateNotice(notice);
	}

	@Override
	public boolean deleteNotice(String id) throws Exception {
		return noticeMapper.deleteNotice(id);
	}

	@Override
	public int count() throws Exception {
		return noticeMapper.count();
	}

	@Override
	public List<Notice> getNotice(int num) throws Exception {
		
		return noticeMapper.getNotice(num);
	}

}
