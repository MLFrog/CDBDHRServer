package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpDepJpaEntity;

@Repository
public interface EmpDepJpaRepository extends JpaRepository<EmpDepJpaEntity, Long> {}