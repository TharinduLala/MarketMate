package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.ProductDto;
import lk.itum.MarketMate.service.ProductService;
import lk.itum.MarketMate.util.ResponseUtil;
import org.springframework.http.MediaType;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllProduct() {
        return new ResponseUtil(200,"Ok",productService.getAllProducts());
    }

    @GetMapping(path = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchProduct(@PathVariable String productId) {
        return new ResponseUtil(200,"Ok",productService.searchProduct(productId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveProduct(@ModelAttribute ProductDto productDto) {
        productService.saveProduct(productDto);
        return new ResponseUtil(200,"Saved Successfully",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
        return new ResponseUtil(200,"Updated Successfully",null);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteProduct(@RequestParam String productId) {
        productService.deleteProduct(productId);
        return new ResponseUtil(200,"Deleted Successfully",null);
    }

}
