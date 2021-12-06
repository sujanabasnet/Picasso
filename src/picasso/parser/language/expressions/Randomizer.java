/**
 * 
 */
package picasso.parser.language.expressions;

import java.util.Random;

/**
 * @author Sarah Martin
 *
 */
public class Randomizer extends NoArgumentFunctions{

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
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname;
		//return classname.substring(classname.lastIndexOf(".")) + "(" + param + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof NoArgumentFunctions)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}
		return true;
	}

}
