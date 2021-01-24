package com.isi.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isi.map.domain.PolylinePoint;
import com.isi.map.dto.PolylinePointDto;
import com.isi.map.repository.PolylinePointRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PolylinePointService {
	private PolylinePointRepository polylinePointRepository;

	public List<PolylinePointDto> getPoints(Integer objectId, String objectType) {
		return polylinePointRepository.findByIdObjectIdAndIdObjectTypeOrderByIdSequenceNumberAsc(objectId, objectType)
				.stream().map(PolylinePoint::toDto).collect(Collectors.toList());
	}
}
