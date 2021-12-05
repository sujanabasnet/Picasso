package helper;

public class MathHelp {
	
	public static double wrap(double wrappedN, int lower, int upper)
	{
		return lower + (wrappedN - lower) % (upper - lower);
	}

}
