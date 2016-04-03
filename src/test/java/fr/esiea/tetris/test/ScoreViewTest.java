package fr.esiea.tetris.test;

import fr.esiea.tetris.view.ScorePanel;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScoreViewTest {

	@Test
	public void shouldUpdateScore() {
		ScorePanel scorePanel = new ScorePanel();
		scorePanel.updateScore(10);
		assertEquals(scorePanel.getScoreValue(),"10");
	}
	
	@Test
	public void shouldUpdateScoreEnd() {
		ScorePanel scorePanel = new ScorePanel();
		scorePanel.endScore(10);
		assertEquals(scorePanel.getScoreValue(),"SCORE = 10");
		assertEquals(scorePanel.getScoreTitle(),"GAME OVER");
	}
}
