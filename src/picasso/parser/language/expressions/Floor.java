package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the floor function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class Floor extends UnaryFunction {

	/**
	 * Create a floor expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Floor(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.floor(result.getRed());
		double green = Math.floor(result.getGreen());
		double blue = Math.floor(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
//	@Override
//	public RGBColor evaluate(double x, double y, double time) {
//		return this.evaluate(x, y);//do this in expressionTreeNode
//		//could multiply x & y by time 
//	}
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
		if (!(obj instanceof Floor)) {
			return false;
		}
		Floor f = (Floor) obj;
		return param.equals(f.param);
	}

}
