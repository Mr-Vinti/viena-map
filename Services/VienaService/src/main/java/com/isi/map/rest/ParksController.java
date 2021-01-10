package com.isi.map.rest;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isi.map.domain.Parks;
import com.isi.map.dto.ParksDto;
import com.isi.map.service.ParksService;
import com.querydsl.core.types.Predicate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags = "Parks Controller")
@RequestMapping(value = "/parks")
public class ParksController {
	ParksService parksService;
	
	@ApiOperation("Get Parks Method")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
			@ApiResponse(code = 400, message = "Malformed request"),
			@ApiResponse(code = 500, message = "Internal error") })
	@GetMapping
	public ResponseEntity<List<ParksDto>> getParks(@QuerydslPredicate(root = Parks.class) Predicate predicate) {
		
		List<ParksDto> parksDtos = parksService.getParks(predicate);
		return ResponseEntity.ok(parksDtos);
	}
}
