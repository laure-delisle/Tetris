package fr.esiea.tetris.model;

public class Score {
	private int score;
	
	public Score()
	{
		this.score = 0;
	}
	
	public void incrementScore(int nbLines)
	{
		this.score += (10 * nbLines);
	}
	
	public int getScore(){
		return this.score;
	}
}
