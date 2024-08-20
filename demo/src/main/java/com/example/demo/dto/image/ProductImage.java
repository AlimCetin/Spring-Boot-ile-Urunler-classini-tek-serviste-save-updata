package com.example.demo.dto.image;

import com.example.demo.products.BaseProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

/*     @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productDto_id")
    private BaseProduct productDto;
*/
} 