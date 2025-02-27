package com.cdbd.hr.infrastructure.jpa.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
@Comment("부서정보")
public class DepJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "dep_code")
	@Comment("부서코드")
	private String depCode;

    @Column(name = "dep_name")
    @Comment("부서명")
    private String depName;
	
	@Column(name = "p_dep_code")
	@Comment("상위부서코드")
	private String pDepCode;

	@Column(name = "c_dep_code")
	@Comment("하위부서코드")
	private String cDepCode;

	@Column(name = "t_dep_yn")
	@Comment("최상위부서여부")
	private String tDepYn;

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
