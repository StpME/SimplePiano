//---------------------------------------------------------------------------------
//DO NOT MODIFY!!!
//---------------------------------------------------------------------------------

package examples;

/**
 * The NumberKeeper interface keeps track of a single integer.  Your ScoreKeeper
 * class will implement this interface.
 *
 */

public interface NumberKeeper 
{
	/**
	 * Returns the integer this interface keeps track of.
	 * @return The integer this interface keeps track of
	 */
    int getValue();
    
    /**
     * Sets the integer this interface keeps track of.
     * @param newNumber The new integer this interface will keep track of.
     */
    void setValue(int newNumber);
}
