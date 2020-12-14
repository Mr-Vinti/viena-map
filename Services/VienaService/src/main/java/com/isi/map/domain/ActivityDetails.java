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
}
