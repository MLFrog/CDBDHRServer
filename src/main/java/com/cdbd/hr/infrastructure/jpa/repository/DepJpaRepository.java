package com.cdbd.hr.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;

@Repository
public interface DepJpaRepository extends JpaRepository<DepJpaEntity, Long> {
	
	//부서ID를 기준으로 조회
	Optional<DepJpaEntity> findByDepCode(String depCode);
	
	//부서ID를 기준으로 삭제
	void deleteByDepCode(String depcode);
}

