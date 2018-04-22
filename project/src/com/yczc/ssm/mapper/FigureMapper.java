package com.yczc.ssm.mapper;

import java.util.List;

import com.yczc.ssm.pojo.Figure;

public interface FigureMapper {

	public List<Figure> findAllFigure() throws Exception;
	public boolean updateFigure(Figure figure) throws Exception;

}
