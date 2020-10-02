package miniproject.rest.exceptions.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee with id: " + id);
    }
}
