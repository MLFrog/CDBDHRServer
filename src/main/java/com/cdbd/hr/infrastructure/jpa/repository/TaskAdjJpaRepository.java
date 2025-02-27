package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.TaskAdjJpaEntity;

@Repository
public interface TaskAdjJpaRepository extends JpaRepository<TaskAdjJpaEntity, Long> {

	//사번과 기준일을 기준으로 조회
	TaskAdjJpaEntity findByEmpIdAndStdYmd(String empId, String stdYmd);

	//사번과 기준일을 기준으로 삭제
	void deleteByEmpIdAndStdYmd(String empId, String stdYmd);
}
