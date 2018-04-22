package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.SuccessMapper;
import com.yczc.ssm.pojo.Success;
import com.yczc.ssm.service.SuccessService;

@Service("successService")
public class SuccessServiceImpl implements SuccessService{
	@Autowired
	private SuccessMapper successMapper = null;

	public boolean addSuccess(Success success) throws Exception {
		boolean flag = successMapper.addSuccess(success);
		return flag;
	}

	public List<Success> findAllSuccess() throws Exception {
		List<Success> success = successMapper.findAllSuccess();
		return success;
	}

	public Success findSuccessById(String id) throws Exception {
		Success success = successMapper.findSuccessById(id);
		return success;
	}

	public boolean updateSuccess(Success success) throws Exception {
		boolean flag = successMapper.updateSuccess(success);
		return flag;
	}

	public boolean deleteSuccess(String id) throws Exception {
		boolean flag = successMapper.deleteSuccess(id);
		return flag;
	}

	public int count() throws Exception {
		int count = successMapper.count();
		return count;
	}

	public List<Success> findSuccessByFigure() throws Exception {
		List<Success> success = successMapper.findSuccessByFigure();
		return success;
	}

	public boolean updateSuccessView(String id) throws Exception {
		boolean flag = successMapper.updateSuccessView(id);
		return flag;
	}
}
