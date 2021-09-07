package com.pichincha.backend.test.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto {

	@JsonProperty("id")
	private Long id;

	
	@JsonProperty("dt1")
	private String comment = "";

	@JsonProperty("dt2")
	private String type = "";

	@JsonProperty("elements")
	private AccountDto account;

	private LocalDateTime creationDate = LocalDateTime.now();
	


	public TransactionDto(long id, String comment, String type, LocalDateTime creationDate) {
		this.id = id;
		this.comment = comment;
		this.type = type;
		this.creationDate = creationDate;
	}

	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public String getType() {
		return type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
