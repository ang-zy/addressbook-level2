package seedu.addressbook.data.person;

/**
 * Represents the postal code in a Person's address in the address book.
 * Guarantees: immutable
 */
public class PostalCode {
    
    private final String value;

    /**
     * Initializes postal code component of Address
     */
    public PostalCode(String value) {
        this.value = value;
    }
    
    /**
     * Returns the stored value of postal code
     * @return Block Number as a String
     */
    public String getValue() {
        return value;
    }
    
}
