package vn.iostar.SpringSer.services;

import java.util.List;
import vn.iostar.SpringSer.Entity.Product;

public interface ProductServices {
    void delete(Long id);

    Product get(Long id);

    Product save(Product product);

    List<Product> listAll();
}
