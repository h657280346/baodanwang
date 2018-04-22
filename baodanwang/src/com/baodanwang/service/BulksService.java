package com.baodanwang.service;

import java.util.List;

import com.baodanwang.pojo.Bulks;

public interface BulksService {

	public List<Bulks> getBulkList(String sidx, String sord) throws Exception;

	public void deleteBulk(String bulkId) throws Exception;

	public List<Bulks> searchBulk(String searchField, String searchString, String sidx, String sord) throws Exception;

	public int insertBulk(Bulks bulk) throws Exception;

	public Bulks getBulk(String bulkId) throws Exception;

	public int updataBulk(Bulks bulk) throws Exception;
}
