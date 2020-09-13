import java.util.Objects;

/**
 * An adress class
 *
 * @author Jeremie Guerchon
 */

public class Adress {

    private String city;
    private String street;
    private int streetNum;
    private String zipCode;

    /**
     * Constructor with 4 parameters.
     *
     * @param city      City input
     * @param street    Street input
     * @param streetNum Street Number input
     * @param zipCode   Zip Code input
     */

    public Adress(String city, String street, int streetNum, String zipCode) {
        this.city = city;
        this.street = street;
        this.streetNum = streetNum;
        this.zipCode = zipCode;
    }

    /**
     * Our default constructor.
     */

    public Adress() {
        this.city = "Unknown";
        this.street = "Unknown";
        this.streetNum = 100;
        this.zipCode = "Unkown";

    }

    /**
     * @param streetNum Street number input.
     * @return true/false if the Street Number input is valid.
     */

    public boolean isStreetNumValid(int streetNum) {
        if (this.streetNum >= 0 && this.streetNum <= 99999) {
            return true;
        }
        return false;
    }

    /**
     * @param city City input.
     * @return true/false if the City input is valid.
     */

    public boolean isCityValid(String city) {
        boolean confirm = false;

        for (int i = 0; i < city.length(); i++) {
            if (Character.isLetter(city.charAt(i)) || Character.isWhitespace(city.charAt(i))
                    || city.charAt(i) == '-') {
                confirm = true;
            } else {
                return false;
            }
        }
        return confirm;
    }

    /**
     * @param zipCode Zip Code input.
     * @return true/false if the Zip Code input is valid.
     */

    public boolean isZipCodeValid(String zipCode) {
        return (Character.isLetter(zipCode.charAt(0))
                && Character.isDigit(zipCode.charAt(1))
                && Character.isLetter(zipCode.charAt(2))
                && Character.isDigit(zipCode.charAt(3))
                && Character.isLetter(zipCode.charAt(4))
                && Character.isDigit(zipCode.charAt(5)))
                && zipCode.length() == 6;
    }


    /**
     * @param str String to put to capitalize.
     * @return The string with a capital on each word that are spaced out.
     */

    public String toTitleCase(String str) {
        String result = "";
        String[] splitString = str.split(" ");

        for (String word : splitString) {
            String fCap = word.substring(0, 1);
            String aCap = word.substring(1);
            result += fCap.toUpperCase() + aCap + " ";

        }

        return result.trim();
    }

    @Override
    public String toString() {
        return String.format("%-10s%s\n%-10s%s\n%-10s%s\n",
                "Street:", toTitleCase(this.street), "City:", toTitleCase(this.city), "Zip Code:", this.zipCode);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return streetNum == adress.streetNum &&
                Objects.equals(city, adress.city) &&
                Objects.equals(street, adress.street) &&
                Objects.equals(zipCode, adress.zipCode);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (isCityValid(city))
            this.city = toTitleCase(city);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        if (isStreetNumValid(this.streetNum))
            this.streetNum = streetNum;
    }


    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        if (isZipCodeValid(zipCode))
            this.zipCode = zipCode;
    }

}