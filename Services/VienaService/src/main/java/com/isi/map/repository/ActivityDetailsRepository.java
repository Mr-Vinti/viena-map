package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.isi.map.domain.ActivityDetails;
import com.isi.map.domain.QActivityDetails;

public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails, Integer>,
		QuerydslPredicateExecutor<ActivityDetails>, QuerydslBinderCustomizer<QActivityDetails> {

	@Override
	default public void customize(QuerydslBindings bindings, QActivityDetails root) {
	}
}
