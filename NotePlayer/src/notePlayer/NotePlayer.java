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
	


	


    	//time for duration and spaceindex for chunking notes		
    	int time = noteinput.indexOf("_")+1;
    	int spaceindex = noteinput.indexOf(" ");


    	//vars
    	String accidental = "";
    	
    	String STRduration="";
    	int duration=0;
    	
    	String STRduration2="";
    	int duration2=0;
    	
    	String note="";
    	int notenum=0;
    	int notenum2=0;
    	
    	
    	//finds note and any accidental
    	if (noteinput.substring(1,2).equals("#") || noteinput.substring(1,2).equals("b"));
    	{
    		accidental=noteinput.substring(0,2);
    		note=noteinput.substring(0,1);
    	}
    	
    	

    	
    	
    	//finds duration of note1
    	 if (spaceindex!=-1)
    	{
        	STRduration = noteinput.substring(time, spaceindex);
    	}
    	else  
    	{
    		STRduration = noteinput.substring(time);
    	}
    	duration=Integer.parseInt(STRduration); 
    
    	
    	//multiple notes (make more efficient)
    	String note2="";
    	String notesymbol2="";
    	String accidental2="";
    	
    	note2=noteinput.substring(spaceindex+1,spaceindex+2);
    	
    	int underscore2=noteinput.indexOf("_", noteinput.indexOf("_") + 1);
    	int time2=(underscore2+1);
    	int spaceindex3=noteinput.indexOf(" ", noteinput.indexOf(" ") + 2);
    	
    	
    	//finds second duration
    	/*if (spaceindex3!=-1)
    	{
        	STRduration2 = noteinput.substring(time2, spaceindex3);
    	}
    	else 
    	{
    		STRduration2 = noteinput.substring(time2);
    	}
    	duration2=Integer.parseInt(STRduration2); */
    	
    	//second accidental
    	if (noteinput.substring(spaceindex+2,spaceindex+3).equals("#")|| noteinput.substring(spaceindex+2,spaceindex+3).equals("b"))
    	{
    		accidental2=noteinput.substring(spaceindex+2,spaceindex+3);
    		
    	}
    	

    	//note 3 
    	String note3="";
    	String accidental3="";
    	int notenum3=0;
    	String STRduration3="";
    	int duration3=0;
    	
    	
    	
    	
    	
    
    	
    	
    	
    	
    	
    	
    	//Note Letter (make a lot more efficient)
    	if (note.equals ("C"))
    	{
    		notenum=60; 
    	}
    	else if (note.equals ("D"))
    	{
    		notenum=62; 
    	}
    	else if (note.equals ("E"))
    	{
    		notenum=64; 
    	}
    	else if (note.equals ("F"))
    	{
    		notenum=65; 
    	}
    	else if (note.equals ("G"))
    	{
    		notenum=67; 
    	}
    	else if (note.equals ("A"))
    	{
    		notenum=69; 
    	}
    	else if (note.equals ("B"))
    	{
    		notenum=71; 
    	}
    	
    	if (note2.equals ("C")) {notenum2=60;}
    	else if (note2.equals ("D")) {notenum2=62;}
    	else if (note2.equals ("E")) {notenum2=64;}
    	else if (note2.equals ("F")) {notenum2=65;}
    	else if (note2.equals ("G")) {notenum2=67;}
    	else if (note2.equals ("A")) {notenum2=69;}
    	else if (note2.equals ("B")) {notenum2=71;}

    		
    	playNote(notenum,duration);
    	if (notenum != notenum2)
    	{
    		playNote(notenum2,duration2);
    	}
    	
    	
    	
     }
    
    
    
    
    
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
