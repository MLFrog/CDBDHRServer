package com.cdbd.hr.domain.dep.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.util.Assert;

import com.cdbd.hr.domain.dep.DepRepository;
import com.cdbd.hr.domain.dep.Department;
import com.cdbd.hr.domain.dep.convert.DepConverter;
import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.DepJpaRepository;

public class JpaDepRepository implements DepRepository{
	
    private final DepJpaRepository jpaRepository;
    private final DepConverter<DepJpaEntity> converter;
    
    public JpaDepRepository(DepJpaRepository jpaRepository, DepConverter<DepJpaEntity> converter) {
        Assert.notNull(jpaRepository, "jpaRepository는 null일 수 없습니다.");
        Assert.notNull(converter, "converter는 null일 수 없습니다.");
        this.jpaRepository = jpaRepository;
        this.converter = converter;
    }
	
    @Override
	public void save(Department department)
	{
    	Assert.notNull(department, "회원 엔티티는 Null일 수 없습니다.");
    	System.out.println("JpaDepRepository의 insert까지는 탐" + department);
        this.jpaRepository.save(convert(department));
	}
    
    @Override
	public void update(Department department)
	{

	}
	
    @Override
	public void delete(String boardId)
	{
  
	}
	
    @Override
	public List<Department> getAllDepartment()
	{
    	return null;
	}
    
    
    @Override
    public List<Department> findAllByOrderByDepCodeAsc()
    {
    	return null;
    }
    
    private DepJpaEntity convert(Department  data) {
    	DepJpaEntity obj = new DepJpaEntity();
    	
        obj.setDepCode(Optional.ofNullable(data.getDepCode()).orElse(null));
        obj.setPDepCode(Optional.ofNullable(data.getPDepCode()).orElse(null));
        obj.setCDepCode(Optional.ofNullable(data.getCDepCode()).orElse(null));
        obj.setTDepYn(Optional.ofNullable(data.getTDepYn()).orElse("N"));
        obj.setStaYmd(Optional.ofNullable(data.getStaYmd()).orElse(null));
        obj.setEndYmd(Optional.ofNullable(data.getEndYmd()).orElse(null));
        obj.setCreatedAt(Timestamp.from(Instant.now()));
        obj.setUpdatedAt(Timestamp.from(Instant.now()));
        
        return obj;
    }

}
