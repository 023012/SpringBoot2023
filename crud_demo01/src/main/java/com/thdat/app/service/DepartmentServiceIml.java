package com.thdat.app.service;

import com.thdat.app.model.Department;
import com.thdat.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceIml implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save operation
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    // Read operation
    @Override
    public List<Department> fetchDepartmentList(){
        return (List<Department>)
        departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department updateDepartment(Department department, Long  id){
        Department department01 = departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(
                department.getName())){
            department01.setName(
                    department.getName());
        }

        if(Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(
                department.getAddress())){
            department01.setAddress(
                    department.getAddress());
        }

        if(Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(
                department.getCode())){
            department01.setCode(
                    department.getCode());
        }

        return  departmentRepository.save(department01);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }
}
