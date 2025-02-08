package com.cdbd.hr.domain.emp;

import com.cdbd.hr.domain.common.DomainEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class EmpId {
	
	private String empId;
	private String useYn;
	
}

