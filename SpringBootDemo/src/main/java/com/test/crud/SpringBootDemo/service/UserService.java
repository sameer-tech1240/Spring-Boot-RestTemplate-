package com.test.crud.SpringBootDemo.service;

import com.test.crud.SpringBootDemo.models.Product;
import com.test.crud.SpringBootDemo.models.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final List<Product> productList;

    public ProductResponse createProduct(Product product){
          product.setId(productList.size()+1);
            productList.add(product);
        System.out.println("...................................................");
        System.out.println(product);
           ProductResponse response  =new ProductResponse();
           response.setMessage("success");
           response.setStatusCode("201");
           return response;

    }
 public Product getProductById(int id){
     Product product = productList.stream().filter(x -> x.getId() == id).findFirst().get();
     return product;
 }
    public List<Product> getProductByName(String  name) {
        return productList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

    }

    public String deleteProductById(int id) {
        productList.remove(this.getProductById(id));
        return "id successfully deleted";
    }

    public String updateProduct(Product product) {
        Product productById = getProductById(product.getId());
        if (productById==null)
               throw new RuntimeException("product not found");
        else
            productList.set(this.productList.indexOf(productById), product);
          return "product successfully updated";
    }




}
