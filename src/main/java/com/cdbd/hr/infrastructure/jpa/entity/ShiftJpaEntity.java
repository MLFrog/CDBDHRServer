package com.cdbd.hr.infrastructure.jpa.entity;

import java.security.Timestamp;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shift")
@Comment("근무조")
public class ShiftJpaEntity {
	
    @Id  
    @Column(name = "shift_id")
    @Comment("근무형태(근무조)")
    private String shiftId;

    @Column(name = "shift_nm")
    @Comment("근무조명")
    private String shiftName;

    @Column(name = "base_day")
    @Comment("기준 요일")
    private String baseDay;

    @Column(name = "use_yn")
    @Comment("사용 여부")
    private String useYn;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("생성일시")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("수정일시")
    private Timestamp updatedAt;
}