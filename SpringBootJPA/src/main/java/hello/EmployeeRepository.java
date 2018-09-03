package hello;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findByName(String name);

    public Optional<Employee> findById(Long id);

    public Long findSalaryById(Long id);
}
