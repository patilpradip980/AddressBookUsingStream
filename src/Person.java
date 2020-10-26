public class Person {
    String firstName;
    String lastName;
    String city;

    @Override
    public String toString() {
        return "" + firstName + "" + lastName + "" + city + "" + state + "" + zipCode + "" + phoneNumber;
    }

    String state;
    int zipCode;
    String phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Person(String firstname, String lastname, String city, String state, int zipcode, String phonenumber) {
        super();
        this.firstName = firstname;
        this.lastName = lastname;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
        this.phoneNumber = phonenumber;

    }
}
