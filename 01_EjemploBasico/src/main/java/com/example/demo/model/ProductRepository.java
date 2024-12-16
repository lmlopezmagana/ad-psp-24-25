package com.example.demo.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private HashMap<Long, Product> products = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Product.builder().name("Laptop").price(1200.0).build());
        add(Product.builder().name("Smartphone").price(800.0).build());
        add(Product.builder().name("Headphones").price(150.0).build());
        add(Product.builder().name("Monitor").price(300.0).build());
        add(Product.builder().name("Keyboard").price(50.0).build());
    }

    public Product add(Product product) {
        long id = counter.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    public Optional<Product> get(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> getAll() {
        return List.copyOf(products.values());
    }

    public Optional<Product> edit(Long id, Product newValue) {
        return Optional.ofNullable(products.computeIfPresent(id, (k, v) -> {
            v.setName(newValue.getName());
            v.setPrice(newValue.getPrice());
            return v;
        }));
    }

    public void delete(Long id) {
        products.remove(id);
    }

    public List<Product> query(double maxPrice, String sortDirection) {
        List<Product> data = new ArrayList<>(products.values());
        List<Product> result;

        if (maxPrice < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(p -> p.getPrice() <= maxPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Product::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Product::getName).reversed());

        return Collections.unmodifiableList(result);
    }




}

