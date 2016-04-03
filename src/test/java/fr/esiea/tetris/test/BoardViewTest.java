package fr.esiea.tetris.test;

import static org.junit.Assert.*;
import javax.swing.JPanel;
import org.junit.Test;
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
}
