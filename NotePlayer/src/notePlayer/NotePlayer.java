package notePlayer;

import core.MidiWrapper;
import java.util.Scanner;
public class NotePlayer

{
    public static void main(String[] args)
    { 
    	
    	String input="";
    	while (!(input.equals("quit")))
    	{
    		Scanner con=new Scanner(System.in);
        	System.out.println("Enter note list or list/set instrument or 'quit' to end");
        	input= con.nextLine();
        	if (!(input.equals("quit")))
        	{
		    	if (input.contains("_"))
		    	{
		    		NotePlayer(input);
		    	}
	
		    	else if(input.equals("list instruments"))
		    	{
		    		listI();
		    	}
		    	else
		    	{
		    		setI(input);
		    	}
        	}
    	}
    }
    
    public static void setI(String input)
    {
    	String set=input;
		set=set.substring(15);
		int instrumentNumber=Integer.parseInt(set);
		setInstrument(instrumentNumber);
    }
    
    public static void listI()
    {
    	System.out.println("0: Piano 1        1: Piano 2        2: Piano 3        3: Honky-tonk     4: E.Piano");
    	System.out.println("5: E.Piano 2      6: Harpsichord    7: Clav.          8: Celesta        9: Glockenspiel");
    	System.out.println("10: Music Box     11: Vibraphone    12: Marimba       13: Xylophone     14: Tubular-bell");
    	System.out.println("15: Santur        16: Organ 1       17: Organ 2       18: Organ 3       19: Church Org.1");
    	System.out.println("20: Reed Organ    21: Accordion Fr  22: Harmonica     23: Bandoneon     24: Nylon-str.Gt");
    	System.out.println("25: Steel-str.Gt  26: Jazz Gt.      27: Clean Gt.     28: Muted Gt.     29: Overdrive Gt");
    	System.out.println("30: DistortionGt  31: Gt.Harmonics  32: Acoustic Bs.  33: Fingered Bs.  34: Picked Bs.");
    	System.out.println("35: Fretless Bs.  36: Slap Bass 1   37: Slap Bass 2   38: Synth Bass 1  39: Synth Bass 2");
    	System.out.println("40: Violin        41: Viola         42: Cello         43: Contrabass    44: Tremolo Str");
    	System.out.println("45: PizzicatoStr  46: Harp          47: Timpani       48: Strings       49: Slow Strings");
    	System.out.println("50: Syn.Strings1  51: Syn.Strings2  52: Choir Aahs    53: Voice Oohs    54: SynVox");
    	System.out.println("55: OrchestraHit  56: Trumpet       57: Trombone      58: Tuba          59: MutedTrumpet");
    	System.out.println("60: French Horns  61: Brass 1       62: Synth Brass1  63: Synth Brass2  64: Soprano Sax");
    	System.out.println("65: Alto Sax      66: Tenor Sax     67: Baritone Sax  68: Oboe          69: English Horn");
    	System.out.println("70: Bassoon       71: Clarinet      72: Piccolo       73: Flute         74: Recorder");
    	System.out.println("75: Pan Flute     76: Bottle Blow   77: Shakuhachi    78: Whistle       79: Ocarina");
    	System.out.println("80: Square Wave   81: Saw Wave      82: Syn.Calliope  83: Chiffer Lead  84: Charang");
    	System.out.println("85: Solo Vox      86: 5th Saw Wave  87: Bass & Lead   88: Fantasia      89: Warm Pad");
    	System.out.println("90: Polysynth     91: Space Voice   92: Bowed Glass   93: Metal Pad     94: Halo Pad");
    	System.out.println("95: Sweep Pad     96: Ice Rain      97: Soundtrack    98: Crystal       99: Atmosphere");
    	System.out.println("100: Brightness   101: Goblin       102: Echo Drops   103: Star Theme   104: Sitar");
    	System.out.println("105: Banjo        106: Shamisen     107: Koto         108: Kalimba      109: Bagpipe");
    	System.out.println("110: Fiddle       111: Shanai       112: Tinkle Bell  113: Agogo        114: Steel Drums");
    	System.out.println("115: Woodblock    116: Taiko        117: Melo. Tom 1  118: Synth Drum   119: Reverse Cym.");
    	System.out.println("120: Gt.FretNoise 121: Breath Noise 122: Seashore     123: Bird         124: Telephone 1");
    	System.out.println("125: Helicopter   126: Applause     127: Gun Shot");

    }
    
    public static void TandT(String noteinput, int trans, double tempo, String combo)
    {
    	trans=Integer.parseInt(noteinput.substring(0,1));
    	noteinput=noteinput.substring(noteinput.indexOf("_")+1);
    	tempo=Double.parseDouble(noteinput.substring(0,noteinput.indexOf(",")));
    	noteinput=noteinput.substring(noteinput.indexOf(",")+1);
    	
		System.out.println(noteinput);
		System.out.println(trans);
		System.out.println(tempo);
		combo=noteinput+"$"+trans+"$"+tempo;
    	
    }
    
    public static void NotePlayer (String input)
    {

    	System.out.println(input);
		String note="";
		String noteinput=input;
		int accidental=0;
		int octave=0;
		int space=noteinput.indexOf(" ");
		int duration=0;
		String d="";
		int trans=0;
		double tempo=0;
		String combo="";
		
		//transpose and tempo
		if (noteinput.contains(","))
		{
			TandT(noteinput, trans, tempo, combo);
			noteinput=noteinput.substring(noteinput.indexOf(",")+1);
		}
				
		
		System.out.println(combo);
		
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
					duration=Integer.parseInt(noteinput.substring(noteinput.indexOf("_")+1,space));
				}
				else 
				{
					duration=Integer.parseInt(noteinput.substring(noteinput.indexOf("_")+1));
				}
				
				
				//next note
				noteinput=noteinput.substring(space+1);				
				
				NM(note,accidental,octave,duration,trans);			

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
			duration=Integer.parseInt(noteinput.substring(noteinput.indexOf("_")+1));
			
			NM(note,accidental,octave,duration,trans);			
	    	accidental=0;
	    	octave=0;	
		}	 
   }  //////End NotePlayer method		

    
    //notenum table and playnote
    public static void NM(String note, int accidental, int octave, int duration,int trans)
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
    			notenum+=12*octave+1+trans;
    			playNote(notenum,duration);
    		}
    		else if (accidental==-1)
    		{
    			
    			
    			notenum+=12*octave-1+trans;
    			playNote(notenum,duration);
    		}
    		else 
    		{
    			notenum+=12*octave+trans;
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