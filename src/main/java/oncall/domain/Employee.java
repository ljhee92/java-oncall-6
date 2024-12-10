package oncall.domain;

import oncall.util.ErrorMessage;

import java.util.Objects;

public class Employee {
    private final String name;

    private Employee(final String name) {
        this.name = name;
    }

    public static Employee of(final String name) {
        validateLength(name);
        return new Employee(name);
    }

    private static void validateLength(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
