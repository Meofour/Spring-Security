package vn.iostar.SpringSer.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.iostar.SpringSer.Customer;

@RestController
public class CustomerController {

    private final List<Customer> customers = List.of(
            new Customer.Builder().id("001").name("thuanluong").email("thuanspkt@gmail.com").phoneNumber("123456789").build(),
            new Customer.Builder().id("002").name("thuan").email("thuan@gmail.com").phoneNumber("987654321").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello is Guest");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") String id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
