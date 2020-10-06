package miniproject.rest;

import miniproject.rest.model.Cart;
import miniproject.rest.model.Item;
import miniproject.rest.model.Status;
import miniproject.rest.repository.TestObjectApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.swing.plaf.basic.BasicTextUI;
import java.io.IOException;
import java.util.*;


public class ClientApplication {
    private static BasicTextUI HttpClientBuilder;
    static final String cartBaseEndpoint = "http://localhost:8080/carts/";
    static final String itemBaseEndpoint = "http://localhost:8080/items/";
    static final RestTemplate restTemplate = new RestTemplate();
    static final Logger LOG = LoggerFactory.getLogger(ClientApplication.class);


    public static void main(String[] args) throws IOException {

        System.out.println("\t\nn////////// [CART] //////////");
        System.out.println(".........................");

        System.out.println("\t\nn------ [Get a list of all carts in the database] ------");
        List<Cart> bla = getAllCarts();
        for (Cart c : bla) { System.out.println(c.toString());}

        System.out.println("\t \n------ [Get a cart by id] ------");
        System.out.println(getCartById(1L));

        System.out.println("\t \n------ [Add cart to database] ------");
        Cart cart = new Cart( "New Cart", Status.IN_PROGRESS);
        cart.setId(6L);
        Cart cart2 = new Cart("NEW CAAAAAAAAAAAAAAAAACart", Status.IN_PROGRESS);
        cart2.setId(7L);
        postCart(cart);
        postCart(cart2);
        System.out.println(getCartById(6));

        System.out.println("\t \n------ [Delete cart from database] ------");
        deleteCart(6L);
        System.out.println(getCartById(6L) + "\t Notice how the status is now CANCELLED instead of IN_PROGRESS");



        System.out.println("\t\nn////////// [ITEM] //////////");
        System.out.println(".........................");

        System.out.println("\t\nn------ [Get a list of all items in the database] ------");
        List<Item> itm = getAllItems();
        for (Item i : itm) {System.out.println(i.toString());}

        System.out.println("\t \n------ [Get an item by id] ------");
        System.out.println(getItemById(4L));

        System.out.println("\t \n------ [Delete an item by id] ------");
        deleteitem(4L);
        System.out.println(getItemById(4L));
    }


    public static List<Cart> getAllCarts() {
        String requestUri = cartBaseEndpoint;
        TestObjectApi entity = restTemplate.getForObject(requestUri,
                TestObjectApi.class);
        return entity.get_embedded().getCarts();
    }

    public static Cart getCartById(long id) {
        String requestUri = cartBaseEndpoint;
        ResponseEntity<Cart> entity = restTemplate.getForEntity(requestUri + id,
                Cart.class);
        return entity.getBody();
    }

    public static void postCart(Cart c) {
        String requestUri = cartBaseEndpoint;
        restTemplate.postForEntity(requestUri, c, Cart.class);
    }

    public static void deleteCart(long id) {
        restTemplate.delete(cartBaseEndpoint + id + "/cancel");
    }

    public static List<Item> getAllItems() {
        String requestUri = itemBaseEndpoint;
        TestObjectApi entity = restTemplate.getForObject(requestUri,
                TestObjectApi.class);
        return entity.get_embedded().getItems();
    }

    public static Item getItemById(long id) {
        String requestUri = itemBaseEndpoint;
        Item entity = restTemplate.getForObject(requestUri + id,
                Item.class);
        return entity;
    }

    public static void postitem(Item c) {
        String requestUri = itemBaseEndpoint;
        restTemplate.postForEntity(requestUri, c, Item.class);
    }

    public static void deleteitem(long id) {
        restTemplate.delete(itemBaseEndpoint + id);
    }

    public static void addedItemToCart(long itemID, long cartID) {
        restTemplate.put(itemBaseEndpoint + itemID + "/cart/" + cartID, null);
    }
}