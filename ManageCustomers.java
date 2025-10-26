import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ManageCustomers {
    private List<Customer> customers;

    public ManageCustomers() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(String email) {
        customers.removeIf(customer -> customer.getEmail().equals(email));
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Lista de clienti este goala.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public String encryptCreditCardNumber(String creditCardNumber) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : creditCardNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                char encryptedChar = (char) ('0' + (c - '0' + 5) % 10);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public String decryptCreditCardNumber(String encryptedCreditCardNumber) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedCreditCardNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                char decryptedChar = (char) ('0' + (c - '0' + 5) % 10);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}