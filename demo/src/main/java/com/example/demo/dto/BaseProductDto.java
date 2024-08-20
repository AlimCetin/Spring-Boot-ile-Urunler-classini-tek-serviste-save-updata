package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.comment.Comment;
import com.example.demo.dto.image.ProductImage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = HizmetDto.class, name = "hizmet"),
    @JsonSubTypes.Type(value = ElektronikDto.class, name = "elektronik"),
})
public abstract class BaseProductDto {

  protected Long id;

  @Column(name = "userId")
  protected Long userId;

  @Column(name = "categoryId")
  protected Long  categoryId;

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

  /*
   * @OneToMany(mappedBy = "productDto", cascade = CascadeType.ALL, fetch =
   * FetchType.LAZY)
   * private List<ProductImage> productImage ;
   */

  /*
   * @OneToMany(mappedBy = "productDto", cascade = CascadeType.ALL, fetch =
   * FetchType.LAZY)
   * private List<Comment> comments ;
   */
  private Boolean status;

  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate uptodate;

}
