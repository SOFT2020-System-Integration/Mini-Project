package miniproject.rest.repository;

import miniproject.rest.model.Cart;

import java.io.Serializable;
import java.util.List;

public class TestObjectApi implements Serializable {
    private long id;

    private embedded _embedded;



    public embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(embedded _embedded) {
        this._embedded = _embedded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
