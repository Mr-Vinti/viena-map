package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.isi.map.dto.ActivityDetailsDto;
import com.isi.map.dto.TouristRoutesDto;
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
@Table(schema = "dbo", name = "TRASEE_TURISTICE")
public class TouristRoutes {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Nume")
	private String name;
	
	@Column(name = "Lungime")
	private Integer length;
	
	@Column(name = "Numar_obiective")
	private Integer objectivesNumber;
	
	@OneToOne
	@JoinColumn(name = "ID_detaliu", referencedColumnName = "ID")
	private ActivityDetails activityDetails;
	
	public static TouristRoutesDto toDto(TouristRoutes entity) {
		return TouristRoutesDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.length(entity.getLength())
				.objectivesNumber(entity.getObjectivesNumber())
				.activityDetails(ActivityDetails.toDto(entity.getActivityDetails()))
				.build();
	}
}
