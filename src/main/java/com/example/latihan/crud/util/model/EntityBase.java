package com.example.latihan.crud.util.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class EntityBase implements Serializable {

    private static final long serialVersionUID = 2025317384448593285L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String description ;

    @Version
    private Integer version;
    private Boolean deleted;

    @PreUpdate
    private void preUpdate() {
        this.version = getVersion() + 1;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
