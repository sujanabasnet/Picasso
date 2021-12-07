/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Dimension;
import helper.MathHelp;
import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.view.commands.Evaluater;

/**
 * @author sujanabasnet
 *
 */
public class ImageWrap extends MultipleArgumentFunctions {

	private Pixmap image;

	/**
	 * @param image
	 * @param expr1
	 * @param expr2
	 */
	public ImageWrap(String name, ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		super(expr1, expr2);
		image = new Pixmap(new Pixmap(name));
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = expr1.evaluate(x, y);
		RGBColor b = expr2.evaluate(x, y);
		double newX = MathHelp.wrap(a.getRed(), -1, 1);
		double newY = MathHelp.wrap(b.getRed(), -1, 1);
		Dimension size = image.getSize();
		int evalX = domainToImageScale(newX, size.width);
		int evalY = domainToImageScale(newY, size.height);	
		return new RGBColor(image.getColor(evalX, evalY));
	}
	
	public int domainToImageScale(double value, int bounds) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) (((value - Evaluater.DOMAIN_MIN) / range) * bounds);
	}
	

}
