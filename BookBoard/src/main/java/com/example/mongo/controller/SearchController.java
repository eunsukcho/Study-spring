package com.example.mongo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mongo.domain.Criteria;
import com.example.mongo.domain.FileDetailVO;
import com.example.mongo.domain.PageMaker;
import com.example.mongo.service.FileDetailService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class SearchController {
	
	@Autowired
	FileDetailService service;
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	static String day = format.format(new Date());
	
	@RequestMapping(value="/findBook", method=RequestMethod.GET)
	public void findBook() {
		
	}
	
	@RequestMapping(value="findBook/search", method=RequestMethod.POST,  produces = "application/json; charset=utf-8")
	public ResponseEntity<?> findBookSearch(@RequestBody FileDetailVO vo) throws ParseException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ResponseEntity<?> entity;
		
		String oldstring = vo.getkeyValue();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		vo.setkeyValue(day);

		try {
			entity = new ResponseEntity<Object>(gson.toJson(service.findBook(vo)), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//검색
	
	@RequestMapping(value="findBook/All", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ResponseEntity<?> findBookAll(@RequestBody FileDetailVO vo, Criteria cri) throws ParseException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ResponseEntity<?> entity;
		
		String oldstring = vo.getkeyValue();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		vo.setkeyValue(day);
		
		try {
			entity = new ResponseEntity<Object>(gson.toJson(service.findBookAll(day)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//전체보기
}
