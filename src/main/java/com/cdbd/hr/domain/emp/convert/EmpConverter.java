package com.cdbd.hr.domain.emp.convert;

import com.cdbd.hr.domain.common.DomainConverter;
import com.cdbd.hr.domain.emp.Employee;

public interface EmpConverter <T> extends DomainConverter<T, Employee> {
	 Employee convert(T entity, Object obj);
}
