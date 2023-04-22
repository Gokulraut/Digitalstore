package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDao {

    @Autowired
    ProductRepo productRepoImpl;

    public Product saveProduct(Product product){
        return productRepoImpl.save(product);

    }
    public List<Product>search(String input){
        List<Product>searching=new ArrayList<>();

        for (Product product: productRepoImpl.findAll()){
            if (product.getProdBrand().equals(input)
            ||product.getProdCat().equals(input)
            ||product.getProdName().equals(input)
            ||product.getProdSubCat().equals(input)){
                searching.add(product);
            }
        }
    return searching;
    }
public List<Product>sortLowToHighPrice(){
        return productRepoImpl.findAll().stream().sorted(Comparator.comparingDouble(Product::getProdprice)).collect(Collectors.toList());
}
    public List<Product>sortHighToLowPrice(){
        return productRepoImpl.findAll().stream().sorted(Comparator.comparingDouble(Product::getProdprice).reversed()).collect(Collectors.toList());
}

public List<Product>findByCategory(String prodCat,String prodSubCat){
       return productRepoImpl.findByProdCatAndProdSubCat(prodCat,prodSubCat);
}
public List<Product>findByBrands(String brands){
        return productRepoImpl.findAll().stream().filter(br->br.getProdBrand().equals(brands)).collect(Collectors.toList());
}
public List<Product>allProducts(){
        return productRepoImpl.findAll();
}
    public List<Product>saveMuiltipleProducts(List<Product> products){
        return productRepoImpl.saveAll(products);
    }

    public Product update(Product product){

        return productRepoImpl.save(product);
    }
}
