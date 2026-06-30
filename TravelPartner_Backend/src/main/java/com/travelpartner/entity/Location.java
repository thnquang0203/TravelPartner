package com.travelpartner.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tenDiaDiem;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(nullable = false)
    private Double viDo;

    @Column(nullable = false)
    private Double kinhDo;

    @Column(nullable = false)
    private String tinhThanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category danhMuc;

    @Builder.Default
    private Double diemDanhGia = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TrangThai trangThai = TrangThai.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User nguoiTao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime ngayTao;

    @PrePersist
    protected void onCreate() {
        this.ngayTao = LocalDateTime.now();
    }

    public enum TrangThai {
        PENDING, APPROVED, REJECTED
    }
}