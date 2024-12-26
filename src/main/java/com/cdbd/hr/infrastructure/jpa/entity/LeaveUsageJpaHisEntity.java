package com.cdbd.hr.infrastructure.jpa.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_usage_history")
@Comment("연차사용내역")
public class LeaveUsageJpaHisEntity {
	
    @Id
    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;
    
    @Column(name = "leave_type")
    @Comment("연차유형")   
    private String leaveType;

    @Column(name = "std_ymd")
    @Comment("기준일")
    private String stdYmd;
    
    @Column(name = "used_cnt")
    @Comment("사용개수")
    private Integer usedCount;
    
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("생성일시")
	private Timestamp createdAt;
	
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("수정일시")
	private Timestamp updatedAt;
    
}
