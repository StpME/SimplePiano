//---------------------------------------------------------------------------------
//DO NOT MODIFY!!!
//---------------------------------------------------------------------------------

package examples;

/**
 * The SortingGame interface includes behavior related to tracking the
 * player's progress in the game.  Your SelectionSorter class will
 * implement this interface for the final submission of your Sort Zapper
 * project.
 *
 */

public interface SortingGame 
{
	/**
	 * Returns the object used to keep track of the player's score.
	 * @return The object used to keep track of the player's score.
	 */
	public NumberKeeper getScoreKeeper();
}
