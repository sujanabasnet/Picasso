/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
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
