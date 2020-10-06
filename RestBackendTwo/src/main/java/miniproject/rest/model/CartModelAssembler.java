package miniproject.rest.model;

import miniproject.rest.controller.CartController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CartModelAssembler implements RepresentationModelAssembler<Cart, EntityModel<Cart>> {
    @Override
    public EntityModel<Cart> toModel(Cart cart) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Cart> orderModel = EntityModel.of(cart,
                linkTo(methodOn(CartController.class).getCartsById(cart.getId())).withSelfRel(),
                linkTo(methodOn(CartController.class).getAllCarts()).withRel("carts"));

        if(cart.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(CartController.class).cancelCart(cart.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(CartController.class).completeCart(cart.getId())).withRel("complete"));
        }

        return orderModel;
    }
}
