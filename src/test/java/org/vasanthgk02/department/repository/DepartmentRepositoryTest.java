package org.vasanthgk02.department.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.vasanthgk02.department.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TestEntityManager entityManager;



    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentCode("IT-07").departmentAddress("Coimbatore").departmentName("Information Technology").build();
        entityManager.persist(department);
    }

    public void whenFindByID_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("IT-07", department.getDepartmentCode());
        assertEquals("Coimbatore", department.getDepartmentAddress());
        assertEquals("Information Technology", department.getDepartmentName());

    }
}