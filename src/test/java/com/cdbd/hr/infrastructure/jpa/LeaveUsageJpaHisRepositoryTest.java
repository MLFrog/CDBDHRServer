package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.LeaveMngJpaEntity;
import com.cdbd.hr.infrastructure.jpa.entity.LeaveUsageJpaHisEntity;
import com.cdbd.hr.infrastructure.jpa.repository.LeaveUsageJpaHisRepository;

import jakarta.transaction.Transactional;

public class LeaveUsageJpaHisRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(LeaveUsageJpaHisRepositoryTest.class);
 
    @Autowired
    private LeaveUsageJpaHisRepository leaveUsageJpaHisRepository;

    private LeaveMngJpaEntity leaveMngJpaEntity;
    private LeaveUsageJpaHisEntity leaveUsageJpaHisEntity;

    @BeforeEach
    public void setUp() {
        // 1. 연차 사용 내역 엔티티 생성
        leaveUsageJpaHisEntity = new LeaveUsageJpaHisEntity();
        leaveUsageJpaHisEntity.setEmpId("E001");
        leaveUsageJpaHisEntity.setLeaveType("연차휴가"); 
        leaveUsageJpaHisEntity.setStdYmd("20240115");
        leaveUsageJpaHisEntity.setUsedCount(2);
        leaveUsageJpaHisEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        leaveUsageJpaHisEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("LeaveMngJpaEntity 저장 완료: {}", leaveMngJpaEntity);
    }

    @Test
    public void 연차사용내역생성하기() {
        // given: 연차 사용 내역이 준비됨

        // when: 데이터를 저장
        LeaveUsageJpaHisEntity savedEntity = leaveUsageJpaHisRepository.save(leaveUsageJpaHisEntity);

        // then: 저장된 값이 올바른지 검증
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getLeaveType()).isEqualTo("연차휴가");
        assertThat(savedEntity.getStdYmd()).isEqualTo("20240115");
        assertThat(savedEntity.getUsedCount()).isEqualTo(2);
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("연차 사용 내역 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 연차사용내역조회하기() {
        // given: 엔티티 저장
        leaveUsageJpaHisRepository.save(leaveUsageJpaHisEntity);

        // when: 데이터 조회
        LeaveUsageJpaHisEntity foundEntity = leaveUsageJpaHisRepository.findById("E001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");
        assertThat(foundEntity.getLeaveType()).isEqualTo("연차휴가");

        logger.info("연차 사용 내역 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    @Transactional
    public void 연차사용내역삭제하기() {
        // given: 엔티티 저장
        leaveUsageJpaHisRepository.save(leaveUsageJpaHisEntity);

        // when: 데이터 삭제
        leaveUsageJpaHisRepository.deleteByEmpIdAndLeaveTypeAndStdYmd("E001","연차휴가","20240115");

        // then: 삭제 후 데이터 조회
        LeaveUsageJpaHisEntity foundEntity = leaveUsageJpaHisRepository.findByEmpIdAndLeaveTypeAndStdYmd("E001","연차휴가","20240115");
        assertThat(foundEntity).isNull();

        logger.info("연차 사용 내역 삭제 테스트 완료. 삭제된 사번: E001");
    }
}
