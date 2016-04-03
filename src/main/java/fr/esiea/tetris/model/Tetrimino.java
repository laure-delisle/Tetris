package fr.esiea.tetris.model;

import java.util.Random;

public class Tetrimino {
	
	public int[][] tetriminoArray;
	public int posX;
	public int posY;
	public int[][][] arrayOrientations;
	private Random random;
	public int orientation;
	private int id;
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
		orientation = 0;
		posX = 0;
		posY = 3;
		id = random.nextInt(7);
		switch(id){
		case 0:
			this.arrayOrientations = I;
			break;
		case 1:
			this.arrayOrientations = O;
			break;
		case 2:
			this.arrayOrientations = T;
			break;
		case 3:
			this.arrayOrientations = S;
			break;
		case 4:
			this.arrayOrientations = Z;
			break;
		case 5:
			this.arrayOrientations = J;
			break;
		case 6:
			this.arrayOrientations = L;
			break;
		}
		this.tetriminoArray = arrayOrientations[orientation];
	}
	
	public void turn() {
		this.orientation = (orientation+1)%4;
		this.tetriminoArray = arrayOrientations[orientation];
	}
	
	public void left() {
		this.posY -=1;
	}
	
	public void right() {
		this.posY +=1;
	}
	
	public void down() {
		this.posX +=1;
	}

}


