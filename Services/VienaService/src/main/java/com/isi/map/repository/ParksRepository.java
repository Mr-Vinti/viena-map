package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.isi.map.domain.Parks;
import com.isi.map.domain.QParks;


public interface ParksRepository extends JpaRepository<Parks, Integer>,
		QuerydslPredicateExecutor<Parks>, QuerydslBinderCustomizer<QParks> {

	@Override
	default public void customize(QuerydslBindings bindings, QParks root) {
	}
}
