package angular.api.rest.api.with.angular.Service;

import angular.api.rest.api.with.angular.Model.Category;
import angular.api.rest.api.with.angular.Model.Product;
import angular.api.rest.api.with.angular.ModelDTO.ProductDto;
import angular.api.rest.api.with.angular.Repository.CategoryRepository;
import angular.api.rest.api.with.angular.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDto> findAll(){
        try {
            List<Product> products = productRepository.findAll();
            List<ProductDto> dto = new ArrayList<>();
            for(Product dt : products){
                dto.add(new ProductDto(dt.getProductId(),dt.getProductName(),dt.getProductPrice(),dt.getProductImages(),dt.getProductTotal(),dt.getProductSale(),dt.getProductDescription()
                        ,dt.isProductStatus(),dt.getCategory().getName()));
            }
            Type listType = new TypeToken<List<ProductDto>>(){}.getType();
            List<ProductDto> productDtos = modelMapper.map(dto,listType);
            return productDtos;
        }
        catch (Exception e){
            return null;
        }
    }

    public ProductDto findById(Long id){
       try{
           Optional<Product> product = productRepository.findById(id);
           ProductDto productDto = modelMapper.map(new ProductDto(
                   product.get().getProductId(),product.get().getProductName(),product.get().getProductPrice(),product.get().getProductImages(),
                   product.get().getProductTotal(),product.get().getProductSale(),product.get().getProductDescription(),product.get().isProductStatus(),
                   product.get().getCategory().getName()
           ),ProductDto.class);

           return productDto;
       }
       catch (Exception e){
           return null;
       }
    }

    public List<ProductDto> findAllByCategory(String name){
       try {
           List<Product> products = productRepository.findAllByCategory(name);
           List<ProductDto> dto = new ArrayList<>();
           for(Product dt : products){
               dto.add(new ProductDto(dt.getProductId(),dt.getProductName(),dt.getProductPrice(),dt.getProductImages(),dt.getProductTotal(),dt.getProductSale(),dt.getProductDescription()
                       ,dt.isProductStatus(),dt.getCategory().getName()));
           }
           Type listType = new TypeToken<List<ProductDto>>(){}.getType();
           List<ProductDto> productDtos = modelMapper.map(dto,listType);
           return productDtos;
       }
       catch (Exception e){
           return null;
       }
    }

    public List<ProductDto> findAllByCategoryId(Long id){
        try {
            List<Product> products = productRepository.findAllByCategoryId(id);
            List<ProductDto> dto = new ArrayList<>();
            for(Product dt : products){
                dto.add(new ProductDto(dt.getProductId(),dt.getProductName(),dt.getProductPrice(),dt.getProductImages(),dt.getProductTotal(),dt.getProductSale(),dt.getProductDescription()
                        ,dt.isProductStatus(),dt.getCategory().getName()));
            }
            Type listType = new TypeToken<List<ProductDto>>(){}.getType();
            List<ProductDto> productDtos = modelMapper.map(dto,listType);
            return productDtos;
        }
        catch (Exception e){
            return null;
        }
    }

    public ProductDto save(ProductDto productDto) {
       try {
           Category category = categoryRepository.findByName(productDto.getCategory());
           Product product = modelMapper.map(new Product(null,productDto.getProductName(),productDto.getProductPrice(),productDto.getProductImage(),productDto.getProductTotal()
                   ,productDto.getProductSale(),productDto.getProductDescription(),true,category), Product.class);
           productRepository.save(product);
           return findById(product.getProductId());
       }
       catch (Exception e){
           return null;
       }
    }

    public ProductDto update(ProductDto productDto){
        try {
            Category category = categoryRepository.findByName(productDto.getCategory());
            Optional<Product> pr = productRepository.findById(productDto.getId());
            Product product = modelMapper.map(new Product(productDto.getId(),productDto.getProductName(),productDto.getProductPrice(),productDto.getProductImage(),productDto.getProductTotal()
                    ,productDto.getProductSale(),productDto.getProductDescription(),pr.get().isProductStatus(),category), Product.class);
            productRepository.save(product);
            return findById(productDto.getId());
        }
        catch (Exception e){
            return null;
        }
    }

    public ProductDto removeNoneDelete(Long id){
       try {
           Optional<Product> pr  = productRepository.findById(id);
           pr.get().setProductStatus(false);
           productRepository.save(pr.get());
           return findById(id);
       }
       catch (Exception e){
           return null;
       }
    }

    public ProductDto delete(Long id){
        try {
            ProductDto product = findById(id);
            productRepository.deleteById(id);
            return product;
        }
        catch (Exception e){
            return null;
        }
    }
}
