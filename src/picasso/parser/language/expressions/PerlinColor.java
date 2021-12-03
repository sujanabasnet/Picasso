/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author andrewmarsh
 *
 */
public class PerlinColor extends MultipleArgumentFunctions {

	/**
	 * @param expr1
	 * @param expr2
	 */
	public PerlinColor(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		super(expr1, expr2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = expr1.evaluate(x, y);
		RGBColor b = expr2.evaluate(x, y);
		double red = ImprovedNoise.noise(a.getRed() + 0.3, b.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(a.getBlue() + 0.1, b.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(a.getGreen() - 0.8, b.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}

}
