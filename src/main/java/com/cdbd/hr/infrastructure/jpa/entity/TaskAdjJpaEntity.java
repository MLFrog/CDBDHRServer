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
@Table(name = "task_adjustment")
@Comment("업무 가감")
public class TaskAdjJpaEntity {
	
    @Id
    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;

    @Column(name = "adj_type")
    @Comment("업무가감유형")
    private String adjType;

    @Column(name = "std_ymd")
    @Comment("기준일")
    private String stdYmd;

    @Column(name = "sta_hms")
    @Comment("시작시간")    
    private String startHms;

    @Column(name = "end_hms")
    @Comment("종료시간")
    private String endHms;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("생성일시")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("수정일시")
    private Timestamp updatedAt;
}
