/**
 * 
 */
package picasso.view.commands;

import java.util.Random;

/**
 * Represents a random expression generator.
 * @author sujanabasnet
 *
 */
public class RandomExpressionGenerator {
	private static final Random r = new Random();
	private static String[] unary = {"floor", "ceil", "abs", "clamp", "wrap", "sin", "cos", "tan", "atan", "exp", "log", "RGBToYCrCb", "yCrCbToRGB"};
	private static String[] multi = {"perlinColor", "perlinBW"};
	private static String[] coords = {"x", "y"};
	private static String[] chars = {"+", "-", "/", "*", "%", "^"};
	private static String[][] funcs = {unary, multi};
	private static int maxDepth = 5;


	/**
	 * 
	 */
	public RandomExpressionGenerator() {
		
	}
	
	
	/**
	 * 
	 * A random expression generator
	 */
	public static String getRandomExpression(int depth, String input) {
		
		if (depth == 0) {
			
			int decider = r.nextInt(3);
			
			if (decider == 0) {
				String[] funcList = funcs[r.nextInt(funcs.length)];
				
				if (funcList.equals(unary)) {
					return input + unary[r.nextInt(unary.length)] + "(" + getRandomExpression(depth+1, "") + ")";	
				}
				
				else if (funcList.equals(multi)) {
					return input + multi[r.nextInt(multi.length)] + "(" + getRandomExpression(depth+1, "") + "," + getRandomExpression(depth+2, "") + ")"; 
				}
			}
			else if (decider == 1) {
				double red = -1 + 2 * r.nextDouble();
				double green = -1 + 2 * r.nextDouble();
				double blue = -1 + 2 * r.nextDouble();
				String color = "[" + String.format("%.15f", red) + "," + String.format("%.15f", green) + "," + String.format("%.15f", blue) + "]";
				return color + chars[r.nextInt(chars.length)] + getRandomExpression(depth+2, "") ; 
			}
			else { return coords[r.nextInt(coords.length)] + chars[r.nextInt(chars.length)] + getRandomExpression(depth+2, "") ;}
	
		}
		
		else if  (depth < maxDepth) {
			int decider = r.nextInt(4);
			
			if (decider == 0) {
				return input + getRandomExpression(depth+1, "") + chars[r.nextInt(chars.length)] + getRandomExpression(depth+2, "");
			}
			
			else if ( decider == 1) {
				return input + unary[r.nextInt(unary.length)] + "(" + getRandomExpression(depth+1, "") + ")";
			}
			
			else if ( decider == 2) {
				return input + multi[r.nextInt(multi.length)] + "(" + getRandomExpression(depth+1, "") + "," + getRandomExpression(depth+2, "") + ")"; 
			}
			
			else {
				double red = -1 + 2 * r.nextDouble();
				double green = -1 + 2 * r.nextDouble();
				double blue = -1 + 2 * r.nextDouble();
				String color = "[" + String.format("%.15f", red) + "," + String.format("%.15f", green) + "," + String.format("%.15f", blue) + "]";
				return input + color + chars[r.nextInt(chars.length)] + getRandomExpression(depth+1, "") ;
			}
		}
		
		return input + coords[r.nextInt(coords.length)];
		
	
		
		
		
	}

}
