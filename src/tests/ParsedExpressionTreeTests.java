package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.StringToken;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
		
		e = parser.makeExpression("y");
		assertEquals(new Y(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);
		
		// no spaces!
		e = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Subtraction(new X(), new Y()), e);
		
		// no spaces!
		e = parser.makeExpression("x-y");
		assertEquals(new Subtraction(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Subtraction(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x - y - [ -.51, 0, 1]");
		assertEquals(new Subtraction(new Subtraction(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	
	@Test
	public void exponentiateExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x ^ y");
		assertEquals(new Exponentiate(new X(), new Y()), e);
		
		// no spaces!
		e = parser.makeExpression("x^y");
		assertEquals(new Exponentiate(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] ^ y");
		assertEquals(new Exponentiate(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x ^ y ^ [ -.51, 0, 1]");
		assertEquals(new Exponentiate(new Exponentiate(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	
	@Test
	public void multiplicationExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x * y");
		assertEquals(new Multiplication(new X(), new Y()), e);
		
		// no spaces!
		e = parser.makeExpression("x*y");
		assertEquals(new Multiplication(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] * y");
		assertEquals(new Multiplication(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x * y * [ -.51, 0, 1]");
		assertEquals(new Multiplication(new Multiplication(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	@Test
	public void modExpressionTests() {
		ExpressionTreeNode m = parser.makeExpression("x % y");
		assertEquals(new Multiplication(new X(), new Y()), m);
		
		// no spaces!
		m = parser.makeExpression("x%y");
		assertEquals(new Mod(new X(), new Y()), m);

		m = parser.makeExpression("[1,.5,-1] % y");
		assertEquals(new Mod(new RGBColor(1, .5, -1), new Y()), m);
		
		m = parser.makeExpression("x % y % [ -.51, 0, 1]");
		assertEquals(new Mod(new Mod(new X(), new Y()), new RGBColor(-.51, 0, 1)), m);
	}
	
	@Test
	public void negExpressionTests() {
		ExpressionTreeNode m = parser.makeExpression("! x");
		assertEquals(new Negate(new X()), m);
		
		// no spaces!
		m = parser.makeExpression("!y");
		assertEquals(new Negate(new Y()), m);

		m = parser.makeExpression("![1,.5,-1]");
		assertEquals(new Negate(new RGBColor(1, .5, -1)), m);

	}
	
	
	
	@Test
	public void divisionExpressionTests() {
		ExpressionTreeNode d = parser.makeExpression("x / y");
		assertEquals(new Division(new X(), new Y()), d);
		
		// no spaces!
		d = parser.makeExpression("x/y");
		assertEquals(new Division(new X(), new Y()), d);

		d = parser.makeExpression("[0, .5, 1] / y");
		assertEquals(new Division(new RGBColor(0, .5, 1), new Y()), d);
		
		d = parser.makeExpression("x / y / [ -.32, 1, 1]");
		assertEquals(new Division(new Division(new X(), new Y()), new RGBColor(-.32, 1, 1)), d);
	}
	
	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}

	@Test
	public void ceilFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("ceil( x )");
		assertEquals(new Ceil(new X()), e);

		e = parser.makeExpression("ceil( x + y )");
		assertEquals(new Ceil(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void logFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("log( x )");
		assertEquals(new Log(new X()), e);

		e = parser.makeExpression("log( x + y )");
		assertEquals(new Log(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void tanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan( x )");
		assertEquals(new Tan(new X()), e);

		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tan(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cos(new X()), e);

		e = parser.makeExpression("cos( x + y )");
		assertEquals(new Cos(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("exp( x )");
		assertEquals(new Exp(new X()), e);

		e = parser.makeExpression("exp( x + y )");
		assertEquals(new Exp(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void absFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Abs(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new Abs(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void clampFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("clamp( x )");
		assertEquals(new Clamp(new X()), e);

		e = parser.makeExpression("clamp( x + y )");
		assertEquals(new Clamp(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void sinFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("sin(x)");
		assertEquals(new Sin(new X()), e);
		
		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sin(new Addition(new X(), new Y())), e);
		
	}
	
	@Test
	public void wrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("wrap(x)");
		assertEquals(new Wrap(new X()), e);
		
		e = parser.makeExpression("wrap( x + y )");
		assertEquals(new Wrap(new Addition(new X(), new Y())), e);
		
	}
	
	@Test
	public void perlinColorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor(x,y)");
		assertEquals(new PerlinColor(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinColor(x + y, y)");
		assertEquals(new PerlinColor(new Addition(new X(), new Y()), new Y()), e);
		
	}
	
	@Test
	public void perlinBWFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinBW(x,y)");
		assertEquals(new PerlinBW(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinBW(x + y, y)");
		assertEquals(new PerlinBW(new Addition(new X(), new Y()), new Y()), e);
		
	}
	
	@Test
	public void RandomizerFunctionTests() {
		ExpressionTreeNode r = parser.makeExpression("random()");
		assertEquals(new Randomizer(), r);
		
	}
	
	@Test
	public void ycrcbtorgbFunctionTests() {
		ExpressionTreeNode r = parser.makeExpression("yCrCbToRGB(x)");
		assertEquals(new YCrCbToRGB(new X()), r);
		
		r = parser.makeExpression("yCrCbToRGB(x + y)");
		assertEquals(new YCrCbToRGB(new Addition(new X(), new Y())), r);
		
	}

	@Test
	public void rgbtoycrcbFunctionTests() {
		ExpressionTreeNode rgb = parser.makeExpression("RGBToYCrCb(x)");
		assertEquals(new RGBToYCrCb(new X()), rgb);
		
		rgb = parser.makeExpression("RGBToYCrCb(x + y)");
		assertEquals(new RGBToYCrCb(new Addition(new X(), new Y())), rgb);
		
	}
	
	
	@Test
	public void assignmentTests() {
		ExpressionTreeNode e = parser.makeExpression("a = x + y");
		ExpressionTreeNode s = parser.makeExpression("a");
		assertEquals(s, e);
		
		e = parser.makeExpression(" b = sin(y)");
		s = parser.makeExpression("b");
		assertEquals(s, e);
	}
		
	
	@Test
	public void imageWrapTests() {
		String image = "\"test.jpg\"";
		ExpressionTreeNode e = parser.makeExpression("imageWrap(\"test.jpg\", x+x, y)");
		assertEquals(new ImageWrap(image, new Addition(new X(), new Y()), new Y()), e);
	}
	
	@Test
	public void imageClipTests() {
		String image = "\"test.jpg\"";
		ExpressionTreeNode e = parser.makeExpression("imageClip(\"test.jpg\", x+x, y)");
		assertEquals(new ImageClip(image, new Addition(new X(), new Y()), new Y()), e);
	}
	
	@Test
	public void StringsTests() {
		ExpressionTreeNode e = parser.makeExpression("strings(\"hello\")");
		System.out.println(e);
		assertEquals(new Strings("hello"), e);
	}



}
