package seedu.addressbook.data.person;

/**
 * Represents the street in a Person's address in the address book.
 * Guarantees: immutable
 */
public class Street {
    
    private final String value;

    /**
     * Initializes street component of Address
     */
    public Street(String value) {
        this.value = value;
    }
    
    /**
     * Returns the stored value of street
     * @return Street as a String
     */
    public String getValue() {
        return value;
    }
    
}
