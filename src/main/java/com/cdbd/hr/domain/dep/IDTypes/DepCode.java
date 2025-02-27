package com.cdbd.hr.domain.dep.IDTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepCode {

	private String depCode;

	
	public static DepCode valueOf(String value) {
	    return new DepCode(value);
	}
	
}


	

	