package fr.esiea.tetris.model;

public class Board {
	int[][] boardArray;
	
	public Board() {
		boardArray = new int[20][10];
	}
	
	public void init() {
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < 10; j++) {
				boardArray[i][j] = 0;
			}
		}
	}
	
	public int checkLine() {
		int lines = 0;
		boolean isLineComplete;
		for (int i = 0; i < 20; i++){
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
			}
		}
		return lines;
	}
	
	public void cleanLine(int lineToClean){
		for (int i = 19; i < 0; i--){
			for (int j = 0; j < 10; j++) {
				//décallage ligne vers le bas
				boardArray[i][j] = boardArray[i-1][j];
			}
		}
		for (int j = 0; j < 10; j++) {
			//ligne du haut remise à 0
			boardArray[0][j] = 0;
		}
	}
	
}
