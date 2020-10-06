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

        List<Cart> bla = getAllCarts();
        for (Cart c : bla)
        {
            System.out.println(c.toString());
        }
        Cart singleCart = getCartById(1L);
        System.out.println(singleCart.toString());
        List<Item> bla2 = getAllItems();
        for (Item i : bla2)
        {
            System.out.println(i.toString());
        }
        Item singleItem = getTtemById(1L);
        System.out.println(singleItem.toString());
        List<Item> bal2 = getAllItems();
        for (Item i : bal2)
        {
            System.out.println(i.toString());
        }
        postCart(new Cart("A nice cart", Status.IN_PROGRESS));

        

        //Item makeItem = new Item("A nice item", "Nice item", singleCart);
        //postitem(makeItem);

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

    public static Item getTtemById(long id) {
        String requestUri = cartBaseEndpoint;
        Item entity = restTemplate.getForObject(requestUri + id,
                Item.class);
        return entity;
    }

    public static void postitem(Item c) {
        String requestUri = itemBaseEndpoint;
        restTemplate.postForEntity(requestUri, c, Item.class);
    }

    public static void deleteitem(long id) {
        restTemplate.delete(cartBaseEndpoint + id);
    }

    public static void addedItemToCart(long itemID, long cartID) {
        restTemplate.put(itemBaseEndpoint + itemID + "/cart/" + cartID, null);
    }
}