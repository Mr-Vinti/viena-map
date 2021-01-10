package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.isi.map.domain.TouristAttractions;
import com.isi.map.domain.QTouristAttractions;


public interface TouristAttractionsRepository extends JpaRepository<TouristAttractions, Integer>,
		QuerydslPredicateExecutor<TouristAttractions>, QuerydslBinderCustomizer<QTouristAttractions> {

	@Override
	default public void customize(QuerydslBindings bindings, QTouristAttractions root) {
	}
}
