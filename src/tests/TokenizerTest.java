package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}
	
	/**
	 * Test that parsing an expression with a comment works
	 */
	@Test
	public void testTokenizeComment() {
		String expression = "x // this is a comment";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(1, tokens.size());
		
		expression = "// everything is a comment";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(0, tokens.size());
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));

		// No problems here; problem will be in next step (Semantic Analysis)
		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}

	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

  
	@Test
	public void testTokenizeInvalidColor() {
		String expression = "[1, 1.0001, 1]";

		assertThrows(ParseException.class, () -> {
			tokens = tokenizer.parseTokens(expression);
		});
	}

  
	@Test
	public void testTokenizeBasicFunctionExpression() {
		String expression = "floor(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new FloorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "ceil(y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new CeilToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "tan(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new TanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "atan(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AtanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));

		expression = "abs(y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AbsToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "clamp(y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "wrap(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new WrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "random()";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RandomToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new RightParenToken(), tokens.get(2));

		expression = "sin(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new SinToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}


	@Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new PerlinColorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new FloorToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new CommaToken(), tokens.get(6));
		assertEquals(new IdentifierToken("y"), tokens.get(7));
		assertEquals(new RightParenToken(), tokens.get(8));

		expression = "sin(perlinBW(x, y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new SinToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new PerlinBWToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new CommaToken(), tokens.get(5));
		assertEquals(new IdentifierToken("y"), tokens.get(6));
		assertEquals(new RightParenToken(), tokens.get(7));
		assertEquals(new RightParenToken(), tokens.get(8));

		expression = "clamp(abs(x))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new AbsToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
		expression = "abs(clamp(y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AbsToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new ClampToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
	
		
		expression = "sin(ceil(y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new SinToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new CeilToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
		expression = "tan(atan(x))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new TanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new AtanToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
		
		expression = "atan(tan(y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AtanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new TanToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
		
		expression = "wrap(tan(x))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new WrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new TanToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
		expression = "abs(wrap(y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AbsToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new WrapToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new RightParenToken(), tokens.get(6));
		
	}

	@Test
	public void testTokenizeArithmaticExpression() {
		String expression = "x + y";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new PlusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x - y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new MinusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x * y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new StarToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x / y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new SlashToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
	}
	
	@Test
	public void testAssignment() {
		String expression = "a = sin(x)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("a"), tokens.get(0));
		assertEquals(new EqualsToken(), tokens.get(1));
		assertEquals(new SinToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));

	}

}
