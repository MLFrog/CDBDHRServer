package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.DepJpaRepository;

public class DepJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(DepJpaRepositoryTest.class);

    @Autowired
    private DepJpaRepository depJpaRepository;

    private DepJpaEntity depJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: DepJpaEntity 객체를 준비
        depJpaEntity = new DepJpaEntity();
        depJpaEntity.setDepCode("D001");
        depJpaEntity.setDepName("영업부");
        depJpaEntity.setPDepCode("PD001");
        depJpaEntity.setCDepCode("CD001");
        depJpaEntity.setTDepYn("Y");
        depJpaEntity.setStaYmd("2024-01-01");
        depJpaEntity.setEndYmd("2025-01-01");
        depJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        depJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체생성확인: {}", depJpaEntity);
    }

    @Test
    public void 부서생성하기() {
        // given: Entity가 준비되었음

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        DepJpaEntity savedEntity = depJpaRepository.save(depJpaEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getDepCode()).isEqualTo("D001");
        assertThat(savedEntity.getDepName()).isEqualTo("영업부");
        assertThat(savedEntity.getPDepCode()).isEqualTo("PD001");
        assertThat(savedEntity.getCDepCode()).isEqualTo("CD001");
        assertThat(savedEntity.getTDepYn()).isEqualTo("Y");
        assertThat(savedEntity.getStaYmd()).isEqualTo("20240101");
        assertThat(savedEntity.getEndYmd()).isEqualTo("99991231");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("부서 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 부서조회하기() {
        // given: Entity를 저장
        depJpaRepository.save(depJpaEntity);

        // when: 특정 depCode로 엔티티를 조회
        DepJpaEntity foundEntity = depJpaRepository.findById("D001").orElse(null);

        // then: 조회된 엔티티의 값이 맞는지 확인
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getDepCode()).isEqualTo("D001");
        assertThat(foundEntity.getDepName()).isEqualTo("영업부");
        assertThat(foundEntity.getPDepCode()).isEqualTo("PD001");

        logger.info("부서 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 부서삭제하기() {
        // given: Entity 저장
        depJpaRepository.save(depJpaEntity);

        // when: 엔티티 삭제
        depJpaRepository.deleteById("D001");

        // then: 삭제 후 조회하여 null 반환되는지 확인
        DepJpaEntity foundEntity = depJpaRepository.findById("D001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("부서 삭제 테스트 완료. 삭제된 부서: D001");
    }
}
