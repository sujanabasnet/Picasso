package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
/**
 * Represents the PerlinBW function.
 * @author andrewmarsh
 *
 */
public class PerlinBW extends MultipleArgumentFunctions {

	public PerlinBW(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		super(expr1, expr2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = expr1.evaluate(x, y);
		RGBColor b = expr2.evaluate(x, y);
		double grey = ImprovedNoise.noise(a.getRed() + b.getRed(), a.getGreen() + b.getGreen(),
				a.getBlue() + b.getBlue());
		return new RGBColor(grey, grey, grey);
	}

}
