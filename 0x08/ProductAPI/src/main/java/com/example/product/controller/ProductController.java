package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Product")
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @GetMapping("/allProducts")
    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    public List<Product> allProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    public Product findProductById(@PathVariable Long id) {
        return productRepository.getProductById(id);
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    public void removeProduct(@RequestBody Product product) {
        productRepository.removeProduct(product);
    }

    @PutMapping("/updateProduct")
    @ApiOperation(value = "Responsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    public void updateProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
    }


    @GetMapping("/welcome")
    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    public String welcome() {
        return "BEM VINDO À PRODUCT REST API.";
    }
}
