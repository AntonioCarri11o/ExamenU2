package com.example.examenu2.model;


import com.example.examenu2.utils.Response;

import java.util.List;

public interface Repository <T>{
    List<T> findAll();
    //List<T> findCat();
    //List<T> findType();
    Response findById(Long id);
    Response save(T object);
    Response update(T object);
}
