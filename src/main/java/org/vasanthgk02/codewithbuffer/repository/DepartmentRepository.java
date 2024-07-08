package org.vasanthgk02.codewithbuffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vasanthgk02.codewithbuffer.entity.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String name);
}
