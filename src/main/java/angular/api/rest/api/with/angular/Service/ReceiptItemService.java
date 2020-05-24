package angular.api.rest.api.with.angular.Service;

import angular.api.rest.api.with.angular.Model.Product;
import angular.api.rest.api.with.angular.Model.Receipt;
import angular.api.rest.api.with.angular.Model.ReceiptItem;
import angular.api.rest.api.with.angular.ModelDTO.ReceiptItemDto;
import angular.api.rest.api.with.angular.Repository.ProductRepository;
import angular.api.rest.api.with.angular.Repository.ReceiptItemRepository;
import angular.api.rest.api.with.angular.Repository.ReceiptRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReceiptItemRepository receiptItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    public List<ReceiptItemDto> findAllByReceiptId(Long id){
        List<ReceiptItem>  receiptItems = receiptItemRepository.findAllByReceiptId(id);
        List<ReceiptItemDto> receiptItemDtos = new ArrayList<>();
        for(ReceiptItem receiptItem : receiptItems){
            Optional<Product> product = productRepository.findById(receiptItem.getProduct().getProductId());
            receiptItemDtos.add(new ReceiptItemDto(receiptItem.getReceiptItemId(),receiptItem.getReceiptItemTotal(),receiptItem.getReceiptItemPrice(),
                    receiptItem.getReceiptItemSale(),receiptItem.isReceiptItemStatus(),product.get().getProductName(),product.get().getProductImages(),product.get().getProductSale()
            ,receiptItem.getProduct().getProductId(),receiptItem.getReceipt().getReceiptId()));
        }
        Type listType = new TypeToken<List<ReceiptItemDto>>(){}.getType();
        List<ReceiptItemDto> reIt = modelMapper.map(receiptItemDtos,listType);
        return reIt;
    }

    public List<ReceiptItemDto> saveAll(List<ReceiptItemDto> receiptItemDto,String code){
        Product product = null;
        Receipt receipt  = receiptRepository.findByCodeOrders(code);
       for(ReceiptItemDto re : receiptItemDto){
           product = productRepository.findById(re.getProductId()).get();
           product.setProductTotal(product.getProductTotal()-re.getReceiptItemTotal());
           ReceiptItem receiptItem  = modelMapper.map(new ReceiptItem(product,receipt,re.getReceiptItemPrice(),re.getReceiptItemSale(),re.getReceiptItemTotal(),true),ReceiptItem.class);
           receiptItemRepository.save(receiptItem);
       }
           return findAllByReceiptId(receipt.getReceiptId());
    }
}
