package org.vasanthgk02.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vasanthgk02.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String name);
}
