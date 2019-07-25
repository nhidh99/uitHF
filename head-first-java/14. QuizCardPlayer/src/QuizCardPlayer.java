import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardPlayer {
	
	public class QuizCard {
		String question;
		String answer;
		
		public QuizCard(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}
		
		public String getQuestion() {
			return question;
		}
		
		public String getAnswer() {
			return answer;
		}
	}
	
	JFrame frame;
	ArrayList<QuizCard> cardList;
	QuizCard currentCard;
	JTextArea displayTextArea;
	JButton displayButton;
	JLabel displayLabel;
	boolean isShowAnswer;
	int currentCardIndex;
	
	public static void main(String[] args) {
		new QuizCardPlayer().buildGUI();
	}
	
	public void buildGUI() {
		frame = new JFrame("Quiz Card Player");
		var panel = buildPanel();
		var menuBar = buildMenuBar();
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(500, 330);
		frame.setVisible(true);
	}
	
	private JPanel buildPanel() {
		var panel = new JPanel();
		var questionPane = buildContentPane();
		displayLabel = new JLabel("Question");
		displayButton = new JButton("Next Question");
		displayButton.setEnabled(false);
		displayButton.addActionListener(new NextQuestionListener());
		
		panel.add(displayLabel);
		panel.add(questionPane);
		panel.add(displayButton);
		return panel;
	}
	
	private JScrollPane buildContentPane() {
		var font = new Font("sanserif", Font.BOLD, 24);
		displayTextArea = new JTextArea(6, 20);
		displayTextArea.setFont(font);
		displayTextArea.setLineWrap(true);
		displayTextArea.setEditable(false);
		
		var scroller = new JScrollPane(displayTextArea);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		return scroller;
	}
	
	private JMenuBar buildMenuBar() {
		var menuBar = new JMenuBar();
		var fileMenu = new JMenu("File");
		var loadMenuItem = new JMenuItem("Open");
		loadMenuItem.addActionListener(new OpenMenuListener());
		
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		return menuBar;
	}
	
	private class NextQuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// when the question is displayed -> show the answer
			if (isShowAnswer) {
				var answer = currentCard.getAnswer();
				displayTextArea.setText(answer);
				displayLabel.setText("Answer");
				displayButton.setText("Next Question");
				isShowAnswer = false;
			}
			
			// when the answer is displayed -> show next question
			else {
				displayLabel.setText("Question");
				if (currentCardIndex < cardList.size()) {
					showNextCard();
				}
				else {
					displayTextArea.setText("This was last card");
					displayButton.setEnabled(false);
				}
			}
		}
	}
	
	private class OpenMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			var fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
			displayButton.setEnabled(true);
			currentCardIndex = 0;
		}
	}
	
	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		displayTextArea.setText(currentCard.getQuestion());
		displayButton.setText("Show Answer");
		isShowAnswer = true;
	}
	
	private void loadFile(File file) {
		cardList = new ArrayList<QuizCard>();
		try {
			var reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
		}
		catch (Exception ex) { ex.printStackTrace(); }
	}
	
	private void makeCard(String lineToParse) {
		// lineToParse with format: question/answer
		var result = lineToParse.split("/");
		var question = result[0];
		var answer = result[1];
		var card = new QuizCard(question, answer);
		cardList.add(card);
	}
}