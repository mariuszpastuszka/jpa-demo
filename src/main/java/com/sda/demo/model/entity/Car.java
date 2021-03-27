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
import javax.persistence.FetchType;
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

    // Róbmy lepiej związki jednokierunkowe: owner -> OneToMany do swoich aut
    // auta nie potrzebują znać swojego właściciela :) będzie mniej problemów z odczytem :P
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "MY_OWNER_ID", referencedColumnName = "ID")
    private Person owner;

    public Car(Long id, String brand, String model, Colour colour) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", colour=" + colour +
            ", noName=" + noName +
            ", owner=" + owner +
            '}';
    }
}
