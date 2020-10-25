import java.io.IOException;
import java.util.*;

public class AddressBook extends AddressBookManager {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = null, key = null;
        HashMap<String, ArrayList<Person>> arrayListHashMap = new HashMap<>(100);
        ArrayList<Person> arrayList = new ArrayList<Person>(100);

        AddressBook addressBook = new AddressBook();
        System.out.println("AddressBook By Using Java 8 Stream ");
        while (true) {
            System.out.println("1) Create Book \n" + "2) Add Person \n" + "3) Save Person \n" +
                    "4) Edit Person \n" + "5) Delete Person \n" + "6) Sort ByZip \n" +
                    "7) Sort ByName \n" + "8) Display \n" + "9) Search Person \n" + "10) Show Books \n");

            int ch2 = scanner.nextInt();
            switch (ch2) {
                case 1:
                    fileName = addressBook.createBook();
                    break;
                case 2:
                    arrayListHashMap = addressBook.addPerson(fileName);
                    Iterator it = arrayListHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        key = (String) pair.getKey();
                        arrayList = (ArrayList<Person>) pair.getValue();
                    }
                    break;
                case 3:
                    addressBook.saveData(key, arrayList);
                    break;
                case 4:
                    addressBook.editPerson(fileName);
                    break;
                case 5:
                    addressBook.deletePerson(fileName);
                    break;
                default:
                    System.out.println("Please enter correct choice");

            }
        }
    }
}
