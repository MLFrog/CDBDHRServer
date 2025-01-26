package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.LeaveMngJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.LeaveMngJpaRepository;

import jakarta.transaction.Transactional;

public class LeaveMngJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(LeaveMngJpaRepositoryTest.class);

    @Autowired
    private LeaveMngJpaRepository leaveMngJpaRepository;

    private LeaveMngJpaEntity leaveMngJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: LeaveMngJpaEntity 객체 준비
        leaveMngJpaEntity = new LeaveMngJpaEntity();
        leaveMngJpaEntity.setLeaveType("연차휴가");
        leaveMngJpaEntity.setEmpId("E001");
        leaveMngJpaEntity.setStaYmd("20240101");
        leaveMngJpaEntity.setEndYmd("20241231");
        leaveMngJpaEntity.setTotCnt(15);
        leaveMngJpaEntity.setUsedCount(5);
        leaveMngJpaEntity.setRemainCount(10);
        leaveMngJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        leaveMngJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", leaveMngJpaEntity);
    }

    @Test
    public void 연차생성하기() {
        // when: 데이터를 저장하고 반환된 엔티티 확인
        LeaveMngJpaEntity savedEntity = leaveMngJpaRepository.save(leaveMngJpaEntity);

        // then: 저장된 엔티티 필드 값 검증
        assertThat(savedEntity.getLeaveType()).isEqualTo("연차휴가");
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getStaYmd()).isEqualTo("20240101");
        assertThat(savedEntity.getEndYmd()).isEqualTo("20241231");
        assertThat(savedEntity.getTotCnt()).isEqualTo(15);
        assertThat(savedEntity.getUsedCount()).isEqualTo(5);
        assertThat(savedEntity.getRemainCount()).isEqualTo(10);
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("연차 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 연차조회하기() {
        // given: 엔티티 저장
        leaveMngJpaRepository.save(leaveMngJpaEntity);

        // when: 특정 leaveType으로 엔티티 조회
        LeaveMngJpaEntity foundEntity = leaveMngJpaRepository.findByEmpIdAndLeaveType("E001", "연차휴가");

        // then: 조회된 엔티티 값 확인
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getLeaveType()).isEqualTo("연차휴가");
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");

        logger.info("연차 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    @Transactional
    public void 연차삭제하기() {
        // given: 엔티티 저장
        leaveMngJpaRepository.save(leaveMngJpaEntity);

        // when: 엔티티 삭제
        leaveMngJpaRepository.deleteByEmpIdAndLeaveType("E001", "연차휴가");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        LeaveMngJpaEntity foundEntity = leaveMngJpaRepository.findByEmpIdAndLeaveType("E001", "연차휴가");

        assertThat(foundEntity).isNull();
        logger.info("연차 삭제 테스트 완료. 삭제된 연차: annual");
    }
}
