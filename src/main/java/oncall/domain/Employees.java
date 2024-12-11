package oncall.domain;

import oncall.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class Employees {
    protected List<Employee> employees;

    protected Employees(List<Employee> employee) {
        validate(employee);
        this.employees = new ArrayList<>(employee);
    }

    private void validate(List<Employee> employees) {
        validateNumberOfEmployees(employees);
        validateDuplicate(employees);
    }

    private void validateNumberOfEmployees(List<Employee> employees) {
        if (employees.size() < 5 || employees.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicate(List<Employee> employees) {
        if (employees.stream().distinct().count() != employees.size()) { // 중복 제거 후 개수 카운트
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
