package com.fasttrackit.imcapplication.service;

import com.fasttrackit.imcapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IMCRepository extends JpaRepository<User, Integer> {

    List<User> findByUserTown(String name);
    @Query("select u from User u join UserData")
    List<User> getAllUserData();

}
