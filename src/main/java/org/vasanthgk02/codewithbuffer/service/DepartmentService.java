package org.vasanthgk02.codewithbuffer.service;

import org.vasanthgk02.codewithbuffer.entity.Department;
import org.vasanthgk02.codewithbuffer.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> findAllDepartments();

    Department findByDepartmentID(Long id) throws DepartmentNotFoundException;

    void deleteByDepartmentID(Long departmentID);

    void updateDepartmentById(Long departmentID, Department department);

    Department findByDepartmentName(String departmentName);
}
