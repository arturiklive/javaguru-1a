package model;

public class ShopUser {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    public ShopUser(String name, String lastName, String email, String password, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
