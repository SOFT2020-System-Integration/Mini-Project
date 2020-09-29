package rest.client.app;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.app.models.Employee;

import javax.swing.plaf.basic.BasicTextUI;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static BasicTextUI HttpClientBuilder;
    static final String employeeBaseEndpoint = "http://localhost:8080/api/employees";
    static final String employeeIdEndpoint = "http://localhost:8080/api/employees/{id}";
    static final RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {

        // JSON values
        Map<String, String> params = new HashMap<String, String>();
        // HTTP request object
        HttpRequest request = null;
        // HTTP response onject
        HttpResponse response = null;
        String result;

        System.out.println("\n========= [GET BY ID] =========\n");
        System.out.println(getEmployeeById(101));

        //Get a list of all Employees
        System.out.println("\n========= [GET ALL] =========\n");
        for (Employee emp : getAllEmployees())
        {
            System.out.println(emp);
        }

        //Add a new employee to the database
        System.out.println("\n========= [ADD NEW] =========\n");
        Employee newEmp = addNewEmployee(new Employee(null, "New User", "User", "nuu@mail.com"), params);
        System.out.println("Added " + newEmp + " to the database...");

        //Update employee in the database
        System.out.println("\n========= [UPDATE EMPLOYEE] =========\n");
        Employee updatedEmployee = new Employee(null,"Magnum", "Opus", "mo@mail.com");
        System.out.println(updateEmployee(104, updatedEmployee, params));

        //Delete employee from the database
        System.out.println("\n========= [DELETE EMPLOYEE] =========\n");
        String res = deleteEmployeeById(104);
        System.out.println(res);


    }

    public static Employee getEmployeeById(long id) {
        ResponseEntity<Employee> emp = restTemplate.getForEntity(employeeIdEndpoint, Employee.class, id);
        return emp.getBody();
    }

    public static Employee[] getAllEmployees() {
        return restTemplate.getForObject(employeeBaseEndpoint, Employee[].class);
    }

    public static Employee addNewEmployee(Employee employee, Map params) {
        ResponseEntity<Employee> emp = restTemplate.postForEntity(employeeBaseEndpoint, employee, String.class, params);
        return employee;
    }

    public static Employee updateEmployee(long id, Employee updatedEmployee, Map params) {
        Employee employeeToUpdate = getEmployeeById(id);
        updatedEmployee.setId(employeeToUpdate.getId());
        params.put("id", employeeToUpdate.getId());
        restTemplate.put(employeeIdEndpoint, updatedEmployee, params);
        return updatedEmployee;
    }

    public static String deleteEmployeeById(long id) {
        restTemplate.delete(employeeIdEndpoint, id);
        return "Deleted user with ID: " + id;
    }
}