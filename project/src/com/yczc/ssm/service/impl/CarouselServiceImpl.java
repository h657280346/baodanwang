package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.CarouselMapper;
import com.yczc.ssm.pojo.Carousel;
import com.yczc.ssm.service.CarouselService;

@Service("carouselService")
public class CarouselServiceImpl implements CarouselService{
	
	@Autowired
	private CarouselMapper carouselMapper=null;

	@Override
	public boolean addCarousel(Carousel carousel) throws Exception {
		
		return carouselMapper.addCarousel(carousel);
	}

	@Override
	public List<Carousel> findAllCarousel() throws Exception {
		
		return carouselMapper.findAllCarousel();
	}

	@Override
	public Carousel findCarouselById(String id) throws Exception {
		
		return carouselMapper.findCarouselById(id);
	}

	@Override
	public boolean updateCarousel(Carousel carousel) throws Exception {
		
		return carouselMapper.updateCarousel(carousel);
	}

	@Override
	public boolean deleteCarousel(String id) throws Exception {
	
		return carouselMapper.deleteCarousel(id);
	}

	@Override
	public int count() throws Exception {
		
		return carouselMapper.count();
	}

	@Override
	public List<Carousel> getCarousel(int num) throws Exception {
		
		return carouselMapper.getCarousel(num);
	}

}
