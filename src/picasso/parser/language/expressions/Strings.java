/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Strings function in the Picasso language.
 * 
 * @author sarahmartin
 *
 */
public class Strings extends StringFunction {
	ExpressionTreeNode node;
	/**
	 * Create a string expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to sine
	 */
	public Strings(String s) {
		super(s);
		this.node = stringToEtn(s);
	}

	/**
	 * 
	 * 
	 * @return the color 
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = node.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}
	

}


