package picasso.view;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JList;
import javax.swing.*;
import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */

public class Frame extends JFrame {
	@SuppressWarnings("unchecked")
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
		
		//history window 
		Border blackline = BorderFactory.createTitledBorder("Saved");
		JPanel historyPane = new JPanel();
		historyPane.setBorder(blackline);

		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer()); 
		
		// add input window and evaluate button 
		JPanel inputPane = new JPanel();
		JLabel label = new JLabel("Enter Expression");
		JTextField textField = new JTextField();
		textField.setColumns(15);
		
		
		ArrayList<String> data= new ArrayList<String>();
		
		JList list;
		  
		list = new JList(data.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(6);
		//add(new JScrollPane(list));
		
        
        list.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //getContentPane().setBackground(colors[jList.getSelectedIndex()]);]
            	//textField.setText(getName());
            	textField.setText(data.get(list.getSelectedIndex()));
            }
        });
		
		
		
		JButton button2 = new JButton("Save Input");
		button2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  data.add(textField.getText());
		    	  list.setListData(data.toArray());
		      }
		});


		
		JButton button = new JButton("Evaluate");
		Evaluater evaluater = new Evaluater();
		Command<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, evaluater);
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  evaluater.setExpression(textField.getText());
		    	  action.execute(canvas.getPixmap());
		    	  canvas.refresh();
		      }
		});
		
		inputPane.add(label);
		inputPane.add(textField);
		inputPane.add(button2);
		inputPane.add(button);
		//historyPane.add(Header);
		historyPane.add(list);
		
		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(inputPane, BorderLayout.SOUTH);
		getContentPane().add(historyPane, BorderLayout.LINE_START);
		pack();

		
	}

}
