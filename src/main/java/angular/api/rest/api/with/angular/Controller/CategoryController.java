package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.Model.Category;
import angular.api.rest.api.with.angular.ModelDTO.CategoryDto;
import angular.api.rest.api.with.angular.Repository.CategoryRepository;
import angular.api.rest.api.with.angular.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/",produces = "application/json")
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public CategoryDto findById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category save(@RequestBody CategoryDto category){
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id") Long id,@RequestBody CategoryDto category){
        return null;
    }

    @DeleteMapping("/{id}")
    public CategoryDto delete(@PathVariable("id") Long id){
        return categoryService.delete(id);
    }
}
