/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author sarahmartin
 *
 */
public class Rgbtoycrcb extends UnaryFunction{

	/**
	 * @param param
	 * 
	 */
	public Rgbtoycrcb(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = param.evaluate(x,y);
		double red = a.getRed() * 0.2989 + a.getGreen() * 0.5866 + a.getBlue() * 0.1145;
		double green = a.getRed() * -0.1687 + a.getGreen() * -0.3312 + a.getBlue() * 0.5;
		double blue = a.getRed() * 0.5000 + a.getGreen() * -0.4183 + a.getBlue() * -0.0816;
		return new RGBColor(red, green, blue);
	}
}
