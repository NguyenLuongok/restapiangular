package angular.api.rest.api.with.angular.ModelDTO;



import java.sql.Timestamp;

public class ReceiptDto {
    private Long receiptId;
    private String codeOrders;
    private String receiptName;
    private String receiptEmail;
    private String receiptAddress;
    private String receiptPhone;
    private Timestamp receiptDate;
    private boolean receiptStatus;
    private Long userId;

    public ReceiptDto(Long receiptId, String codeOrders,String receiptName, String receiptEmail, String receiptAddress, String receiptPhone, Timestamp receiptDate, boolean receiptStatus,Long userId) {
        this.receiptId = receiptId;
        this.codeOrders = codeOrders;
        this.receiptName = receiptName;
        this.receiptEmail = receiptEmail;
        this.receiptAddress = receiptAddress;
        this.receiptPhone = receiptPhone;
        this.receiptDate = receiptDate;
        this.receiptStatus = receiptStatus;
        this.userId = userId;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getCodeOrders() {
        return codeOrders;
    }

    public void setCodeOrders(String codeOrders) {
        this.codeOrders = codeOrders;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }

    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
    }

    public boolean isReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(boolean receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

