package org.vasanthgk02.department.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.vasanthgk02.department.entity.Department;
import org.vasanthgk02.department.repository.DepartmentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;
    Department department;

    @BeforeEach
    void setUp() {
         department = Department.builder()
                .departmentAddress("Coimbatore")
                .departmentCode("IT-06")
                .departmentId(1L)
                .departmentName("Information Technology")
                .build();

    }

    @Test
    void findByDepartmentName() {
        String departmentName = "Information Technology";
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Information Technology"))
                .thenReturn(department);
        Department department = departmentService.findByDepartmentName(departmentName);
        assertNotNull(department);
        assertEquals(departmentName, department.getDepartmentName());
    }
}