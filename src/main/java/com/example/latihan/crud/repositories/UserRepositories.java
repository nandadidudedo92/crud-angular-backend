package com.example.latihan.crud.repositories;

import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.entities.master.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity, Long> {
}
