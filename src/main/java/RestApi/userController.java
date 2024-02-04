package RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class userController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private  EmployeeDao e;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllCustomer() {
        List<Employee> employee = jdbcTemplate.query("SELECT * FROM EMPL1", new BeanPropertyRowMapper<>((Employee.class)));

        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
       e.save(new Employee(employee.getEmpcode(),employee.getEname(),employee.getEmpage(),employee.getEsalary()));
        return new ResponseEntity<>("Employee was created successfully.", HttpStatus.CREATED);

    }
    @DeleteMapping("/employee/{empcode}")
        public String delete(@PathVariable int empcode)
        {
        return e.delete(empcode)+"Employee deleted sucessfully";
    }
    @PutMapping("/update/{empcode}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable int empcode){
        return  e.update(employee,empcode)+"Employee updated";
    }

}