package fr.esiea.tetris.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.esiea.tetris.model.Model;

public class MoveTest {
	
	
	@Test
	public void shouldTurnTetrimino() {
		Model model = new Model();
		int[][] beforeTurn = {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}};
		int[][] afterTurn = {{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][][] orientations = { {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},{{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}},{{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},{{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}} };
		model.getTetrimino().tetriminoArray = beforeTurn;
		model.getTetrimino().arrayOrientations = orientations;
		model.turnTetrimino();
		assertArrayEquals(model.getTetrimino().tetriminoArray,afterTurn);
	}
	
	@Test
	public void shouldMoveRightTetrimino() {
		Model model = new Model();
		int beforePosY = model.getTetrimino().posY;
		int afterPosY = beforePosY + 1;
		model.moveRight();
		assertEquals(model.getTetrimino().posY,afterPosY);
	}
	
	@Test
	public void shouldMoveLeftTetrimino() {
		Model model = new Model();
		int beforePosY = model.getTetrimino().posY;
		int afterPosY = beforePosY - 1;
		model.moveLeft();
		assertEquals(model.getTetrimino().posY,afterPosY);
	}
	
	@Test
	public void shouldMoveDownTetrimino() {
		Model model = new Model();
		int beforePosX = model.getTetrimino().posX;
		int afterPosX = beforePosX + 1;
		model.moveDown();
		assertEquals(model.getTetrimino().posX,afterPosX);
	}
	
}
