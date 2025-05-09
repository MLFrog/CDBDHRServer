package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpDepJpaEntity;

@Repository
public interface EmpDepJpaRepository extends JpaRepository<EmpDepJpaEntity, Long> {
	
	//사번을 기준으로 조회
	Optional<EmpDepJpaEntity> findByEmpIdAndDepId(String empId);
	
	//사번과 부서 ID를 기준으로 조회
	Optional<EmpDepJpaEntity> findByEmpIdAndDepId(String empId, String depId);
	
}