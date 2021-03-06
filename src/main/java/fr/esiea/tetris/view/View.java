package fr.esiea.tetris.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class View extends JFrame{

	//automatic
	private static final long serialVersionUID = 1L;
	private ScorePanel score;
	private BoardPanel board;
	
	public View() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 500);
		setTitle("Tetris - Baud & Delisle");
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		score = new ScorePanel();
		add(score, BorderLayout.CENTER);

		board = new BoardPanel();
		add(board, BorderLayout.EAST);
		
		setFocusable(true);
		setVisible(true);
	}
	
	public BoardPanel getBoard() {
		return this.board;
	}

	public void displayBoard(int[][] gridArray, int[][] tetriminoArray, int tetX, int tetY) {
		board.colorizeBoard(gridArray);
		board.colorizeTetrimino(gridArray, tetriminoArray, tetX, tetY);
		
	}
	
	public void updateScore(int newScore) {
		score.updateScore(newScore);
	}
	
	public void end(int finalScore) {
		score.endScore(finalScore);		
	}

}
