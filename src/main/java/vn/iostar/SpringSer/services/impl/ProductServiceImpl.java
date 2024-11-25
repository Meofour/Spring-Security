package vn.iostar.SpringSer.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iostar.SpringSer.Entity.Product;
import vn.iostar.SpringSer.Repository.ProductRepository;
import vn.iostar.SpringSer.services.ProductServices;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {

    private final ProductRepository repo;

    @Autowired
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).orElse(null); // Return null if not found
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
