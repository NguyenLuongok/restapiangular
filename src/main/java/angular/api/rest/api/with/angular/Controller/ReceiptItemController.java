package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.ModelDTO.ReceiptItemDto;
import angular.api.rest.api.with.angular.Service.ReceiptItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receiptItem/")
public class ReceiptItemController {

    @Autowired
    private ReceiptItemService receiptItemService;

    @GetMapping("/{id}")
    public List<ReceiptItemDto> findAllByReceiptId(@PathVariable Long id){
        return  receiptItemService.findAllByReceiptId(id);
    }

    @PostMapping("/{code}")
    public List<ReceiptItemDto> save(@RequestBody List<ReceiptItemDto> receiptItemDto, @PathVariable String code){
        return  receiptItemService.saveAll(receiptItemDto,code);
    }
}
