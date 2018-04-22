package com.yczc.ssm.mapper;

import java.util.List;

import com.yczc.ssm.pojo.Highlights;

public interface HighlightsMapper {
	public boolean addHighlights(Highlights highlights) throws Exception;
	public List<Highlights> findAllHighlights() throws Exception;
	public Highlights findHighlightsById(String id) throws Exception;
	public boolean updateHighlights(Highlights highlights) throws Exception;
	public boolean updateHighlightsView(String id) throws Exception;
	public boolean deleteHighlights(String id) throws Exception;
	public int count() throws Exception;
	public List<Highlights> findHighlightsByFigure() throws Exception;
}
