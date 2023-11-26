package lk.itum.MarketMate.service.impl;

import jakarta.transaction.Transactional;
import lk.itum.MarketMate.dto.ProductDto;
import lk.itum.MarketMate.entity.Product;
import lk.itum.MarketMate.repo.ProductRepo;
import lk.itum.MarketMate.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepo productRepo, ModelMapper mapper) {
        this.productRepo = productRepo;
        this.mapper = mapper;
    }


    @Override
    public void saveProduct(ProductDto dto) {
        if (!productRepo.existsById(dto.getProductId())) {
            productRepo.save(mapper.map(dto, Product.class));
        } else {
            throw new RuntimeException("This Product ID is Already Exists.");
        }
    }

    @Override
    public void deleteProduct(String code) {
        if (!productRepo.existsById(code)) {
            productRepo.deleteById(code);
        } else {
            throw new RuntimeException("Please Check Product Id. No Such Product to Delete.");
        }

    }

    @Override
    public void updateProduct(ProductDto dto) {
        if (productRepo.existsById(dto.getProductId())) {
            productRepo.save(mapper.map(dto, Product.class));
        } else {
            throw new RuntimeException("Please Check product Id. No Such Product to Update.");
        }
    }

    @Override
    public ProductDto searchProduct(String code) {
        if (productRepo.existsById(code)) {
            return mapper.map(productRepo.findById(code), ProductDto.class);
        } else {
            throw new RuntimeException("No Such Product for " + code + "..!");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return mapper.map(productRepo.findAll(), new TypeToken<List<ProductDto>>() {
        }.getType());
    }
}
