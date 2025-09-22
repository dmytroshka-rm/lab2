package patientpackage;
public class Patient {
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String address;
    private String number;
    private int numMedCard;
    private String diagnos;

    public Patient(int id, String firstName, String secondName, String lastName, String address, String number, int numMedCard, String diagnos) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
        this.numMedCard = numMedCard;
        this.diagnos = diagnos;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getNumber() {
        return number;
    }
    public int getNumMedCard() {
        return numMedCard;
    }
    public String getDiagnos() {
        return diagnos;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setNumMedCard(int numMedCard) {
        this.numMedCard = numMedCard;
    }
    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }
    public boolean firstNumPhone(char sumbol) {
        return number.charAt(0) == sumbol;
    }
    public boolean interval(int a, int b) {
        return numMedCard >= a && numMedCard <= b;
    }
    public boolean TrueDisgnos(String diag) {
        return diagnos.equalsIgnoreCase(diag);
    }

    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", numMedCard=" + numMedCard +
                ", diagnos='" + diagnos + '\'' +
                '}';
    }
}

