package com.example.examenu2.model.category;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanCategory {
    Long id;
    String name;

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
}
