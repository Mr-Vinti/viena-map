package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.TouristRoutes;
import com.isi.map.dto.TouristRoutesDto;
import com.isi.map.repository.TouristRoutesRepository;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class TouristRoutesService {

	TouristRoutesRepository touristRoutesRepository;

	public List<TouristRoutesDto> getTouristRoutes(Predicate predicate) {
		log.info("Retrieving tourist routes for predicate: {}", predicate.toString());
		List<TouristRoutes> touristRoutes = IterableUtils.toList(touristRoutesRepository.findAll(predicate));
		
		// TODO Auto-generated method stub
		return touristRoutes.stream().map(TouristRoutes::toDto).collect(Collectors.toList());
	}
}
