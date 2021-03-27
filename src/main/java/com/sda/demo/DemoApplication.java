package com.sda.demo;

import com.sda.demo.model.entity.Car;
import com.sda.demo.model.entity.Person;
import com.sda.demo.model.entity.Radio;
import com.sda.demo.model.enumeration.Colour;
import com.sda.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person me = new Person(null, "maniek", "maniek");
        Car toyota = new Car(null, "Toyota", "Carola", Colour.SILVER);
        toyota.setOwner(me);
        toyota.setNoName(new Radio("yamaha"));
        carRepository.save(toyota);
    }
}
