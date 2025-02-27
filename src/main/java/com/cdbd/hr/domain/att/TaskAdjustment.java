package com.cdbd.hr.domain.att;

import java.sql.Timestamp;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class TaskAdjustment {

    private EmpId empId;
    private String adjType;
    private String stdYmd;
    private String startHms;
    private String endHms;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
