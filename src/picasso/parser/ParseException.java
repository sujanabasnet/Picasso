package picasso.parser;
import javax.swing.JOptionPane;

/**
 * Describe an exception that occurred during parsing.
 * 
 * @author Sara Sprenkle
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	public ParseException(String message) {
		super("ParseException: " + message);
		JOptionPane.showMessageDialog(null, message, "Error Notification", JOptionPane.ERROR_MESSAGE);
		
	}

}
