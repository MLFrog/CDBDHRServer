package com.cdbd.hr.domain.dep.repository.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.util.Assert;

import com.cdbd.hr.domain.dep.DepRepository;
import com.cdbd.hr.domain.dep.Department;
import com.cdbd.hr.domain.dep.IDTypes.DepCode;
import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.DepJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DepDomainRepository implements DepRepository{
	
    private final DepJpaRepository jpaRepository;
    
    @Override
	public void save(Department department)
	{
    	Assert.notNull(department, "회원 엔티티는 Null일 수 없습니다.");
        this.jpaRepository.save(JpaConverter(department));
	}
	
    @Override
	public void delete(DepCode depCode)
	{
    	this.jpaRepository.deleteByDepCode(String.valueOf(depCode));
	}
	
    @Override
	public List<Department> getAllDepartment()
	{
    	return this.jpaRepository.findAll().stream()
				.map(this::domainconverter)
				.toList();
	}
    
    @Override
    public Department findByDepCodeIgnoreCase(DepCode depCode)
    {
    	return this.domainconverter(this.jpaRepository.findByDepCode(String.valueOf(depCode)).orElse(null));
    }
    
    
    private DepJpaEntity JpaConverter(Department data) { 
        DepJpaEntity obj = new DepJpaEntity();

        obj.setDepCode(String.valueOf(Optional.ofNullable(data.getDepCode()).orElse(null)));
        obj.setDepName(String.valueOf(Optional.ofNullable(data.getDepName()).orElse(null)));
        obj.setPDepCode(Optional.ofNullable(data.getPDepCode()).orElse(null));
        obj.setCDepCode(Optional.ofNullable(data.getCDepCode()).orElse(null));
        obj.setTDepYn(Optional.ofNullable(data.getTDepYn()).orElse("N"));
        obj.setStaYmd(Optional.ofNullable(data.getStaYmd()).orElse(null));
        obj.setEndYmd(Optional.ofNullable(data.getEndYmd()).orElse(null));
        obj.setCreatedAt(Optional.ofNullable(data.getCreatedAt())
                .map(instant -> instant.atZone(java.time.ZoneId.systemDefault()).toLocalDateTime())
                .orElse(LocalDateTime.now())); 
        obj.setUpdatedAt(Optional.ofNullable(data.getUpdatedAt())
                .map(instant -> instant.atZone(java.time.ZoneId.systemDefault()).toLocalDateTime())
                .orElse(LocalDateTime.now()));

        return obj;
    }

    
    public Department domainconverter(DepJpaEntity entity) {
        Department obj = new Department();

        obj.setDepCode(DepCode.valueOf(Optional.ofNullable(entity.getDepCode()).orElse(null)));
        obj.setDepName(String.valueOf(entity.getDepName()));
        obj.setPDepCode(Optional.ofNullable(entity.getPDepCode()).orElse(null));
        obj.setCDepCode(Optional.ofNullable(entity.getCDepCode()).orElse(null));
        obj.setTDepYn(Optional.ofNullable(entity.getTDepYn()).orElse("N"));
        obj.setStaYmd(Optional.ofNullable(entity.getStaYmd()).orElse(null));
        obj.setEndYmd(Optional.ofNullable(entity.getEndYmd()).orElse(null));
        obj.setCreatedAt(Optional.ofNullable(entity.getCreatedAt())
                .map(date -> date.atZone(java.time.ZoneId.systemDefault()).toInstant())
                .orElse(Instant.now()));
        obj.setUpdatedAt(Optional.ofNullable(entity.getUpdatedAt())
                .map(date -> date.atZone(java.time.ZoneId.systemDefault()).toInstant())
                .orElse(Instant.now()));

        return obj;
    }

}
