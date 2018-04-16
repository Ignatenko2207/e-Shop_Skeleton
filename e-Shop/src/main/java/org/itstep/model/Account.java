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
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "login")
	@JsonProperty
	private String login;

	@Column(name = "password")
	@JsonProperty
	private String password;

	@Column(name = "first_name")
	@JsonProperty
	private String firstName;

	@Column(name = "second_name")
	@JsonProperty
	private String secondName;

	@Column(name = "telephone")
	@JsonProperty
	private String telephone;

}