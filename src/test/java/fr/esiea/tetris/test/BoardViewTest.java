package fr.esiea.tetris.test;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Test;

import fr.esiea.tetris.model.Board;
import fr.esiea.tetris.model.Tetrimino;
import fr.esiea.tetris.view.BoardPanel;

public class BoardViewTest {

	@Test
	public void shouldInitBoardView() {
		BoardPanel boardPanel = new BoardPanel();
		JPanel[][] grid = boardPanel.getGrid();
		for (int i = 0; i<16; i++) {
			for (int j = 0; j<10;j++) {
				assertNotNull(grid[i][j]);
			}
		}
	}
	
	@Test
	public void shouldColorTetrimino(){
		BoardPanel boardPanel = new BoardPanel();
		Tetrimino tetrimino = Tetrimino.getInstance();
		tetrimino.init();
		Board board = new Board();
		int[][] gridArray = board.boardArray;
		boardPanel.colorizeTetrimino(gridArray, tetrimino.tetriminoArray, tetrimino.posX, tetrimino.posY);
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				if (tetrimino.tetriminoArray[i][j] != 0) {
					assertEquals((boardPanel.getGrid())[tetrimino.posX+i][tetrimino.posY+j].getBackground(),
							boardPanel.getColor(tetrimino.tetriminoArray[i][j]));
				}
			}
		}

	}
}
