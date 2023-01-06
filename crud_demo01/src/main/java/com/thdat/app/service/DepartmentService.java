package com.thdat.app.service;

import com.thdat.app.model.Department;

import java.util.List;

public interface DepartmentService {

    // Save operation
    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    // Update operation
    Department updateDepartment(Department department, Long id);

    // Delete operation
    void deleteDepartmentById(Long id);
}
