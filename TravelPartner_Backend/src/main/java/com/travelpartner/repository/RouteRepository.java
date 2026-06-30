package com.travelpartner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelpartner.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long>{
	List<Route> findByNguoiDungId(Long nguoiDungId);
}
