package ro.zenitech.probono.serviciisociale.socialcase.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.getOne(id);
    }

    @PostMapping
    public Employee create(@RequestBody final Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeRepository.getOne(id);
        BeanUtils.copyProperties(employee, existingEmployee, "id");
        return employeeRepository.saveAndFlush(existingEmployee);
    }

    @GetMapping
    @RequestMapping("/new/")
    public Employee getEmployeeWithParam(@RequestParam(name = "idEmployee") long id){
        return employeeRepository.getOne(id);
    }
    
}
