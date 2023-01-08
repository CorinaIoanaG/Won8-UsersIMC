package com.fasttrackit.imcapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserData {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Column
    private Date date;

    @Column
    private int userWeight;

    @Column
    private float userIMC;

    public UserData(Date date, int userWeight, float userIMC) {
        this.date = date;
        this.userWeight = userWeight;
        this.userIMC = userIMC;
    }
}
