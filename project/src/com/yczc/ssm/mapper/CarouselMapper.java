package com.yczc.ssm.mapper;

import java.util.List;

import com.yczc.ssm.pojo.Carousel;

public interface CarouselMapper {
	public boolean addCarousel(Carousel carousel) throws Exception;
	public List<Carousel> findAllCarousel() throws Exception;
	public List<Carousel> getCarousel(int num) throws Exception;
	public Carousel findCarouselById(String id) throws Exception;
	public boolean updateCarousel(Carousel carousel) throws Exception;
	public boolean deleteCarousel(String id) throws Exception;
	public int count() throws Exception;
}
