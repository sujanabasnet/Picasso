/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author andrewmarsh
 *
 */
public abstract class BinaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode param;

	/**
	 * 
	 */
	public BinaryOperator(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + param + ")";
	} 

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator bo = (BinaryOperator) o;

		// check if their parameters are equal
		if (!this.param.equals(bo.param)) {
			return false;
		}
		return true;
	}

}
