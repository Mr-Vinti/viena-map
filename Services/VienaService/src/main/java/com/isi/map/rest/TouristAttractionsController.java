package com.isi.map.rest;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isi.map.domain.TouristAttractions;
import com.isi.map.dto.TouristAttractionsDto;
import com.isi.map.service.TouristAttractionsService;
import com.querydsl.core.types.Predicate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags = "Tourist Attractions Controller")
@RequestMapping(value = "/touristAttractions")
public class TouristAttractionsController {
	TouristAttractionsService touristAttractionsService;
	
	@ApiOperation("Get Tourist Attractions Method")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
			@ApiResponse(code = 400, message = "Malformed request"),
			@ApiResponse(code = 500, message = "Internal error") })
	@GetMapping
	public ResponseEntity<List<TouristAttractionsDto>> getTouristAttractions(@QuerydslPredicate(root = TouristAttractions.class) Predicate predicate,
			@RequestParam(name = "name:like", required = false) String name) {
		
		List<TouristAttractionsDto> touristAttractionsDtos = touristAttractionsService.getTouristAttractions(predicate,name);
		return ResponseEntity.ok(touristAttractionsDtos);
	}
}
