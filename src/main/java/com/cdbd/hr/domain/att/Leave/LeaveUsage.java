package com.cdbd.hr.domain.att.Leave;

import java.sql.Timestamp;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class LeaveUsage {

    private EmpId empId;
    private String leaveType;
    private String stdYmd;
    private Integer usedCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
