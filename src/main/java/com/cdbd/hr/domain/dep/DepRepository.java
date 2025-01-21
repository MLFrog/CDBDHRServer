package com.cdbd.hr.domain.dep;

import java.util.List;

public interface DepRepository {
	void insert(Department board);
	
	void update(Department board);
	
	void delete(String boardId);
	
	List<Department>  getAllDepartment();
}
