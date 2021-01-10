package com.isi.map.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDetailsDto {
	Integer id;
	Double xMin;
	Double xMax;
	Double yMin;
	Double yMax;
}
