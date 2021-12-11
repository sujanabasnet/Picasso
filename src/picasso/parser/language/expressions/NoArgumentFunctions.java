/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Parent class for the functions without any arguments.
 * @author sarahmartin
 *
 */
public abstract class NoArgumentFunctions extends ExpressionTreeNode{

	/**
	 * 
	 */
	public NoArgumentFunctions() {
		
	}
	
	public abstract String toString();
	
	public abstract boolean equals(Object o);

}
