package com.cdbd.hr.domain.att.Leave;

import java.sql.Timestamp;

import com.cdbd.hr.domain.att.IDTypes.LeaveType;
import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class LeaveMng {
 
    private LeaveType leaveType;
    private EmpId empId;
    private String staYmd;
    private String endYmd;
    private Integer totCnt;
    private Integer usedCount;
    private Integer remainCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
