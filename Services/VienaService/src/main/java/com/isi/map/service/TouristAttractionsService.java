package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.TouristAttractions;
import com.isi.map.domain.QTouristAttractions;
import com.isi.map.dto.TouristAttractionsDto;
import com.isi.map.repository.TouristAttractionsRepository;
import com.isi.map.util.OptionalBooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class TouristAttractionsService {

	TouristAttractionsRepository touristAttractionsRepository;

	public List<TouristAttractionsDto> getTouristAttractions(Predicate predicate, String name) {
		log.info("Retrieving tourist attractions for predicate: {}"
				+ (StringUtils.isNotBlank(name) ? " and name like: {}" : ""), predicate.toString(), name);
		QTouristAttractions qTouristAttractions = QTouristAttractions.touristAttractions;
		BooleanExpression customPredicate = new OptionalBooleanBuilder(qTouristAttractions.isNotNull())
				.notEmptyAnd(qTouristAttractions.name::containsIgnoreCase, name).build();
		
		List<TouristAttractions> touristAttractions = IterableUtils.toList(
				touristAttractionsRepository.findAll(customPredicate != null ? customPredicate.and(predicate) : predicate));
		
		
		return touristAttractions.stream().map(TouristAttractions::toDto).collect(Collectors.toList());
	}
}
