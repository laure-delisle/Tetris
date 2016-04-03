package fr.esiea.tetris.model;

import java.util.Random;

public class Tetrimino {
	
	public int[][] array;
	public int[][][] arrayPositions;
	private Random random;
	private int id;
	private int position;
	private int[][][] I = { {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},{{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}},{{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},{{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}} };
	private int[][][] O = { {{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}},{{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}},{{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}},{{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}} };
	private int[][][] T = { {{0,3,0,0},{0,3,3,0},{0,3,0,0},{0,0,0,0}},{{0,0,0,0},{0,0,3,0},{0,3,3,3},{0,0,0,0}},{{0,0,0,3},{0,0,3,3},{0,0,0,3},{0,0,0,0}},{{0,3,3,3},{0,0,3,0},{0,0,0,0},{0,0,0,0}} }; 
	private int[][][] S = { {{0,4,0,0},{0,4,4,0},{0,0,4,0},{0,0,0,0}},{{0,0,0,0},{0,0,4,4},{0,4,4,0},{0,0,0,0}},{{0,4,0,0},{0,4,4,0},{0,0,4,0},{0,0,0,0}},{{0,0,0,0},{0,0,4,4},{0,4,4,0},{0,0,0,0}} };
	private int[][][] Z = { {{0,0,5,0},{0,5,5,0},{0,5,0,0},{0,0,0,0}},{{0,0,0,0},{0,5,5,0},{0,0,5,5},{0,0,0,0}},{{0,0,5,0},{0,5,5,0},{0,5,0,0},{0,0,0,0}},{{0,0,0,0},{0,5,5,0},{0,0,5,5},{0,0,0,0}} };
	private int[][][] J = { {{0,0,6,0},{0,0,6,0},{0,6,6,0},{0,0,0,0}},{{0,0,0,0},{0,6,6,6},{0,0,0,6},{0,0,0,0}},{{0,6,6,0},{0,6,0,0},{0,6,0,0},{0,0,0,0}},{{0,0,0,0},{0,6,0,0},{0,6,6,6},{0,0,0,0}} }; 
	private int[][][] L = { {{0,7,0,0},{0,7,0,0},{0,7,7,0},{0,0,0,0}},{{0,0,0,0},{0,0,0,7},{0,7,7,7},{0,0,0,0}},{{0,7,7,0},{0,0,7,0},{0,0,7,0},{0,0,0,0}},{{0,0,0,0},{0,7,7,7},{0,7,0,0},{0,0,0,0}} }; 
	
	public Tetrimino() {
		random = new Random();
	}
	
	public void init() {
		position = 0;
		id = random.nextInt(7);
		switch(id){
		case 0:
			this.arrayPositions = I;
			break;
		case 1:
			this.arrayPositions = O;
			break;
		case 2:
			this.arrayPositions = T;
			break;
		case 3:
			this.arrayPositions = S;
			break;
		case 4:
			this.arrayPositions = Z;
			break;
		case 5:
			this.arrayPositions = J;
			break;
		case 6:
			this.arrayPositions = L;
			break;
		}
		this.array = arrayPositions[position];
	}
	
	public void turn() {
		position = (position+1)%4;
		this.array = arrayPositions[position];
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
