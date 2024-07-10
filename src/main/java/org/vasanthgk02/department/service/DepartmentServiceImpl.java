package org.vasanthgk02.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vasanthgk02.department.entity.Department;
import org.vasanthgk02.department.exception.DepartmentNotFoundException;
import org.vasanthgk02.department.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findByDepartmentID(Long id) throws DepartmentNotFoundException {
        Optional<Department> res = departmentRepository.findById(id);
        if(res.isEmpty()) throw new DepartmentNotFoundException("Department Not Found!!");
        return res.get();
    }

    @Override
    public void deleteByDepartmentID(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public void updateDepartmentById(Long departmentID, Department department) {
        Department oldDepartment = departmentRepository.findById(departmentID).get();
        oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        oldDepartment.setDepartmentName(department.getDepartmentName());
        oldDepartment.setDepartmentCode(department.getDepartmentCode());
        departmentRepository.save(oldDepartment);

    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
