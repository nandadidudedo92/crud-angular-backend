package com.example.latihan.crud.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseEntity {

    private static final long serialVersionUID = 2025317384448593285L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


}
