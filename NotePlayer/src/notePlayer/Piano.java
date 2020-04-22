package notePlayer;

//imports
//Project borrows packages from APCS to construct API and play notes
import core.MidiWrapper;
import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;


public class Piano
{
	
	/* 				***Basic Purpose***
	*Create a piano keyboard, pressing the keys will play a note.
	*Other functions: accidentals, octaves to implement
	*/
	
	private static int octave;
	private static String end;
	private static int columns;
	private static int notenum;
	
    public static void main(String[] args)
    { 
    	
    	System.out.println("NUMBERS - play notes(1-8) || Y,U,I,O,P - Accidentals || LEFT/RIGHT arrows (-/+ octave) ");
    	columns=8;
    	notenum=0;
    	CustomAppearance ca = new CustomAppearance(2, columns);
    	ca.setCellColor(Color.white);
    	ca.setBorderColor(Color.black);
    	notePlayer.API.initialize(ca); 
    	keyboard(columns);
    	
    	String input=""; 
    	
		
		while(!(input.equals("x")))
		{
			Scanner con=new Scanner(System.in);
			checkPressedKey();	
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
    	System.out.println("0: Piano 1        1: Piano 2        2: Piano 3        3: Honky-tonk     4: E.Piano 1");
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
    

    
    
    
    
    
    
    
    
  
    
    
    //Print notes to keyboard
    public static void keyboard(int columns)
    {
    	String[] notes = {"C", "D", "E", "F", "G", "A", "B", "C"};
    	String[] notesAccidental = {"C#", "D", "Eb", "F#", "G#", "A#", "Bb"};
    	//Set regular notes
    	for(int i = 0; i<columns;i++)
    	{
    		notePlayer.API.drawText(1, i, notes[i], Color.BLACK);
    		//System.out.println(notes[i]+ i);
    	}
    	//Set Accidentals
    	notePlayer.API.drawText(0, 0, "C#", Color.BLACK);
    	notePlayer.API.drawText(0, 2, "Eb", Color.BLACK);
    	notePlayer.API.drawText(0, 3, "F#", Color.BLACK);
    	notePlayer.API.drawText(0, 5, "A#", Color.BLACK);
    	notePlayer.API.drawText(0, 6, "Bb", Color.BLACK);
    	
    }
    
    
    //check input for piano note
    public static void checkPressedKey()
    {
	  
	  String key = notePlayer.API.getPressedKey();
	  
	  if (key!=null)
	  {
		  notenum=0;
		  noteplayer(key);
	  }
	  
	  
	  return;
	  
    }
    
    public static void noteplayer(String key)
    {
    	  
    	  //Inside staff
    	  if(key.equals("1")) {notenum+=60; System.out.print("C "); notePlayer.API.paintSolidColor(1, 0, Color.YELLOW);}
    	  else if(key.equals("2")) {notenum+=62; System.out.print("D "); notePlayer.API.paintSolidColor(1, 1, Color.YELLOW);}
		  else if(key.equals("3")) {notenum+=64; System.out.print("E "); notePlayer.API.paintSolidColor(1, 2, Color.YELLOW);}
		  else if(key.equals("4")) {notenum+=65; System.out.print("F "); notePlayer.API.paintSolidColor(1, 3, Color.YELLOW);}
		  else if(key.equals("5")) {notenum+=67; System.out.print("G "); notePlayer.API.paintSolidColor(1, 4, Color.YELLOW);}
		  else if(key.equals("6")) {notenum+=69; System.out.print("A "); notePlayer.API.paintSolidColor(1, 5, Color.YELLOW);}
		  else if(key.equals("7")) {notenum+=71; System.out.print("B "); notePlayer.API.paintSolidColor(1, 6, Color.YELLOW);}
		  else if(key.equals("8")) {notenum+=72; System.out.print("C^ "); notePlayer.API.paintSolidColor(1, 7, Color.YELLOW);}
    	  //Accidentals
		  else if(key.equals("Y")) {notenum+=61; System.out.print("C# "); notePlayer.API.paintSolidColor(0, 0, Color.YELLOW);}
		  else if(key.equals("U")) {notenum+=63; System.out.print("Eb "); notePlayer.API.paintSolidColor(0, 2, Color.YELLOW);}
		  else if(key.equals("I")) {notenum+=66; System.out.print("F# "); notePlayer.API.paintSolidColor(0, 3, Color.YELLOW);}
		  else if(key.equals("O")) {notenum+=68; System.out.print("G# "); notePlayer.API.paintSolidColor(0, 5, Color.YELLOW);}
		  else if(key.equals("P")) {notenum+=70; System.out.print("Bb "); notePlayer.API.paintSolidColor(0, 6, Color.YELLOW);}

    	  if(notenum>=40)
    	  {
    		  playNote(notenum,200);
    	  }
    	  keyboard(columns);
    	  System.out.println(octave);
    }
    

//-------------------------------------------------------------------//

    /**
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