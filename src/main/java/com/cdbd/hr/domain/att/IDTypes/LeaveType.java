package com.cdbd.hr.domain.att.IDTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveType {

	private String ShiftId;

	
	public static LeaveType valueOf(String value) {
	    return new LeaveType(value);
	}
	
}


	

	