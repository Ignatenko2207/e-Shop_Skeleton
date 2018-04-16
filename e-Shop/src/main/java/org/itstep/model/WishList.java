package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="Wishlist")
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@JsonProperty
	private Integer id;
	
	@ManyToOne(targetEntity = Account.class)
	private Account account;
	
	@ManyToOne(targetEntity = Good.class)
	private Good good;
		
}
