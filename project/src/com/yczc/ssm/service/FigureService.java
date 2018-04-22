package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Figure;

public interface FigureService {

	public List<Figure> findAllFigure() throws Exception;
	public boolean updateFigure(Figure figure) throws Exception;

}
