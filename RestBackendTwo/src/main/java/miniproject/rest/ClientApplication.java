package miniproject.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import miniproject.rest.model.Cart;
import miniproject.rest.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.swing.plaf.basic.BasicTextUI;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.*;

public class ClientApplication {
    private static BasicTextUI HttpClientBuilder;
    static final String cartBaseEndpoint = "http://localhost:8080/carts/";
    static final RestTemplate restTemplate = new RestTemplate();
    static final Logger LOG = LoggerFactory.getLogger(ClientApplication.class);



    public static void main(String[] args) throws IOException {

        // JSON values
        Map<String, String> params = new HashMap<String, String>();
        // HTTP request object
        HttpRequest request = null;
        // HTTP response onject
        HttpResponse response = null;
        String result;

//        System.out.println(getForEntity(1));
//        System.out.println(getAsJsonNode());
        System.out.println(getAll());

        asdasd();
    }

    public static void asdasd() {
    }


    public static JsonNode getAsJsonNode() throws IOException {
        String jsonString = restTemplate.getForObject(cartBaseEndpoint,
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(jsonString);
    }


        public static List<Cart> getAll() {
        String requestUri = cartBaseEndpoint;
        Map<String, String> urlParameters = new HashMap<>();
        ResponseEntity<Cart[]> entity = restTemplate.getForEntity(requestUri,
                Cart[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :
                Collections.emptyList();
    }


        public static ResponseEntity<Cart> getForEntity(long id) {
        ResponseEntity<Cart> entity = restTemplate.getForEntity(cartBaseEndpoint + "/{id}",
                Cart.class,
                Long.toString(id));
        LOG.info("Status code value: " + entity.getStatusCodeValue());
        LOG.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());
        return entity;
    }
}
