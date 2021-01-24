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
public class PolylinePointDto {
	@JsonProperty(value = "x")
	private Double x;
	@JsonProperty(value = "y")
	private Double y;
}
