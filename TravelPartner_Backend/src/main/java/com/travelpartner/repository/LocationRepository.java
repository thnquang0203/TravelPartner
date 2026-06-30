package com.travelpartner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelpartner.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	@Query("SELECT l FROM Location l WHERE "+
			"(:keyword IS NULL OR l.tenDiaDiem LIKE %:keyword%) AND "+
			"(:province IS NULL OR l.tinhThanh = :province) AND " +
			"(:categoryId IS NULL OR l.danhMuc.id = :categoryId) AND "+
			"l.trangThai = 'APPROVED'")
	Page<Location> timkiem(@Param("keyword") String keyword,
							@Param("province") String province,
							@Param("categoryId") String categoryId,
							Pageable pageable);
	Page<Location> findBytrangThai(Location.TrangThai trangThai, Pageable pageable);
}
