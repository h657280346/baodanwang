package com.baodanwang.service;

import java.util.List;

import com.baodanwang.pojo.Stores;

public interface StoresService {
	public List<Stores> getStoreList(String sidx, String sord) throws Exception;

	public void deleteStore(String storeId) throws Exception;

	public List<Stores> searchStore(String searchField, String searchString, String sidx, String sord) throws Exception;

	public Stores getStore(String storeOpenid,String storeNickname,String storeAvatarurl) throws Exception;
	
	public Stores getStore(String storeId)throws Exception;
	
	public int upDataStore(Stores store)throws Exception;
}
