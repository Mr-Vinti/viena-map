package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.Parks;
import com.isi.map.dto.ParksDto;
import com.isi.map.repository.ParksRepository;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ParksService {

	ParksRepository parksRepository;

	public List<ParksDto> getParks(Predicate predicate) {
		log.info("Retrieving parks for predicate: {}", predicate.toString());
		List<Parks> parks = IterableUtils.toList(parksRepository.findAll(predicate));
		
		// TODO Auto-generated method stub
		return parks.stream().map(Parks::toDto).collect(Collectors.toList());
	}
}
