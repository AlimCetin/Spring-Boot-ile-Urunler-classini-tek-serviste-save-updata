package com.example.demo.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseProductRepository  extends JpaRepository<BaseProduct, Long> {



}
    
