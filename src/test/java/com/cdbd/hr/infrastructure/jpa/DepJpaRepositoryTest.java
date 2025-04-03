package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

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
        depJpaEntity.setStaYmd("20240101"); 
        depJpaEntity.setEndYmd("99991231"); 
        depJpaEntity.setCreatedAt(LocalDateTime.now());  
        depJpaEntity.setUpdatedAt(LocalDateTime.now()); 

        depJpaRepository.save(depJpaEntity); // 사전 저장
        logger.info("객체생성 및 저장 완료: {}", depJpaEntity);
    }

    @Test
    public void 부서생성하기() {
        // when: 엔티티를 저장하고 반환된 객체 확인
        Optional<DepJpaEntity> savedEntityOpt = depJpaRepository.findByDepCode("D001");
        DepJpaEntity savedEntity = savedEntityOpt.orElseThrow(() -> new AssertionError("저장된 부서가 없습니다."));

        // then: 저장된 엔티티의 필드 값 검증
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
    public void 부서ID로조회하기() {
        // when: 특정 depCode로 엔티티를 조회
        Optional<DepJpaEntity> foundEntity = depJpaRepository.findByDepCode("D001");

        // then: 조회된 엔티티 검증
        DepJpaEntity entity = foundEntity.orElseThrow(() -> new AssertionError("조회된 부서가 존재하지 않습니다."));
        assertThat(entity.getDepCode()).isEqualTo("D001");
        assertThat(entity.getDepName()).isEqualTo("영업부");
        assertThat(entity.getPDepCode()).isEqualTo("PD001");

        logger.info("부서 조회 테스트 완료: {}", entity);
    }

    @Test
    public void 부서삭제하기() {
        // when: 엔티티 삭제
        depJpaRepository.deleteByDepCode("D001");

        // then: 삭제 후 존재 여부 확인
        Optional<DepJpaEntity> foundEntity = depJpaRepository.findByDepCode("D001");

        assertThat(foundEntity.isPresent()).isFalse(); // 수정됨
        logger.info("부서 삭제 테스트 완료. 삭제된 부서: D001");
    }
}
