package com.fasttrackit.imcapplication.service;

import com.fasttrackit.imcapplication.controller.dto.PatchUserDataRequest;
import com.fasttrackit.imcapplication.exception.ResourceNotFoundException;
import com.fasttrackit.imcapplication.model.User;
import com.fasttrackit.imcapplication.model.UserData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IMCService {
    private final IMCRepository imcRepository;

    // Constructor
    public IMCService(IMCRepository imcRepository, IMCReader imcReader) {
        this.imcRepository = imcRepository;
        imcRepository.saveAll(imcReader.getUsers());
    }

    // Returns a list of users from a specific town.
    public List<User> getByTown(String town) {
        return imcRepository.findByTown(town);
    }

    // Returns all users.
    public List<User> getAll() {
        return imcRepository.findAll();
    }

    // Returns a User with a specific id.
    public User getById(int id) {
        return imcRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User missing ", id));
    }

    // Updates name, town and contact for a specific User.
    public User patch(int id, String name, String town, String contact) {
        User userToBeUpdated = getById(id);
        userToBeUpdated.setFullName(name);
        userToBeUpdated.setTown(town);
        userToBeUpdated.setContact(contact);
        return imcRepository.save(userToBeUpdated);
    }

    // Deletes a specific User.
    public User deleteById(int id) {
        User userToBeDeleted = getById(id);
        imcRepository.deleteById(id);
        return userToBeDeleted;
    }

    // Adding a new User.
    public User add(User user) {
        return imcRepository.save(user);
    }

    // Adding a new UserData to a specific User.
    public User addDataToUser(int id, PatchUserDataRequest patchUserDataRequest) {
        User user = getById(id);
        UserData userData = new UserData(patchUserDataRequest.date(), patchUserDataRequest.weight(), patchUserDataRequest.height());
        userData.setUser(user);
        user.getUserData().add(userData);
        return imcRepository.save(user);
    }

}
