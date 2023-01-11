package com.thdat.app.repository;

import com.thdat.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Custom query
    @Query(value = "select * from employee e where e.name like '%:keyword%' or e.email '%:keyword%'", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}
