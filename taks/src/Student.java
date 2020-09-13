import java.util.Objects;
import java.util.Random;

/**
 * A student class
 *
 * @author Jeremie Guerchon
 */

public class Student {

    private String fName;
    private String lName;
    private int age;
    private Adress addr;
    private String email;

    /**
     * Our default constructor for Student.
     */

    public Student() {
        this.fName = "XXXX";
        this.lName = "XXXX";
        this.age = 0;
        this.email = "xxx@email.com";

    }

    /**
     * A constructor with only fName and lName as its parameters
     *
     * @param fName First name input
     * @param lName Last name input
     */

    public Student(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.email = generateEmail();
    }

    /**
     * A constructor with 4 parameters.
     *
     * @param fName First name input
     * @param lName Last name input
     * @param age   Age input
     * @param addr  Address input
     */

    public Student(String fName, String lName, int age, Adress addr) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.addr = addr;
        this.email = generateEmail();
    }

    /**
     * A constructor with all variables.
     *
     * @param fName First name input
     * @param lName Last name input
     * @param age   Age input
     * @param addr  Address input
     * @param email Email input
     */

    public Student(String fName, String lName, int age, Adress addr, String email) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.addr = addr;
        this.email = email;
    }

    /**
     * A method that will generate an email for the user.
     *
     * @return A generated email.
     */

    public String generateEmail() {
        String emailEnd = "@vaniercollege.qc.ca";
        String fNameL = fName.substring(0, 1);
        Random rand = new Random();
        int numbs = rand.nextInt(9000) + 1000;

        return lName + fNameL + numbs + emailEnd;
    }

    /**
     * A method that will check if the age input is valid.
     *
     * @param age Age input
     * @return true/false if the Age input is valid or not.
     */

    public boolean isAgeValid(int age) {
        if (age >= 0 && age <= 120) {
            return true;
        }
        return false;
    }

    /**
     * A method to check if both First name and Last name are valid.
     * #param fName first name input
     *
     * @param lName second name input
     * @return true or false if the full name is valid or not.
     */

    public boolean isNameValid(String fName, String lName) {
        boolean confirm1 = false;
        boolean confirm2 = false;

        for (int i = 0; i < fName.length(); i++) {
            if (Character.isLetter(fName.charAt(i)) || Character.isWhitespace(fName.charAt(i))
                    || fName.charAt(i) == '-') {
                confirm1 = true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < lName.length(); i++) {
            if (Character.isLetter(lName.charAt(i)) || Character.isWhitespace(lName.charAt(i))
                    || lName.charAt(i) == '-') {
                confirm2 = true;
            } else {
                return false;
            }
        }

        return confirm1 && confirm2;
    }

    @Override
    public String toString() {
        return String.format("%-10s%s\n%-10s%d\n%-1s%s\n%-10s%s",
                "Name:", fName + " " + lName, "Age:", age, "Address:\n", addr, "Email:", email);
    }

    public boolean equals(Student stu) {
        return age == stu.age &&
                Objects.equals(fName, stu.fName) &&
                Objects.equals(lName, stu.lName) &&
                Objects.equals(addr, stu.addr) &&
                Objects.equals(email, stu.email);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        if (isNameValid(fName, lName))
            this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        if (isNameValid(lName, fName))
            this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (isAgeValid(age))
            this.age = age;
    }

    public Adress getAddr() {
        return addr;
    }

    public void setAddr(Adress addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
