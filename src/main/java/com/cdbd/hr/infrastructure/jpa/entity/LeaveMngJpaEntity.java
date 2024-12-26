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
@Table(name = "annual_leave_manage")
@Comment("연차관리")
public class LeaveMngJpaEntity {

    @Id
    @Column(name = "leave_type")
    @Comment("연차유형")   
    private String leaveType;

    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;
    
    @Column(name = "sta_ymd")
    @Comment("시작일")
    private String staYmd;

    @Column(name = "end_ymd")
    @Comment("종료일")
    private String endYmd;

    @Column(name = "tot_cnt")
    @Comment("총개수")
    private Integer totCnt;

    @Column(name = "used_cnt")
    @Comment("사용개수")
    private Integer usedCount;

    @Column(name = "remain_cnt")
    @Comment("잔여개수")
    private Integer remainCount;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("생성일시")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("수정일시")
    private Timestamp updatedAt;
}
