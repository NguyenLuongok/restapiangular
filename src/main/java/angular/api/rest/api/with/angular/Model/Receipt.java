package angular.api.rest.api.with.angular.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Receipt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId;
    private String codeOrders;
    private String receiptName;
    private String receiptEmail;
    private String receiptAddress;
    private String receiptPhone;
    private Timestamp receiptDate;
    private boolean receiptStatus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiptId")
    private List<ReceiptItem> receiptItems;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", codeOrders='" + codeOrders + '\'' +
                ", receiptName='" + receiptName + '\'' +
                ", receiptEmail='" + receiptEmail + '\'' +
                ", receiptAddress='" + receiptAddress + '\'' +
                ", receiptPhone='" + receiptPhone + '\'' +
                ", receiptDate=" + receiptDate +
                ", receiptStatus=" + receiptStatus +
                '}';
    }

    public Receipt() {
    }

    public Receipt(Long receiptId,String receiptName, String receiptEmail, String receiptAddress, String receiptPhone, Timestamp receiptDate,boolean receiptStatus,String codeOrders,User user) {
            this.receiptId = receiptId;
            this.receiptName = receiptName;
            this.receiptEmail = receiptEmail;
            this.receiptAddress = receiptAddress;
            this.receiptPhone = receiptPhone;
            this.receiptDate = receiptDate;
            this.receiptStatus = receiptStatus;
            this.codeOrders = codeOrders;
            this.user = user;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
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

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public String getCodeOrders() {
        return codeOrders;
    }

    public void setCodeOrders(String codeOrders) {
        this.codeOrders = codeOrders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
