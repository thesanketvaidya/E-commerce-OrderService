package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
