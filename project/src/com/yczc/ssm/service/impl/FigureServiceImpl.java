package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.FigureMapper;
import com.yczc.ssm.pojo.Figure;
import com.yczc.ssm.service.FigureService;

@Service("figureService")
public class FigureServiceImpl implements FigureService{

	@Autowired
	private FigureMapper figureMapper = null;
	public List<Figure> findAllFigure() throws Exception {
		List<Figure> figures = figureMapper.findAllFigure();
		return figures;
	}
	public boolean updateFigure(Figure figure) throws Exception {
		boolean flag = figureMapper.updateFigure(figure);
		return flag;
	}

}
