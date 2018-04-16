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
@Table(name = "order")
public class Order {

	@Id
	@JsonProperty
	@GeneratedValue
	@Column(name = "id_order")
	private Integer idOrder;
	
	@ManyToOne(targetEntity = Cart.class)
	private Cart idCart;
	
	@ManyToOne(targetEntity = Good.class)
	private Good idGood;

	
}
