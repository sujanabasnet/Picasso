/**
 * 
 */
package helper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.view.commands.Evaluater;

/**
 * @author sujanabasnet
 *
 */
public class Image {
	public static final Color DEFAULT_COLOR = Color.BLACK;

	private String myFileName;
	private BufferedImage myImage;
	private Dimension mySize;
	/**
	 * 
	 */
	public Image(String name) {
		try {
			myFileName = name;
			myImage = ImageIO.read(new File(myFileName));
			mySize = new Dimension(myImage.getWidth(), myImage.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean isInBounds(int x, int y) {
		return (0 <= x && x < mySize.width) && (0 <= y && y < mySize.height);
	}

	public Dimension getSize() {
		return new Dimension(mySize);
	}

	/**
	 * Returns the color of the pixel at the given (x,y) coordinate if the
	 * coordinate is within the bounds of the image; otherwise returns the default
	 * color
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the color of the pixel at the given (x,y) coordinate if the
	 *         coordinate is within the bounds of the image; otherwise returns the
	 *         default color
	 */
	public Color getColor(int x, int y) {
		if (isInBounds(x, y))
			return new Color(myImage.getRGB(x, y));
		else
			return DEFAULT_COLOR;
	}
	public static int domainToImageScale(double value, int bounds) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) (((value - Evaluater.DOMAIN_MIN)/ range) * bounds);

	}

}
