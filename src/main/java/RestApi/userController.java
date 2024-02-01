package RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class userController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllCustomer() {
        List<Employee> employee = jdbcTemplate.query("SELECT * FROM EMPL1", new BeanPropertyRowMapper<>((Employee.class)));

        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Employee employee) {
        String insertQuery=String.format("INSERT INTO Empl1(%s,%s,%s,%s)VALUES(?,?,?,?)",employee.getEmpcode(),employee.getEname(),employee.getEmpage(),employee.getEsalary());
        jdbcTemplate.update(insertQuery);

       //jdbcTemplate.update("Insert into Empl1(empcode,ename,empage,esalary)values(?,?,?,?)",employee.getEmpcode(),employee.getEname(),employee.getEmpage(),employee.getEsalary());
        return new ResponseEntity<>("inserted successfully", HttpStatus.CREATED);

    }
}