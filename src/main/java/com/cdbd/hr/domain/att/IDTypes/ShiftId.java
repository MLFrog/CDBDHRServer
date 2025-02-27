package com.cdbd.hr.domain.att.IDTypes;

import com.cdbd.hr.infrastructure.jpa.entity.ShiftJpaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShiftId {

	private String ShiftId;

	
	public static ShiftId valueOf(String value) {
	    return new ShiftId(value);
	}
	
}


	

	