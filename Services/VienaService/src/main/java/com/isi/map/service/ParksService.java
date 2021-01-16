package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.Parks;
import com.isi.map.domain.QParks;
import com.isi.map.dto.ParksDto;
import com.isi.map.repository.ParksRepository;
import com.isi.map.util.OptionalBooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ParksService {

	ParksRepository parksRepository;

	public List<ParksDto> getParks(Predicate predicate , String name) {
		log.info("Retrieving hiking trails for predicate: {}"
				+ (StringUtils.isNotBlank(name) ? " and name like: {}" : ""), predicate.toString(), name);
		QParks qParks = QParks.parks;
		BooleanExpression customPredicate = new OptionalBooleanBuilder(qParks.isNotNull())
				.notEmptyAnd(qParks.name::containsIgnoreCase, name).build();

		List<Parks> parks = IterableUtils.toList(
				parksRepository.findAll(customPredicate != null ? customPredicate.and(predicate) : predicate));
		
		return parks.stream().map(Parks::toDto).collect(Collectors.toList());
	}
}
