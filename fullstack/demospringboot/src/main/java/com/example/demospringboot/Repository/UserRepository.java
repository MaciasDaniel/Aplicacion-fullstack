package com.example.demospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demospringboot.Model.UserModel;


@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
    
}