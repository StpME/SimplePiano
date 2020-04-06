//---------------------------------------------------------------------------------
//DO NOT MODIFY!!!  For internal testing.
//---------------------------------------------------------------------------------

package examples;

import static org.junit.Assert.assertNull;

public interface SorterTestHooks
{
    void onBeforeCheckPressedKey(String letter, int currentColumn, int finalColumnToMoveTo);
    void onAfterCheckPressedKey(String letter, int currentColumn, int finalColumnToMoveTo, int superRet);
    void setSorterRow(int row);
    void setSorterRowConflictCheckingEnabled(boolean enabled);
}
