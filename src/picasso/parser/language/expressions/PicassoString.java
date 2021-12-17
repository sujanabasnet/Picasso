/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Dimension;

import helper.Image;
import helper.MathHelp;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the string with image name.
 * @author sujanabasnet
 *
 */
public class PicassoString extends ExpressionTreeNode {
	
	private Image image;

	/**
	 * 
	 */
	public PicassoString(String name) { 
		image = new Image(name);
		
		
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		Dimension size;
		try {
			size = image.getSize();
		} catch (NullPointerException e) {
			return new RGBColor(-1, -1, -1);
		}
		int evalX = Image.domainToImageScale(x, size.width-1);
		int evalY = Image.domainToImageScale(y, size.height-1);	
		return new RGBColor(image.getColor(evalX, evalY));

	}

}
