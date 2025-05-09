package com.cdbd.hr.domain.att;

import java.sql.Timestamp;
import java.time.LocalTime;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class Attendance {

    private EmpId empId;
    private String stdYmd;
    private String holidayYn;
    private String inTime;
    private String outTime;
    private LocalTime workHours;
    private LocalTime breakHours;
    private LocalTime overTimeHours;
    private LocalTime nightWorkHours;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
