package com.test.crud.SpringBootDemo.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private long price;

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
         Product product = (Product) obj;
         return this.getId()==product.getId();
    }
}
