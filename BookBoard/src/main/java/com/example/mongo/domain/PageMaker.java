package com.example.mongo.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;
	private int endPage;
	private int startPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private Criteria cri;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum); //displayPageNum�� �럹�씠吏뺤쓽 媛쒖닔, perPageNum�� �븳 �솕硫댁쓽 寃뚯떆湲��쓽 �닔
		startPage = (endPage-displayPageNum) + 1;
		int tempEndPage = (int) Math.ceil(totalCount/(double)cri.getPerPageNum());
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1?false:true;
		next = endPage*cri.getPerPageNum()>=totalCount?false:true;
	}
	public String makeQuery(int page){
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum()).build();
		
		return uriComponents.toUriString();
	}
}
