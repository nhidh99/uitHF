import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {
	
	private ArrayList<QuizCard> cardList;
	private JTextArea questionTextArea;
	private JTextArea answerTextArea;
	private JFrame frame;
	
	public static void main(String[] args) {
		new QuizCardBuilder().buildGUI();
	}
	
	public void buildGUI() {
		cardList = new ArrayList<QuizCard>();
		frame = new JFrame("Quiz Card");
		var panel = buildPlayPanel();
		var menu = buildMenuBar();
		
		frame.setJMenuBar(menu);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(500, 550);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private JPanel buildPlayPanel() {
		var questionLabel = new JLabel("Question");
		var answerLabel = new JLabel("Answer");		
		var questionPane = buildQuestionPane();
		var answerPane = buildAnswerPane();
		
		var nextButton = new JButton("Next Card");		
		nextButton.addActionListener(new NextButtonListener());
		
		var playPanel = new JPanel();
		playPanel.add(questionLabel);
		playPanel.add(questionPane);
		playPanel.add(answerLabel);
		playPanel.add(answerPane);
		playPanel.add(nextButton);
		return playPanel;
	}
	
	private JScrollPane buildQuestionPane() {
		var font = new Font("sanserif", Font.BOLD, 24);
		questionTextArea = new JTextArea(6, 20);
		questionTextArea.setLineWrap(true);
		questionTextArea.setFont(font);
		
		var questionPane = new JScrollPane(questionTextArea);
		questionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		questionPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		return questionPane;
	}
	
	private JScrollPane buildAnswerPane() {
		var font = new Font("sanserif", Font.BOLD, 24);
		answerTextArea = new JTextArea(6, 20);
		answerTextArea.setLineWrap(true);
		answerTextArea.setFont(font);
		
		var answerPane = new JScrollPane(answerTextArea);
		answerPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		answerPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);				
		return answerPane;
	}
	
	private JMenuBar buildMenuBar() {
		var menuBar = new JMenuBar();
		var fileMenu = new JMenu("File");

		var newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new NewMenuItemListener());
		
		var saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		return menuBar;
	}
	
	// Save the card with the contents
	private class NextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			var question = questionTextArea.getText();
			var answer = answerTextArea.getText();			
			
			if (!question.isBlank() && !answer.isBlank()) {
				cardList.add(new QuizCard(question, answer));
			}
			clearCard();
		}
	}
	
	// Clear all the saved cards
	private class NewMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cardList.clear();
			clearCard();
		}
	}
	
	// Save all the cards to text file
	private class SaveMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			var question = questionTextArea.getText();
			var answer = answerTextArea.getText();
			
			if (!question.isBlank() && !answer.isBlank()) {
				cardList.add(new QuizCard(question, answer));
			}
			var fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}
	
	private void clearCard() {
		questionTextArea.setText("");
		answerTextArea.setText("");
		questionTextArea.requestFocus();
	}
	
	private void saveFile(File file) {
		try {
			var writer = new BufferedWriter(new FileWriter(file));
			for (var card : cardList) {
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
		}
		catch (IOException ex) {
			System.out.println("Cannot save the cards!");
			ex.printStackTrace();
		}
	}
}