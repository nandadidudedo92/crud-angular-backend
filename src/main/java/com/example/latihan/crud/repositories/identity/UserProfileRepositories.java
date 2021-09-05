package com.example.latihan.crud.repositories.identity;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.entities.identity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepositories extends JpaRepository<UserProfileEntity, Long> {
}
