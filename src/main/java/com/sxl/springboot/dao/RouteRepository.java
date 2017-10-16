package com.sxl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxl.springboot.model.Route;

public interface RouteRepository extends JpaRepository<Route,Integer> {

}
