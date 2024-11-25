package vn.iostar.SpringSer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.SpringSer.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}