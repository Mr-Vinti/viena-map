package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "VienaDatabase", name = "DETALII_ACTIVITATE")
public class ActivityDetails {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "X_min")
	private Double xMin;
	
	@Column(name = "X_max")
	private Double xMax;
	
	@Column(name = "Y_min")
	private Double yMin;
	
	@Column(name = "Y_max")
	private Double yMax;
}
