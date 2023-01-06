// Java Program to Illustrate DepartmentController File

// Importing package module to this code
package com.thdat.app.controller;


// Importing required classes
import com.thdat.app.model.Department;
import com.thdat.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/departments")

// Class
public class DepartmentController {

    // Annotation
    @Autowired private DepartmentService departmentService;

    // Save operation
    @PostMapping("")
    public Department saveDepartment(
            @Validated(Boolean.class) @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long id)
    {
        return departmentService.updateDepartment(
                department, id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long id)
    {
        departmentService.deleteDepartmentById(
                id);
        return "Deleted Successfully";
    }
}
