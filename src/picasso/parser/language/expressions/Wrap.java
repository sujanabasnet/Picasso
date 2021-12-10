package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import helper.MathHelp; 

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Praise Apata
 *
 */
public class Wrap extends UnaryFunction {

	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the ceiling of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the ceiling of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = MathHelp.wrap(result.getRed());
		double green = MathHelp.wrap(result.getGreen());
		double blue = MathHelp.wrap(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Wrap)) {
			return false;
		}
		Wrap w = (Wrap) obj;
		return param.equals(w.param);
	}

}
