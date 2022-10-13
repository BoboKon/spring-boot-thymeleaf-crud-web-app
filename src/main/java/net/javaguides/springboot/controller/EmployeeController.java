package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Workplace;
import net.javaguides.springboot.service.EmployeeService;
import net.javaguides.springboot.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WorkplaceService workplaceService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    @GetMapping("/showNewWorkplaceForm")
    public String showNewWorkplaceForm(Model model) {
        Workplace workplace = new Workplace();
        model.addAttribute("workplace", workplace);
        return "new_workplace";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeFor(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("workplaces",workplaceService.getAllWorkplaces());
        return "new_employee";
    }
    @PostMapping("/saveWorkplace")

    public String saveWorkplace(@ModelAttribute("workplace") Workplace workplace) {
        workplaceService.saveWorkplace(workplace);
        return "redirect:/";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model ) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("workplaces",workplaceService.getAllWorkplaces());
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
