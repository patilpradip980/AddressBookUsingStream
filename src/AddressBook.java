import java.io.IOException;
import java.util.Scanner;

public class AddressBook extends AddressBookManager {
    public static void main(String[] args) throws IOException {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("AddressBook By Using Java 8 Stream ");
        System.out.println("1) Create Book \n" + "2) Add Person \n" + "3) Save Person \n" +
                "4) Edit Person \n" + "5) Delete Person \n" + "6) Sort ByZip \n" +
                "7) Sort ByName \n" + "8) Display \n" + "9) Search Person \n" + "10) Show Books \n");

        int ch2 = scanner.nextInt();
        switch (ch2) {
            case 1:
                addressBook.createBook();
                break;
            default:
                System.out.println("Please enter correct choice");

        }
    }
}
