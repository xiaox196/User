package com.ming.model;

import java.sql.Timestamp;

public class User {
	public String borrower_id;
	public String name;
	public String created_at;
	public String uuid;
	public String cnid;
	public String mobile;


	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(String borrower_id) {
		this.borrower_id = borrower_id;
	}

	public String getCnid() {
		return cnid;
	}

	public void setCnid(String cnid) {
		this.cnid = cnid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



}
