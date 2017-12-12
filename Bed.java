/* Filename:        Bed.java
 * Date:            2017-12-12
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * Room is a class used to hold the type of a bed as a
 * string.
 * -------------------------------------------------------
 */

public class Bed {                              // Class of type bed

    private String bedType = "Empty";           // Field containing the type of bed as a string

    public Bed(String bedType) {                // Constructor used when making bed objects
        this.bedType = bedType;
    }

    public String getBedType() {                // Method used to access the current bed type
        return bedType;
    }

    public void setBedType(String bedType) {    // Method used to set the current bed type
        this.bedType = bedType;
    }
}
