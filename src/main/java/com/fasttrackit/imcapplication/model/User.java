package com.fasttrackit.imcapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String userName;

    @Column
    private String userPass;

    @Column
    private String userFullName;

    @Column
    private String userTown;

    @Column
    private float userHeight;

    @Column
    private String userContact;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<UserData> userData;
}
