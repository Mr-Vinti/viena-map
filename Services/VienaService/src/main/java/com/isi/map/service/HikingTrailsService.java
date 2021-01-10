package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.HikingTrails;
import com.isi.map.domain.QHikingTrails;
import com.isi.map.dto.HikingTrailsDto;
import com.isi.map.repository.HikingTrailsRepository;
import com.isi.map.util.OptionalBooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class HikingTrailsService {

	HikingTrailsRepository hikingTrailsRepository;

	public List<HikingTrailsDto> getHikingTrails(Predicate predicate, String name) {
		log.info("Retrieving hiking trails for predicate: {}"
				+ (StringUtils.isNotBlank(name) ? " and name like: {}" : ""), predicate.toString(), name);
		QHikingTrails qhikingTrails = QHikingTrails.hikingTrails;
		BooleanExpression customPredicate = new OptionalBooleanBuilder(qhikingTrails.isNotNull())
				.notEmptyAnd(qhikingTrails.name::containsIgnoreCase, name).build();

		List<HikingTrails> hikingTrails = IterableUtils.toList(
				hikingTrailsRepository.findAll(customPredicate != null ? customPredicate.and(predicate) : predicate));

		return hikingTrails.stream().map(HikingTrails::toDto).collect(Collectors.toList());
	}
}
