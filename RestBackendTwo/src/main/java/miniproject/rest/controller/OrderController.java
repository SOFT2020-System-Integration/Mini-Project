package miniproject.rest.controller;

import miniproject.rest.exceptions.order.OrderNotFoundException;
import miniproject.rest.model.order.Order;
import miniproject.rest.model.order.OrderModelAssembler;
import miniproject.rest.model.order.Status;
import miniproject.rest.repository.OrderRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderRepository repo;
    private final OrderModelAssembler assembler;

    OrderController(OrderRepository repo, OrderModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @GetMapping("/orders")
    public CollectionModel<EntityModel<Order>> getAllOrders() {
        List<EntityModel<Order>> orders = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(orders, //
                linkTo(methodOn(OrderController.class).getAllOrders()).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    public EntityModel<Order> getOrderById(@PathVariable Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    public ResponseEntity<EntityModel<Order>> createNewOrder(@RequestBody Order order) {
        order.setStatus(Status.IN_PROGRESS);
        Order newOrder = repo.save(order);

        return ResponseEntity
                .created(linkTo(methodOn(OrderController.class).getOrderById(newOrder.getId())).toUri())
                .body(assembler.toModel(newOrder));
    }

    @DeleteMapping("/orders/{id}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if(order.getStatus() == Status.IN_PROGRESS) {
            order.setStatus(Status.CANCELLED);
            return ResponseEntity.ok(assembler.toModel(repo.save(order)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                .withTitle("Method not allowed!")
                .withDetail("You can't cancel an order with status " + order.getStatus()));
    }

    @PutMapping("/orders/{id}/complete")
    public ResponseEntity<?> completeOrder(@PathVariable Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if(order.getStatus() == Status.IN_PROGRESS) {
            order.setStatus(Status.COMPLETED);
            return ResponseEntity.ok(assembler.toModel(repo.save(order)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                        .withTitle("Method not allowed!")
                        .withDetail("You can't complete an order with status " + order.getStatus()));
    }
}
