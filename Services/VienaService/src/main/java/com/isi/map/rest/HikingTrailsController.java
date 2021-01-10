package com.isi.map.rest;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isi.map.domain.HikingTrails;
import com.isi.map.dto.HikingTrailsDto;
import com.isi.map.service.HikingTrailsService;
import com.querydsl.core.types.Predicate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags = "Hiking Trails Controller")
@RequestMapping(value = "/hikingTrails")
public class HikingTrailsController {
	HikingTrailsService hikingTrailsService;
	
	@ApiOperation("Get Hiking Trails Method")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
			@ApiResponse(code = 400, message = "Malformed request"),
			@ApiResponse(code = 500, message = "Internal error") })
	@GetMapping
	public ResponseEntity<List<HikingTrailsDto>> getHikingTrails(@QuerydslPredicate(root = HikingTrails.class) Predicate predicate) {
		
		List<HikingTrailsDto> hikingTrailsDtos = hikingTrailsService.getHikingTrails(predicate);
		return ResponseEntity.ok(hikingTrailsDtos);
	}
}
