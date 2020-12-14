package com.isi.map.service;

import org.springframework.stereotype.Service;

import com.isi.map.repository.ActivityDetailsRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ActivityDetailsService {

	ActivityDetailsRepository activityDetailsRepository;
}
