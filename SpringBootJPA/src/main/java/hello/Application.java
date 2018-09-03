package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // save a couple of employees
            repository.save(new Employee("Jack", 1000));
            repository.save(new Employee("Chloe", 20000));
            repository.save(new Employee("David", 100000));
            repository.save(new Employee("David", 6000));
            repository.save(new Employee("Michelle", 45000));

            // fetch all employees
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Employee employee : repository.findAll()) {
                log.info(employee.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                .ifPresent(employee -> {
                    log.info("Customer found with findById(1L):");
                    log.info("--------------------------------");
                    log.info(employee.toString());
                    log.info("");
                });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("David").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}