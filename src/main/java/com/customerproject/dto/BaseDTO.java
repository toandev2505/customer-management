package com.customerproject.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//model
public abstract class BaseDTO<T> {
	private Long id;
//	private Date createdDate;
//	private Date modifiedDate;
//	private String createdBy;
//	private String modifiedBy;
	private long[] ids;
	private List<T> listResult = new ArrayList<T>();
//	private Integer page;
//	private Integer limit;
//	private Integer totalPage;
//	private Integer totalItem;
//	private String sortName;
//	private String sortBy;
//	private String type;
	
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getSortName() {
//		return sortName;
//	}
//	public void setSortName(String sortName) {
//		this.sortName = sortName;
//	}
//	public String getSortBy() {
//		return sortBy;
//	}
//	public void setSortBy(String sortBy) {
//		this.sortBy = sortBy;
//	}
//	public Integer getPage() {
//		return page;
//	}
//	public void setPage(Integer page) {
//		this.page = page;
//	}
//	public Integer getTotalPage() {
//		return totalPage;
//	}
//	public void setTotalPage(Integer totalPage) {
//		this.totalPage = totalPage;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
//	public Integer getTotalItem() {
//		return totalItem;
//	}
//	public void setTotalItem(Integer totalItem) {
//		this.totalItem = totalItem;
//	}
//	public Integer getLimit() {
//		return limit;
//	}
//	public void setLimit(Integer limit) {
//		this.limit = limit;
//	}
	
}
