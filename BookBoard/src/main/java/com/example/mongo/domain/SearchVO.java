package com.example.mongo.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="SearchVO")
public class SearchVO {
	
	@Field(value = "book_rank")
	private String book_rank;
	
	@Field(value = "book_store")
	private String book_store;
	
	@Field(value = "title")
	private String title;
	
	@Field(value = "writer")
	private String writer;
	
	@Field(value = "sale_price")
	private String sale_price;
	
	@Field(value = "detail")
	private String detail;
	
	@Field(value = "publish_day")
	private String publish_day;
	
	@Field(value = "keyValue")
	private String keyValue;
	
	public SearchVO() {}
	
	public SearchVO(String book_rank, String book_store, String title, String writer, String sale_price, String detail, String publish_day, String keyValue) {
		this.book_rank = book_rank;
		this.book_store = book_store;
		this.title = title;
		this.writer = writer;
		this.sale_price = sale_price;
		this.detail = detail;
		this.publish_day = publish_day;
		this.keyValue = keyValue;
	}
	
	public String getkeyValue() {
		return keyValue;
	}

	public void setkeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getBook_rank() {
		return book_rank;
	}

	public void setBook_rank(String string) {
		this.book_rank = string;
	}

	public String getBook_store() {
		return book_store;
	}

	public void setBook_store(String book_store) {
		this.book_store = book_store;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSale_price() {
		return sale_price;
	}

	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPublish_day() {
		return publish_day;
	}

	public void setPublish_day(String publish_day) {
		this.publish_day = publish_day;
	}
	
	
	
}
