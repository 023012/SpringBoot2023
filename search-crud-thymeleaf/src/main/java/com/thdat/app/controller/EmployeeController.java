package com.thdat.app.controller;

import com.thdat.app.model.Employee;
import com.thdat.app.repository.EmployeeRepository;
import com.thdat.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("allEmpList",
                employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/addNew")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id,
                             Model model){

        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmpById(@PathVariable(value = "id") long id){

        employeeService.deleteById(id);
        return "redirect:/";
    }

    //search action

    @RequestMapping(path = {"/search"})
    public String searchByKeyword(Employee employee, Model model, String keyword){
        if(keyword!=null){
            List<Employee> list = employeeRepository.findByKeyword(keyword);
            model.addAttribute("list", list);
        }else{
            List<Employee> list = employeeService.getAllEmployee();
            model.addAttribute("list", list);
        }
        return "index";
    }
}
