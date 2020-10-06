package rest.client.app;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.app.models.Cart;
import rest.client.app.models.Item;

import javax.swing.plaf.basic.BasicTextUI;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static BasicTextUI HttpClientBuilder;
    RestTemplate restTemplate = new RestTemplate();
    final String baseUrl = "http://localhost:"+8080+"/items/";
    URI uri = new URI(baseUrl);


    public static void main(String[] args) {
        // JSON values
        Map<String, String> params = new HashMap<String, String>();

        // HTTP request object
        HttpRequest request = null;
        // HTTP response onject
        HttpResponse response = null;
        String result;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<Cart> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);



    }
}