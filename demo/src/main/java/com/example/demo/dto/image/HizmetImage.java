package com.example.demo.dto.image;

import com.example.demo.products.BaseProduct;
import com.example.demo.products.Hizmet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class HizmetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;
/* 
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hizmetDto_id")
    private Hizmet hizmetDto; */
}