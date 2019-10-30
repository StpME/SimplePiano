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
    	NotePlayer();
    	
    	
    }
    
    public static void NotePlayer ()
    {
		//input + console
		Scanner console = new Scanner (System.in);
		System.out.println("Enter a Note (x_yyy) ");
		String noteinput = console.nextLine();
	

		//variables
		String notesymbol=noteinput.substring(0,noteinput.length());
		String note=noteinput.substring(0,1);
		String accid="";
		int space=noteinput.indexOf(" ");
		int duration=0;
		String d="";
		int notenum=0;
		
		
		//cuts previous note symbol and puts in noteinput
		if (space !=-1)
		{
			while(space!=-1)
			{		
				//F#_483 Gb_281 A_38
				if (noteinput.substring(1,2).equals("#") || noteinput.substring(1,2).equals("b"))
				{
					accid=noteinput.substring(1,2);
					//System.out.println(accid);
				}
				
				
				
				d=noteinput.substring(noteinput.indexOf("_")+1,space);
				duration=Integer.parseInt(d);
				note=noteinput.substring(0,1);
				noteinput=noteinput.substring((space)+1);
				//note=noteinput.substring(0,1);
				//F_1000 Gb_4832 A_3481
				space=noteinput.indexOf(" ");
			/*	System.out.println(note);  
				System.out.println(notesymbol);
				System.out.println(noteinput);
				System.out.println(duration); */
				
				
				
				
		    	if (note.equals ("C")) {notenum=60;}
		    	else if (note.equals ("D")) {notenum=62;}
		    	else if (note.equals ("E")) {notenum=64;}
		    	else if (note.equals ("F")) {notenum=65;}
		    	else if (note.equals ("G")) {notenum=67;}
		    	else if (note.equals ("A")) {notenum=69;}
		    	else if (note.equals ("B")) {notenum=71;}
		    	
		    	playNote(notenum,duration);
		    	
			}
		}
		//for single notes
		if (space == -1)
		{
			d=noteinput.substring(noteinput.indexOf("_")+1);
			duration=Integer.parseInt(d);
			note=noteinput.substring(0,1);
			//System.out.print(note);
	    	if (note.equals ("C")) {notenum=60;}
	    	else if (note.equals ("D")) {notenum=62;}
	    	else if (note.equals ("E")) {notenum=64;}
	    	else if (note.equals ("F")) {notenum=65;}
	    	else if (note.equals ("G")) {notenum=67;}
	    	else if (note.equals ("A")) {notenum=69;}
	    	else if (note.equals ("B")) {notenum=71;}
	    	
	    	playNote(notenum,duration);
		}
    
    }
  
    
    /*public static void MIDIconv()
    {
    	
    	if (.equals("C"))
    }
    */
//-------------------------------------------------------------------//
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
