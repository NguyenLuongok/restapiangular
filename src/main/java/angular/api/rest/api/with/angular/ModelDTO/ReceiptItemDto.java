package angular.api.rest.api.with.angular.ModelDTO;


public class ReceiptItemDto {

    private Long receiptItemId;
    private int receiptItemTotal;
    private double receiptItemPrice;
    private int receiptItemSale;
    private boolean receiptItemStatus;
    private Long productId;
    private String productName;
    private double productPrice;
    private String productImage;
    private int productTotal;
    private int productSale;
    private Long receiptId;

    public ReceiptItemDto(Long receiptItemId, int receiptItemTotal, double receiptItemPrice, int receiptItemSale, boolean receiptItemStatus
    ,String productName, String productImage,int productSale,Long productId,Long receiptId) {
        this.receiptItemId = receiptItemId;
        this.receiptItemTotal = receiptItemTotal;
        this.receiptItemPrice = receiptItemPrice;
        this.receiptItemSale = receiptItemSale;
        this.receiptItemStatus = receiptItemStatus;
        this.productName = productName;
        this.productImage = productImage;
        this.productSale = productSale;
        this.productId = productId;
        this.receiptId = receiptId;
    }

    public Long getReceiptItemId() {
        return receiptItemId;
    }

    public void setReceiptItemId(Long receiptItemId) {
        this.receiptItemId = receiptItemId;
    }

    public int getReceiptItemTotal() {
        return receiptItemTotal;
    }

    public void setReceiptItemTotal(int receiptItemTotal) {
        this.receiptItemTotal = receiptItemTotal;
    }

    public double getReceiptItemPrice() {
        return receiptItemPrice;
    }

    public void setReceiptItemPrice(double receiptItemPrice) {
        this.receiptItemPrice = receiptItemPrice;
    }

    public int getReceiptItemSale() {
        return receiptItemSale;
    }

    public void setReceiptItemSale(int receiptItemSale) {
        this.receiptItemSale = receiptItemSale;
    }

    public boolean isReceiptItemStatus() {
        return receiptItemStatus;
    }

    public void setReceiptItemStatus(boolean receiptItemStatus) {
        this.receiptItemStatus = receiptItemStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductSale() {
        return productSale;
    }

    public void setProductSale(int productSale) {
        this.productSale = productSale;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }
}
