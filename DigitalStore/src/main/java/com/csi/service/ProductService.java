package com.csi.service;

import com.csi.dao.ProductDao;
import com.csi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

@Autowired
    ProductDao productDaoImpl;

    public Product saveProduct(Product product){
        return productDaoImpl.saveProduct(product);

    }

    public List<Product> search(String input){

        return productDaoImpl.search(input);
    }
    public List<Product>sortLowToHighPrice(){
        return productDaoImpl.sortLowToHighPrice();
    }
    public List<Product>sortHighToLowPrice(){
        return productDaoImpl.sortHighToLowPrice();
    }

   public List<Product>findByCategory(String prodCat,String prodSubCat){
      return productDaoImpl.findByCategory(prodCat,prodSubCat);
   }
    public List<Product>findByBrands(String brands){
        return productDaoImpl.findByBrands(brands);
    }
    public List<Product>allProducts(){
        return productDaoImpl.allProducts();
    }
    public List<Product>saveMuiltipleProducts(List<Product> products){
        return productDaoImpl.saveMuiltipleProducts(products);
    }
    public Product update(Product product){

        return productDaoImpl.update(product);
    }
}
