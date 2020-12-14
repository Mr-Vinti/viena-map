package com.isi.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.map.domain.ActivityDetails;

public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails, Integer> {

}
