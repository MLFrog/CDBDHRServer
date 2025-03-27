package com.cdbd.hr.domain.dep.convert.impl;

import java.time.Instant;
import java.util.Optional;

import com.cdbd.hr.domain.dep.DepFactory;
import com.cdbd.hr.domain.dep.Department;
import com.cdbd.hr.domain.dep.IDTypes.DepCode;
import com.cdbd.hr.domain.dep.convert.DepConverter;
import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;

public class JpaDepConverter implements DepConverter<DepJpaEntity>{
	
	private final  DepFactory factory = new DepFactory();
	
    @Override
    public Department convert(DepJpaEntity depEntity) {
        return convert(depEntity, null); 
    }

	@Override	
    public Department convert(DepJpaEntity entity, Object object) {
		
		Department obj = this.factory.getInstance();

        obj.setDepCode(DepCode.valueOf(Optional.ofNullable(entity.getDepCode()).orElse(null)));
        obj.setDepName(String.valueOf(entity.getDepName()));
        obj.setPDepCode(Optional.ofNullable(entity.getPDepCode()).orElse(null));
        obj.setCDepCode(Optional.ofNullable(entity.getCDepCode()).orElse(null));
        obj.setTDepYn(Optional.ofNullable(entity.getTDepYn()).orElse("N"));
        obj.setStaYmd(Optional.ofNullable(entity.getStaYmd()).orElse(null));
        obj.setEndYmd(Optional.ofNullable(entity.getEndYmd()).orElse(null));
		obj.setCreatedAt(Optional.ofNullable(entity.getCreatedAt().toInstant()).orElse(Instant.now()));
		obj.setUpdatedAt(Optional.ofNullable(entity.getUpdatedAt().toInstant()).orElse(Instant.now())); 
        
        return obj;
    }
}
