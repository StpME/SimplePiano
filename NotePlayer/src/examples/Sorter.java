//---------------------------------------------------------------------------------
//DO NOT MODIFY!!!
//---------------------------------------------------------------------------------

package examples;

import java.awt.Color;
import java.util.Arrays;

/**
 * 
 * Super class for sorting letters visually in ObjectLand.  The swap
 * method animates moving the letters into place.  You will create a subclass
 * of this class for your Sort Zapper project.
 *
 */
public class Sorter
{
    private class Item
    {
        private String value;
        private boolean wasZapped;
        
        public Item(String valueP)
        {
            value = valueP;
            wasZapped = false;
        }
    }
    
    /** Your implementation of checkPressedKey returns this value to indicate that no key is currently pressed by the player. */
    public static final int PRESSED_KEY_NONE = 0;

    /** Your implementation of checkPressedKey returns this value to indicate that the player has correctly pressed the same key as the letter currently being sorted. */
    public static final int PRESSED_KEY_CORRECT = 1;

    /** Your implementation of checkPressedKey returns this value to indicate that the player has wrongly pressed a different key than the letter currently being sorted. */
    public static final int PRESSED_KEY_WRONG = 2;

    private static final Color COLOR_STILL = Color.GREEN;
    private static final Color COLOR_MOVING = Color.RED;

    private int row;
    private int animationPause;
    private Item[] items;
    private boolean sortInProgress;
    
    private SorterTestHooks testHooks;

    /**
     * Constructs a new Sorter object
     * @param rowP The row inside the ObjectLand grid to display the array.
     */
    public Sorter(int rowP)
    {
        row = rowP;
        animationPause = 0;
        items = null;
        sortInProgress = false;
    }

    /**
     * Initiates a sort of an array of random letters with size numItems.
     * You will call this method from your main method after creating an instance
     * of your Sorter subclass.
     * @param numItems Length of the random array to create and then sort
     * @param animationPauseP Number of milliseconds to pause while animating
     * 		the letters as they move into place.  Try a value like 100 to start with.
     */
    public void performSort(int numItems, int animationPauseP)
    {
        initAndSort(numItems, null, animationPauseP);
    }

    /**
     * Returns the number of items (array length) to be sorted
     * @return number of items to be sorted
     */
    public int getNumItems()
    {
        if (items == null)
        {
            return 0;
        }
        return items.length;
    }

    /**
     * Returns the element stored at the specified index
     * @param i The index to look up.  (Indices start counting at 0.)
     * @return The value stored at i
     */
    public String getItemAt(int i)
    {
        return items[i].value;
    }

    /**
     * Returns the row number that the array is displayed at within the grid.
     * @return The row number that the array is displayed at within the grid
     */
    public int getRow()
    {
        return row;
    }


    /**
     * You will override this in your subclass to sort the array.  Your sort method will call
     * getNumItems to find the length of the array, and will call getItemAt to look inside
     * the array at a particular element.  When your algorithm needs to swap elements in the
     * array, you will call swap.
     */
    public void sort()
    {
    	// YOU MUST OVERRIDE THIS IN YOUR SUBCLASS
    }

    /**
     * Draws the array elements to the ObjectLand grid, at the row specified by this object's
     * row field, and starting at column 0.  The rows immediately above and below are cleared out.
     * 
     * This method is automatically called before the sort begins, and also immediately after
     * the user presses the correct key to stop that letter's animation and move on to the 
     * next element
     */
    private void drawArray()
    {
        for (int col=0; col < items.length; col++)
        {
            // Clear out rows above and below
            notePlayer.API.eraseImage(row-1, col);
            notePlayer.API.eraseImage(row+1, col);

            // Draw a letter only if we're not in motion OR it wasn't
            // zapped by the user
            if (!sortInProgress || !items[col].wasZapped) 
            {
                notePlayer.API.drawText(row, col, "" + items[col].value, COLOR_STILL);
            }
        }
    }

    /**
     * If this class is being subclassed to implement a "zapping game", this method
     * should be overridden to check whether the keyboard key currently pressed by the user
     * matches the letter currently moving into place.  The Sorter class's implementation
     * of this method does nothing and just returns PRESSED_KEY_NONE.  Your subclass must override
     * this method to determine whether the user has "zapped" the letter moving into
     * place.  Your implementation may also include any sound effects or additional
     * animation to illustrate the "zapping".
     * <P>Warning!  Calling getPressedKey twice inside this method will not necessarily return
     * the same String both times.  In fact, if getPressedKey returns a non-null String, it is
     * likely to return null the next time you call it (unless the user has
     * quickly released and pressed another key in the meantime).  You should
     * therefore place the returned String into a variable if you expect
     * to use the String more than once.  To protect you from yourself, this method will
     * throw an exception if you accidentally call getPressedKey twice.
     * @param letter The letter currently moving into place by the sorting algorithm
     * @param currentColumn The grid column where the letter is currently at, while it
     * 		is moving into place
     * @param finalColumnToMoveTo The grid column where the letter is moving toward.  This
     * 		is the smaller of the two columns that were specified to the swap method,
     * 		as called by your sorting algorithm.
     * @return An integer that symbolizes whether a key is pressed and matches the letter
     * 		moving into place.  You should return one of these three 'final' integers defined
     * 		at the top of the Sorter class:
     * 		<ul>
     * 			<li>PRESSED_KEY_NONE if the user is not pressing a key, or
     * 			<li> PRESSED_KEY_CORRECT if 
     * 				the key pressed by the user matches the letter moving into place, or
     * 			<li> PRESSED_KEY_WRONG if the key pressed by the user does NOT match the letter
     * 				being moved into place. 
     * 		</ul>
     */
    public int checkPressedKey(String letter, int currentColumn, int finalColumnToMoveTo)
    {
        return PRESSED_KEY_NONE;
    }

    /**
     * Your sorting algorithm calls this to swap (exchange) the element at index i with the
     * element at index j.
     * @param i Index of one of the elements to swap (counting starts at 0).
     * @param j Index of the other element to swap.
     */
    public void swap(int i, int j)
    {
        // Normalize so we can move the leftish one above,
        // and the rightish one below
        int min = Math.min(i,  j);
        int max = Math.max(i,  j);

        // Move leftish up
        if (processPressedKey(max, max, min))
        {
            return;
        }
        notePlayer.API.drawText(row-1, min, items[min].value + "", COLOR_STILL);
        notePlayer.API.eraseImage(row, min);
        notePlayer.API.pause(animationPause);

        // Move rightish down
        if (processPressedKey(max, max, min))
        {
            return;
        }
        notePlayer.API.drawText(row+1, max, items[max].value + "", COLOR_MOVING);
        notePlayer.API.eraseImage(row, max);
        notePlayer.API.playNote(getNoteFromIndex(max), animationPause);

        // Slide them simultaneously to their new homes
        for (int k=min+1; k <= max; k++)
        {
            // Move leftish to the right
            if (processPressedKey(max, min + max - k + 1, min))
            {
                return;
            }
            notePlayer.API.drawText(row-1, k, items[min].value + "", COLOR_STILL);
            notePlayer.API.eraseImage(row-1, k - 1);
            notePlayer.API.pause(animationPause);

            // Move rightish to the left
            if (processPressedKey(max, min + max - k + 1, min))
            {
                return;
            }
            notePlayer.API.drawText(row+1, min + max - k, items[max].value + "", COLOR_MOVING);
            notePlayer.API.eraseImage(row+1, min + max - k + 1);
            notePlayer.API.playNote(getNoteFromIndex(min + max - k), animationPause);
        }

        // Move leftish back down
        if (processPressedKey(max, min, min))
        {
            return;
        }
        notePlayer.API.drawText(row, max, items[min].value + "", COLOR_STILL);
        notePlayer.API.eraseImage(row-1, max);
        notePlayer.API.pause(animationPause);

        // Move rightish back up
        if (processPressedKey(max, min, min))
        {
            return;
        }
        notePlayer.API.drawText(row, min, items[max].value + "", COLOR_STILL);
        notePlayer.API.eraseImage(row+1, min);        
        notePlayer.API.playNote(getNoteFromIndex(min), animationPause);

        // Finally, swap the actual values in the array
        Item temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private int getNoteFromIndex(int index)
    {
        // Calibrate so middle index of array is middle-C (60)
        return (index - (items.length / 2)) + 60;
    }


    /**
     * Do not call.  This is for internal testing only.
     * @param itemsP
     */
    public void performSort(String[] itemsP)
    {
        initAndSort(0, itemsP, 0);
    }    

    private void initAndSort(int numItems, String[] itemsP, int animationPauseP)
    {
        init(numItems, itemsP, animationPauseP);
        sortInProgress = true;
        sort();
        sortInProgress = false;
    }

    // If itemsP is null, generate random array of size numItems;
    // else just use itemsP directly
    private void init(int numItems, String[] itemsP, int animationPauseP)
    {
        // If a previous sort ocurred, clear it out
        if (items != null)
        {
            for (int col=0; col < items.length; col++)
            {
                notePlayer.API.eraseImage(row, col);
            }
        }
        if (itemsP == null)
        {
            items = new Item[numItems];

            // Initialize with random values
            for (int i=0; i < numItems; i++)
            {
                items[i] = new Item("" + (char)('A' + ((int) (Math.random() * 26))));
            }
        }
        else
        {
            numItems = itemsP.length;
            items = new Item[numItems];
            for (int i=0; i < numItems; i++)
            {
                items[i] = new Item(itemsP[i]);
            }
        }
        animationPause = animationPauseP;

        // Print initial configuration
        drawArray();
    }

    // Wrapper around calling checkPressedKey
    private boolean processPressedKey(int columnStartedFrom, int currentColumn, int finalColumnToMoveTo)
    {
    	notePlayer.API.disallowMultipleKeyCalls(
    			"\nYou must not call getPressedKey more than once from your checkPressedKey method.\n" +
    			"Reread the documentation for checkPressedKey for an explanation.");
    	if (testHooks != null)
        {
            testHooks.onBeforeCheckPressedKey(items[columnStartedFrom].value, currentColumn, finalColumnToMoveTo);
        }
        
        int keyType = checkPressedKey(items[columnStartedFrom].value, currentColumn, finalColumnToMoveTo);
        
        if (testHooks != null)
        {
            testHooks.onAfterCheckPressedKey(items[columnStartedFrom].value, currentColumn, finalColumnToMoveTo, keyType);
        }
    	notePlayer.API.allowMultipleKeyCalls();

        if (keyType == PRESSED_KEY_NONE)
        {
        	return false;
        }
        
        boolean wasZapped = (keyType == PRESSED_KEY_CORRECT);
        
        items[columnStartedFrom].wasZapped = wasZapped;
        if (wasZapped)
        {
            // Complete swap and redraw
            Item temp = items[columnStartedFrom];
            items[columnStartedFrom] = items[finalColumnToMoveTo];
            items[finalColumnToMoveTo] = temp;
            drawArray();
        }

        return wasZapped;
    }
    
    /**
     * Do not call or override this method.  It is for internal testing use only.
     */
    public void setTestHooks(SorterTestHooks testHooksP)
    {
        testHooks = testHooksP;
        testHooks.setSorterRow(row);
    }
}
