package fr.esiea.tetris.model;

public class Board {
	public int[][] boardArray;
	
	public Board() {
		boardArray = new int[16][10];
	}
	
	public void init() {
		for (int i = 0; i < 16; i++){
			for (int j = 0; j < 10; j++) {
				boardArray[i][j] = 0;
			}
		}
	}
	
	public int checkLine() {
		int lines = 0;
		boolean isLineComplete;
		for (int i = 15; i >= 0; i--){
			isLineComplete = true;
			for (int j = 0; j < 10; j++) {
				if (boardArray[i][j] == 0) {
					isLineComplete = false;
					break;
				}
			}
			if (isLineComplete) {
				lines++;
				cleanLine(i);
				isLineComplete = false;
				//la ligne est descendue, il faut la revérifier
				i++;
			}
		}
		return lines;
	}
	
	public void cleanLine(int lineToClean){
		for (int i = lineToClean; i >= 0; i--){
			for (int j = 0; j < 10; j++) {
				//on vide la ligne
				boardArray[i][j] = 0;
				//décallage ligne vers le bas
				if (i>0)
					boardArray[i][j] = boardArray[i-1][j];
			}
		}
		for (int j = 0; j < 10; j++) {
			//ligne du haut remise à 0
			boardArray[0][j] = 0;
		}
	}
	
}
