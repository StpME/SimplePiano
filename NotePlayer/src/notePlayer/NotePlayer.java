

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

		//variables initialize
		String note=noteinput.substring(0,1);
		int accidental=0;
		int octave=0;
		int space=noteinput.indexOf(" ");
		int duration=0;
		String d="";
		int notenum=0;
		
		//for multiple notes
		//cuts previous note symbol and puts in noteinput
		if (space !=-1)
		{
			while(space!=-1)
			{		
				//Accidentals
				if (noteinput.substring(1,2).equals("#"))
				{
					accidental=1; 
					
					
				}
				else if (noteinput.substring(1,2).equals("b"))
				{
					accidental=-1; 
				}
				
				
				
				//octave check
				if (!(noteinput.substring(1,2).equals("_")) && accidental !=0)
				{
					if (accidental == 1 || accidental == -1)
					{
						if (noteinput.substring(1,2).equals("-"))
						{
							octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
						//	System.out.println(octave);
						}
						else if (!noteinput.substring(1,2).equals("#") || !noteinput.substring(1,2).equals("b"))
						{
							octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
							//System.out.println(octave);
						}
					}
				}
				else// if (accidental==0)
					{
						if (noteinput.substring(1,2).equals("-"))
						{
							octave=Integer.parseInt(noteinput.substring(1,noteinput.indexOf("_")));
						//	System.out.println(octave);
						}
						else if (!noteinput.substring(1,2).equals("#") || !noteinput.substring(1,2).equals("b"))
						{
							octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
						//	System.out.println(octave);
						}
					} 
				
				
				
				
				
				d=noteinput.substring(noteinput.indexOf("_")+1,space);
				duration=Integer.parseInt(d);
				note=noteinput.substring(0,1);
				noteinput=noteinput.substring((space)+1);
				space=noteinput.indexOf(" ");

				
				
				
		    	if (note.equals ("C")) {notenum=60;}
		    	else if (note.equals ("D")) {notenum=62;}
		    	else if (note.equals ("E")) {notenum=64;}
		    	else if (note.equals ("F")) {notenum=65;}
		    	else if (note.equals ("G")) {notenum=67;}
		    	else if (note.equals ("A")) {notenum=69;}
		    	else if (note.equals ("B")) {notenum=71;}
		    	
		    	if (accidental==1)
		    		{
		    			notenum+=12*octave+1;
		    			playNote(notenum,duration);
		    		}
	    		else if (accidental==-1)
	    			{
		    			
		    			notenum+=12*octave-1;
		    			playNote(notenum,duration);
	    			}
	    		else 
	    		{
	    			notenum+=12*octave;
	    			playNote(notenum,duration);	
	    		}
		    	accidental=0;
		    	octave=0;
			} 
		}

		//for single notes and/or last note
		if (space == -1)
		{
			if (noteinput.substring(1,2).equals("#"))
			{
				accidental=1; 
				
			}
			else if (noteinput.substring(1,2).equals("b"))
			{
				accidental=-1;
			}
			
			
			
			
			
			//octave check
			if (!(noteinput.substring(1,2).equals("_")) && !(noteinput.substring(2,3).equals("_")) && accidental !=0)
			{
				if (accidental == 1 || accidental == -1)
				{
					if (noteinput.substring(1,2).equals("-"))
					{
						octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
						//System.out.println(octave);
					}
					else if (!(noteinput.substring(1,noteinput.indexOf("_")).equals("#") || !noteinput.substring(1,noteinput.indexOf("_")).equals("b")))
					{
						octave=Integer.parseInt(noteinput.substring(1,noteinput.indexOf("_")));
						//System.out.println(octave);
					} 
					else
					{
						octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
						//System.out.println(octave);
					}
				}
			}
			else if (accidental==0)
				{
					if (noteinput.substring(1,2).equals("-"))
					{
						octave=Integer.parseInt(noteinput.substring(1,noteinput.indexOf("_")));
						//System.out.println(octave);
					}
					else if (!noteinput.substring(1,2).equals("#") || !noteinput.substring(1,2).equals("b"))
					{
						octave=Integer.parseInt(noteinput.substring(2,noteinput.indexOf("_")));
						//System.out.println(octave);
					}
					
				} 
			
			
			
		
			d=noteinput.substring(noteinput.indexOf("_")+1);
			duration=Integer.parseInt(d);
			note=noteinput.substring(0,1);
			
	    	if (note.equals ("C")) {notenum=60;}
	    	else if (note.equals ("D")) {notenum=62;}
	    	else if (note.equals ("E")) {notenum=64;}
	    	else if (note.equals ("F")) {notenum=65;}
	    	else if (note.equals ("G")) {notenum=67;}
	    	else if (note.equals ("A")) {notenum=69;}
	    	else if (note.equals ("B")) {notenum=71;}
	    	
	    		if (accidental==1)
	    		{
	    			
	    			
	    			notenum+=12*octave+1;
	    			playNote(notenum,duration);
	    			
	    		}
	    		else if (accidental==-1)
	    		{
	    			
	    			
	    			notenum+=12*octave-1;
	    			playNote(notenum,duration);
	    		}
	    		else 
	    		{
	    			notenum+=12*octave;
	    			playNote(notenum,duration);
	    		}
	    		accidental=0;
	    		octave=0;	
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

