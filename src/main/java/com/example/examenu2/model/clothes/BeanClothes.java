package com.example.examenu2.model.clothes;

import com.example.examenu2.model.category.BeanCategory;
import com.example.examenu2.model.types.BeanType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanClothes {
    Long id;
    String name;
    double price;
    String size;
    String brand;
    int stock;
    String created_at;
    int status;
    BeanType type;
    BeanCategory category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanType getType() {
        return type;
    }

    public void setType(BeanType type) {
        this.type = type;
    }

    public BeanCategory getCategory() {
        return category;
    }

    public void setCategory(BeanCategory category) {
        this.category = category;
    }
}
