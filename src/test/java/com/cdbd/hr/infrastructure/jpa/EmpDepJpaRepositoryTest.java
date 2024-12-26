package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.EmpDepJpaEntity;
import com.cdbd.hr.infrastructure.jpa.entity.DepJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.EmpDepJpaRepository;
import com.cdbd.hr.infrastructure.jpa.repository.DepJpaRepository;

public class EmpDepJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(EmpDepJpaRepositoryTest.class);

    @Autowired
    private EmpDepJpaRepository empDepJpaRepository;

    @Autowired
    private DepJpaRepository depJpaRepository;

    private EmpDepJpaEntity empDepJpaEntity;
    private DepJpaEntity depJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: 부서 엔티티 준비
        depJpaEntity = new DepJpaEntity();
        depJpaEntity.setDepCode("D001");
        depJpaEntity.setPDepCode("PD001");
        depJpaEntity.setCDepCode("CD001");
        depJpaEntity.setTDepYn("Y");
        depJpaEntity.setStaYmd("20240101");
        depJpaEntity.setEndYmd("99991231");
        depJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        depJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        depJpaRepository.save(depJpaEntity);  // 부서 저장

        // given: EmpDepJpaEntity 객체 준비
        empDepJpaEntity = new EmpDepJpaEntity();
        empDepJpaEntity.setEmpId("E001");
        empDepJpaEntity.setDepCode(depJpaEntity);  // 부서 외래키 설정
        empDepJpaEntity.setDepLeaderYn("Y");
        empDepJpaEntity.setDualDepYn("N");
        empDepJpaEntity.setStaYmd("20240101");
        empDepJpaEntity.setEndYmd("99991231");
        empDepJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        empDepJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체생성확인: {}", empDepJpaEntity);
    }

    @Test
    public void 사번_부서관계생성하기() {
        // when: EmpDepJpaEntity 저장
        EmpDepJpaEntity savedEntity = empDepJpaRepository.save(empDepJpaEntity);

        // then: 저장된 엔티티의 값 확인
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getDepCode().getDepCode()).isEqualTo("D001");  // 부서코드 확인
        assertThat(savedEntity.getDepLeaderYn()).isEqualTo("Y");
        assertThat(savedEntity.getDualDepYn()).isEqualTo("N");
        assertThat(savedEntity.getStaYmd()).isEqualTo("20240101");
        assertThat(savedEntity.getEndYmd()).isEqualTo("99991231");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("사번-부서 관계 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 사번_부서관계조회하기() {
        // given: 엔티티를 저장
        empDepJpaRepository.save(empDepJpaEntity);

        // when: empId로 엔티티 조회
        EmpDepJpaEntity foundEntity = empDepJpaRepository.findById("E001").orElse(null);

        // then: 조회된 엔티티의 값 확인
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getEmpId()).isEqualTo("E001");
        assertThat(foundEntity.getDepCode().getDepCode()).isEqualTo("D001");  // 부서코드 확인
        assertThat(foundEntity.getDepLeaderYn()).isEqualTo("Y");

        logger.info("사번-부서 관계 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 사번_부서관계삭제하기() {
        // given: 엔티티 저장
        empDepJpaRepository.save(empDepJpaEntity);

        // when: 엔티티 삭제
        empDepJpaRepository.deleteById("E001");

        // then: 삭제 후 조회하여 null인지 확인
        EmpDepJpaEntity foundEntity = empDepJpaRepository.findById("E001").orElse(null);
        assertThat(foundEntity).isNull();

        logger.info("사번-부서 관계 삭제 테스트 완료. 삭제된 엔티티: {}", empDepJpaEntity);
    }
}
