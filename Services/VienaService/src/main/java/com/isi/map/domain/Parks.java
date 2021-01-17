package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.isi.map.dto.ParksDto;
import com.querydsl.core.annotations.QueryEntity;

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
@QueryEntity
@Entity
@Table(schema = "dbo", name = "PARCURI")
public class Parks {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Nume")
	private String name;
	
	@Column(name = "Suprafata")
	private Integer surface;
	
	@Column(name = "Locuri_joaca")
	private String playgrounds;
	
	@Column(name = "Spatii_animale")
	private String petspaces;
	
	@OneToOne
	@JoinColumn(name = "ID_detaliu", referencedColumnName = "ID")
	private ActivityDetails activityDetails;
	
	
	public static ParksDto toDto(Parks entity) {
		return ParksDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.surface(entity.getSurface())
				.playgrounds(entity.getPlaygrounds().equals("Y") ? true : false)
				.petspaces(entity.getPetspaces().equals("Y") ? true : false)
				.activityDetails(ActivityDetails.toDto(entity.getActivityDetails()))
				.build();
	}
	
}
