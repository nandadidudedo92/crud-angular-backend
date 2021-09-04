package com.example.latihan.crud.repositories;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.entities.identity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositories extends JpaRepository<RoleEntity, Long> {
}
