package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.ShiftJpaEntity;

@Repository
public interface ShiftJpaRepository extends JpaRepository<ShiftJpaEntity, Long> {
	
	//근무조ID를 기준으로 조회
	Optional<ShiftJpaEntity> findByShiftId(String shiftId);
	
	//근무조ID를 기준으로 삭제
	void deleteByShiftId(String shiftId);
}
