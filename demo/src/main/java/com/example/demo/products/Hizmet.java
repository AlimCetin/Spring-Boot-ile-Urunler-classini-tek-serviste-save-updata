package com.example.demo.products;



import java.util.List;

import com.example.demo.image.HizmetImage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity

public class Hizmet extends BaseProduct {

    @Column(name = "verhizmet")
    private String verhizmet;

    @OneToMany(mappedBy = "hizmet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HizmetImage> hizmetImages ;

}