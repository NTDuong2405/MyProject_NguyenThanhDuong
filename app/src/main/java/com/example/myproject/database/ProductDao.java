package com.example.myproject.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    long insertProduct(Product product);


    @Query("Select * from products")
    List<Product> getAllProduct();
}
