import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.sound.midi.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicApp {
	public static void main(String[] args) {
		var gui = new MiniMusicApp();
		gui.go();
	}
	
	void go() {
		//set-up GUI
		var frame = new JFrame("My first music video");
		var panel = new DrawPanel();
		frame.setContentPane(panel);
		frame.setBounds(30, 30, 300, 300);
		frame.setVisible(true);
		 		
		try {
			// setup sequencer, sequence and track
			var sequencer = MidiSystem.getSequencer();			
			var sequence = new Sequence(Sequence.PPQ, 4);
			var track = sequence.createTrack();
			sequencer.open();
			sequencer.addControllerEventListener(panel, new int[] {127});
			
			int r = 0;
			for (int i = 0; i < 60; i += 4) {
				r = (int)((Math.random() * 50) + 1);
				track.add(makeMidiEvent(144, 1, r, 100, i));		// note-on
				track.add(makeMidiEvent(176, 1, 127, 0, i));
				track.add(makeMidiEvent(128, 1, r, 100, i + 2));	// note-off
			}
					
			// play-sequencer
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// custom Panel
	class DrawPanel extends JPanel implements ControllerEventListener {
		boolean msg = false;
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics g) {
			if (msg) {
				// Paint background white
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());

				// Random start Color
				int red = (int)(Math.random() * 255);
				int green = (int)(Math.random() * 255);
				int blue = (int)(Math.random() * 255);
				var startColor = new Color(red, green, blue);	
				
				// Random end Color
				red = (int)(Math.random() * 255);
				green = (int)(Math.random() * 255);
				blue = (int)(Math.random() * 255);
				var endColor = new Color(red, green, blue);
			
				// Draw gradiend-color-circle
				var gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
				var g2d = (Graphics2D)g;
				g2d.setPaint(gradient);
				
				// generate a rect and fill with the color
				int height = (int)((Math.random() * 120) + 10);
				int width = (int)((Math.random() * 120) + 10);
				int x = (int)((Math.random() * 120) + 10);
				int y = (int)((Math.random() * 120) + 10);
				g2d.fillRect(x, y, width, height);
				msg = false;
			}
		}
	}
	
	// make a MidiEvent for creating sound with arguments
	public MidiEvent makeMidiEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			var msg = new ShortMessage();
			msg.setMessage(comd, chan, one, two);
			event = new MidiEvent(msg, tick);
		}
		catch (Exception ex) {}
		return event;
	}
}