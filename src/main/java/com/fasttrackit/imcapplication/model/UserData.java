package com.fasttrackit.imcapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasttrackit.imcapplication.controller.dto.PatchUserDataRequest;
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
    private int weight;
    @Column
    private float imc;
    @Column
    private String imcRange;

    // Constructor
    public UserData(Date date, int weight, float height) {
        this.date = date;
        this.weight = weight;
        this.imc = (float) (weight / Math.pow(height, 2));
        this.imcRange = getRange(imc);
    }

    // Returns imcRange based on imc.
    public String getRange(float imc) {
        if (imc < 18.49) {
            return "Subponderal";
        } else if (imc < 25) {
            return "Greutate normala";
        } else if (imc < 30) {
            return "Supraponderal";
        } else if (imc < 35) {
            return "Obezitate grad I";
        } else if (imc < 40) {
            return "Obezitate grad II";
        } else {
            return "Obezitate morbida";
        }
    }
}
