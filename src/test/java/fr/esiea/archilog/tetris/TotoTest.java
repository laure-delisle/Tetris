package fr.esiea.archilog.tetris;
import static org.junit.Assert.*;
import org.junit.Test;

public class TotoTest {
	@Test
	public void shouldReturnFive(){
		Toto t = new Toto();
		assertEquals(t.titi(),5);
	}
}
