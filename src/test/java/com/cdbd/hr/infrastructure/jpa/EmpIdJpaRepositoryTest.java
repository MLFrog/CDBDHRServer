package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.EmpIdJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.EmpIdJpaRepository;

public class EmpIdJpaRepositoryTest extends JpaRepositoryTest{

    private static final Logger logger = LoggerFactory.getLogger(EmpIdJpaRepositoryTest.class);

    @Autowired
    private EmpIdJpaRepository empIdJpaRepository;

    private EmpIdJpaEntity empIdJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: EmpIdJpaEntity 객체를 준비
        empIdJpaEntity = new EmpIdJpaEntity();
        empIdJpaEntity.setEmpId("E001");
        empIdJpaEntity.setUseYn("Y");
        empIdJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        empIdJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체생성확인: {}", empIdJpaEntity);
    }

    @Test
    public void 사번생성하기() {
        // given: Entity가 준비되었음

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        EmpIdJpaEntity savedEntity = empIdJpaRepository.save(empIdJpaEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getUseYn()).isEqualTo("Y");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("사번 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 사번조회하기() {
        // given: Entity를 저장
        empIdJpaRepository.save(empIdJpaEntity);

        // when: 특정 empId로 엔티티를 조회
        EmpIdJpaEntity foundEntity = empIdJpaRepository.findById("E001").orElse(null);

        // then: 조회된 엔티티의 값이 맞는지 확인
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");
        assertThat(foundEntity.getUseYn()).isEqualTo("Y");

        logger.info("사번 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 사번삭제하기() {
        // given: Entity 저장
        empIdJpaRepository.save(empIdJpaEntity);

        // when: 엔티티 삭제
        empIdJpaRepository.deleteById("E001");

        // then: 삭제 후 조회하여 null 반환되는지 확인
        EmpIdJpaEntity foundEntity = empIdJpaRepository.findById("E001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("사번 삭제 테스트 완료. 삭제된 사번: E001");
    }
}
