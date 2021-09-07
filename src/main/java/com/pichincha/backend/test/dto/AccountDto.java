package com.pichincha.backend.test.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {
	
	public AccountDto(){}

	public AccountDto(String number, String type, LocalDateTime creationDate) {
		this.number = number;
		this.type = type;
		this.creationDate = creationDate;
	}

	@JsonProperty("id")
	private Long id;

	@JsonProperty("dt1")
	private String number = "";

	@JsonProperty("dt2")
	private String type = "";

	@JsonProperty("ddt1")
	private LocalDateTime creationDate = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	

}
