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
    public List<User> getAll(@RequestParam(required = false) String town) {
        if (town == null){
            return imcService.getAll();
        } else{
            return imcService.getByTown(town);
        }
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return imcService.getById(id);
    }
}
