package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the cosine function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Jared Cordova
 *
 */
public class Cosine extends UnaryFunction {

	/**
	 * Create a cosine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to cosine
	 */
	public Cosine(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the cosine of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.cos(result.getRed());
		double green = Math.cos(result.getGreen());
		double blue = Math.cos(result.getBlue());

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
		if (!(obj instanceof Cosine)) {
			return false;
		}
		Cosine c = (Cosine) obj;
		return param.equals(c.param);
	}

}

