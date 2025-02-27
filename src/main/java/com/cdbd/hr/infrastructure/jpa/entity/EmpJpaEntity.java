package com.cdbd.hr.infrastructure.jpa.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@Comment("사원 정보")
public class EmpJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
    @Column(name = "emp_id")
    @Comment("사번")
    private String empId;

    @ManyToOne
    @Column(name = "shift_id")
    @Comment("근무형태(근무조)")
    private String shiftId;

    @Column(name = "name")
    @Comment("이름")
    private String name;

    @Column(name = "ssn")
    @Comment("주민등록번호(외국인 등록번호)")
    private String ssn;

    @Column(name = "nationality")
    @Comment("국적")
    private String nationality;

    @Column(name = "gender")
    @Comment("성별")
    private String gender;

    @Column(name = "phone_number")
    @Comment("연락처")
    private String phoneNumber;

    @Column(name = "address")
    @Comment("주소")
    private String address;

    @Column(name = "join_date")
    @Comment("입사일")
    private String joinDate;

    @Column(name = "resignation_date")
    @Comment("퇴사일")
    private String resignationDate;

    @Column(name = "position")
    @Comment("직급")
    private String position;

    @Column(name = "job_title")
    @Comment("직책")
    private String jobTitle;

    @Column(name = "emp_type")
    @Comment("고용 형태")
    private String empType;

    @Column(name = "work_loc")
    @Comment("근무지")
    private String workLoc;

    @Column(name = "salary")
    @Comment("연봉")
    private Integer salary;

    @Column(name = "bank")
    @Comment("계좌 은행")
    private String bank;

    @Column(name = "bank_account")
    @Comment("계좌")
    private String bankAccount;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("생성일시")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("수정일시")
    private Timestamp updatedAt;
}
