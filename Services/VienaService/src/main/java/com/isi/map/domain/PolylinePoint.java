package com.isi.map.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.isi.map.dto.PolylinePointDto;

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
@Table(schema = "dbo", name = "PUNCT_POLILINIE")
public class PolylinePoint {

	@EmbeddedId
	private PolylinePointPK id;

	@Column(name = "X")
	private Double x;

	@Column(name = "Y")
	private Double y;

	public static PolylinePointDto toDto(PolylinePoint entity) {
		return PolylinePointDto.builder().x(entity.x).y(entity.y).build();
	}
}
