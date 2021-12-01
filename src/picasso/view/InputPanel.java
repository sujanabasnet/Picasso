/**
 * 
 */
package picasso.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPanel;
import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.commands.Evaluater;

/**
 * @author sujanabasnet
 *
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	private Canvas myView;
	private JTextField textField;
	private JButton button;
	
	public InputPanel(Canvas view) {
		myView = view;
		textField = new JTextField();
		textField.setColumns(15);
		button = new JButton("Evaluate");
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if (e.getSource() == button) {
		    		  Command<Pixmap> action = new ThreadedCommand<Pixmap>(myView, new Evaluater(textField.getText()));
			    	  action.execute(myView.getPixmap());
			    	  myView.refresh();
		    	  }
		      }
		});
		add(button);
		add(textField);
	}
}
