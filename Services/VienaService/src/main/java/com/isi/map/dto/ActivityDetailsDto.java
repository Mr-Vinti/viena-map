package com.isi.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDetailsDto {
	String id;
	Double xMin;
	Double xMax;
	Double yMin;
	Double yMax;
}
