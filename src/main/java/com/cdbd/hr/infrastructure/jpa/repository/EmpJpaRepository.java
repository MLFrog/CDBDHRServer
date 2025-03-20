package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpJpaEntity;

@Repository
public interface EmpJpaRepository extends JpaRepository<EmpJpaEntity, Long> {
	
	//사번을 기준으로 조회
	Optional<EmpJpaEntity> findByEmpId(String empI);

	//사번을 기준으로 삭제
	void deleteByEmpId(String empId);
	

}

