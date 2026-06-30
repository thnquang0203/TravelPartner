package com.travelpartner.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User nguoiDung;

    @Column(nullable = false)
    private String tenLoTrinh;

    @Column(nullable = false)
    private Integer soNgay;

    @Column(nullable = false, updatable = false)
    private LocalDateTime ngayTao;

    @OneToMany(mappedBy = "loTrinh", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RouteLocation> danhSachDiaDiem = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.ngayTao = LocalDateTime.now();
    }
}