package com.isi.map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.map.domain.PolylinePoint;
import com.isi.map.domain.PolylinePointPK;

@Repository
public interface PolylinePointRepository extends JpaRepository<PolylinePoint, PolylinePointPK>{

	public List<PolylinePoint> findByIdObjectIdAndIdObjectTypeOrderByIdSequenceNumberAsc(Integer objectId, String objectType);
}
