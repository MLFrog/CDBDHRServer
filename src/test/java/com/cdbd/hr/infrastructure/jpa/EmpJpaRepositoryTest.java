package com.cdbd.hr.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.hr.infrastructure.jpa.entity.EmpJpaEntity;
import com.cdbd.hr.infrastructure.jpa.repository.EmpJpaRepository;

public class EmpJpaRepositoryTest extends JpaRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(EmpJpaRepositoryTest.class);

    @Autowired
    private EmpJpaRepository empJpaRepository;

    private EmpJpaEntity empJpaEntity;

    @BeforeEach
    public void setUp() {
        // given: EmpJpaEntity 객체를 준비
        empJpaEntity = new EmpJpaEntity();
        empJpaEntity.setEmpId("E001");
        empJpaEntity.setName("김철수");
        empJpaEntity.setSsn("970101-1234567");
        empJpaEntity.setNationality("대한민국");
        empJpaEntity.setGender("남성");
        empJpaEntity.setPhoneNumber("010-1234-5678");
        empJpaEntity.setAddress("성남시 분당구");
        empJpaEntity.setJoinDate("20230101");
        empJpaEntity.setResignationDate(null);
        empJpaEntity.setPosition("사원");
        empJpaEntity.setJobTitle("개발자");
        empJpaEntity.setEmpType("정규직");
        empJpaEntity.setWorkLoc("서울 본사");
        empJpaEntity.setSalary(50000000);
        empJpaEntity.setBank("우리은행");
        empJpaEntity.setBankAccount("1002-123-456789");
        empJpaEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        empJpaEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 완료: {}", empJpaEntity);
    }

    @Test
    public void 사원생성하기() {
        // given: Entity가 준비되었음

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        EmpJpaEntity savedEntity = empJpaRepository.save(empJpaEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getEmpId()).isEqualTo("E001");
        assertThat(savedEntity.getName()).isEqualTo("김철수");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("사원 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 사원조회하기() {
        // given: Entity를 저장
        empJpaRepository.save(empJpaEntity);

        // when: 특정 empId로 엔티티를 조회
        Optional<EmpJpaEntity> foundEntity = empJpaRepository.findByEmpId("E001");

        // then: 조회된 엔티티의 값이 맞는지 확인
        EmpJpaEntity entity = foundEntity.orElseThrow(() -> new AssertionError("조회된 사원이 존재하지 않습니다."));
        assertThat(entity.getEmpId()).isEqualTo("E001");
        assertThat(entity.getName()).isEqualTo("김철수");

        logger.info("사원 조회 테스트 완료: {}", entity);
    }


    @Test
    public void 사원삭제하기() {
        // given: Entity 저장
        empJpaRepository.save(empJpaEntity);

        // when: 엔티티 삭제
        empJpaRepository.deleteByEmpId("E001");

        // then: 삭제 후 조회하여 null 반환되는지 확인
        Optional<EmpJpaEntity> foundEntity = empJpaRepository.findByEmpId("E001");

        assertThat(foundEntity).isNull();
        logger.info("사원 삭제 테스트 완료. 삭제된 사번: E001");
    }
}
