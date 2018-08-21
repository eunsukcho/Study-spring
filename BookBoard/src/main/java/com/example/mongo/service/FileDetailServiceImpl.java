package com.example.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.domain.Criteria;
import com.example.mongo.domain.FileDetailVO;
import com.example.mongo.persistance.FileDetailDAO;

@Service
public class FileDetailServiceImpl implements FileDetailService{

	@Autowired
	FileDetailDAO dao;
	
	@Override
	public List<FileDetailVO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<FileDetailVO> findDay(FileDetailVO vo) {
		return dao.findDay(vo);
	}

	@Override
	public List<FileDetailVO> findBook(FileDetailVO vo) {
		return dao.findBook(vo);
	}

	@Override
	public List<FileDetailVO> findBookAll(String day) {
		return dao.findBookAll(day);
	}

	@Override
	public List<FileDetailVO> list(String day, Criteria criteria) {
		return dao.listCriteria(day, criteria);
	}

	@Override
	public long BookCount(String day) {
		return dao.BookCount(day);
	}

}
