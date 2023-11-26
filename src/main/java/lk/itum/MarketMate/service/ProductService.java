package lk.itum.MarketMate.service;

import lk.itum.MarketMate.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductDto dto);
    void deleteProduct(String code);
    void updateProduct(ProductDto dto);
    ProductDto searchProduct(String code);
    List<ProductDto> getAllProducts();

}
