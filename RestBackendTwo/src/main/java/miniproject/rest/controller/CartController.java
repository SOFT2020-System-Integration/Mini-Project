package miniproject.rest.controller;

import miniproject.rest.exceptions.CartNotFoundException;
import miniproject.rest.model.Cart;
import miniproject.rest.model.CartModelAssembler;
import miniproject.rest.model.Status;
import miniproject.rest.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/carts")
public class CartController {
    private final CartRepository repo;
    private final CartModelAssembler assembler;

    @Autowired
    CartController(CartRepository repo, CartModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Cart>> getAllCarts() {
        List<EntityModel<Cart>> carts = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(carts, //
                linkTo(methodOn(CartController.class).getAllCarts()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Cart> getCartsById(@PathVariable Long id) {
        Cart cart = repo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        return assembler.toModel(cart);
    }

    @PostMapping("")
    public ResponseEntity<EntityModel<Cart>> createNewCart(@RequestBody Cart cart) {
        cart.setStatus(Status.IN_PROGRESS);
        Cart newCart = repo.save(cart);

        return ResponseEntity
                .created(linkTo(methodOn(CartController.class).getCartsById(newCart.getId())).toUri())
                .body(assembler.toModel(newCart));
    }

    @DeleteMapping("/{id}/cancel")
    public ResponseEntity<?> cancelCart(@PathVariable Long id) {
        Cart cart = repo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

        if(cart.getStatus() == Status.IN_PROGRESS) {
            cart.setStatus(Status.CANCELLED);
            return ResponseEntity.ok(assembler.toModel(repo.save(cart)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                .withTitle("Method not allowed!")
                .withDetail("You can't cancel an order with status " + cart.getStatus()));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<?> completeCart(@PathVariable Long id) {
        Cart cart = repo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

        if(cart.getStatus() == Status.IN_PROGRESS) {
            cart.setStatus(Status.COMPLETED);
            return ResponseEntity.ok(assembler.toModel(repo.save(cart)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                        .withTitle("Method not allowed!")
                        .withDetail("You can't complete an order with status " + cart.getStatus()));
    }
}
