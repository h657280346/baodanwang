package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.HighlightsMapper;
import com.yczc.ssm.pojo.Highlights;
import com.yczc.ssm.service.HighlightsService;

@Service("highlightsService")
public class HighlightsServiceImpl implements HighlightsService {
	@Autowired
	private HighlightsMapper highlightsMapper = null;
	public boolean addHighlights(Highlights highlights) throws Exception {
		boolean flag = highlightsMapper.addHighlights(highlights);
		return flag;
	}

	public List<Highlights> findAllHighlights() throws Exception {
		List<Highlights> highs = highlightsMapper.findAllHighlights();
		return highs;
	}

	public Highlights findHighlightsById(String id) throws Exception {
		Highlights high = highlightsMapper.findHighlightsById(id);
		return high;
	}

	public boolean updateHighlights(Highlights highlights) throws Exception {
		boolean flag = highlightsMapper.updateHighlights(highlights);
		return flag;
	}

	public boolean deleteHighlights(String id) throws Exception {
		boolean flag = highlightsMapper.deleteHighlights(id);
		return flag;
	}

	public int count() throws Exception {
		int count = highlightsMapper.count();
		return count;
	}

	public List<Highlights> findHighlightsByFigure() throws Exception {
		List<Highlights> high = highlightsMapper.findHighlightsByFigure();
		return high;
	}

	public boolean updateHighlightsView(String id) throws Exception {
		boolean flag = highlightsMapper.updateHighlightsView(id);
		return flag;
	}

}
