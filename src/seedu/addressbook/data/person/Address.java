package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_PREFIX = "a/";

    private final Block blockNumber;
    private final Street streetName;
    private final Unit unitNumber;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressValues=removePrefix(trimmedAddress, ADDRESS_PREFIX).split(",", 4);

        if (addressValues.length>=1){
            blockNumber = new Block(addressValues[0].trim());
        } else {
            blockNumber = null;
        }
        
        if (addressValues.length>=2){
            streetName = new Street(addressValues[1].trim());
        } else {
            streetName = null;
        }
        
        if (addressValues.length>=3){
            unitNumber = new Unit(addressValues[2].trim());
        } else {
            unitNumber = null;
        }
        
        if (addressValues.length>=4){
            postalCode = new PostalCode(addressValues[3].trim());
        } else {
            postalCode = null;
        }
    }

    /**
     * Removes the prefix ("a/") from the front of the parameter
     * @param Address to be parsed
     */
    private String removePrefix(String address, String prefix) {
        if (address.startsWith(prefix)) {
            return address.substring(prefix.length());
        } else {
            return address;
        }
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Returns the stored address as a String with prefix
     * @return Address with prefix as a String
     */
    public String getValue() {
        return combineAddress();
    }
    
    /**
     * Combines block, street, unit and postal code into address, and returns it
     * @return Combined address as a String
     */
    private String combineAddress(){
        String result = "";
        if (blockNumber != null) {
            result += blockNumber.getValue();
        }
        if (streetName != null) {
            result += ", " + streetName.getValue();
        }
        if (unitNumber != null) {
            result += ", " + unitNumber.getValue();
        }
        if (postalCode != null) {
            result += ", " + postalCode.getValue();
        }
        return result;
    }
}
