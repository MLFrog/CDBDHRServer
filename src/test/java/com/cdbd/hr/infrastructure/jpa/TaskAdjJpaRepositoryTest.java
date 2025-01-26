package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.TaskAdjJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.TaskAdjJpaRepository;

import jakarta.transaction.Transactional;

public class TaskAdjJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TaskAdjJpaRepositoryTest.class);

    @Autowired
    private TaskAdjJpaRepository taskAdjJpaRepository;

    private TaskAdjJpaEntity taskAdjJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: TaskAdjJpaEntity 객체 준비
        taskAdjJpaEntity = new TaskAdjJpaEntity();
        taskAdjJpaEntity.setEmpId("E001");
        taskAdjJpaEntity.setAdjType("출장");
        taskAdjJpaEntity.setStdYmd("20241226");
        taskAdjJpaEntity.setStartHms("090000");
        taskAdjJpaEntity.setEndHms("180000");
        taskAdjJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        taskAdjJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("TaskAdj 객체 생성 완료: {}", taskAdjJpaEntity);
    }

    @Test
    public void 업무가감생성하기() {
        // given: 엔티티 준비 완료

        // when: 데이터를 저장
        TaskAdjJpaEntity savedEntity = taskAdjJpaRepository.save(taskAdjJpaEntity);

        // then: 저장된 데이터 검증
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getAdjType()).isEqualTo("출장");
        assertThat(savedEntity.getStdYmd()).isEqualTo("20241226");
        assertThat(savedEntity.getStartHms()).isEqualTo("090000");
        assertThat(savedEntity.getEndHms()).isEqualTo("180000");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("업무 가감 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 업무가감조회하기() {
        // given: 엔티티 저장
        taskAdjJpaRepository.save(taskAdjJpaEntity);

        // when: 데이터 조회
        TaskAdjJpaEntity foundEntity = taskAdjJpaRepository.findById("E001").orElse(null);

        // then: 조회된 데이터 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");
        assertThat(foundEntity.getAdjType()).isEqualTo("출장");
        assertThat(foundEntity.getStdYmd()).isEqualTo("20241226");

        logger.info("업무 가감 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    @Transactional
    public void 업무가감삭제하기() {
        // given: 엔티티 저장
        taskAdjJpaRepository.save(taskAdjJpaEntity);

        // when: 데이터 삭제
        taskAdjJpaRepository.deleteByEmpIdAndStdYmd("E001", "20241226");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        TaskAdjJpaEntity foundEntity = taskAdjJpaRepository.findByEmpIdAndStdYmd("E001", "20241226");

        assertThat(foundEntity).isNull();

        logger.info("업무 가감 삭제 테스트 완료. 삭제된 사번: E001");
    }
}
