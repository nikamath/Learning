package hello;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable Long id) {
        Optional<Employee> findById = employeeRepository.findById(id);
        if (!findById.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findById.get());
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee emp) {
        Employee save = employeeRepository.save(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(save.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
        Optional<Employee> findById = employeeRepository.findById(id);
        if (!findById.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        emp.setId(id);
        employeeRepository.save(emp);
        return ResponseEntity.noContent().build();
    }

}
