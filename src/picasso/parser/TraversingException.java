package picasso.parser;
import javax.swing.JOptionPane;

/**
 * Describe an exception that occured while traversing the input history.
 * 
 * @author Praise Apata
 *
 */
@SuppressWarnings("serial")
public class TraversingException extends RuntimeException {

	public TraversingException(String message) {
		super("TraversingException: " + message);
		JOptionPane.showMessageDialog(null, message, "Error Notification", JOptionPane.ERROR_MESSAGE);
		
	}

}
