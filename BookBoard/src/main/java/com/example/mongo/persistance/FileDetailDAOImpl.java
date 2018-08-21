package com.example.mongo.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.mongo.domain.FileDetailVO;

@Repository("FileDetailVO")
public class FileDetailDAOImpl implements FileDetailDAO{

	@Autowired
	MongoTemplate mongo;
	
	@Override
	public List<FileDetailVO> findAll() {
		return mongo.findAll(FileDetailVO.class);
	}

	@Override
	public List<FileDetailVO> findDay(FileDetailVO vo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("KeyValue").is(vo.getkeyValue()));
		return mongo.find(query, FileDetailVO.class);
	}

	@Override
	public List<FileDetailVO> findBook(FileDetailVO vo) {
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("title").is(vo.getTitle()), Criteria.where("writer").is(vo.getWriter())).andOperator(Criteria.where("keyValue").is(vo.getkeyValue()));
		Query query = new Query(criteria);
		return mongo.find(query, FileDetailVO.class);
	}

	@Override
	public List<FileDetailVO> findBookAll(String day) {

		Query query = new Query();
		query.addCriteria(Criteria.where("KeyValue").is(day));
		return mongo.find(query, FileDetailVO.class);
	}

	@Override
	public List<FileDetailVO> listCriteria(String day, com.example.mongo.domain.Criteria cri) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("KeyValue").is(day)).skip(cri.getPageStart()).limit(cri.getPerPageNum());
		return mongo.find(query, FileDetailVO.class);
	}

	@Override
	public long BookCount(String day) {
		Query query = new Query();
		query.addCriteria(Criteria.where("keyValue").is(day));
		return mongo.count(query, FileDetailVO.class);
	}

}
