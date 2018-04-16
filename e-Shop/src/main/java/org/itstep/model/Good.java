package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@Entity
@Table(name="Goods")
public class Good {

	
	
	@Id
	@Column(name = "ArticleID")
	@JsonProperty
	private String articleId;
	
	@JsonProperty
	@Column(name = "Name")
	private String name;
	
	@JsonProperty
	@Column(name = "Price")
	private Integer price;
	
	@JsonProperty
	@Column(name = "InitialPrice")
	private Integer initialPrice;
	
	@JsonProperty
	@Column(name = "Description")
	private String description;
	
	@JsonProperty
	@Column(name = "Units")
	private String units;
	
	@JsonProperty
	@Column(name = "Availability")
	private Boolean availability;
	
}
