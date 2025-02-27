package com.cdbd.hr.domain.emp.EmpDep;

import java.sql.Timestamp;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.dep.Department;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class EmpDep {
	
    private EmpId empId;
    private Department depCode;
    private String depLeaderYn;
    private String dualDepYn;
    private String staYmd;
    private String endYmd;
	private Timestamp createdAt;
	private Timestamp updatedAt;

}
