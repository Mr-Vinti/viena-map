package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.ActivityDetails;
import com.isi.map.dto.ActivityDetailsDto;
import com.isi.map.repository.ActivityDetailsRepository;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ActivityDetailsService {

	ActivityDetailsRepository activityDetailsRepository;

	public List<ActivityDetailsDto> getActivityDetails(Predicate predicate) {
		log.info("Retrieving activity details for predicate: {}", predicate.toString());
		List<ActivityDetails> activityDetails = IterableUtils.toList(activityDetailsRepository.findAll(predicate));
		
		// TODO Auto-generated method stub
		return activityDetails.stream().map(ActivityDetails::toDto).collect(Collectors.toList());
	}
}
