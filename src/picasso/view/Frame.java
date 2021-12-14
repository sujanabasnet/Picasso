package picasso.view;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
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
		setResizable(false);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		
		//Image interaction menu 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Image Interactions (Drop Down)");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
			    // get the path and the name
			    new Reader().execute(canvas.getPixmap());
			  }
			});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save JPG Image");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
			    // get the path and the name
			    new Writer().execute(canvas.getPixmap());
			  }
			});
		
		//Saved Variables Tab 
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Currently Defined Variables", null, tabbedPane_2, null);


		//history window 
		Border blackline = BorderFactory.createTitledBorder("Saved");
		JPanel historyPane = new JPanel();
		historyPane.setBorder(blackline);

		//arrows (NOT FUNCTIONAL YET - NO EVENT LISTENER)
		BasicArrowButton upArrow = new BasicArrowButton(BasicArrowButton.NORTH);
		BasicArrowButton downArrow = new BasicArrowButton(BasicArrowButton.SOUTH);
		
		
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
	
		JScrollPane scrollableList = new JScrollPane();
		scrollableList.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		scrollableList.setPreferredSize(new Dimension(100,100));
		
        list.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	textField.setText(data.get(list.getSelectedIndex()));
            }
        });
		
		
		JButton button2 = new JButton("Save Input");
		button2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  data.add(textField.getText());
		    	  list.setListData(data.toArray());
		    	  scrollableList.setViewportView(list);
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

		
		//history window + canvas
		JSplitPane splitPane = new JSplitPane();
		
		//JScrollBar scrollBar = new JScrollBar();
		splitPane.setLeftComponent(scrollableList);
		splitPane.setRightComponent(canvas);
		
		inputPane.add(label);
		inputPane.add(textField);
		inputPane.add(button2);
		inputPane.add(button);
		historyPane.add(list);
		
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		getContentPane().add(inputPane, BorderLayout.SOUTH);
		pack();
		
	}

}
