package oncall.domain;

import oncall.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class HolidayEmployees extends Employees {
    private HolidayEmployees(List<Employee> employees) {
        super(employees);
    }

    public static HolidayEmployees of(List<String> employeesStr, Employees weekdayEmployees) {
        List<Employee> employees = new ArrayList<>();
        for (String employeeStr : employeesStr) {
            Employee employee = Employee.of(employeeStr);
            employees.add(employee);
        }
        validateWithWeekday(weekdayEmployees, employees);
        return new HolidayEmployees(employees);
    }

    private static void validateWithWeekday(Employees weekdayEmployees, List<Employee> employees) {
        if (weekdayEmployees.getEmployees().size() != employees.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }
}
