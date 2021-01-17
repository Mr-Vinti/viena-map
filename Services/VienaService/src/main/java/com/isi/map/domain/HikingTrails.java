package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.isi.map.dto.HikingTrailsDto;
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
@Table(schema = "dbo", name = "DRUMETII")
public class HikingTrails {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
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
	
	public static HikingTrailsDto toDto(HikingTrails entity) {
		return HikingTrailsDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.length(entity.getLength())
				.duration(entity.getDuration())
				.dificulty(entity.getDificulty())
				.activityDetails(ActivityDetails.toDto(entity.getActivityDetails()))
				.build();
	}
}
