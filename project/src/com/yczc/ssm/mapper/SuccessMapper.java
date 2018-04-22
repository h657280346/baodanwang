package com.yczc.ssm.mapper;

import java.util.List;

import com.yczc.ssm.pojo.Success;

public interface SuccessMapper {
	
	public boolean addSuccess(Success success) throws Exception;
	public List<Success> findAllSuccess() throws Exception;
	public Success findSuccessById(String id) throws Exception;
	public boolean updateSuccess(Success success) throws Exception;
	public boolean updateSuccessView(String id) throws Exception;
	public boolean deleteSuccess(String id) throws Exception;
	public int count() throws Exception;
	public List<Success> findSuccessByFigure() throws Exception;
	
}
