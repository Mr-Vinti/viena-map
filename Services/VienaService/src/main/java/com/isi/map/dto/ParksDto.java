package com.isi.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParksDto {
	String id;
	String name;
	Integer surface;
	Boolean playgrounds;
	Boolean pet_spaces;
	ActivityDetailsDto activityDetails;
}
