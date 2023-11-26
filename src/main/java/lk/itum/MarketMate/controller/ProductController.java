package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.ProductDto;
import lk.itum.MarketMate.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProduct() {
        return "Get All Product";
    }

    @GetMapping(path = "/{productId}")
    public String searchProduct(@PathVariable String productId) {
        return "Product Search";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute ProductDto productDto) {
        return "Product Saves";
    }

    @PutMapping
    public String updateProduct(@RequestBody ProductDto productDto) {
        return "Product Updated";
    }


    @DeleteMapping(params = {"id"})
    public String deleteProduct(@RequestParam String productId) {
        return "Product Deleted";
    }

}
