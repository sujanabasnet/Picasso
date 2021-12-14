/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Dimension;

import helper.Image;
import helper.MathHelp;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author sujanabasnet
 *
 */
public class ImageClip extends MultipleArgumentFunctions {

	private Image image;

	/**
	 * @param image
	 * @param expr1
	 * @param expr2
	 */
	public ImageClip(String name, ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		super(expr1, expr2);
		image = new Image(name);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor a = expr1.evaluate(x, y);
		RGBColor b = expr2.evaluate(x, y);
		double newX = MathHelp.clamp(a.getRed());
		double newY = MathHelp.clamp(b.getRed());
		Dimension size = image.getSize();
		int evalX = Image.domainToImageScale(newX, size.width-1);
		int evalY = Image.domainToImageScale(newY, size.height-1);	
		return new RGBColor(image.getColor(evalX, evalY));
	}




}