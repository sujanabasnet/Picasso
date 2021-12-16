/**
 * 
 */
package picasso.parser.language.expressions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author sarahmartin
 *
 */
public abstract class StringFunction extends ExpressionTreeNode{
	
	static Map<String, ExpressionTreeNode> charToExpression = new HashMap<String, ExpressionTreeNode>();
	private static Random rand = new Random();
	String s;
	static {
		charToExpression.put("a", new Sin(new X()));
		charToExpression.put("b", new Cos(new Y()));
		charToExpression.put("c", new Tan(new X()));
		charToExpression.put("d", new Atan(new Y()));
		charToExpression.put("e", new Abs(new Addition(new X(), new Y())));
		charToExpression.put("f", new Ceil(new Mod(new Y(), new X())));
		charToExpression.put("g", new Floor(new Subtraction(new Y(), new X())));
		charToExpression.put("h", new Rgbtoycrcb(new Mod(new Y(), new X())));
		charToExpression.put("i", new Mod(new Addition(new X(), new Y()), new X()));
		charToExpression.put("j", new Ycrcbtorgb(new Mod(new Y(), new X())));
		charToExpression.put("k", new Rgbtoycrcb(new Subtraction(new Y(), new X())));
		charToExpression.put("l", new Exp(new Multiplication(new X(), new Y())));
		charToExpression.put("m", new Cos(new Addition(new X(), new Y())));
		charToExpression.put("n", new Atan(new Mod(new Y(), new X())));
		charToExpression.put("o", new Subtraction(new Subtraction(new Y(), new X()), new Y()));
		charToExpression.put("p", new Mod(new X(), new Exp(new Ycrcbtorgb( new Y()))));
		charToExpression.put("q", new Mod(new Addition(new X(), new Y()), new X()));
		charToExpression.put("r", new Exp(new Mod(new Y(), new X())));
		charToExpression.put("s", new Rgbtoycrcb(new Division(new X(), new Y())));
		charToExpression.put("t", new Exp(new Multiplication(new Y(), new X())));
		charToExpression.put("u", new Multiplication(new Mod(new Y(), new X()), new Sin(new X())));
		charToExpression.put("v", new Sin(new Rgbtoycrcb(new X())));
		charToExpression.put("w", new Division(new Addition(new X(), new Y()), new X()));
		charToExpression.put("x", new Mod(new Cos(new X()), new Y()));
		charToExpression.put("y", new PerlinColor(new Division(new X(), new Y()), new X()));
		charToExpression.put("z", new Abs(new Multiplication(new Y(), new X())));
		
		//uppercase letters
		charToExpression.put("A", new Sin(new Y()));
		charToExpression.put("B", new Cos(new X()));
		charToExpression.put("C", new Tan(new X()));
		charToExpression.put("D", new Atan(new X()));
		charToExpression.put("E", new Abs(new Subtraction(new X(), new Y())));
		charToExpression.put("F", new Ceil(new Multiplication(new Y(), new X())));
		charToExpression.put("G", new Floor(new Addition(new Y(), new X())));
		charToExpression.put("H", new Rgbtoycrcb(new Mod(new Y(), new X())));
		charToExpression.put("I", new PerlinBW(new Addition(new X(), new Y()), new Y()));
		charToExpression.put("J", new Ycrcbtorgb(new Addition(new Y(), new X())));
		charToExpression.put("K", new Rgbtoycrcb(new Mod(new Y(), new X())));
		charToExpression.put("L", new Exp(new Division(new X(), new Y())));
		charToExpression.put("M", new Cos(new PerlinColor(new X(), new Y())));
		charToExpression.put("N", new Atan(new Subtraction(new Floor(new Y()), new X())));
		charToExpression.put("O", new Addition(new Subtraction(new Y(), new X()), new PerlinColor(new X(), new Ceil(new Y()))));
		charToExpression.put("P", new Multiplication(new Mod(new X(), new Y()), new Ycrcbtorgb( new X())));
		charToExpression.put("Q", new Division(new Addition(new X(), new Y()), new Y()));
		charToExpression.put("R", new Exp(new Mod(new Y(), new Ycrcbtorgb(new X()))));
		charToExpression.put("S", new Rgbtoycrcb(new Multiplication(new X(), new Floor(new Y()))));
		charToExpression.put("T", new Exp(new Division(new Y(), new X())));
		charToExpression.put("U", new Division(new Mod(new Y(), new X()), new Atan(new Y())));
		charToExpression.put("V", new Cos(new Rgbtoycrcb(new Y())));
		charToExpression.put("W", new Multiplication(new Subtraction(new X(), new Y()), new Y()));
		charToExpression.put("X", new Division(new Sin(new X()), new Y()));
		charToExpression.put("Y", new PerlinColor(new Multiplication(new X(), new Y()), new Y()));
		charToExpression.put("Z", new Log(new Division(new Y(), new X())));
		
		//special characters
		charToExpression.put(" ", new Multiplication(new RGBColor(-.5,.6,.2), new X()));
		charToExpression.put("!", new Multiplication(new RGBColor(-.3,.1,.8), new Y()));
		charToExpression.put("\"", new Multiplication(new RGBColor(.5,-.6,.1), new X()));
		charToExpression.put("#", new Multiplication(new RGBColor(-.11,.32,.25), new Y()));
		charToExpression.put("$",new Multiplication(new RGBColor(.6,-.7,-.12), new X()));
		charToExpression.put("%",new Multiplication(new RGBColor(.1,.4,.9), new Y()));
		charToExpression.put("&",new Multiplication(new RGBColor(-.8,.3,.99), new X()));
		charToExpression.put("'",new Multiplication(new RGBColor(0,.6,.2), new Y()));
		charToExpression.put("(",new Multiplication(new RGBColor(-.5,0,.2), new X()));
		charToExpression.put(")",new Multiplication(new RGBColor(-.5,.6,0), new Y()));
		charToExpression.put("*",new Multiplication(new RGBColor(.5,.86,.06), new X()));
		charToExpression.put("+",new Multiplication(new RGBColor(-.6,.2,.9), new Y()));
		charToExpression.put(",",new Multiplication(new RGBColor(.1,.2,.3), new X()));
		charToExpression.put("-",new Multiplication(new RGBColor(.4,.5,.6), new Y()));
		charToExpression.put(".",new Multiplication(new RGBColor(.7,.8,.9), new X()));
		charToExpression.put("/",new Multiplication(new RGBColor(.5,.3,-.6), new Y()));
		charToExpression.put(":",new Multiplication(new RGBColor(-.3,.9,-.4), new X()));
		charToExpression.put(";",new Multiplication(new RGBColor(-.4,-.6,-.07), new Y()));
		charToExpression.put("<",new Division(new RGBColor(.1,.5,.7), new X()));
		charToExpression.put("=",new Division(new RGBColor(.6,.2,.2), new Y()));
		charToExpression.put(">",new Division(new RGBColor(.31,.65,.97), new X()));
		charToExpression.put("?",new Division(new RGBColor(0,-.5,.7), new Y()));
		charToExpression.put("`",new Division(new RGBColor(.1,0,-.7), new X()));
		charToExpression.put("{",new Division(new RGBColor(-.1,.5,.44), new Y()));
		charToExpression.put("|",new Division(new RGBColor(.03,-.5,.7), new X()));
		charToExpression.put("}",new Division(new RGBColor(.1,.5,.7), new Y()));
		charToExpression.put("~",new Division(new RGBColor(.9,.234,.8), new X()));
		charToExpression.put("",new Division(new RGBColor(-.1,-.5,.7), new Y()));
		charToExpression.put("@",new Division(new RGBColor(-.33461,-.5465,.34567), new X()));
		charToExpression.put("[",new Division(new RGBColor(-.65371,.53675,.7), new Y()));
		charToExpression.put("\\",new Division(new RGBColor(.53633461,-.885465,.9934567), new X()));
		charToExpression.put("]",new Division(new RGBColor(.1,.85,.87), new Y()));
		charToExpression.put("^",new Division(new RGBColor(.3346661,.85465,-.134567), new X()));
		charToExpression.put("_",new Division(new RGBColor(-.3461,-.34575,.77777), new Y()));
		
		
		//numbers
		charToExpression.put("1", new Addition(new RGBColor(.1,.2,.3), new X()));
		charToExpression.put("2", new Addition(new RGBColor(-.4,.5,.6), new Y()));
		charToExpression.put("3", new Addition(new RGBColor(.7,-.8,.9), new X()));
		charToExpression.put("4", new Addition(new RGBColor(.123,.2234,-.3456), new Y()));
		charToExpression.put("5", new Addition(new RGBColor(.94561,-.34562,-.3), new X()));
		charToExpression.put("6", new Addition(new RGBColor(-.24561,.43562,.675633), new Y()));
		charToExpression.put("7", new Addition(new RGBColor(.456781,-.67802,-.47533), new X()));
		charToExpression.put("8", new Addition(new RGBColor(.5671,-.3582,.6793), new Y()));
		charToExpression.put("9", new Addition(new RGBColor(.4571,.552,.773), new X()));
		

	}
	/**
	 * 
	 */
	public StringFunction(String s) {
		this.s=s;
		
	}
	
	public ExpressionTreeNode stringToEtn(String s) {

		if (s.length() % 2 == 1) {
			String initialsplice = s.substring(0,1);
			ExpressionTreeNode total = charToExpression.get(initialsplice);
			
			for (int i = 1; i < s.length(); i = i + 2) {
				
				String splice = s.substring(i, i + 1);
				String splice2 = s.substring(i+1, i+2);
				
				int randnum = rand.nextInt(6);
	
				 
				if (randnum == 1) {
					ExpressionTreeNode etm =  new Multiplication(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etm);
					}
				if (randnum == 2) {
					ExpressionTreeNode etd =  new Division(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etd);
					}
				if (randnum == 3) {
					ExpressionTreeNode eta =  new Addition(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, eta);
					}
				if (randnum == 4) {
					ExpressionTreeNode etmod =  new Mod(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etmod);
					}				
				
				if (randnum == 5) {
					ExpressionTreeNode ets =  new Subtraction(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ets);
					}
//				if (randnum == 6) {
//					ExpressionTreeNode ete =  new Exponentiate(charToExpression.get(splice), charToExpression.get(splice2));
//					total = new Addition(total, ete);}
				
				
			}
			return total;
		}
		else {
			String initialsplice = s.substring(0,1);
			ExpressionTreeNode total = charToExpression.get(initialsplice);
			String secondsplice = s.substring(1,2);
			ExpressionTreeNode finalet =  new Addition(charToExpression.get(secondsplice), charToExpression.get(initialsplice));
			total = new Addition(total, finalet);
			for (int i = 2; i < s.length(); i += 2) {
				
				String splice = s.substring(i, i + 1);
				String splice2 = s.substring(i+1, i+2);
				
				int randnum = rand.nextInt(6);
	
				
				if (randnum == 1) {
					ExpressionTreeNode etm =  new Multiplication(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etm);
					}
				if (randnum == 2) {
					ExpressionTreeNode etd =  new Division(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etd);
					}
				if (randnum == 3) {
					ExpressionTreeNode eta =  new Addition(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, eta);
					}
				if (randnum == 4) {
					ExpressionTreeNode etmod =  new Mod(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, etmod);
					}				
				
				if (randnum == 5) {
					ExpressionTreeNode ets =  new Subtraction(charToExpression.get(splice), charToExpression.get(splice2));
					total = new Addition(total, ets);
					}
//				if (randnum == 6) {
//					ExpressionTreeNode ete =  new Exponentiate(charToExpression.get(splice), charToExpression.get(splice2));
//					total = new Addition(total, ete);}
				
			
			}
			
			
			return total;
		
			
		}
	}
	
	}


