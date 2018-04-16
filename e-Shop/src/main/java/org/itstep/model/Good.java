package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@Entity
@Table(name="GOODS")
public class Good {

	@Id
	@Column(name = "ARTICLE_ID")
	@JsonProperty
	private String articleId;
	
	@JsonProperty
	@Column(name = "NAME")
	private String name;
	
	@JsonProperty
	@Column(name = "PRICE")
	private Integer price;
	
	@JsonProperty
	@Column(name = "INITIAL_PRICE")
	private Integer initialPrice;
	
	@JsonProperty
	@Column(name = "DESCRIPTION")
	private String description;
	
	@JsonProperty
	@Column(name = "UNITS")
	private String units;
	
	@JsonProperty
	@Column(name = "AVAILABILITY")
	private Boolean availability;
	
}
