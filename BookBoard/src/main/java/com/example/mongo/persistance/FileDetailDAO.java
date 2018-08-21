package com.example.mongo.persistance;

import java.util.List;

import com.example.mongo.domain.Criteria;
import com.example.mongo.domain.FileDetailVO;

public interface FileDetailDAO {
	
	public List<FileDetailVO> findAll();
	public List<FileDetailVO> findDay(FileDetailVO vo);
	public List<FileDetailVO> findBook(FileDetailVO vo);
	public List<FileDetailVO> findBookAll(String day);
	public List<FileDetailVO> listCriteria(String day, Criteria criteria);
	public long BookCount(String day);
}
