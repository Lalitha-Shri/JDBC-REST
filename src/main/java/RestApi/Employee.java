package RestApi;

import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
public class Employee {
    private int empcode;
    private String ename;



    public Employee() {
        super();
    }

    private int empage;
    private int esalary;


    public Employee(int empcode, String ename, int empage, int esalary) {
        this.empcode = empcode;
        this.ename = ename;
        this.empage = empage;
        this.esalary = esalary;
    }


    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEmpage() {
        return empage;
    }

    public void setEmpage(int empage) {
        this.empage = empage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empcode=" + empcode +
                ", ename='" + ename + '\'' +
                ", empage=" + empage +
                ", esalary=" + esalary +
                '}';
    }

    public int getEsalary() {
        return esalary;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }
}
