package com.cdbd.hr.domain.emp.convert.impl;

import java.time.Instant;
import java.util.Optional;

import com.cdbd.hr.domain.att.IDTypes.ShiftId;
import com.cdbd.hr.domain.emp.EmpFactory;
import com.cdbd.hr.domain.emp.Employee;
import com.cdbd.hr.domain.emp.IDTypes.EmpId;
import com.cdbd.hr.domain.emp.convert.EmpConverter;
import com.cdbd.hr.infrastructure.jpa.entity.EmpIdJpaEntity;
import com.cdbd.hr.infrastructure.jpa.entity.EmpJpaEntity;

public class JpaEmpConverter implements EmpConverter<EmpJpaEntity> {

    private final EmpFactory factory = new EmpFactory();

    @Override
    public Employee convert(EmpJpaEntity empEntity) {
        return convert(empEntity, null); 
    }

    @Override
    public Employee convert(EmpJpaEntity empEntity, Object object) {
        EmpIdJpaEntity empIdEntity = (object instanceof EmpIdJpaEntity) ? (EmpIdJpaEntity) object : new EmpIdJpaEntity();

        Employee obj = this.factory.getInstance();

        obj.setEmpId(EmpId.valueOf(Optional.ofNullable(empEntity.getEmpId()).orElse(null)));
        obj.setUseYn(Optional.ofNullable(empIdEntity.getUseYn()).orElse("N")); 
        obj.setShiftId(ShiftId.valueOf(Optional.ofNullable(empEntity.getShiftId()).orElse(null)));
        obj.setName(Optional.ofNullable(empEntity.getName()).orElse(null));
        obj.setSsn(Optional.ofNullable(empEntity.getSsn()).orElse(null));
        obj.setNationality(Optional.ofNullable(empEntity.getNationality()).orElse(null));
        obj.setGender(Optional.ofNullable(empEntity.getGender()).orElse(null));
        obj.setPhoneNumber(Optional.ofNullable(empEntity.getPhoneNumber()).orElse(null));
        obj.setAddress(Optional.ofNullable(empEntity.getAddress()).orElse(null));
        obj.setJoinDate(Optional.ofNullable(empEntity.getJoinDate()).orElse(null));
        obj.setResignationDate(Optional.ofNullable(empEntity.getResignationDate()).orElse(null));
        obj.setPosition(Optional.ofNullable(empEntity.getPosition()).orElse(null));
        obj.setJobTitle(Optional.ofNullable(empEntity.getJobTitle()).orElse(null));
        obj.setEmpType(Optional.ofNullable(empEntity.getEmpType()).orElse(null));
        obj.setWorkLoc(Optional.ofNullable(empEntity.getWorkLoc()).orElse(null));
        obj.setSalary(Optional.ofNullable(empEntity.getSalary()).orElse(0));
        obj.setBank(Optional.ofNullable(empEntity.getBank()).orElse(null));
        obj.setBankAccount(Optional.ofNullable(empEntity.getBankAccount()).orElse(null));
        obj.setCreatedAt(Optional.ofNullable(empEntity.getCreatedAt().toInstant()).orElse(Instant.now()));
        obj.setUpdatedAt(Optional.ofNullable(empEntity.getUpdatedAt().toInstant()).orElse(Instant.now()));

        return obj;
    }
}
