import java.util.Scanner;
import javax.sound.midi.*;

public class MiniMusicApp {
	public static void main(String[] args) {
		var app = new MiniMusicApp();
		var isPlaying = true;
		var scanner = new Scanner(System.in);

		while (isPlaying) {
			// some samples (instrument & note): [102, 30], [80, 20], [40, 70] 
			System.out.print("Input instrument number: ");
			int instrument = Integer.parseInt(scanner.nextLine());
			System.out.print("Input note number: ");
			int note = Integer.parseInt(scanner.nextLine());
			
			// input (-1, -1) to exit
			if (instrument == -1 && note == -1) {
				isPlaying = false;
				scanner.close();
			}
			else {
				System.out.println("Wait for playing...");
				app.play(instrument, note);
			}
		}
	}
	
	public void play(int instrument, int note) {
		try {
			var player = MidiSystem.getSequencer();		// the CD-player
			var seq = new Sequence(Sequence.PPQ, 4);	// the CD
			var track = seq.createTrack();				// the track
			
			// change instrument
			var msg_i = new ShortMessage();
			msg_i.setMessage(192, 1, instrument, 0);
			track.add(new MidiEvent(msg_i, 1));
			
			// noteOn in track
			var msg_a = new ShortMessage();			
			msg_a.setMessage(144, 1, note, 100);
			track.add(new MidiEvent(msg_a, 1));
			
			// noteOf in track
			var msg_b = new ShortMessage();				
			msg_b.setMessage(128, 1, note, 100);
			track.add(new MidiEvent(msg_b, 16));

			player.open();
			player.setSequence(seq);
			player.start();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}