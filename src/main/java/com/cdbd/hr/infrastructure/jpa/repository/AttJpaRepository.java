package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.AttJpaEntity;

@Repository
public interface AttJpaRepository extends JpaRepository<AttJpaEntity, Long> {
	
	//사번을 기준으로 조회
	Optional<AttJpaEntity> findByEmpId(String empId);
	
	//사번과 기준일을 기준으로 조회
	Optional<AttJpaEntity> findByEmpIdAndStdYmd(String empId, String stdYmd);

	//사번과 기준일을 기준으로 삭제
	void deleteByEmpIdAndStdYmd(String empId, String stdYmd);
}