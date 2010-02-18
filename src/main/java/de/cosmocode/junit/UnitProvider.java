package de.cosmocode.junit;

/**
 * Provides the unit under testing.
 *
 * @author Willi Schoenborn
 * @param <T>
 */
public interface UnitProvider<T> {

    /**
     * Provides the unit under testing.
     * 
     * @return a new unit
     */
    T unit();
    
}
