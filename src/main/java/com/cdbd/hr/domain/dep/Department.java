package com.cdbd.hr.domain.dep;

import java.time.Instant;
import java.util.List;

import com.cdbd.hr.domain.common.DomainEntity;
import com.cdbd.hr.domain.dep.IDTypes.DepCode;
import com.cdbd.hr.domain.dep.repository.impl.DepDomainRepository;

import lombok.Data;

@Data
@DomainEntity
public class Department {

	private DepCode depCode;
	private String depName;
	private String pDepCode;
	private String cDepCode;
	private String tDepYn;
	private String staYmd;
	private String endYmd;
    private Instant createdAt;
    private Instant updatedAt;

	
	// 저장,수정
	public void save(DepDomainRepository repository) {
		repository.save(this);
	}
	
   	// 삭제
	public void delete(DepDomainRepository repository){
		repository.delete(this.depCode);
	}
    
	// 전체 부서 조회
	public List<Department> getDepartmentList(DepDomainRepository repository) {
		return repository.getAllDepartment();
	}
	
	// 부서 코드로 조회
	public Department findByDepCode(DepDomainRepository repository) {
		Department data = repository.findByDepCodeIgnoreCase(this.depCode);
		setDepCode(data.getDepCode());
		setDepName(data.getDepName());
		setPDepCode(data.getPDepCode());
		setCDepCode(data.getCDepCode());
		setTDepYn(data.getTDepYn());
		setStaYmd(data.getStaYmd());
		setEndYmd(data.getEndYmd());
		setCreatedAt(data.getCreatedAt());
		setUpdatedAt(data.getUpdatedAt());
		
		return this;
	}
	
}
