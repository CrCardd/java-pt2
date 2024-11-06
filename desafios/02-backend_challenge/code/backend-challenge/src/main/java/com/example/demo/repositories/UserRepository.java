package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserB;

@Repository
public interface UserRepository extends JpaRepository<UserB, Long>{
    public List<UserB> findByName(String name);
    public List<UserB> findByMail(String mail);
    public List<UserB> findByNameAndPassword(String mail, String password);

}
