package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.AttJpaEntity;

@Repository
public interface AttJpaRepository extends JpaRepository<AttJpaEntity, String> {
	
	//사번과 기준일을 기준으로 조회
	AttJpaEntity findByEmpIdAndStdYmd(String empId, String stdYmd);
	
	//사번과 기준일을 기준으로 삭제 
	void deleteByEmpIdAndStdYmd(String empId, String stdYmd);
}