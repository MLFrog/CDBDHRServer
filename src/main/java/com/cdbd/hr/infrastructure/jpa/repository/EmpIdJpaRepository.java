package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpIdJpaEntity;

@Repository
public interface EmpIdJpaRepository extends JpaRepository<EmpIdJpaEntity, Long> {
	
	//사번을 기준으로 조회
	Optional<EmpIdJpaEntity> findByEmpId(String empI);

	//사번을 기준으로 삭제
	void deleteByEmpId(String empId);
	
}
