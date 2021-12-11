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

	ExpressionTreeNode left;
	ExpressionTreeNode right;


	/**
	 * 
	 */
	public BinaryOperator(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right; 
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {  //
		return this.left + this.getOperation() + this.right;
	} 

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		BinaryOperator bo = (BinaryOperator) o;

		// check if their parameters are equal
		if (!this.left.equals(bo.left) && !this.right.equals(bo.right)) {
			return false;
		}
		return true;
	}
	
//	public String getOperation() { //not finished jsut trying something 
//		return "operatation";
//	}

	public abstract String getOperation(); 


}
