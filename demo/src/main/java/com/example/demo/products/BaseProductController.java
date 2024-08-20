package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BaseProductDto;

@RestController
@RequestMapping("/base")
public class BaseProductController {

    @Autowired
    private BaseProductService baseProductService;


    @PostMapping("/{dType}")
    public Object create(@RequestBody BaseProductDto baseProductDto, @PathVariable("dType") String dType) {
        return baseProductService.save(baseProductDto,dType);
    }


}
