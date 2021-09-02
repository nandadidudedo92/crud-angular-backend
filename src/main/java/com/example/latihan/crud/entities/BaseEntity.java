package com.example.latihan.crud.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity  implements Serializable {

    private static final long serialVersionUID = 2025317384448593285L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


}
