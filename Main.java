import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageCustomers manageCustomers = new ManageCustomers();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Meniu Gestiune Clienti ---");
            System.out.println("1. Adauga client");
            System.out.println("2. Sterge client");
            System.out.println("3. Afiseaza lista de clienti");
            System.out.println("4. Iesire");
            System.out.print("Alege o optiune: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumă newline lăsat de nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Introduceti numele: ");
                    String name = scanner.nextLine();

                    System.out.print("Introduceti adresa de email: ");
                    String email = scanner.nextLine();
                    if (!manageCustomers.validateEmail(email)) {
                        System.out.println("Adresa de email este invalida! Clientul nu a fost adaugat.");
                        break;
                    }

                    System.out.print("Introduceti numarul cartii de credit: ");
                    String creditCardNumber = scanner.nextLine();
                    String encryptedCreditCardNumber = manageCustomers.encryptCreditCardNumber(creditCardNumber);

                    Customer customer = new Customer(name, email, encryptedCreditCardNumber);
                    manageCustomers.addCustomer(customer);
                    System.out.println("Client adaugat cu succes!");
                    break;
                case 2:
                    System.out.print("Introduceti adresa de email a clientului de sters: ");
                    String emailToDelete = scanner.nextLine();
                    manageCustomers.removeCustomer(emailToDelete);
                    System.out.println("Client sters cu succes!");
                    break;
                case 3:
                    System.out.println("\n--- Lista Clienti ---");
                    manageCustomers.displayCustomers();
                    break;
                case 4:
                    System.out.println("Iesire...");
                    break;
                default:
                    System.out.println("Optiune invalida! Va rugam incercati din nou.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}