package com.baodanwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baodanwang.mapper.HomeimageMapper;
import com.baodanwang.pojo.Homeimage;
import com.baodanwang.pojo.HomeimageExample;
import com.baodanwang.service.HomeImageService;

@Service("homeImageService")
public class HomeImageServiceImpl implements HomeImageService {

	@Autowired
	private HomeimageMapper homeimageMapper = null;

	@Override
	public Homeimage getHomeImage() throws Exception {
		HomeimageExample example = new HomeimageExample();
		HomeimageExample.Criteria criteria = example.createCriteria();
		criteria.andHomeImageNotEqualTo("null");
		List<Homeimage> homeImage = homeimageMapper.selectByExample(example);
		return homeImage.get(0);
	}

	@Override
	public int setHomeImage(Homeimage homeImage) throws Exception {
		HomeimageExample example = new HomeimageExample();
		HomeimageExample.Criteria criteria = example.createCriteria();
		criteria.andHomeImageNotEqualTo("null");
		int result = homeimageMapper.updateByExample(homeImage, example);
		return result;
	}

}