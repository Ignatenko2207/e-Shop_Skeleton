package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "CART")
public class Cart {

	
	@JsonProperty
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne(targetEntity = Account.class)
	private Account account;
	
	@JsonProperty
	@Column(name = "CREATION_TIME")
	private Long creationTime;
	
}
