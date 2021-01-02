package com.isi.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TouristRoutesDto {
	String id;
	String name;
	Integer length;
	Integer objectives_number;
	ActivityDetailsDto activityDetails;
}
