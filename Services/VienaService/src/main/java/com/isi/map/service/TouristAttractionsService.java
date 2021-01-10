package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.TouristAttractions;
import com.isi.map.dto.TouristAttractionsDto;
import com.isi.map.repository.TouristAttractionsRepository;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class TouristAttractionsService {

	TouristAttractionsRepository touristAttractionsRepository;

	public List<TouristAttractionsDto> getTouristAttractions(Predicate predicate) {
		log.info("Retrieving hiking trails for predicate: {}", predicate.toString());
		List<TouristAttractions> activityDetails = IterableUtils.toList(touristAttractionsRepository.findAll(predicate));
		
		// TODO Auto-generated method stub
		return activityDetails.stream().map(TouristAttractions::toDto).collect(Collectors.toList());
	}
}
