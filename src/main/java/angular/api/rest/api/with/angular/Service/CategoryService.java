package angular.api.rest.api.with.angular.Service;

import angular.api.rest.api.with.angular.Model.Category;
import angular.api.rest.api.with.angular.Model.Product;
import angular.api.rest.api.with.angular.ModelDTO.CategoryDto;
import angular.api.rest.api.with.angular.Repository.CategoryRepository;
import angular.api.rest.api.with.angular.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto findById(Long id){
        try {
            Optional<Category> category = categoryRepository.findById(id);
            CategoryDto categoryDto = modelMapper.map(category.get(),CategoryDto.class);
            return categoryDto;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<CategoryDto> findAll(){
      try {
          List<Category> ct = categoryRepository.findAll();
          Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
          List<CategoryDto> categoryDtos = modelMapper.map(ct,listType);
          return categoryDtos;
      }
      catch (Exception e){
          return null;
      }
    }
    public Category save(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto,Category.class);
        categoryRepository.save(category);
        return categoryRepository.findById(category.getCategoryId()).get();
    }


    public CategoryDto delete(Long id){
        CategoryDto categoryDto = findById(id);
        productRepository.deleteAllByCategoryId(id);
        categoryRepository.deleteById(id);
        return categoryDto;
    }
}
