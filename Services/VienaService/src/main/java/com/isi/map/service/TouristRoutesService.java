package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.isi.map.domain.TouristRoutes;
import com.isi.map.domain.QTouristRoutes;
import com.isi.map.dto.TouristRoutesDto;
import com.isi.map.repository.TouristRoutesRepository;
import com.isi.map.util.OptionalBooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class TouristRoutesService {

	TouristRoutesRepository touristRoutesRepository;
	PolylinePointService polylinePointService;

	public List<TouristRoutesDto> getTouristRoutes(Predicate predicate, String name) {
		log.info("Retrieving tourist routes for predicate: {}"
				+ (StringUtils.isNotBlank(name) ? " and name like: {}" : ""), predicate.toString(), name);
		QTouristRoutes qTouristRoutes = QTouristRoutes.touristRoutes;

		BooleanExpression customPredicate = new OptionalBooleanBuilder(qTouristRoutes.isNotNull())
				.notEmptyAnd(qTouristRoutes.name::containsIgnoreCase, name).build();

		List<TouristRoutes> touristRoutes = IterableUtils.toList(
				touristRoutesRepository.findAll(customPredicate != null ? customPredicate.and(predicate) : predicate));

		return touristRoutes.stream().map((touristRoute) -> {
			TouristRoutesDto touristRouteDto = TouristRoutes.toDto(touristRoute);
			touristRouteDto.setPoints(polylinePointService.getPoints(touristRouteDto.getId(), "Traseu turistic"));
			return touristRouteDto;
		}).collect(Collectors.toList());
	}
}
