package com.security.jwt.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private record Product(Integer productId,String productName,double price){
    }

    List<Product> productList=new ArrayList<>(List.of(new Product(123,"stem",122.9),
            new Product(212,"rim",323.8),
            new Product(22,"ribbon",322.9),
            new Product(2322,"roil",122.9),
            new Product(34433,"roil",122.9),
            new Product(34363,"james",1422.9)));


    @GetMapping
    public List<ProductController.Product> getAllProducts(){
        return productList;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        productList.add(product);
        return product;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}


