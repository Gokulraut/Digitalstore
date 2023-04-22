package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import com.csi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productServiceImpl;
    @Autowired
    ProductRepo productRepo;

    @PostMapping("/saveData")
    public ResponseEntity<?>saveProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productServiceImpl.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/search/{input}")
    public ResponseEntity<List<?>>search(@PathVariable String input){
        return ResponseEntity.ok(productServiceImpl.search(input));
    }

    @GetMapping("/sortlowtohigh")
    public ResponseEntity<List<?>>sortlowtohigh(){
        return ResponseEntity.ok(productServiceImpl.sortLowToHighPrice());
    }
    @GetMapping("/sorthightolow")
    public ResponseEntity<List<?>>sorthightolow(){
        return ResponseEntity.ok(productServiceImpl.sortHighToLowPrice());
    }
    @GetMapping("/findByCategory/{prodCat}/{prodSubCat}")
    public ResponseEntity<List<?>>findByCategory(@PathVariable String prodCat,@PathVariable String prodSubCat){
        return ResponseEntity.ok(productServiceImpl.findByCategory(prodCat,prodSubCat));
    }
    @GetMapping("/findByBrands/{brands}")
    public ResponseEntity<List<?>>findByBrands(@PathVariable String brands){
        return ResponseEntity.ok(productServiceImpl.findByBrands(brands));
    }
    @GetMapping("/allProducts")
    public ResponseEntity<List<?>>allProducts(){
        return ResponseEntity.ok(productServiceImpl.allProducts());
    }
    @PostMapping("/saveMuiltipleProducts/{products}")
    public ResponseEntity<List<?>>saveMuiltipleProducts(@PathVariable List<Product> products){
        return ResponseEntity.ok(productServiceImpl.saveMuiltipleProducts(products));
    }
    @PutMapping("/updateData/{prodId}")
    public ResponseEntity<?>updateProd(@RequestBody Product product,@PathVariable int prodId){
        Product product1=productRepo.findById(prodId).orElseThrow(()->new RecordNotFoundException("id Dose Not Exist"));

        product1.setProdBrand(product1.getProdBrand());
        product1.setProdCat(product.getProdCat());
        product1.setProdName(product.getProdName());
        product1.setProdSubCat(product.getProdSubCat());
        product1.setProdprice(product.getProdprice());
        product1.setCreatedTimestamp(product.getCreatedTimestamp());
        product1.setProdPhoto(product.getProdPhoto());
return ResponseEntity.ok(product1);
    }
}
