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
@Table(schema = "VienaDatabase", name = "PARCURI")
public class Parks {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Nume")
	private String name;
	
	@Column(name = "Suprafata")
	private Integer surface;
	
	@Column(name = "Locuri_joaca")
	private Boolean playgrounds;
	
	@Column(name = "Spatii_animale")
	private Boolean pet_spaces;
	
	@OneToOne
	@JoinColumn(name = "ID_detaliu", referencedColumnName = "ID")
	private ActivityDetails activityDetails;
	
	
}
