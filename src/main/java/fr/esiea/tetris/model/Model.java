package fr.esiea.tetris.model;

public class Model {
	private Score score;
	private Board board;
	private Tetrimino tetrimino;
	private int nextX;
	private int nextY;
	private int[][] nextArray;
	
	public Model() {
		score = new Score();
		board = new Board();
		tetrimino = new Tetrimino();
		this.newTetrimino();
		board.init();
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public Tetrimino getTetrimino(){
		return this.tetrimino;
	}
	
	public void newTetrimino()
	{
		tetrimino.init();
		nextX = 0;
		nextY = 3;
	}
	
	public boolean checkEndOfGame() {
		//collision décor dès le placement de la pièce
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if ((board.boardArray[nextX+i][nextY+j] != 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public void anchorTetrimino() {
		nextX = tetrimino.posX;
		nextY = tetrimino.posY;
		// ajout du Tetrimino à la board avant de passer au suivant
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < 10; j++) {
				board.boardArray[nextX+i][nextY+j] = tetrimino.array[i][j];
			}
		}
	}

	public boolean turnTetrimino() {
		nextArray = tetrimino.arrayOrientations[(tetrimino.orientation+1)%4];
		if (! blocked()) {
			tetrimino.turn();
			return true;
		}
		return false;
	}
	
	public boolean moveLeft() {
		nextY = tetrimino.posY - 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.left();
			return true;
		}
		return false;
	}

	public boolean moveRight() {
		nextY = tetrimino.posY + 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.right();
			return true;
		}
		return false;
	}

	public boolean moveDown() {
		nextX = tetrimino.posX + 1;
		nextArray = tetrimino.array;
		if (! blocked()) {
			tetrimino.down();
			return true;
		}
		return false;
	}
	
	private boolean blocked(){
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
