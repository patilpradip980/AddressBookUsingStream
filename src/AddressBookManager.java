import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (file.isFile()) {
            System.out.println("Book with Name " + fileName + " already Created");
        } else {
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
        }
        return fileName;
    }

    public HashMap<String, ArrayList<Person>> addPerson() throws IOException {
        fileName = AccessBook();
        System.out.println("How many data do you want to save in AddressBook :" + fileName);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
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
        }
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


    public String editPerson() throws FileNotFoundException, IOException {
        fileName = AccessBook();
        System.out.println("Enter Name for edit person data\n");
        String lineToFind = scanner.next();
        File inFile = new File((path + fileName + ".csv"));
        File tempFile = new File(path + fileName + ".tmp");
        bufferedReader = new BufferedReader(new FileReader(inFile));
        bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().contains(lineToFind)) {
                System.out.println("Data found for given Name \n" + line);
                String[] personDetail = line.split(",");
                String firstName = personDetail[0];
                String lastName = personDetail[1];
                System.out.println("enter the new city");
                String city = scanner.next();
                System.out.println("enter the new State");
                String state = scanner.next();
                System.out.println("enter the new Zipcode");
                int zipCode = scanner.nextInt();
                phoneNumber = personDetail[5];
                bufferedWriter.write(firstName);
                bufferedWriter.write("," + lastName);
                bufferedWriter.write("," + city);
                bufferedWriter.write("," + state);
                bufferedWriter.write("," + zipCode);
                bufferedWriter.write("," + phoneNumber);
                bufferedWriter.newLine();
                flag++;
            } else {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        }
        bufferedWriter.close();
        bufferedReader.close();
        inFile.delete();
        tempFile.renameTo(inFile);
        if (flag == 0) {
            System.out.println("Data not found in AddressBook :" + fileName);
        } else {
            System.out.println("Data Modified Successfully.....");
        }
        return null;
    }

    public void deletePerson() throws IOException {
        fileName = AccessBook();
        System.out.println("Enter Name for Delete Data ");
        String lineToRemove = scanner.next();
        File inFile = new File((path + fileName + ".csv"));
        File tempFile = new File(path + fileName + ".tmp");
        bufferedReader = new BufferedReader(new FileReader(inFile));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().contains(lineToRemove)) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        bufferedReader.close();
        inFile.delete();
        System.out.println("Data deleted From AddressBook");
        tempFile.renameTo(inFile);
        System.out.println(" ");
    }

    public String AccessBook() {
        System.out.println("AddressBooks :---- \n");
        File file = new File(path);
        String[] list = file.list();
        for (String list1 : list) {
            System.out.println(list1);
        }
        System.out.println("======================");
        System.out.println("In which AddressBook You want to Perform Operation\n");
        fileName = scanner.next();
        file = new File(path + fileName + ".csv");
        if (file.isFile()) {
            return fileName;
        } else
            return null;
    }

    public void searchperson() throws RuntimeException, FileNotFoundException, IOException {
        fileName = AccessBook();
        boolean temp = false;
        System.out.println("enter city and person name to search");
        System.out.println("Person name :-");
        String name = scanner.next();
        System.out.println("city name :-");
        String cityname = scanner.next();
        List<String> filteredLines = Files.lines(Paths.get(path + fileName + ".csv"))
                .filter(line -> line.contains(name) && line.contains(cityname)).collect(Collectors.toList());
        if (filteredLines.size() > 0) {
            System.out.println(filteredLines);
        } else {
            System.out.println("Data not found");
        }
    }

    public void Display() throws IOException, FileNotFoundException {
        fileName = AccessBook();
        System.out.println("Display data please select\n" + "1)Bycity \n" + "2)Bystate \n");
        int ch = scanner.nextInt();
        switch (ch) {
            case 1:
                System.out.println("enter city name to view data");
                String city = scanner.next();
                List<String> filteredLines = Files.lines(Paths.get(path + fileName + ".csv"))
                        .filter(line -> line.contains(city)).collect(Collectors.toList());
                if (filteredLines.size() > 0) {
                    for (int i = 0; i < filteredLines.size(); i++) {
                        System.out.println(filteredLines.get(i)+"\n");
                    }
                } else {
                    System.out.println("Data not found for given city");
                }
                break;
            case 2:
                System.out.println("enter state name to view data");
                String state = scanner.next();
                List<String> filteredLines2 = Files.lines(Paths.get(path + fileName + ".csv"))
                        .filter(line -> line.contains(state)).collect(Collectors.toList());
                if (filteredLines2.size() > 0) {
                    for (int i = 0; i < filteredLines2.size(); i++) {
                        System.out.println(filteredLines2.get(i)+"\n");
                    }
                } else {
                    System.out.println("Data not found for given state");
                }
        }
    }


}

