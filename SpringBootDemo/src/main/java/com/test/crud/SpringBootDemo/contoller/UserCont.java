package com.test.crud.SpringBootDemo.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.crud.SpringBootDemo.models.Product;
import com.test.crud.SpringBootDemo.models.ProductResponse;
import com.test.crud.SpringBootDemo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v6/")
@RequiredArgsConstructor
public class UserCont {
    private final UserService userService;



    @PostMapping("save")
    public ProductResponse createProduct(@RequestBody Product product){
         return this.userService.createProduct(product);
    }
    //  http://localhost:7033/api/v6/getById/21
    @GetMapping("get/{id}")
    public Product getProductByid(@PathVariable int id){
         return this.userService.getProductById(id);
    }


    //   http://localhost:7033/api/v6/getByName?name=apple
    @GetMapping("getByName")
    public List<Product> getProductByid(@RequestParam String name){
         return this.userService.getProductByName(name);
    }
    @DeleteMapping("deleteProduct/{id}")
       public String deleteById(@PathVariable int id){
          return this.userService.deleteProductById(id);

       }
       @PutMapping("update")
        public String updateProduct(@RequestBody Product product){
        return this.userService.updateProduct(product);
        }



}
