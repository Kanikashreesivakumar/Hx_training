package com.springboot.cms.repository;

import com.springboot.cms.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident,Integer> {




}
