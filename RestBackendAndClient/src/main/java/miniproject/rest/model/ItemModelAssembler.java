package miniproject.rest.model;

import miniproject.rest.controller.ItemController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ItemModelAssembler implements RepresentationModelAssembler<Item, EntityModel<Item>> {
    @Override
    public EntityModel<Item> toModel(Item item) {

        EntityModel<Item> itemModel = EntityModel.of(item,
                linkTo(methodOn(ItemController.class).getItemById(item.getId())).withSelfRel(),
                linkTo(methodOn(ItemController.class).getAllItems()).withRel("items"));
        return itemModel;
    }
}
