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
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
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
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				//anchor only colored block :)
				if (tetrimino.tetriminoArray[i][j] != 0)
					board.boardArray[nextX+i][nextY+j] = tetrimino.tetriminoArray[i][j];
			}
		}
	}

	public boolean turnTetrimino() {
		nextArray = tetrimino.arrayOrientations[(tetrimino.orientation+1)%4];
		if (! blocked_decor()) {
			tetrimino.turn();
			return true;
		}
		return false;
	}
	
	public boolean moveLeft() {
		nextY = tetrimino.posY - 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_left()) {
			tetrimino.left();
			return true;
		}
		nextY = tetrimino.posY;
		return false;
	}

	public boolean moveRight() {
		nextY = tetrimino.posY + 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_right()) {
			tetrimino.right();
			return true;
		}
		nextY = tetrimino.posY;
		return false;
	}

	public boolean moveDown() {
		nextX = tetrimino.posX + 1;
		nextArray = tetrimino.tetriminoArray;
		if (! blocked_down()) {
			tetrimino.down();
			return true;
		}
		nextX = tetrimino.posX;
		return false;
	}
	
	private boolean blocked_decor(){
		//collision décor
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				//prevent outofbond
				if (nextArray[i][j] != 0) {
					if (board.boardArray[nextX+i][nextY+j] != 0) 
						return true;
				}
			}
		}
		return false;
	}

	private boolean blocked_down() {
		//collision bord bas
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextX+i >= 16) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		if (blocked_decor())
			return true;
		return false;
	}

	private boolean blocked_left() {
		//collision bord gauche
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextY+j < 0) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		if (blocked_decor())
			return true;
		return false;
	}

	private boolean blocked_right() {
		//collision bord droit
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				if ((nextY+j >= 10) && (nextArray[i][j] != 0)) {
					return true;
				}
			}
		}
		if (blocked_decor())
			return true;
		return false;
	}

	
	
}
