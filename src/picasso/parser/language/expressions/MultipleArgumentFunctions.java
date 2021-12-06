/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author andrewmarsh
 *
 */
public abstract class MultipleArgumentFunctions extends ExpressionTreeNode {

	ExpressionTreeNode expr1;
	ExpressionTreeNode expr2;
	/**
	 * 
	 */
	public MultipleArgumentFunctions(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	public MultipleArgumentFunctions() {
		
	}

	@Override
	public String toString() {  //
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + expr1 + "," + expr2 + ")";
	} 
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof MultipleArgumentFunctions)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		MultipleArgumentFunctions maf = (MultipleArgumentFunctions) o;

		// check if their parameters are equal
		if (!(this.expr1.equals(maf.expr1) && this.expr2.equals(maf.expr2))) {
			return false;
		}
		return true;
	}
}
