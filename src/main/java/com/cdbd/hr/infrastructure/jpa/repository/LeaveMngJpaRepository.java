package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.LeaveMngJpaEntity;

@Repository
public interface LeaveMngJpaRepository extends JpaRepository<LeaveMngJpaEntity, Long> {

	//사번과 휴가유형을 기준으로 조회
	LeaveMngJpaEntity findByEmpIdAndLeaveType(String empId, String leaveType);

	//사번과 휴가유형을 기준으로 삭제
	void deleteByEmpIdAndLeaveType(String empId, String leaveType);
}

