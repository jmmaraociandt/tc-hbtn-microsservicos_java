package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        for (Product productToFind  : list) {
            if (productToFind.getId().equals(id))
                return productToFind;
        }
        return null;
    }

    public void addProduct(Product s) {
        if (getProductById(s.getId()) == null)
            list.add(s);
    }

    public void updateProduct(Product s) {
        int index;

        if (getProductById(s.getId()) != null) {
            index = list.indexOf(s);

            list.set(index, s);
        }
    }

    public void removeProduct(Product s) {
        if (getProductById(s.getId()) != null)
            list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        listOfProducts.forEach(this::addProduct);
    }
}
