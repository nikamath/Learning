package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByName(String name);

    public Long findSalaryById(Long id);
}
