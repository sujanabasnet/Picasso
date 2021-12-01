package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Exp function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Jared Cordova
 *
 */
public class Exp extends UnaryFunction {

	/**
	 * Create a exponential expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to exponential
	 */
	public Exp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the exponential of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the cosine of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

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
		if (!(obj instanceof Exp)) {
			return false;
		}
		Exp x = (Exp) obj;
		return param.equals(x.param);
	}

}