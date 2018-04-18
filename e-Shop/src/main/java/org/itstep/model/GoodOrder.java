package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ORDERS")
public class GoodOrder {

	@Id
	@JsonProperty
	@GeneratedValue
	@Column(name = "ID_ORDER")
	private Integer idOrder;
	
	@JsonProperty
	@Column(name = "GOOD_AMOUNT")
	private Integer amount; 
	
	@ManyToOne(targetEntity = Cart.class)
	private Cart cart;
	
	@ManyToOne(targetEntity = Good.class)
	private Good good;

	
}
