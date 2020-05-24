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
	*Other functions: accidentals, note list and note counter
	*/
	
	private static ArrayList<String> noteList;
	private static int noteCount;
	private static int columns;
	private static int notenum;
	private static String input;
	
    public static void main(String[] args)
    { 
    	
    	System.out.println("NUMBERS - play notes(1-8) || Y,U,I,O,P - Accidentals || N - Display Counter & Notes");
    	System.out.println("Chromatic scale: 1 Y 2 U 3 4 I 5 O 6 P 7 8");
    	
    	//Field initialization
    	columns=8;
    	notenum=0;
    	
    	noteList = new ArrayList<String>();
    	noteCount=0;
    	
    	CustomAppearance ca = new CustomAppearance(2, columns);
    	ca.setCellColor(Color.white);
    	ca.setBorderColor(Color.black);
    	notePlayer.API.initialize(ca); 
    	
    	Scanner con=new Scanner(System.in);
    	System.out.println("");
     	System.out.println("Type 'list' or Select an Instrument");
    	input = con.nextLine();
   
    	//List + set instrument
    	if(input.equalsIgnoreCase("list"))
    	{
    		listI();
    	}
    	else
    	{
    		setI(input);
    	}
    	
    	//Initialize API
    	keyboard(columns);
    	
    	
		
		while(!(input.equals("x")))
		{
			checkPressedKey();	
		}
		
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
    	
    	Scanner con=new Scanner(System.in);
    	System.out.println("");
    	System.out.println("Select an Instrument:");
    	input = con.nextLine();
    	setI(input);
    }
    

    public static void setI(String input)
    {
		int instrumentNumber=Integer.parseInt(input);
		setInstrument(instrumentNumber);
		System.out.println("Keyboard initialized.");
    }
    
    
    
    
    
    
    
  
    
    
    //Print notes to keyboard
    public static void keyboard(int columns)
    {
    	String[] notes = {"C", "D", "E", "F", "G", "A", "B", "C"};
    	//String[] notesAccidental = {"C#", "D", "Eb", "F#", "G#", "Bb"};
    	//Set regular notes
    	
    	for(int i = 0; i<columns;i++)
    	{
    		notePlayer.API.drawText(1, i, notes[i], Color.BLACK);
    	}
    	//Set Accidentals
    	notePlayer.API.drawText(0, 0, "C#", Color.BLACK);
    	notePlayer.API.drawText(0, 2, "Eb", Color.BLACK);
    	notePlayer.API.drawText(0, 3, "F#", Color.BLACK);
    	notePlayer.API.drawText(0, 4, "G#", Color.BLACK);
    	notePlayer.API.drawText(0, 6, "Bb", Color.BLACK);
    	
    }
    
    
    //check input for piano note
    public static void checkPressedKey()
    {
	  
	  String key = notePlayer.API.getPressedKey();
	  
	  if (key!=null)
	  {
		  
		  notenum=0;
		  if(key.equals("v"))
		  {
			  notenum+=12;
		  }
		  noteSet(key);
	  }
	  
	  
	  return;
	  
    }
    
    public static void noteSet(String key)
    {
    	  //paintSolidColor(row,col,color,text to print)
    	
    	  //Inside staff 
    	  if(key.equals("1")) {notenum+=60; System.out.print("C "); noteList.add("C"); notePlayer.API.paintSolidColor(1, 0, Color.YELLOW);}
    	  else if(key.equals("2")) {notenum+=62; System.out.print("D "); noteList.add("D"); notePlayer.API.paintSolidColor(1, 1, Color.YELLOW);}
		  else if(key.equals("3")) {notenum+=64; System.out.print("E "); noteList.add("E"); notePlayer.API.paintSolidColor(1, 2, Color.YELLOW);}
		  else if(key.equals("4")) {notenum+=65; System.out.print("F "); noteList.add("F"); notePlayer.API.paintSolidColor(1, 3, Color.YELLOW);}
		  else if(key.equals("5")) {notenum+=67; System.out.print("G "); noteList.add("G"); notePlayer.API.paintSolidColor(1, 4, Color.YELLOW);}
		  else if(key.equals("6")) {notenum+=69; System.out.print("A "); noteList.add("A"); notePlayer.API.paintSolidColor(1, 5, Color.YELLOW);}
		  else if(key.equals("7")) {notenum+=71; System.out.print("B "); noteList.add("B"); notePlayer.API.paintSolidColor(1, 6, Color.YELLOW);}
		  else if(key.equals("8")) {notenum+=72; System.out.print("C^ "); noteList.add("C^");notePlayer.API.paintSolidColor(1, 7, Color.YELLOW);}
    	  //Accidentals
		  else if(key.equals("Y")) {notenum+=61; System.out.print("C# "); noteList.add("C#"); notePlayer.API.paintSolidColor(0, 0, Color.YELLOW);}
		  else if(key.equals("U")) {notenum+=63; System.out.print("Eb "); noteList.add("Eb"); notePlayer.API.paintSolidColor(0, 2, Color.YELLOW);}
		  else if(key.equals("I")) {notenum+=66; System.out.print("F# "); noteList.add("F#"); notePlayer.API.paintSolidColor(0, 3, Color.YELLOW);}
		  else if(key.equals("O")) {notenum+=68; System.out.print("G# "); noteList.add("G#"); notePlayer.API.paintSolidColor(0, 4, Color.YELLOW);}
		  else if(key.equals("P")) {notenum+=70; System.out.print("Bb "); noteList.add("Bb"); notePlayer.API.paintSolidColor(0, 6, Color.YELLOW);}
    	  //Print/add to noteList and noteCount
		  listCount(key);
		  
		  
		  if(notenum>=40)
		  {
			  playNote(notenum,200);
		  }
		  keyboard(columns); 
    }
    
    public static void listCount(String key)
    {
		  if(key.equals("N") || key.equals("n"))
		  {
			  System.out.print("Notes played: ");
		  for(int i = 0;i<noteList.size();i++)
		  {
			  System.out.print(noteList.get(i) + " ");
		  }
		  System.out.println("");
		  System.out.println("Number of notes: "+noteCount);
		  }    //1 Y 2 U 3 4 I 5 O 6 P 7 8
		  
		  //Note Counter
		  noteCount++;
    }
	 
    

//-------------------------------------------------------------------//

    //Acknowledgments 
    //Classes for playing notes and constructing API(MidiPlayer, Objectland) provided by BHS CS
    public static void playNote(int noteNumber, int durationMs)
    {
        MidiWrapper.playNote(noteNumber, durationMs);
    }
    
	public static void setInstrument(int instrumentNumber)
	{
		MidiWrapper.setInstrument(instrumentNumber);
	}
}