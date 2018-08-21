package com.example.mongo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mongo.domain.Criteria;
import com.example.mongo.domain.PageMaker;
import com.example.mongo.persistance.FileDetailDAO;
import com.example.mongo.service.FileDetailService;

@Controller
public class MongoController {
	
	@Autowired
	FileDetailService service;
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	static String day = format.format(new Date());

	@RequestMapping(value = "/todayBook", method = RequestMethod.GET)
	public void TodayBook(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) { 
		model.addAttribute("list", service.list(day, cri));
		
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		maker.setTotalCount((int) service.BookCount(day));
		
		model.addAttribute("maker", maker);
	}//페이징

}

