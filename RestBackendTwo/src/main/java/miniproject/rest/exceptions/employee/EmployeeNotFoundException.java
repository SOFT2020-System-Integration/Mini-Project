package miniproject.rest.exceptions.employee;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee with id: " + id);
    }
}
