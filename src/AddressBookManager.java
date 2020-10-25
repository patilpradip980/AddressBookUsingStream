import java.util.*;
import java.io.*;

public class AddressBookManager {
    Scanner scanner = new Scanner(System.in);
    public String fileName;
    public File file;
    public String path = "C:\\csv\\";
    public BufferedWriter bufferedWriter;
    public FileWriter fileWriter;

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
}
