package com.travelpartner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelpartner.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByDiaDiemId(Long diaDiemId);
	@Query("SELECT AVG(r.soSao) FROM Review r WHERE r.diaDiem.id = :diaDiemId")
	Double tinhDiemTrungBinh(@Param("diaDiemId") Long diaDiemId);
}
