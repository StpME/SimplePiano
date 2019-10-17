package notePlayer;

import core.MidiWrapper;
import java.util.Scanner;
public class NotePlayer

{
    public static void main(String[] args)
    {
    	// This is where you will begin writing your code, and this is where the program will start.
    	// Although you can place all of your code here in main, we strongly suggest that you
    	// separate your code into multiple helper methods.  Your main method should then call those
    	// helper methods at the right places.  Organizing your code like this makes your code easier
    	// to read and debug, and helps avoid duplicating code.  
    	scan();
    	
    	
    	
    	
    	
    }
    
    public static void scan ()
    {
    	Scanner console = new Scanner (System.in);
    	//System.out.println("Enter a Note (x_yyy) ");
    	String noteinput=console.nextLine();
    	
    	
    	//int note=noteinput.substring(1,3);
    	
    	int max=noteinput.length();
    	String letter1 = noteinput.substring(0,1);
    	String number1=noteinput.substring(2,max);
    	
    	System.out.print("note letter: "+letter1+", duration: "+number1+" ");
    	

    }
    
    
    
    
    
    
    
    
    
    // You may choose to add extra helper methods here to break up your code into
    // smaller, reusable chunks
    
    
    
    
    
    

    /**
     * WARNING!!!  DO NOT MODIFY THIS METHOD.
     * 
     * Once you have calculated the MIDI note number and its duration, call this
     * method to play that note.
     * 
     * @param noteNumber The MIDI note number, as described in the spec.
     * @param durationMs The number of milliseconds to play the note.  A larger number will play the note for a longer time.
     */
    public static void playNote(int noteNumber, int durationMs)
    {
    	// WARNING!!!  DO NOT MODIFY THIS METHOD.
        MidiWrapper.playNote(noteNumber, durationMs);
    }
    
    
    
    
	/**
	 * WARNING!!!  DO NOT MODIFY THIS METHOD.
	 * 
	 * Call this method to change the instrument used to play notes.
	 * 
	 * @param instrumentNumber The MIDI instrument number to begin using.  Must
	 * be in the range between 0 and 127 inclusive.
	 */
	public static void setInstrument(int instrumentNumber)
	{
		// WARNING!!!  DO NOT MODIFY THIS METHOD.
		MidiWrapper.setInstrument(instrumentNumber);
	}
    
}
