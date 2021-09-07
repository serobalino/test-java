package com.pichincha.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String number;

	@Column(length = 70)
	private String type;

	private LocalDateTime creationDate = LocalDateTime.now();

	public String getNumber() {
		return number;
	}

	public void setNumber(String title) {
		this.number = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String content) {
		this.type = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
