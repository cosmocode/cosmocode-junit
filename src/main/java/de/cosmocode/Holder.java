package de.cosmocode;


/**
 * A mutable helper class which allows to store a
 * value of generic type.
 * 
 * <p>
 *   It's used in cases where anonymous inner classes
 *   have to access outer variables, which must be final
 *   and are therefore immutable (in case of primitives).
 * </p>
 *
 * @author Willi Schoenborn <schoenborn@cosmocode.de>
 * @param <T> the type an instance of this class is able to hold a value from
 */
public final class Holder<T> {

    private T value;
    
    private Holder(T value) {
        this.value = value;
    }

    /**
     * Sets the value.
     * 
     * @param newValue the new value
     * @throws NullPointerException if newValue is null
     */
    public void set(T newValue) {
        if (newValue == null) throw new NullPointerException("Value must not be null");
        this.value = newValue;
    }
    
    /**
     * Returns the current value.
     * 
     * @return the current value
     */
    public T get() {
        return value;
    }
    
    /**
     * Creates a new {@link Holder} and
     * initialises the inner value with the given one.
     * 
     * @param <T> the type an instance of this class is able to hold a value from
     * @param value the start value
     * @return a new {@link Holder} instance initialized with the given value
     * @throws NullPointerException if value is null
     */
    public static <T> Holder<T> of(T value) {
        if (value == null) throw new NullPointerException("Value must not be null");
        return new Holder<T>(value);
    }
    
}
