package org.vasanthgk02.department.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.vasanthgk02.department.entity.Department;
import org.vasanthgk02.department.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    Department department;

    @BeforeEach
    void setUp() {
        department =  Department.builder()
                .departmentName("Information Technology")
                .departmentAddress("Coimbatore")
                .departmentCode("IT-08")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment =  Department.builder()
                .departmentName("Information Technology")
                .departmentAddress("Coimbatore")
                .departmentCode("IT-08")
                .departmentId(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"departmentId\": 1,\n" +
                                "  \"departmentName\": \"Information Technology\",\n" +
                                "  \"departmentCode\": \"IT-08\",\n" +
                                "  \"departmentAddress\": \"Coimbatore\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findByDepartmentName() throws Exception {
        Mockito.when(departmentService.findByDepartmentName("Information Technology"))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/name/Information Technology")).andExpect(MockMvcResultMatchers.status().isOk());

    }
}