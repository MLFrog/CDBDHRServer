package com.cdbd.hr.domain.dep;

import java.time.Instant;

import com.cdbd.hr.domain.common.DomainEntity;

import lombok.Data;

@Data
@DomainEntity
public class Department {

	private String depCode;
	private String pDepCode;
	private String cDepCode;
	private String tDepYn;
	private String staYmd;
	private String endYmd;
    private Instant createdAt;
    private Instant updatedAt;
    
}
