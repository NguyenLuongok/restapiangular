package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.Model.Product;
import angular.api.rest.api.with.angular.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/test")
    public List<Product> getAll(){
        return productRepository.findAll();
    }
}
