package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.Model.Product;
import angular.api.rest.api.with.angular.ModelDTO.ProductDto;
import angular.api.rest.api.with.angular.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value ="/{id}",produces = "application/json")
    public ProductDto fillById(@PathVariable("id")Long id){
        return productService.findById(id);
    }

    @GetMapping(value = "/",produces = "application/json")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping(value = "/category/{id}",produces = "application/json")
    public List<ProductDto> findAllByCategory(@PathVariable("id") Long id){
        return productService.findAllByCategoryId(id);
    }

    @PostMapping("/")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        if(productDto.getProductName()=="" ||productDto.getProductPrice()<=0 ||productDto.getProductTotal()<=0 || productDto.getProductImage()==""
        || productDto.getProductSale()<0 || productDto.getCategory()==""|| productDto.getProductDescription()==""){
            return null;
        }
        else {
            return productService.save(productDto);
        }
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id,@RequestBody ProductDto productDto){
        productDto.setId(id);
        if(productDto.getProductName()=="" ||productDto.getProductPrice()<0 ||productDto.getProductTotal()<0 || productDto.getProductImage()==""
                || productDto.getProductSale()<=0 || productDto.getCategory()=="" || productDto.getProductDescription()==""){
            return null;
        }
        else {
            return productService.update(productDto);
        }
    }

    @PutMapping("/remove/{id}")
    public ProductDto removeNoneDelete(@PathVariable("id") Long id){
        return productService.removeNoneDelete(id);
    }

    @DeleteMapping("/{id}")
    public ProductDto remove(@PathVariable("id") Long id){
        return productService.delete(id);
    }
}
