package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(schema = "VienaDatabase", name = "DRUMETII")
public class HikingTrails {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Nume")
	private String name;
	
	@Column(name = "Lungime")
	private Integer length;
	
	@Column(name = "Durata")
	private Integer duration;
	
	@Column(name = "Grad_dificultate")
	private Integer dificulty;
	
	@OneToOne
	@JoinColumn(name = "ID_detaliu", referencedColumnName = "ID")
	private ActivityDetails activityDetails;
	
	
}
