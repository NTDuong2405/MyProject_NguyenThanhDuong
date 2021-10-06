package com.example.myproject.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)
    public  int id;

    @ColumnInfo(name="name")
    public  String name;

    @ColumnInfo(name="quantity")
    public  int quantity;
}
