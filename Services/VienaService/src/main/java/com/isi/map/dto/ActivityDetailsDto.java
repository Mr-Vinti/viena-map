package com.isi.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty(value = "xMin")
	Double xMin;
	@JsonProperty(value = "xMax")
	Double xMax;
	@JsonProperty(value = "yMin")
	Double yMin;
	@JsonProperty(value = "yMax")
	Double yMax;
}
