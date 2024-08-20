package com.example.demo.products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.comment.Comment;
import com.example.demo.image.ProductImage;
import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
abstract public class BaseProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;

    @Column(name = "userId")
    protected Long userId;

    @Column(name = "categoryId")
    protected   Long [] categoryId;

    @Column(name = "fiyat")
    protected Integer fiyat;

    @Column(name = "adres")
    protected String adres;

    @Column(name = "ilanNo")
    protected Integer ilanNo;

    @Column(name = "aciklama")
    protected String aciklama;

    @Column(name = "kimden")
    protected String kimden;

    @Column(name = "takas")
    protected Boolean takas;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> productImage ;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments ;

      private Boolean status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate uptodate;


}
