import java.util.*;
import java.io.*;

public class AddressBookManager {
    Scanner scanner = new Scanner(System.in);
    public String fileName;
    public File file;
    public String path = "C:\\csv\\";
    public BufferedWriter bufferedWriter;
    public FileWriter fileWriter;
    public FileReader fileReader;
    public BufferedReader bufferedReader;
    public String str;
    public String num, find;
    public int flag = 0;
    String firstName;
    String lastName;
    String city;
    String state;
    int zipCode;
    String phoneNumber;
    public ArrayList<Person> arrayList = new ArrayList<Person>(100);
    public HashMap<String, ArrayList<Person>> hashMap = new HashMap<>(100);

    public String createBook() throws IOException {
        System.out.print("Enter the desired name of your Book : ");
        fileName = scanner.next();
        file = new File(path + fileName + ".csv");
        file.createNewFile();
        fileWriter = new FileWriter(file, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("FirstName");
        bufferedWriter.write(",Lastname");
        bufferedWriter.write(",City");
        bufferedWriter.write(",State");
        bufferedWriter.write(",Zipcode");
        bufferedWriter.write(",Phonenumber");
        bufferedWriter.newLine();
        System.out.println("Address Book Created ");
        bufferedWriter.close();
        fileWriter.close();
        return fileName;
    }

    public HashMap<String, ArrayList<Person>> addPerson(String fileName) {
        System.out.println("Enter First Name :");
        firstName = scanner.next();
        System.out.println("Enter Last Name :");
        lastName = scanner.next();
        System.out.println("Enter City :");
        city = scanner.next();
        System.out.println("Enter State :");
        state = scanner.next();
        System.out.println("Enter Zip Code :");
        zipCode = scanner.nextInt();
        System.out.println("Enter Phone Number :");
        phoneNumber = scanner.next();
        arrayList.add(new Person(firstName + ",", lastName + ",", city + ",", state + ",", zipCode, "," + phoneNumber));
        hashMap.put(fileName, arrayList);
        System.out.println("Please save Data in AddressBook " + fileName + " By save data option");
        return hashMap;
    }

    public void saveData(String key, ArrayList<Person> personArrayList) throws IOException {
        fileWriter = new FileWriter(path + key + ".csv", true);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (int J = 0; J < personArrayList.size(); J++) {
            bufferedWriter.write(personArrayList.get(J).toString() + "\n");
            System.out.println(" Data Saved in AddressBook :" + key + ".csv");
        }
        bufferedWriter.close();
        fileWriter.close();
    }



}

