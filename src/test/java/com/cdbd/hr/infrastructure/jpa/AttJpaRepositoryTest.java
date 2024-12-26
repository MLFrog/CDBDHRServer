package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.AttJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.AttJpaRepository;

import jakarta.transaction.Transactional;

public class AttJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AttJpaRepositoryTest.class);

    @Autowired
    private AttJpaRepository attJpaRepository;

    private AttJpaEntity attJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: AttJpaEntity 객체를 준비
        attJpaEntity = new AttJpaEntity();
        attJpaEntity.setEmpId("E001");
        attJpaEntity.setStdYmd("20241222");
        attJpaEntity.setHolidayYn("N");
        attJpaEntity.setInTime("20241220080000");
        attJpaEntity.setOutTime("20241220170000");
        attJpaEntity.setWorkHours(8.0);
        attJpaEntity.setBreakHours(1.0);
        attJpaEntity.setOverTimeHours(2.0);
        attJpaEntity.setNightWorkHours(0.0);
        attJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        attJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", attJpaEntity);
    }

    @Test
    public void 근태생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        AttJpaEntity savedEntity = attJpaRepository.save(attJpaEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getStdYmd()).isEqualTo("20241222");
        assertThat(savedEntity.getHolidayYn()).isEqualTo("N");
        assertThat(savedEntity.getInTime()).isEqualTo("20241220080000");
        assertThat(savedEntity.getOutTime()).isEqualTo("20241220170000");
        assertThat(savedEntity.getWorkHours()).isEqualTo(8.0);
        assertThat(savedEntity.getBreakHours()).isEqualTo(1.0);
        assertThat(savedEntity.getOverTimeHours()).isEqualTo(2.0);
        assertThat(savedEntity.getNightWorkHours()).isEqualTo(0.0);

        logger.info("근태 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 근태조회하기() {
        // given: Entity를 저장
        attJpaRepository.save(attJpaEntity);

        // when: 특정 empId와 stdYmd로 엔티티 조회
        AttJpaEntity foundEntity = attJpaRepository.findById("E001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");
        assertThat(foundEntity.getStdYmd()).isEqualTo("20241222");

        logger.info("근태 조회 테스트 완료: {}", foundEntity);
    }

    @Test 
    @Transactional
    public void 근태삭제하기() {
        // given: Entity 저장
        attJpaRepository.save(attJpaEntity);

        // when: 엔티티 삭제
        attJpaRepository.deleteByEmpIdAndStdYmd("E001", "20241222");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        AttJpaEntity foundEntity = attJpaRepository.findByEmpIdAndStdYmd("E001", "20241222");

        assertThat(foundEntity).isNull();
        logger.info("근태 삭제 테스트 완료. 삭제된 근태 : 사번(E001) 기준일(20241222)");
    }
}
