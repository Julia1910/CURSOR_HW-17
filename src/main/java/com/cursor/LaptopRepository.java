package com.cursor;

import com.cursor.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository  extends JpaRepository<Laptop, Integer> {
    List<Laptop> findByOrderByManufacturerDesc();
    List<Laptop> findByMemoryAfter(Integer minMemory);
    List<Laptop> findByUsedIsTrue();
}
