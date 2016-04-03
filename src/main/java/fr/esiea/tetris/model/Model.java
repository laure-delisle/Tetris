package fr.esiea.tetris.model;

public class Model {
	Score score;
	Board board;
	Tetrimino tetrimino;
	int tetX;
	int tetY;
	
	public Model() {
		score = new Score();
		board = new Board();
		tetrimino = new Tetrimino();
	}
	
	public void newTetrimino()
	{
		tetrimino.init();
		tetX = 0;
		tetY = 3;
	}
	
}
