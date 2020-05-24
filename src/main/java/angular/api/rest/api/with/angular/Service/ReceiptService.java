package angular.api.rest.api.with.angular.Service;

import angular.api.rest.api.with.angular.Model.Receipt;
import angular.api.rest.api.with.angular.Model.User;
import angular.api.rest.api.with.angular.ModelDTO.ProductDto;
import angular.api.rest.api.with.angular.ModelDTO.ReceiptDto;
import angular.api.rest.api.with.angular.ModelDTO.ReceiptItemDto;
import angular.api.rest.api.with.angular.Repository.ReceiptRepository;
import angular.api.rest.api.with.angular.Repository.ReceiptRepositoryExample;
import angular.api.rest.api.with.angular.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReceiptItemService receiptItemService;

    @Autowired
    private ReceiptRepositoryExample repositoryExample;


    public List<ReceiptDto> findAll(){
        try{
            List<Receipt> receipts = receiptRepository.findAll();
            List<ReceiptDto> receiptDtos = new ArrayList<>();
            for(Receipt receipt :receipts ){
                if(receipt.getUser() != null){
                    receiptDtos.add(new ReceiptDto(receipt.getReceiptId(),receipt.getCodeOrders(),receipt.getReceiptName(),receipt.getReceiptEmail(),receipt.getReceiptAddress(),
                            receipt.getReceiptPhone(), receipt.getReceiptDate(),receipt.isReceiptStatus(), receipt.getUser().getUserId()));
                }
                else {
                    receiptDtos.add(new ReceiptDto(receipt.getReceiptId(),receipt.getCodeOrders(),receipt.getReceiptName(),receipt.getReceiptEmail(),receipt.getReceiptAddress(),
                            receipt.getReceiptPhone(), receipt.getReceiptDate(),receipt.isReceiptStatus(),null));
                }

            }

            Type listType = new TypeToken<List<ReceiptDto>>(){}.getType();
            List<ReceiptDto> re = modelMapper.map(receiptDtos,listType);
            return re;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<ReceiptDto> findAllByUserId(Long id){
        try{
            List<Receipt> receipts = receiptRepository.findAllByUserId(id);
            List<ReceiptDto> receiptDtos = new ArrayList<>();
            for(Receipt receipt :receipts ){
                if(receipt.getUser() != null){
                    receiptDtos.add(new ReceiptDto(receipt.getReceiptId(),receipt.getCodeOrders(),receipt.getReceiptName(),receipt.getReceiptEmail(),receipt.getReceiptAddress(),
                            receipt.getReceiptPhone(), receipt.getReceiptDate(),receipt.isReceiptStatus(), receipt.getUser().getUserId()));
                }
                else {
                    receiptDtos.add(new ReceiptDto(receipt.getReceiptId(),receipt.getCodeOrders(),receipt.getReceiptName(),receipt.getReceiptEmail(),receipt.getReceiptAddress(),
                            receipt.getReceiptPhone(), receipt.getReceiptDate(),receipt.isReceiptStatus(),null));
                }

            }

            Type listType = new TypeToken<List<ReceiptDto>>(){}.getType();
            List<ReceiptDto> re = modelMapper.map(receiptDtos,listType);
            return re;
        }
        catch (Exception e){
            return null;
        }
    }

    public ReceiptDto findById(Long id){
        try{
            Optional<Receipt> receipt  =receiptRepository.findById(id);
            Receipt receipt1 = receipt.get();
            ReceiptDto receiptDto = modelMapper.map(new ReceiptDto(receipt1.getReceiptId(),receipt1.getCodeOrders(),receipt1.getReceiptName(),receipt1.getReceiptEmail(),receipt1.getReceiptAddress(),
                    receipt1.getReceiptPhone(),receipt1.getReceiptDate(),receipt1.isReceiptStatus(),receipt1.getUser().getUserId()), ReceiptDto.class);
            return receiptDto;
        }
        catch (Exception e){
            return null;
        }
    }

    public ReceiptDto save(ReceiptDto receiptDto){
        try{
            User user  = userRepository.findByEmail(receiptDto.getReceiptEmail());
            Timestamp timestamp = new Timestamp(new Date().getTime());
            Receipt receipt = null;
            if(user != null){
                 receipt  = modelMapper.map(new Receipt(null,receiptDto.getReceiptName(),receiptDto.getReceiptEmail(),receiptDto.getReceiptAddress(),
                        receiptDto.getReceiptPhone(),timestamp,true,receiptDto.getCodeOrders(),user),Receipt.class);
            }
            else {
                receipt  = modelMapper.map(new Receipt(null,receiptDto.getReceiptName(),receiptDto.getReceiptEmail(),receiptDto.getReceiptAddress(),
                        receiptDto.getReceiptPhone(),timestamp,true,receiptDto.getCodeOrders(),null),Receipt.class);
            }
            repositoryExample.save(receipt);
            return receiptDto;
        }
        catch (Exception e){
            return null;
        }
    }

    public ReceiptDto update(Long id){
        try{
            Optional<Receipt> re = receiptRepository.findById(id);
            re.get().setReceiptStatus(false);
            receiptRepository.save(re.get());
            return findById(id);
        }
        catch (Exception e){
            return null;
        }
    }
}
