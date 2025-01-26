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
@Table(name = "attendance")
@Comment("근태")
public class AttJpaEntity {

    @Id
    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;

    @Column(name = "std_ymd")
    @Comment("기준일")
    private String stdYmd;

    @Column(name = "holiday_yn")
    @Comment("휴일여부")
    private String holidayYn;

    @Column(name = "in_time")
    @Comment("출근일시")
    private String inTime;

    @Column(name = "out_time")
    @Comment("퇴근일시")
    private String outTime;

    @Column(name = "work_hours")
    @Comment("근무시간(일)")
    private Double workHours;

    @Column(name = "break_hours")
    @Comment("휴게시간(일)")
    private Double breakHours;

    @Column(name = "over_time_hours")
    @Comment("연장근무시간(일)")
    private Double overTimeHours;

    @Column(name = "night_work_hours")
    @Comment("야간연장근무시간(일)")
    private Double nightWorkHours;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("생성일시")
	private Timestamp createdAt;

	@Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Comment("수정일시")
	private Timestamp updatedAt;
}
