package com.example.userservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
