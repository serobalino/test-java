package com.pichincha.backend.test.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewTransactionDto {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("dt1")
	private String type;

	@JsonProperty("dt2")
	private String comment;

	private LocalDateTime creationDate = LocalDateTime.now();

	@JsonProperty("ndt1")
	private Long accountId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
