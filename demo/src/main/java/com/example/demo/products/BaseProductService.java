package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.dto.BaseProductDto;
import com.example.demo.dto.ElektronikDto;
import com.example.demo.dto.HizmetDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseProductService {

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    ///////////// Gelen categroyId ye göre üst ana categroy leri bulur
    public Long[] categroyFind(BaseProductDto baseProductDto) {
        ArrayList<Long> categroyIdArry = new ArrayList<>();
        Optional<Category> findCategory = categoryRepository.findById(baseProductDto.getCategoryId());
        Long categoryUstId = findCategory.get().getUstId();
        if (categoryUstId == null) {
            categroyIdArry.add(findCategory.get().getId());
        } else {
            categroyIdArry.add(categoryUstId);
            while (categoryUstId != null) {
                findCategory = categoryRepository.findById(categoryUstId);
                if (findCategory.get().getUstId() == null) {
                    categroyIdArry.add(findCategory.get().getId());
                } else {
                    categoryUstId = findCategory.get().getUstId();
                    categroyIdArry.add(categoryUstId);
                }
            }
        }
        return categroyIdArry.toArray(new Long[0]);
    }

    /////
    public BaseProduct baseSwitch(BaseProductDto baseProductDto, String dType) {

        switch (dType) {
            case "elektronik":
                ElektronikDto elektronikDto = (ElektronikDto) baseProductDto;
                Elektronik elektronikProduct = new Elektronik();
                return elektronikProduct;

            case "hizmet":
                HizmetDto hizmetDto = (HizmetDto) baseProductDto;
                Hizmet hizmetProduct = new Hizmet();
                hizmetProduct.setVerhizmet(hizmetDto.getVerhizmet());
                return hizmetProduct;

            default:
                throw new IllegalArgumentException("Unknown product type: " + dType);
        }
    }

    // Kayıt
    public Object save(BaseProductDto baseProductDto, String dType) {
        if (baseProductDto != null) {

            dType = dType.toLowerCase();
            BaseProduct newProduct = null;

            newProduct = baseSwitch(baseProductDto, dType);
            
            newProduct.setUserId(baseProductDto.getUserId());
            newProduct.setCategoryId(categroyFind(baseProductDto));
            newProduct.setFiyat(baseProductDto.getFiyat());
            newProduct.setAdres(baseProductDto.getAdres());
            newProduct.setIlanNo(baseProductDto.getIlanNo());
            newProduct.setAciklama(baseProductDto.getAciklama());
            newProduct.setKimden(baseProductDto.getKimden());
            newProduct.setTakas(baseProductDto.getTakas());
            /* newProduct.setProductImage(baseProductDto.getProductImage()); */
            newProduct.setStatus(true);
            newProduct.setUptodate(LocalDate.now());
            baseProductRepository.save(newProduct);

            return newProduct;
        }

        return null;
    }

    // Güncelleme
    public Object update(BaseProductDto baseProductDto, String dType,Long id) {
        if (baseProductDto != null) {

            dType = dType.toLowerCase();
            BaseProduct newProduct = null;
            newProduct=baseSwitch(baseProductDto, dType);
            newProduct.setId(id);
            newProduct.setUserId(baseProductDto.getUserId());
            newProduct.setCategoryId(categroyFind(baseProductDto));
            newProduct.setFiyat(baseProductDto.getFiyat());
            newProduct.setAdres(baseProductDto.getAdres());
            newProduct.setIlanNo(baseProductDto.getIlanNo());
            newProduct.setAciklama(baseProductDto.getAciklama());
            newProduct.setKimden(baseProductDto.getKimden());
            newProduct.setTakas(baseProductDto.getTakas());
            /* newProduct.setProductImage(baseProductDto.getProductImage()); */
            newProduct.setStatus(true);
            newProduct.setUptodate(LocalDate.now());
            baseProductRepository.save(newProduct);

            return newProduct;
        }

        return null;
    }

}
