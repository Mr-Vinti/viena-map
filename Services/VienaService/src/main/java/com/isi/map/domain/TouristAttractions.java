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

import com.isi.map.dto.TouristAttractionsDto;
import com.querydsl.core.annotations.QueryEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@QueryEntity
@Entity
@Table(schema = "dbo", name = "OBIECTIVE_TURISTICE")
public class TouristAttractions {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Nume")
	private String name;
	
	@Column(name = "Url")
	private String url;
	
	@OneToOne
	@JoinColumn(name = "ID_detaliu", referencedColumnName = "ID")
	private ActivityDetails activityDetails;
	
	public static TouristAttractionsDto toDto(TouristAttractions entity) {
		return TouristAttractionsDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.url(entity.getUrl())
				.activityDetails(ActivityDetails.toDto(entity.getActivityDetails()))
				.build();
	}
}
