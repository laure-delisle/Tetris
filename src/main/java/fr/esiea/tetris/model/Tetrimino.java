package fr.esiea.tetris.model;

import java.util.Random;

public class Tetrimino {
	
	public int[] array;
	private Random random;
	private int number;
	private int[][] I = { {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0} };
	private int[][] O = { {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0} };
	private int[][] T = { {0,3,0,0,0,3,3,0,0,3,0,0,0,0,0,0},{0,0,0,0,0,0,3,0,0,3,3,3,0,0,0,0},{0,0,0,3,0,0,3,3,0,0,0,3,0,0,0,0},{0,3,3,3,0,0,3,0,0,0,0,0,0,0,0,0} }; 
	private int[][] S = { {0,4,0,0,0,4,4,0,0,0,4,0,0,0,0,0},{0,0,0,0,0,0,4,4,0,4,4,0,0,0,0,0},{0,4,0,0,0,4,4,0,0,0,4,0,0,0,0,0},{0,0,0,0,0,0,4,4,0,4,4,0,0,0,0,0} };
	private int[][] Z = { {0,0,5,0,0,5,5,0,0,5,0,0,0,0,0,0},{0,0,0,0,0,5,5,0,0,0,5,5,0,0,0,0},{0,0,5,0,0,5,5,0,0,5,0,0,0,0,0,0},{0,0,0,0,0,5,5,0,0,0,5,5,0,0,0,0} };
	private int[][] J = { {0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},{0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},{0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},{0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0} }; 
	private int[][] L = { {0,7,0,0,0,7,0,0,0,7,7,0,0,0,0,0},{0,0,0,0,0,0,0,7,0,7,7,7,0,0,0,0},{0,7,7,0,0,0,7,0,0,0,7,0,0,0,0,0},{0,0,0,0,0,7,7,7,0,7,0,0,0,0,0,0} }; 
	
	public Tetrimino() {
		random = new Random();
	}
	
	public void init() {
		number = random.nextInt(7);
		switch(number){
		case 0:
			this.array = I[0];
			break;
		case 1:
			this.array = O[0];
			break;
		case 2:
			this.array = T[0];
			break;
		case 3:
			this.array = S[0];
			break;
		case 4:
			this.array = Z[0];
			break;
		case 5:
			this.array = J[0];
			break;
		case 6:
			this.array = L[0];
			break;
		}
	}
	
	public void turn() {
		
	}
	
	public void moveLeft() {
		//TODO
	}

	public void moveRight() {
		//TODO
	}

	public void moveDown() {
		//TODO
	}
	
	public boolean blocked(){
		if (this.blocked_right())
			return true;
		if (this.blocked_left())
			return true;
		if (this.blocked_down())
			return true;
		return false;
	}

	private boolean blocked_down() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean blocked_right() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean blocked_left() {
		// TODO Auto-generated method stub
		return false;
	}

}
