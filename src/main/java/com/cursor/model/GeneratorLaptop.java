package com.cursor.model;

import com.cursor.model.Enums.CPU;
import com.cursor.model.Enums.Case;
import com.cursor.model.Enums.Manufacturer;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorLaptop {

    public static Laptop generateLaptop() {
        Laptop laptop = new Laptop();
        laptop.setModel(getModel());
        laptop.setManufacturer(getManufacturer());
        laptop.setCPU(getCpu());
        laptop.setMemory(getMemory());
        laptop.setUsed(getUsed());
        laptop.setLaptopCase(getCase());
        laptop.setPrice(getPrice());
        laptop.setReleaseDate(getDate());
        return laptop;
    }

    private static UUID getModel() {
        return UUID.randomUUID();
    }

    private static Manufacturer getManufacturer() {
        int pick = new Random().nextInt(Manufacturer.values().length);
        return Manufacturer.values()[pick];
    }

    private static CPU getCpu() {
        int pick = new Random().nextInt(CPU.values().length);
        return CPU.values()[pick];
    }

    private static Integer getMemory() {
        return ThreadLocalRandom.current().nextInt(1, 65);
    }

    private static Case getCase() {
        int pick = new Random().nextInt(Case.values().length);
        return Case.values()[pick];
    }

    private static Boolean getUsed() {
        return new Random().nextBoolean();
    }

    private static Integer getPrice() {
        return ThreadLocalRandom.current().nextInt(50, 2001);
    }

    private static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date start = calendar.getTime();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date end = calendar.getTime();
        return between(start, end);
    }

    private static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}
