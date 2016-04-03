package fr.esiea.tetris.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.esiea.tetris.model.*;
import fr.esiea.tetris.view.*;

public class Controler {
	private Model model;
	private View view;
	private Score score;
	private KeyListener keyListener;
	private int keyCode;
	private boolean endOfGame; 
	
	public Controler() {
		this.model = new Model();
		this.view = new View();
		this.score = new Score();
		this.endOfGame = false;
		this.keyCode = 0;
		
		this.keyListener = new KeyListener() {

			public void keyPressed(KeyEvent e){

				keyCode = e.getKeyCode();

				if(keyCode == KeyEvent.VK_LEFT){
					if (model.moveLeft()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_RIGHT){
					if (model.moveRight()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_DOWN){
					if (model.moveDown()) {
						view.displayBoard();
					}
				}

				if(keyCode == KeyEvent.VK_SPACE){
					if (model.turnTetrimino()) {
						view.displayBoard();
					}
				}
				e.consume();
			}
			
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		};

		view.addKeyListener(keyListener);
		
		while (! endOfGame) {
			if (model.moveDown()) {
				view.displayBoard();
			}
			else {
				this.step();
			}
		}
		this.notifyEnd();
	}
	
	private void step() {
		//si des lignes sont complètes, on clean et on incrémente le score
		score.incrementScore(model.board.checkLine());
		model.anchorTetrimino();
		model.newTetrimino();
		view.displayBoard();
		endOfGame = model.checkEndOfGame();
	}
	
	private void notifyEnd(){
		//TODO
	}
}



