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
	RGBColor color;
	
	public Randomizer() {
		random = new Random();
	}

	
	public RGBColor evaluate(double a, double b) {
		double low = -1;
		double high = 1;
		double randomValue1 = low + (high - low) * random.nextDouble();
		double randomValue2 = low + (high - low) * random.nextDouble();
		double randomValue3 = low + (high - low) * random.nextDouble();

		return new RGBColor(randomValue1, randomValue2, randomValue3);		
	}

}
