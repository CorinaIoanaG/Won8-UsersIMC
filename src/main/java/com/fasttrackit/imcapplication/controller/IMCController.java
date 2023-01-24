package com.fasttrackit.imcapplication.controller;

import com.fasttrackit.imcapplication.controller.dto.PatchUserDataRequest;
import com.fasttrackit.imcapplication.controller.dto.PatchUserRequest;
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
        if (town.equals(null) || town.equals("")) {
            return imcService.getAll();
        } else {
            return imcService.getByTown(town);
        }
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return imcService.getById(id);
    }

    @PatchMapping("{id}")
    public User patch(@PathVariable int id, @RequestBody PatchUserRequest request) {
        return imcService.patch(id, request.fullName(), request.town(), request.contact());
    }

    @DeleteMapping("{id}")
    public User deleteById(@PathVariable int id) {
        return imcService.deleteById(id);
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return imcService.add(user);
    }

    @PostMapping("{id}/datas")
    User addDataToUser(@PathVariable int id, @RequestBody PatchUserDataRequest patchUserDataRequest) {
        return imcService.addDataToUser(id, patchUserDataRequest);
    }

}
