
package notePlayer;

import core.MidiWrapper;
import java.util.Scanner;
public class NotePlayer

{
    public static void main(String[] args)
    { 
    	NotePlayer();	
    }
    
    public static void NotePlayer ()
    {
		
		Scanner console = new Scanner (System.in);
		System.out.println("Enter a Note (x_yyy) ");
		String orig = console.nextLine();

		String note="";
		String noteinput=orig;
		int accidental=0;
		int octave=0;
		int space=noteinput.indexOf(" ");
		int duration=0;
		String d="";
		
		//for multiple notes
		if (space !=-1)
		{
			while(space!=-1)
			{		
				note=noteinput.substring(0,1);
				noteinput=noteinput.substring(1);
				//accidentals
				if (noteinput.substring(0,1).equals("#"))
				{
					accidental=1; 
					noteinput=noteinput.substring(1);
				}
				else if (noteinput.substring(0,1).equals("b"))
				{
					accidental=-1; 
					noteinput=noteinput.substring(1);
					
				}
				//octaves
				if (accidental == -1 || accidental == 1)
				{
					if (noteinput.indexOf("_")!=0)
					{
						if (noteinput.indexOf("-")==0)
						{
							octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
							noteinput=noteinput.substring(2);
						}
						else 
						{
							octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
							noteinput=noteinput.substring(1);
						}
					}
				}
				else 
				{
					if (noteinput.indexOf("_")!=0)
					{
						if (noteinput.indexOf("-")==0)
						{
							octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
							noteinput=noteinput.substring(1);
						}
						else 
						{
							octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
							noteinput=noteinput.substring(0);
						}
					}
				}		
				space=noteinput.indexOf(" ");
				if (space!=-1)
				{
					d=noteinput.substring(noteinput.indexOf("_")+1,space);
					duration=Integer.parseInt(d);
				}
				else 
				{
					d=noteinput.substring(noteinput.indexOf("_")+1);
					duration=Integer.parseInt(d);
				}
				
				
				//next note
				noteinput=noteinput.substring(space+1);				
				
				NM(note,accidental,octave,duration);			

		    		accidental=0;
		    		octave=0;	
			} 
		}

		//////////////////////////for single notes and/or last note//////////////////////////
		else if (space == -1)
		{
			
			note=noteinput.substring(0,1);
			noteinput=noteinput.substring(1);
			//accidentals
			if (noteinput.substring(0,1).equals("#"))
			{
				accidental=1; 
				noteinput=noteinput.substring(1);	
			}
			else if (noteinput.substring(0,1).equals("b"))
			{
				accidental=-1; 
				noteinput=noteinput.substring(1);
				
			}			
			
			//octaves
			if (accidental == -1 || accidental == 1)
			{
				if (noteinput.indexOf("_")!=0)
				{
					if (noteinput.indexOf("-")==0)
					{
						octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
						noteinput=noteinput.substring(2);
					}
					else 
					{
						octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
						noteinput=noteinput.substring(1);
					}
				}
			}
			else 
			{
				if (noteinput.indexOf("_")!=0)
				{
					if (noteinput.indexOf("-")==0)
					{
						octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
						noteinput=noteinput.substring(1);
					}
					else 
					{
						octave=Integer.parseInt(noteinput.substring(0,noteinput.indexOf("_")));
						noteinput=noteinput.substring(0);
					}
				}
			}
			d=noteinput.substring(noteinput.indexOf("_")+1);
			duration=Integer.parseInt(d);
			
			NM(note,accidental,octave,duration);			
	    	accidental=0;
	    	octave=0;	
		}	 
   }  //////End NotePlayer method		

    
    //notenum table and playnote
    public static void NM(String note, int accidental, int octave, int duration)
    {
    	int notenum=0;
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
    		
    }
    public static void ACC(int accidental, String noteinput)
    {
    	if (noteinput.substring(0,1).equals("#"))
		{
			accidental=1; 
			noteinput=noteinput.substring(1);
		}
		else if (noteinput.substring(0,1).equals("b"))
		{
			accidental=-1; 
			noteinput=noteinput.substring(1);
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