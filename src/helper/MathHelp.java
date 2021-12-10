package helper;

/**
 * Holds reusable functions 
 * 
 * @author Praise Apata
 */

public class MathHelp {
	
	public static double wrap(double wrappedN) {
		
		double result = 0;
		if (wrappedN > 1) {
			while (wrappedN > 1) {
				wrappedN = wrappedN - 2;
			}
			result = wrappedN;
		}
		if (wrappedN < -1) {
			while (wrappedN < -1) {
				wrappedN = wrappedN + 2;
			}
			result = wrappedN;
		} else {
			result = wrappedN;
		}
		return result;
	}

}
