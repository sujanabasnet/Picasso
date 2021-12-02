package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the arc tangent function in the Picasso language.
 * 
 * @author Praise Apata
 *
 */
public class Atan extends UnaryFunction {

	/**
	 * Create a arc tangent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to arc tangent
	 */
	public Atan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the arc tangent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the arc tangent of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

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
		if (!(obj instanceof Atan)) {
			return false;
		}
		Atan a = (Atan) obj;
		return param.equals(a.param);
	}

}
