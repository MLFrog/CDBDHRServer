package com.cdbd.hr.domain.dep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cdbd.hr.domain.dep.IDTypes.DepCode;
import com.cdbd.hr.domain.dep.repository.impl.DepDomainRepository;

class DepartmentUnitTest {

    @Mock
    private DepDomainRepository repository;

    @InjectMocks
    private Department department;

    private DepCode depCode;
    private Department sampleDepartment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        depCode = new DepCode("D001");
        sampleDepartment = new Department();
        sampleDepartment.setDepCode(depCode);
        sampleDepartment.setDepName("IT부서");
        sampleDepartment.setPDepCode("D000");
        sampleDepartment.setCDepCode("D002");
        sampleDepartment.setTDepYn("N");
        sampleDepartment.setStaYmd("20240101");
        sampleDepartment.setEndYmd("99991231");
        sampleDepartment.setCreatedAt(Instant.now());
        sampleDepartment.setUpdatedAt(Instant.now());
    }

    @Test
    void 부서_저장_테스트() {
        department.save(repository);
        verify(repository, times(1)).save(department);
    }

    @Test
    void 부서_삭제_테스트() {
        department.setDepCode(depCode);
        department.delete(repository);
        verify(repository, times(1)).delete(depCode);
    }

    @Test
    void 전체_부서_조회_테스트() {
        when(repository.getAllDepartment()).thenReturn(Arrays.asList(sampleDepartment));
        List<Department> result = department.getDepartmentList(repository);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("IT부서", result.get(0).getDepName());

    }

    @Test
    void 부서가_없는_경우_테스트() {
        when(repository.getAllDepartment()).thenReturn(Collections.emptyList());
        List<Department> result = department.getDepartmentList(repository);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void 부서코드로_조회_테스트() {
        when(repository.findByDepCodeIgnoreCase(depCode)).thenReturn(sampleDepartment);
        department.setDepCode(depCode);
        Department result = department.findByDepCode(repository);
        assertNotNull(result);
        assertEquals("IT부서", result.getDepName());
        assertEquals(depCode, result.getDepCode());
    }
    
    @Test
    void 대소문자가_다른_부서코드로_조회_테스트() {
        when(repository.findByDepCodeIgnoreCase(new DepCode("d001"))).thenReturn(sampleDepartment);
        when(repository.findByDepCodeIgnoreCase(new DepCode("D001"))).thenReturn(sampleDepartment);
        
        department.setDepCode(new DepCode("d001"));
        Department result1 = department.findByDepCode(repository);
        assertNotNull(result1);
        assertEquals(depCode, result1.getDepCode());

        department.setDepCode(new DepCode("D001"));
        Department result2 = department.findByDepCode(repository);
        assertNotNull(result2);
        assertEquals(depCode, result2.getDepCode());
    }

    @Test
    void 존재하지_않는_부서코드로_조회_테스트() {
        when(repository.findByDepCodeIgnoreCase(depCode)).thenReturn(null);
        department.setDepCode(depCode);
        assertThrows(NullPointerException.class, () -> department.findByDepCode(repository));
    }

    @Test
    void 특수문자_공백이_포함된_부서코드_조회_테스트() {
        when(repository.findByDepCodeIgnoreCase(any(DepCode.class))).thenReturn(sampleDepartment);
        
        department.setDepCode(new DepCode(" D001"));
        Department result1 = department.findByDepCode(repository);
        assertNotNull(result1);
        assertEquals(depCode, result1.getDepCode());

        department.setDepCode(new DepCode("D001 "));
        Department result2 = department.findByDepCode(repository);
        assertNotNull(result2);
        assertEquals(depCode, result2.getDepCode());

        department.setDepCode(new DepCode(" D0 01"));
        Department result3 = department.findByDepCode(repository);
        assertNotNull(result3);
        assertEquals(depCode, result3.getDepCode());
    }
    
    @Test
    void 부서명_수정_테스트() {
        when(repository.findByDepCodeIgnoreCase(depCode)).thenReturn(sampleDepartment);

        department.setDepCode(depCode);
        department.setDepName("개발부서");
        department.save(repository); 

        verify(repository, times(1)).save(department); 
        assertEquals("개발부서", department.getDepName()); 
    }

}