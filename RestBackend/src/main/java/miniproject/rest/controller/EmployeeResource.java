package miniproject.rest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import miniproject.rest.exceptions.EmployeeNotFoundException;
import miniproject.rest.model.Employee;
import miniproject.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees()
    {
        return repo.findAll();
    }


    // This is the only method, which returns hyperlinks, for now
    // If the resource is found, a link to its 'family' is appended to its native load
    @GetMapping("/employees/{id}")
    public EntityModel<Employee> retrieveEmployee(@PathVariable long id)
    {
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new EmployeeNotFoundException("id: " + id);

        EntityModel<Employee> resource = EntityModel.of(employee.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllEmployees());    // get link
        resource.add(linkTo.withRel("all-students"));										    // append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveEmployee(id)).withSelfRel();   //add also link to self
        resource.add(selfLink);
        return resource;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {

        repo.deleteById(id);
        return "Deleted Employee with id: " + id;
    }

    // Create a new resource and remember its unique location in the hypermedia
    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee)
    {
        Employee savedStudent = repo.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id)
    {
        Optional<Employee> studentOptional = repo.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        employee.setId(id);
        repo.save(employee);
        return ResponseEntity.noContent().build();
    }
}
