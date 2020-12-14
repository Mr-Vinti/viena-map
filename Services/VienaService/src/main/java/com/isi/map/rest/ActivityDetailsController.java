package com.isi.map.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isi.map.beans.StringResponse;
import com.isi.map.dto.ActivityDetailsDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Test Controller")
@RequestMapping(value = "/activityDetails")
public class ActivityDetailsController {
	@ApiOperation("Test Get Method")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful"),
			@ApiResponse(code = 400, message = "Malformed request"),
			@ApiResponse(code = 500, message = "Internal error") })
	@GetMapping
	public ResponseEntity<List<ActivityDetailsDto>> getActivityDetails() {
		return ResponseEntity.ok(null);
	}
}
