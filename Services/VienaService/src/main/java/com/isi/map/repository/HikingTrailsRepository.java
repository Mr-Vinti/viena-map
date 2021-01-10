package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.isi.map.domain.HikingTrails;
import com.isi.map.domain.QHikingTrails;


public interface HikingTrailsRepository extends JpaRepository<HikingTrails, Integer>,
		QuerydslPredicateExecutor<HikingTrails>, QuerydslBinderCustomizer<QHikingTrails> {

	@Override
	default public void customize(QuerydslBindings bindings, QHikingTrails root) {
	}
}
