package io.scif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	//Random test
	public void testSquare() {
		assertEquals(App.square(5), 25);
	}
	
	@Test
	public void getClassName() {
		App app = new App();
		assertEquals(app.getClass().toString(), "class io.scif.App");
	}
	
}
