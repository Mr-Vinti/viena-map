package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.isi.map.domain.TouristRoutes;
import com.isi.map.domain.QTouristRoutes;


public interface TouristRoutesRepository extends JpaRepository<TouristRoutes, Integer>,
		QuerydslPredicateExecutor<TouristRoutes>, QuerydslBinderCustomizer<QTouristRoutes> {

	@Override
	default public void customize(QuerydslBindings bindings, QTouristRoutes root) {
	}
}
