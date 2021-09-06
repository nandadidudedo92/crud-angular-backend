package com.example.latihan.crud.service.identity;

import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.repositories.identity.UserRepositories;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserRepositories userRepositories;

    @Override
    public UserEntity doLogin(UserEntity user) throws Exception {

        UserEntity userEntity = userRepositories.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userEntity.getUsername() == null) {
            throw new Exception("Login Gagal, user tidak ditemukan");
        }
        return userEntity;
    }

    @Override
    public String getJWTToken(String username) {
        String secretKey = "kakNanda";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
