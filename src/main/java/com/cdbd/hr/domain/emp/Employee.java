package com.cdbd.hr.domain.emp;

import java.time.Instant;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.emp.empId.EmpId;
import com.cdbd.hr.infrastructure.jpa.entity.ShiftJpaEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class Employee {
	
    private EmpId empId;
    private ShiftJpaEntity shiftId;
    private String name;
    private String ssn;
    private String nationality;
    private String gender;
    private String phoneNumber;
    private String address;
    private String joinDate;
    private String resignationDate;
    private String position;
    private String jobTitle;
    private String empType;
    private String workLoc;
    private Integer salary;
    private String bank;
    private String bankAccount;
    private Instant createdAt;
    private Instant updatedAt;
}
