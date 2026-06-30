package com.travelpartner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelpartner.entity.RouteLocation;

public interface RouteLocationRepository extends JpaRepository<RouteLocation, Long> {

}
