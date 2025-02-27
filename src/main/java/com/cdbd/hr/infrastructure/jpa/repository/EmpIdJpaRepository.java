package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.EmpIdJpaEntity;

@Repository
public interface EmpIdJpaRepository extends JpaRepository<EmpIdJpaEntity, Long> {
	
	Optional<EmpIdJpaEntity> findByEmpId(String empId);
	
}
