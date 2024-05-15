package com.uos25.uos25.products.entity;

import com.uos25.uos25.products.dto.ProductsDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "products_id")
//    private Long id;

    @Column(nullable = false)
    private String productName;

    @Id
    @Column(nullable = false)
    private String productCode;

    @Column(nullable = false)
    private int salePrice;

    @Column(nullable = false)
    private int orderPrice;

    public static Products toSaveProducts(ProductsDTO productsDTO){
        Products products = new Products();
        products.setProductName(productsDTO.getProductName());
        products.setProductCode(productsDTO.getProductCode());
        products.setSalePrice(productsDTO.getSalePrice());
        products.setOrderPrice(productsDTO.getOrderPrice());
        return products;
    }
}
