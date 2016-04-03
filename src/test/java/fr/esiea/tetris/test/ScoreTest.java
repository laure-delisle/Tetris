package fr.esiea.tetris.test;

import fr.esiea.tetris.model.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class ScoreTest {
	@Test
	public void shouldCreateScore() {
		Score score = new Score();
		assertEquals(score.getScore(),0);
	}
	
	@Test
	public void shouldIncrementScore() {
		Score score = new Score();
		score.incrementScore(1);
		assertEquals(score.getScore(),10);
	}
	
	
}
