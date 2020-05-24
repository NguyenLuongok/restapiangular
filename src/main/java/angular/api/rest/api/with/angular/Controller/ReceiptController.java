package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.ModelDTO.ReceiptDto;
import angular.api.rest.api.with.angular.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receipt/")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/")
    public List<ReceiptDto> getAll(){
        return receiptService.findAll();
    }

    @GetMapping("/{id}")
    public List<ReceiptDto> getAll(@PathVariable("id") Long id){
        return receiptService.findAllByUserId(id);
    }

    @PostMapping("/")
    public ReceiptDto save(@RequestBody ReceiptDto receiptDto){
        return receiptService.save(receiptDto);
    }

    @PutMapping("/{id}")
    public ReceiptDto update(@PathVariable Long id){
        return  receiptService.update(id);
    }
}
