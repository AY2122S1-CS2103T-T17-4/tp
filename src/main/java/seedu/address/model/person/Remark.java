package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Remark for a Person in the address book.
 */
public class Remark {
    public final String value;

    /**
     * Constructs a Remark object with a String.
     *
     * @param remark String to be added as the Remark for the person.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
