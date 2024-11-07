package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserB;

@Repository
public interface UserRepository extends JpaRepository<UserB, Long>{
    public List<UserB> findByName(String name);
    public List<UserB> findByMail(String mail);

    @Query("SELECT u FROM UserB u WHERE u.name = :login OR u.mail = :login")
    public List<UserB> loginMailOrName(@Param("login") String login);

}
