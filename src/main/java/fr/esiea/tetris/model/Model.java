package fr.esiea.tetris.model;

public class Model {
	Score score;
	Board board;
	Tetrimino tetrimino;
	private int nextX;
	private int nextY;
	private int[][] nextArray;
	
	public Model() {
		score = new Score();
		board = new Board();
		tetrimino = new Tetrimino();
	}
	
	public void newTetrimino()
	{
		tetrimino.init();
		nextX = 0;
		nextY = 3;
	}
	
	public void turnTetrimino() {
		nextArray = tetrimino.arrayOrientations[(tetrimino.orientation+1)%4];
		if (! blocked()) {
			tetrimino.turn();
		}
	}
	
	public void moveLeft() {
		nextY = tetrimino.posY - 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.left();
		}
	}

	public void moveRight() {
		nextY = tetrimino.posY + 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.right();
		}
	}

	public void moveDown() {
		nextX = tetrimino.posX + 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.down();
		}
	}
	
	public boolean blocked(){
		//collision bord droit
		if (this.blocked_right())
			return true;
		//collision bord gauche
		if (this.blocked_left())
			return true;
		//collision bord bas
		if (this.blocked_down())
			return true;
		//collision décor
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((board.boardArray[nextX+i][nextY+j] != 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_down() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextX+i >= 20) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_left() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextY+j < 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_right() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((nextY+j >= 10) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
