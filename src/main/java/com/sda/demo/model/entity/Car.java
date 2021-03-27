package com.sda.demo.model.entity;

import com.sda.demo.model.enumeration.Colour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    @Embedded
    private Radio noName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    // domyślnie name = nazwa pola + "_ID"
    @JoinColumn(name = "OWNER_FOREIGN_KEY_ID", referencedColumnName = "ID")
    private Person owner;

    public Car(Long id, String brand, String model, Colour colour) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
    }
}
