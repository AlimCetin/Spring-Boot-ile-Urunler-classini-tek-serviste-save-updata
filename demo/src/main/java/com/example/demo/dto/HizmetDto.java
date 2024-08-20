package com.example.demo.dto;



import java.util.List;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HizmetDto extends BaseProductDto {

    @Column(name = "verhizmet")
    private String verhizmet;

/*     @OneToMany(mappedBy = "hizmetDto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HizmetImage> hizmetImages ;
 */
}