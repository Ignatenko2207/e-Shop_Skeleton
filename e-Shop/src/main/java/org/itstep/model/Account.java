package org.itstep.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	@Id
	@Column(name = "LOGIN")
	@JsonProperty
	private String login;

	@Column(name = "PASSWORD")
	@JsonProperty
	private String password;

	@Column(name = "FIRST_NAME")
	@JsonProperty
	private String firstName;

	@Column(name = "SECOND_NAME")
	@JsonProperty
	private String secondName;

	@Column(name = "TELEPHONE")
	@JsonProperty
	private String telephone;

}