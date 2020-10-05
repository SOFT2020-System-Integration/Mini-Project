package miniproject.rest.controller;

import miniproject.rest.exceptions.cart.CartNotFoundException;
import miniproject.rest.exceptions.cart.ItemNotFoundException;
import miniproject.rest.model.order.Cart;
import miniproject.rest.model.order.Item;
import miniproject.rest.model.order.ItemModelAssembler;
import miniproject.rest.repository.CartRepository;
import miniproject.rest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/items")
public class ItemController {
    private final ItemRepository repo;
    private final CartRepository cartRepo;
    private final ItemModelAssembler assembler;


    @Autowired
    public ItemController(ItemRepository repo, CartRepository cartRepo, ItemModelAssembler assembler) {
        this.repo = repo;
        this.cartRepo = cartRepo;
        this.assembler = assembler;
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Item>> getAllItems() {
        List<EntityModel<Item>> items = repo.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(items, //
                linkTo(methodOn(ItemController.class).getAllItems()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Item> getItemById(@PathVariable Long id) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item with id: " + id + " not found..."));
        return assembler.toModel(item);
    }

    /*@PostMapping("")
    public ResponseEntity<EntityModel<Item>> createNewItem(@RequestBody Item item) {
        Item newItem = item;
        repo.save(newItem);
        return ResponseEntity
                .created(linkTo(methodOn(ItemController.class).getItemById(newItem.getId())).toUri())
                .body(assembler.toModel(newItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Item>> updateItem(@RequestBody Item i, @PathVariable Long id) {
        Item updatedItem =  repo.findById(id)
                .map(item -> {
                    item.setDescription(i.getDescription());
                    item.setName(i.getName());
                    return repo.save(i);
                })
                .orElseGet(() -> {
                    i.setId(id);
                    return repo.save(i);
                });

        EntityModel<Item> entityModel = assembler.toModel(updatedItem);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/{itemId}/cart/{cartId}")
    public ResponseEntity<?> updateWhichCartAnItemIsPlacedIn(@PathVariable("itemId") Long itemId, @PathVariable("cartId") Long cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        Item updatedItemCart = repo.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        updatedItemCart.setCart(cart);

        EntityModel<Item> entityModel = assembler.toModel(updatedItemCart);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
*/
}
