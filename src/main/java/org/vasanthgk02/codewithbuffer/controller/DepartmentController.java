package org.vasanthgk02.codewithbuffer.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.vasanthgk02.codewithbuffer.entity.Department;
import org.vasanthgk02.codewithbuffer.exception.DepartmentNotFoundException;
import org.vasanthgk02.codewithbuffer.service.DepartmentService;

import java.util.List;

@RestController()
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Value("${var.welcomeMessage}")
    String welcomeMessage;

    @GetMapping
    public String welcomeMessage(){
        return welcomeMessage;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Saving department {}", department);
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment() {
        LOGGER.info("Getting all departments");
        return departmentService.findAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department findByDepartmentID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        LOGGER.info("Getting department {}", departmentID);
        return departmentService.findByDepartmentID(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentID) {
        LOGGER.info("Deleting department {}", departmentID);
        departmentService.deleteByDepartmentID(departmentID);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@PathVariable("id") Long departmentID, @Valid @RequestBody Department department) {
        LOGGER.info("Updating department {}", department);
        departmentService.updateDepartmentById(departmentID, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findByDepartmentName(@PathVariable("name") String departmentName) {
        LOGGER.info("Getting department {}", departmentName);
        return departmentService.findByDepartmentName(departmentName);
    }

}
