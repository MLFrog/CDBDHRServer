package com.cdbd.hr.domain.dep;

import java.util.List;

public interface DepRepository {
	void save(Department board);

	void update(Department board);

	void delete(String boardId);

	List<Department> getAllDepartment();
	
	List<Department> findAllByOrderByDepCodeAsc();
}
