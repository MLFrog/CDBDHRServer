package com.cdbd.hr.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.LeaveUsageJpaHisEntity;

@Repository
public interface LeaveUsageJpaHisRepository extends JpaRepository<LeaveUsageJpaHisEntity, Long> {

	//사번과 휴가유형, 기준일을 기준으로 조회
	LeaveUsageJpaHisEntity findByEmpIdAndLeaveTypeAndStdYmd(String empId, String leaveType, String stdYmd);

	//사번과 휴가유형을 기준일을 기준으로 삭제
	void deleteByEmpIdAndLeaveTypeAndStdYmd(String empId, String leaveType, String stdYmd);
}
