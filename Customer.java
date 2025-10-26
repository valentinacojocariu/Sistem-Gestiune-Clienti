public class Customer {
    private String name;
    private String email;
    private String creditCardNumber;

    public Customer(String name, String email, String creditCardNumber) {
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

@Override
    public String toString() {

        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                '}';
    }
} 