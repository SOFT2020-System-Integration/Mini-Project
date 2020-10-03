package miniproject.rest.controller;


import miniproject.rest.model.employee.EmployeeModelAssembler;
import miniproject.rest.exceptions.employee.EmployeeNotFoundException;
import miniproject.rest.model.employee.Employee;
import miniproject.rest.repository.EmployeeRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository repo;
    private final EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository repo, EmployeeModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    //Root
    @GetMapping("/employees")
    public CollectionModel<EntityModel<Employee>> getAllEmployees() {
        List<EntityModel<Employee>> emp = repo.findAll().stream()
                .map(assembler :: toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(emp, linkTo(methodOn(EmployeeController.class).getAllEmployees()).withSelfRel());

        /*List<EntityModel<Employee>> employees = repo.findAll().stream()
                .map(employee -> EntityModel.of(employee,
                        linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getId())).withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees")))
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).getAllEmployees()).withSelfRel());*/
    }

    //Get Employee by id
    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployeeById(@PathVariable Long id) {

        Employee emp = repo.findById(id) //
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toModel(emp);

        /*return EntityModel.of(emp, //
                linkTo(methodOn(EmployeeController.class).getEmployeeById(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees"));*/
    }

    //Post Employee
    @PostMapping("/employees")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee newEmployee) {
        EntityModel<Employee> entityModel = assembler.toModel(repo.save(newEmployee));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    //Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
        Employee updatedEmp =  repo.findById(id)
                .map(employee -> {
                   employee.setFirstName(emp.getFirstName());
                   employee.setLastName(emp.getLastName());
                   employee.setEmail(emp.getEmail());
                   employee.setRole(emp.getRole());
                   return repo.save(emp);
                })
                .orElseGet(() -> {
                    emp.setId(id);
                    return repo.save(emp);
                });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmp);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    //Delete Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
