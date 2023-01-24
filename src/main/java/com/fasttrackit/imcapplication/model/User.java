package com.fasttrackit.imcapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String pass;
    @Column
    private String fullName;
    @Column
    private String town;
    @Column
    private float height;
    @Column
    private String contact;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<UserData> userData;
}
