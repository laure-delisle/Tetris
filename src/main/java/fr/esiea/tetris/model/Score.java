package fr.esiea.tetris.model;

public class Score {
	private int score;
	
	public Score()
	{
		this.score = 0;
	}
	
	public void incrementScore()
	{
		this.score += 10;
	}
	
	public int getScore(){
		return this.score;
	}
}
