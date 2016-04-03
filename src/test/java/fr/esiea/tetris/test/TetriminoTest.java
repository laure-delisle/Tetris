package fr.esiea.tetris.test;

import org.junit.*;

import static org.junit.Assert.*;
import fr.esiea.tetris.model.*;

public class TetriminoTest {
	
	int[][][] expected = { {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},
							{{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}},
							{{0,3,0,0},{0,3,3,0},{0,3,0,0},{0,0,0,0}},
							{{0,4,0,0},{0,4,4,0},{0,0,4,0},{0,0,0,0}},
							{{0,0,5,0},{0,5,5,0},{0,5,0,0},{0,0,0,0}},
							{{0,0,6,0},{0,0,6,0},{0,6,6,0},{0,0,0,0}},
							{{0,7,0,0},{0,7,0,0},{0,7,7,0},{0,0,0,0}} };
	
	@Test
	public void shouldCreateTetrimino() {
		Tetrimino tetrimino = Tetrimino.getInstance();
		tetrimino.init();
		int id = tetrimino.tetriminoArray[0][1];
		if (id == 0)
			id = tetrimino.tetriminoArray[0][2];
		assertArrayEquals(tetrimino.tetriminoArray,expected[id-1]);
	}
	
}
