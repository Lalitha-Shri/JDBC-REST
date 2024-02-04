package RestApi;

public interface EmployeeDao  {
    int save(Employee employee);
    int delete(int empcode);
    int update(Employee employee,int empcode);
}
