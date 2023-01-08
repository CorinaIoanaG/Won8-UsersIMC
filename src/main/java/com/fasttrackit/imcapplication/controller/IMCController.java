package com.fasttrackit.imcapplication.controller;

import com.fasttrackit.imcapplication.model.User;
import com.fasttrackit.imcapplication.service.IMCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("imc") // http://host:port/imc

public class IMCController {
    private final IMCService imcService;

    @GetMapping
    public List<User> getAll(){
        return imcService.getAll();
    }

    @GetMapping("{town}")
    List<User> getByTown(@RequestParam String town){
        return imcService.getByTown(town);}

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        User user = imcService.getById(id);
        user.getUserData().stream().count();
        return user;
    }
}
