package com.fasttrackit.imcapplication.service;

import com.fasttrackit.imcapplication.exception.ResourceNotFoundException;
import com.fasttrackit.imcapplication.model.User;
import com.fasttrackit.imcapplication.model.UserData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IMCService {
    private final IMCRepository imcRepository;

    public IMCService(IMCRepository imcRepository, IMCReader imcReader) {
        this.imcRepository = imcRepository;
        imcRepository.saveAll(imcReader.getUsers());
    }

    public List<User> getByTown(String town) {
        return imcRepository.findByTown(town);
    }

    public List<User> getAll() {
        return imcRepository.findAll();
    }

    public User getById(int id) {
        return imcRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User missing ", id));
    }

    public User patch(int id, String name, String town, String contact) {
        User userToBeUpdated = getById(id);
        userToBeUpdated.setFullName(name);
        userToBeUpdated.setTown(town);
        userToBeUpdated.setContact(contact);
        return imcRepository.save(userToBeUpdated);
    }

    public User deleteById(int id) {
        User userToBeDeleted = getById(id);
        imcRepository.deleteById(id);
        return userToBeDeleted;
    }

    public User addDataToUser(int id, UserData userData) {
        User user = getById(id);
        userData.setUser(user);
        user.getUserData().add(userData);
        return imcRepository.save(user);
    }

}
