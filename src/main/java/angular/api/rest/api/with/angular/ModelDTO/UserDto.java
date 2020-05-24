package angular.api.rest.api.with.angular.ModelDTO;

public class UserDto {
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean status;
    private String typeValue;

    public UserDto() {
    }

    public UserDto(Long userId,String userName, String email, String password, String phone, String address, boolean status, String typeValue) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.typeValue = typeValue;
    }

    public UserDto(String userName, String email, String password, String phone, String address, boolean status, String typeValue) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.typeValue = typeValue;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
