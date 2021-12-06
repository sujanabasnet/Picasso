/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import java.util.Random;

/**
 * @author Sarah Martin
 *
 */
public class Randomizer extends MultipleArgumentFunctions{

	Random random;
	/**
	 * @param expr1
	 * @param expr2
	 */
	public Randomizer() {
		random = new Random();
	}

	
	public RGBColor evaluate(double a, double b) {
		double red = random.nextInt(100);
		double blue = random.nextInt(100);
		double green = random.nextInt(100);
		double signred = random.nextInt(1);
		double signblue = random.nextInt(1);
		double signgreen = random.nextInt(1);
		
		if (signred == 1) {
			red = red/100;
		}
		else if (signred == 0){
			red = -red/100;
		}
		if (signblue == 1) {
			blue = blue/100;
		}
		else if (signblue == 0){
			blue = -blue/100;
		}
		if (signgreen == 1) {
			green = green/100;
		}
		else if (signgreen == 0){
			green = -green/100;
		}
		
		
		return new RGBColor(red, green, blue);
	}

}
