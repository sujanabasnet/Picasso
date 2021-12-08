/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}
	
	@Test
	public void testYEvaluation() {
		Y y = new Y();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), y.evaluate(i, i));
		}
	}
	

	@Test
	public void testFloorEvaluation() {
		Y y = new Y();
		Floor f = new Floor(y);
		assertEquals(new RGBColor(-1, -1, -1), f.evaluate(-0.5,  -0.5));
		assertEquals(new RGBColor(0, 0, 0), f.evaluate(0, 0));
		assertEquals(new RGBColor(0, 0, 0), f.evaluate(0.5,  0.5));
		
		X x = new X();
		f = new Floor(x);
		assertEquals(new RGBColor(-1, -1, -1), f.evaluate(-0.5,  -0.5));
		assertEquals(new RGBColor(0, 0, 0), f.evaluate(0, 0));
		assertEquals(new RGBColor(0, 0, 0), f.evaluate(0.5,  0.5));
	}
	
	@Test
	public void testCeilEvaluation() {
		Y y = new Y();
		Ceil c = new Ceil(y);
		assertEquals(new RGBColor(0, 0, 0), c.evaluate(-0.5,  -0.5));
		assertEquals(new RGBColor(0, 0, 0), c.evaluate(0, 0));
		assertEquals(new RGBColor(1, 1, 1), c.evaluate(0.5,  0.5));
		
		X x = new X();
		c = new Ceil(x);
		assertEquals(new RGBColor(0, 0, 0), c.evaluate(-0.5,  -0.5));
		assertEquals(new RGBColor(0, 0, 0), c.evaluate(0, 0));
		assertEquals(new RGBColor(1, 1, 1), c.evaluate(0.5,  0.5));
		
	}
	
	@Test
	public void testTanEvaluation() {
		Y y = new Y();
		Tan t = new Tan(y);
		assertEquals(new RGBColor(0, 0, 0), t.evaluate(0,  0));

		
		X x = new X();
		t = new Tan(x);
		assertEquals(new RGBColor(0, 0, 0), t.evaluate(0, 0));

	}
	
	@Test
	public void testAtanEvaluation() {
		Y y = new Y();
		Atan t = new Atan(y);
		assertEquals(new RGBColor(0, 0, 0), t.evaluate(0,  0));

		
		X x = new X();
		t = new Atan(x);
		assertEquals(new RGBColor(0, 0, 0), t.evaluate(0, 0));

	}

	@Test
	public void testSinEvaluation() {
		Y y = new Y();
		Sin s = new Sin(y);
		assertEquals(new RGBColor(Math.sin(0.5), Math.sin(0.5), Math.sin(0.5)), s.evaluate(0.5, 0.5));
		
		ExpressionTreeNode e = parser.makeExpression("x + y");
		s = new Sin(e);
		assertEquals(new RGBColor(Math.sin(-0.8 + 1), Math.sin(-0.8 + 1), Math.sin(-0.8 + 1)), s.evaluate(-0.8, 1));
	}
	
	@Test
	public void testLogEvaluation() {
		Y y = new Y();
		Log l = new Log(y);
		assertEquals(new RGBColor(0, 0, 0), l.evaluate(1,  1));

		X x = new X();
		l = new Log(x);
		assertEquals(new RGBColor(0, 0, 0), l.evaluate(1, 1));

	}
	
	@Test
	public void testAdditionEvaluation() {
		X x = new X();
		Y y = new Y();
		Addition a = new Addition(x,y);
		assertEquals(new RGBColor(1,1,1), a.evaluate(.5,  .5));

	}
	
	@Test
	public void testSubtracitonEvaluation() {
		X x = new X();
		Y y = new Y();
		Subtraction a = new Subtraction(x,y);
		assertEquals(new RGBColor(.5,.5,.5), a.evaluate(1,  .5));

	}
	
	@Test
	public void testMultiplicationEvaluation() {
		X x = new X();
		Y y = new Y();
		Multiplication a = new Multiplication(x,y);
		assertEquals(new RGBColor(0,0,0), a.evaluate(0,  1));

	}
	
	@Test
	public void testDivisionEvaluation() {
		X x = new X();
		Y y = new Y();
		Division a = new Division(x,y);
		assertEquals(new RGBColor(1,1,1), a.evaluate(1,  1));

	}
	
	@Test
	public void testExponentiateEvaluation() {
		X x = new X();
		Y y = new Y();
		Exponentiate a = new Exponentiate(x,y);
		assertEquals(new RGBColor(0,0,0), a.evaluate(0,  1));

	} 
	
	@Test
	public void testModEvaluation() {
		X x = new X();
		Y y = new Y();
		Mod a = new Mod(x,y);
		assertEquals(new RGBColor(0,0,0), a.evaluate(1,  1));

	} 
	
	@Test
	public void testAbsEvaluation() {
		Y y = new Y();
		Abs a = new Abs(y);
		assertEquals(new RGBColor(1, 1, 1), a.evaluate(-1,  1));

		X x = new X();
		a = new Abs(x);
		assertEquals(new RGBColor(1, 1, 1), a.evaluate(1, -1));

	}
	
	@Test
	public void testClampEvaluation() {
		Y y = new Y();
		Clamp c = new Clamp(y);
		assertEquals(new RGBColor(0, 0, 0), c.evaluate(0,  0));

		X x = new X();
		c = new Clamp(x);
		assertEquals(new RGBColor(1, 1, 1), c.evaluate(2, 2));

	}
	
	@Test
	public void testWrapEvaluation() {
		Y y = new Y();
		Wrap w = new Wrap(y);
		assertEquals(new RGBColor(0, 0, 0), w.evaluate(0,  0));

		X x = new X();
		w = new Wrap(x);
		assertEquals(new RGBColor(-0.5, -0.5, -0.5), w.evaluate(1.5, 1.5));

	}
	
	@Test
	public void testCosEvaluation() {
		Y y = new Y();
		Cos c = new Cos(y);
		assertEquals(new RGBColor(Math.cos(0.5), Math.cos(0.5), Math.cos(0.5)), c.evaluate(0.5, 0.5));
		
		ExpressionTreeNode e = parser.makeExpression("x + y");
		c = new Cos(e);
		assertEquals(new RGBColor(Math.cos(-0.8 + 1), Math.cos(-0.8 + 1), Math.cos(-0.8 + 1)), c.evaluate(-0.8, 1));
	}
	
	@Test
	public void testExpEvaluation() {
		Y y = new Y();
		Exp p = new Exp(y);
		assertEquals(new RGBColor(1, 1, 1), p.evaluate(-1,  0));

		X x = new X();
		p = new Exp(x);
		assertEquals(new RGBColor(1, 1, 1), p.evaluate(0, -1));	
	}
	/*
	@Test
	public void testRandomizerEvaluation() {
		//Y y = new Y();
		Randomizer r = new Randomizer();
	
	}*/
}

