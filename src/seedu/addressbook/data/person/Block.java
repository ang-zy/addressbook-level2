package seedu.addressbook.data.person;

/**
 * Represents the block number in a Person's address in the address book.
 * Guarantees: immutable
 */
public class Block {
    
    private final String value;

    /**
     * Initializes block number component of Address
     */
    public Block(String value) {
        this.value = value;
    }
    
    /**
     * Returns the stored value of block number
     * @return Block Number as a String
     */
    public String getValue() {
        return value;
    }
    
}
