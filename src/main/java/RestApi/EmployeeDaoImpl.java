package RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl  implements  EmployeeDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
       return jdbcTemplate.update("INSERT INTO EMPL1(empcode,ename,empage,esalary)values(?,?,?,?)",new Object[]{employee.getEmpcode(),employee.getEname(),employee.getEmpage(),employee.getEsalary()});

    }

    @Override
    public int delete(int empcode) {
        return  jdbcTemplate.update("DELETE FROM EMPL1 WHERE empcode=?",empcode);


    }

    @Override
    public int update(Employee employee,int empcode) {
       return jdbcTemplate.update("UPDATE EMPL1 SET empcode=? ,ename=?,empage=?,esalary=? WHERE empcode=?",new Object[]{employee.getEmpcode(),employee.getEname(),employee.getEmpage(),employee.getEsalary(),empcode});
    }
}
