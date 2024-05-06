package com.riwi.salonBelleza.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Services
 */
@Entity(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Lob //Atributo tipo TEXT
    private String desciption;

    @Column(nullable = false)
    private BigDecimal price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        mappedBy = "service",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false)
    private List<Appointment> appointments;
}