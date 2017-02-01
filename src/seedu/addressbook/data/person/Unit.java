package seedu.addressbook.data.person;

/**
 * Represents the unit number in a Person's address in the address book.
 * Guarantees: immutable
 */
public class Unit {
    
    private final String value;

    /**
     * Initializes unit number component of Address
     */
    public Unit(String value) {
        this.value = value;
    }
    
    /**
     * Returns the stored value of unit number
     * @return Unit Number as a String
     */
    public String getValue() {
        return value;
    }
    
}
