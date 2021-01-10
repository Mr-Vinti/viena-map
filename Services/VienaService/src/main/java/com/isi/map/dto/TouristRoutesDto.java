package com.isi.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristRoutesDto {
	Integer id;
	String name;
	Integer length;
	Integer objectivesNumber;
	ActivityDetailsDto activityDetails;
}
