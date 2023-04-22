package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue
    private int prodId;

    @Pattern(regexp="[A-Za-z]*", message="First name should not contain space and special characters")
    private String prodName;
   @NotNull
    private String prodBrand;
   @NotNull
    private String prodCat;
   @NotNull
    private String prodSubCat;
   @NotNull
    private int prodprice;
   @NotNull
    private String prodPhoto;
   @NotNull
   @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdTimestamp;



}
