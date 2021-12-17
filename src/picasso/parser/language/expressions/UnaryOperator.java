/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Parent class for the unary operators.
 * @author Jared Cordova
 *
 */
public abstract class UnaryOperator extends ExpressionTreeNode {
	
	ExpressionTreeNode param;


	/**
	 * 
	 */
	public UnaryOperator(ExpressionTreeNode param) {
	
		this.param = param; 
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {  //
		return this.getOperation() + this.param;
	} 

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof UnaryOperator)) {
			return false;
		}

		UnaryOperator uo = (UnaryOperator) o;

		// check if their parameters are equal
		if (!this.param.equals(uo.param)) {
			return false;
		}
		return true;
	}
	
//	public String getOperation() { //not finished just trying something 
//		return "operation";
//	}

	public abstract String getOperation(); 


}