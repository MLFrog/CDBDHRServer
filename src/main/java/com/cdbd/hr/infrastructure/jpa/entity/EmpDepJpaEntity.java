package com.cdbd.hr.infrastructure.jpa.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_dep")
@Comment("사번-부서 관계")
public class EmpDepJpaEntity {

    @Id
    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;

    @ManyToOne
    @JoinColumn(name = "dep_code", referencedColumnName = "dep_code")
    @Comment("부서코드")
    private DepJpaEntity depCode;

    @Column(name = "dep_leader_yn")
    @Comment("부서장여부")
    private String depLeaderYn;

    @Column(name = "dual_dep_yn")
    @Comment("겸직부서여부")
    private String dualDepYn;

    @Column(name = "sta_ymd")
    @Comment("시작일")
    private String staYmd;

    @Column(name = "end_ymd")
    @Comment("종료일")
    private String endYmd;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("생성일시")
	private Timestamp createdAt;
	
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("수정일시")
	private Timestamp updatedAt;
}