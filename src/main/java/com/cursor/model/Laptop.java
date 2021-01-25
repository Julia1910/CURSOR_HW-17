package com.cursor.model;

import com.cursor.model.Enums.CPU;
import com.cursor.model.Enums.Case;
import com.cursor.model.Enums.Manufacturer;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Component
@Entity
@Table(name = "laptops")
@Data
public class Laptop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private UUID model;

    @Column(name = "manufacturer")
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @Column(name = "cpu")
    @Enumerated(EnumType.STRING)
    private CPU CPU;

    private Integer memory;

    private Boolean used;

    @Column(name = "laptop_case")
    @Enumerated(EnumType.STRING)
    private Case laptopCase;

    private Integer price;

    private Date releaseDate;
}
