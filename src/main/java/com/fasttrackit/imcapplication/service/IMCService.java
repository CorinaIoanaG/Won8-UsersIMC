package com.fasttrackit.imcapplication.service;

import com.fasttrackit.imcapplication.exception.ResourceNotFoundException;
import com.fasttrackit.imcapplication.model.User;
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
}
