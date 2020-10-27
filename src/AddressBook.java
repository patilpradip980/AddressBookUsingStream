import java.io.IOException;
import java.util.*;

public class AddressBook extends AddressBookManager {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = null, key = null;
        AddressBook addressBook = new AddressBook();
        System.out.println("AddressBook By Using Java 8 Stream ");
        while (true) {
            System.out.println("1) Create Book \n" + "2) Add Person \n" + "3) Search Person \n" +
                    "4) Edit Person \n" + "5) Delete Person \n" + "6) Sort Data \n" +
                    "7) Sort ByName \n" + "8) Display \n");

            int ch2 = scanner.nextInt();
            switch (ch2) {
                case 1:
                    addressBook.createBook();
                    break;
                case 2:
                    addressBook.addPerson();
                    break;
                case 3:
                    addressBook.searchperson();
                    break;
                case 4:
                    addressBook.editPerson();
                    break;
                case 5:
                    addressBook.deletePerson();
                    break;
                case 6:
                    addressBook.sortData();
                    break;
                case 7:
                    addressBook.sortByName();
                    break;
                case 8:
                    addressBook.Display();
                    break;
                default:
                    System.out.println("Please enter correct choice");

            }
        }
    }
}
