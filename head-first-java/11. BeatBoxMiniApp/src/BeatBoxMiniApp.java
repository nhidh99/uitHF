import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BeatBoxMiniApp {
	JPanel instrumentPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	Box buttonBox, nameBox;
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
			"Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
			"High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
			"Cowbell","Vibraslap","Low-mid Tom","High Agogo", "Open Hi Conga"};
	
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main(String[] args) {
		new BeatBoxMiniApp().buildGUI();
	}
	
	public void buildGUI() {
		this.createButtonBox();
		this.createNameBox();
		this.createInstrumentPanel();
		this.setupMidi();
		this.setupFrame();
	}
		
	public void setupFrame() {
		var layout = new BorderLayout();
		var background = new JPanel(layout);
		var frame = new JFrame("BeatBox Mini App");
		
		background.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));	
		background.add(BorderLayout.WEST, nameBox);
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.CENTER, instrumentPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(background);
		frame.setBounds(50,50,300,300);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createButtonBox() {
		buttonBox = new Box(BoxLayout.Y_AXIS);
		
		var startButton = new JButton("Start");
		startButton.addActionListener(new StartButtonListener());
		buttonBox.add(startButton);
		
		var stopButton = new JButton("Stop");
		stopButton.addActionListener(new StopButtonListener());
		buttonBox.add(stopButton);
		
		var upTempoButton = new JButton("Tempo Up");
		upTempoButton.addActionListener(new UpTempoButtonListener());
		buttonBox.add(upTempoButton);
		
		var downTempoButton = new JButton("Tempo Down");
		downTempoButton.addActionListener(new DownTempoButtonListener());
		buttonBox.add(downTempoButton);
		
		var serializeButton = new JButton("Serialize");
		serializeButton.addActionListener(new SerializeButtonListener());
		buttonBox.add(serializeButton);
		
		var restoreButton = new JButton("Restore");
		restoreButton.addActionListener(new RestoreButtonListener());
		buttonBox.add(restoreButton);
	}
	
	public void createNameBox() {
		nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
	}
	
	public void createInstrumentPanel() {
		var grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		
		instrumentPanel = new JPanel(grid);
		checkboxList = new ArrayList<JCheckBox>();	
		
		for (int i = 0; i < 256; i++) {
			var checkbox = new JCheckBox();
			checkbox.setSelected(false);
			checkboxList.add(checkbox);
			instrumentPanel.add(checkbox);
		}
	}
	
	public void setupMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		}
		catch (Exception ex) { ex.printStackTrace(); }
	}
	
	public void buildTrackAndStart() {
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for (int i = 0; i < 16; i++) {
			trackList = new int[16];
			int key = instruments[i];
			for (int j = 0; j < 16; j++) {
				var checkbox = checkboxList.get(j + 16*i);
				if (checkbox.isSelected()) {
					trackList[j] = key;
				} else trackList[j] = 0;
			}
			this.makeTrack(trackList);
			track.add(makeMidiEvent(176,1,127,0,16));
		}
		track.add(makeMidiEvent(192,9,1,0,15));

		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception ex) { ex.printStackTrace(); }
	}
	
	public void makeTrack(int[] trackList) {
		for (int i = 0; i < 16; i++) {
			int key = trackList[i];
			if (key != 0) {
				track.add(makeMidiEvent(144,9,key,100,i));
				track.add(makeMidiEvent(128,9,key,100,i+1));
			}
		}
	}
	
	public MidiEvent makeMidiEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			var msg = new ShortMessage();
			msg.setMessage (comd, chan, one, two);
			event = new MidiEvent(msg, tick);
		}
		catch (Exception ex) {ex.printStackTrace();}
		return event;
	}
	
	public class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			buildTrackAndStart();
		}
	}
	
	public class StopButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			sequencer.stop();
		}
	}
	
	public class UpTempoButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			var tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor(tempoFactor * 1.03f);
		}
	}

	public class DownTempoButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			var tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor(tempoFactor * 0.97f);
		}
	}
	
	public class SerializeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				var os = new ObjectOutputStream(new FileOutputStream("checkbox.ser"));
				boolean[] checkboxState = new boolean[256];
				for (int i = 0; i < 256; i++) {
					var checkbox = checkboxList.get(i);
					if (checkbox.isSelected()) {
						checkboxState[i] = true;
					}
					else checkboxState[i] = false;
				}
				
				os.writeObject(checkboxState);
				os.close();
			} 
			catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	public class RestoreButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				var is = new ObjectInputStream(new FileInputStream("checkbox.ser"));
				var checkboxState = (boolean[])is.readObject();
				
				for (int i = 0; i < 256; i++) {
					var checkbox = checkboxList.get(i);
					if (checkboxState[i]) {
						checkbox.setSelected(true);
					}
					else checkbox.setSelected(false);
				}
				is.close();
				sequencer.stop();
				buildTrackAndStart();
			} 
			catch (Exception e) { e.printStackTrace(); }
		}
	}
}