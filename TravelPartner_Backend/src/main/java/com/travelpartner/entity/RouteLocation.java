package com.travelpartner.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RouteLocations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route loTrinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location diaDiem;

    @Column(nullable = false)
    private Integer thuTuNgay;
}