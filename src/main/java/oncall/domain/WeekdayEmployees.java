package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WeekdayEmployees extends Employees {
    private WeekdayEmployees(List<Employee> employees) {
        super(employees);
    }

    public static WeekdayEmployees of(List<String> employeesStr) {
        List<Employee> employees = new ArrayList<>();
        for (String employeeStr : employeesStr) {
            Employee employee = Employee.of(employeeStr);
            employees.add(employee);
        }
        return new WeekdayEmployees(employees);
    }
}
