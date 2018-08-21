package com.example.mongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mongo.domain.Criteria;
import com.example.mongo.domain.FileDetailVO;

@Service
public interface FileDetailService {
	
	public List<FileDetailVO> findAll();
	public List<FileDetailVO> findDay(FileDetailVO vo);
	public List<FileDetailVO> findBook(FileDetailVO vo);
	public List<FileDetailVO> findBookAll(String day);
	public List<FileDetailVO> list(String day, Criteria criteria);
	public long BookCount(String day);
}
