package com.cdbd.hr.domain.dep;

import java.util.List;

import com.cdbd.hr.domain.dep.IDTypes.DepCode;

public interface DepRepository {
	void save(Department board);

	void delete(DepCode depCode);

	List<Department> getAllDepartment();
	
	Department findByDepCodeIgnoreCase(DepCode depCode);

}
