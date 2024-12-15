package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpJpaEntity;

@Repository
public interface EmpJpaRepository extends JpaRepository<EmpJpaEntity, String> {}

