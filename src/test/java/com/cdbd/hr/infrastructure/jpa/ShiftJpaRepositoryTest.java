package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.ShiftJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.ShiftJpaRepository;

public class ShiftJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ShiftJpaRepositoryTest.class);

    @Autowired
    private ShiftJpaRepository shiftJpaRepository;

    private ShiftJpaEntity shiftJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: ShiftJpaEntity 객체를 준비
        shiftJpaEntity = new ShiftJpaEntity();
        shiftJpaEntity.setShiftId("S001");
        shiftJpaEntity.setShiftName("사무직");
        shiftJpaEntity.setBaseDay("월요일");
        shiftJpaEntity.setUseYn("Y");
        shiftJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        shiftJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("Shift 객체 생성 완료: {}", shiftJpaEntity);
    }

    @Test
    public void 근무조생성하기() {
        // given: Entity가 준비됨

        // when: 데이터를 저장
        ShiftJpaEntity savedEntity = shiftJpaRepository.save(shiftJpaEntity);

        // then: 저장된 값 검증
        assertThat(savedEntity.getShiftId()).isEqualTo("S001");
        assertThat(savedEntity.getShiftName()).isEqualTo("사무직");
        assertThat(savedEntity.getBaseDay()).isEqualTo("월요일");
        assertThat(savedEntity.getUseYn()).isEqualTo("Y");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("근무조 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 근무조조회하기() {
        // given: Entity를 저장
        shiftJpaRepository.save(shiftJpaEntity);

        // when: ID를 기준으로 데이터 조회
        ShiftJpaEntity foundEntity = shiftJpaRepository.findById("S001").orElse(null);

        // then: 조회된 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getShiftId()).isEqualTo("S001");
        assertThat(foundEntity.getShiftName()).isEqualTo("사무직");
        assertThat(foundEntity.getBaseDay()).isEqualTo("월요일");
        assertThat(foundEntity.getUseYn()).isEqualTo("Y");

        logger.info("근무조 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 근무조삭제하기() {
        // given: Entity 저장
        shiftJpaRepository.save(shiftJpaEntity);

        // when: 데이터 삭제
        shiftJpaRepository.deleteById("S001");

        // then: 삭제 확인
        ShiftJpaEntity foundEntity = shiftJpaRepository.findById("S001").orElse(null);
        assertThat(foundEntity).isNull();

        logger.info("근무조 삭제 테스트 완료. 삭제된 근무조 ID: S001");
    }
}
