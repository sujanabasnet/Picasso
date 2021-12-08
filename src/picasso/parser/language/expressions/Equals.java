/**
 * 
 */
package picasso.parser.language.expressions;

import java.util.HashMap;
import java.util.Map;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author andrewmarsh
 *
 */
public class Equals extends ExpressionTreeNode{

	String variabelName;
	ExpressionTreeNode expression;
	private static Map<String, ExpressionTreeNode> expressionMap = new HashMap<String, ExpressionTreeNode>();
	
	/**
	 * 
	 */
	public Equals(String variableName, ExpressionTreeNode expression) {
		this.variabelName = variableName;
		this.expression = expression;
		expressionMap.put(this.variabelName, this.expression);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return expression.evaluate(x, y);
	}
	
	public static ExpressionTreeNode getExpression(String name) {
		return expressionMap.get(name);
	}
	
}
