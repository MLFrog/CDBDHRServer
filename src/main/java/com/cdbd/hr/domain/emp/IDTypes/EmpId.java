package com.cdbd.hr.domain.emp.IDTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpId {
	
	private String empId;
	
	public static EmpId valueOf(String value) {
	    return new EmpId(value);
	}
	
}

