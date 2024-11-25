package vn.iostar.SpringSer;

public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor private để ngăn tạo đối tượng trực tiếp
    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Builder class
    public static class Builder {
        private String id;
        private String name;
        private String phoneNumber;
        private String email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
