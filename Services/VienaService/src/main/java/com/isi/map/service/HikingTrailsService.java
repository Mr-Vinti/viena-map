package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.HikingTrails;
import com.isi.map.dto.HikingTrailsDto;
import com.isi.map.repository.HikingTrailsRepository;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class HikingTrailsService {

	HikingTrailsRepository hikingTrailsRepository;

	public List<HikingTrailsDto> getHikingTrails(Predicate predicate) {
		log.info("Retrieving hiking trails for predicate: {}", predicate.toString());
		List<HikingTrails> activityDetails = IterableUtils.toList(hikingTrailsRepository.findAll(predicate));
		
		// TODO Auto-generated method stub
		return activityDetails.stream().map(HikingTrails::toDto).collect(Collectors.toList());
	}
}
