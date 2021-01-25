package com.cursor;

import com.cursor.model.GeneratorLaptop;
import com.cursor.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class Hw17Application implements CommandLineRunner {
    private final LaptopRepository repository;

    @Autowired
    public Hw17Application(LaptopRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Hw17Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting....");
        System.out.println("Adding new Laptops...");
        List<Laptop> laptops = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Laptop laptop = GeneratorLaptop.generateLaptop();
            laptops.add(laptop);
            repository.save(laptop);
        }
        System.out.println("*** ADDED:  " + laptops.size() + " ***");
        repository.findAll().forEach(System.out::println);
        System.out.println("\n*** Sorted by Manufacturer in Descending ***");
        repository.findByOrderByManufacturerDesc().forEach(System.out::println);
        laptops = repository.findByMemoryAfter(16);
        System.out.println("\n*** Laptops with memory bigger than 16: " + laptops.size() + " ***");
        laptops.forEach(System.out::println);
        laptops = repository.findByUsedIsTrue();
        System.out.println("\n*** Used Laptops: " + laptops.size() + " ***");
        laptops.forEach(System.out::println);
    }
}
