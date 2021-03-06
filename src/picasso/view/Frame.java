package picasso.view;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import picasso.parser.TraversingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicButtonListener;
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

@SuppressWarnings("serial")
public class Frame extends JFrame {

	@SuppressWarnings({ "unchecked", "rawtypes" })

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

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
		
		
		//history window 
		Border blackline = BorderFactory.createTitledBorder("Saved");
		JPanel historyPane = new JPanel();
		historyPane.setBorder(blackline);
		
		
		// add input window and evaluate button 
		JPanel inputPane = new JPanel();
		JLabel label = new JLabel("Expression:");
		JTextField textField = new JTextField();
		//textField.setColumns(15);
		
		
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
		
		//history window + canvas (split pane) 
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		splitPane.setLeftComponent(scrollableList);
		splitPane.setRightComponent(canvas);

	
		
		//history window + canvas
		splitPane.setLeftComponent(scrollableList);
		splitPane.setRightComponent(canvas);
		
		//history
		
		ArrayList<String> history =  new ArrayList<String>();
	
		
		JList historyList = new JList(history.toArray());
		historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton button = new JButton("Evaluate");
		Evaluater evaluater = new Evaluater();
		Command<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, evaluater);
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String input = textField.getText();
		    	  if (input.isEmpty()) {
		    		 input = RandomExpressionGenerator.getRandomExpression(0, input);
		    		 textField.setText(input);
		    	  }
		    	  evaluater.setExpression(input);
		    	  action.execute(canvas.getPixmap());
		    	  history.add(input);
		    	  canvas.refresh(); 
		}});
		
		//arrows 

		BasicArrowButton upArrow = new BasicArrowButton(BasicArrowButton.NORTH);
		upArrow.addMouseListener(new BasicButtonListener(upArrow) {
			int position =  -2;
			public void mousePressed(MouseEvent e) {
				if (position == -2) {
					position = history.size() - 1;
				}
				if (position < 0) {
					position = history.size() - 1;
					throw new TraversingException("End of History.");
				}
				else {
					textField.setText(history.get(position).toString());
					position -= 1;
				}
			}
		});
		BasicArrowButton downArrow = new BasicArrowButton(BasicArrowButton.SOUTH);
		downArrow.addMouseListener(new BasicButtonListener(downArrow) {
			int spot = 0;
			public void mousePressed(MouseEvent e) {
				if (spot < history.size()) {
					textField.setText(history.get(spot).toString());
					spot += 1;
				}
				else {
					spot = 0;
					throw new TraversingException("End of History.");
				}

			}
		});
		
		
		JButton button3 = new JButton("Evaluate in a new window");
		button3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  JFrame newFrame = new JFrame();
		    	  newFrame.setPreferredSize(size);
		    	  Canvas newCanvas = new Canvas(newFrame);
		    	  newCanvas.getPixmap().setSize(size);
		    	  Command<Pixmap> action2 = new ThreadedCommand<Pixmap>(newCanvas, evaluater);
		    	  String input = textField.getText();
		    	  if (input.isEmpty()) {
			    		 input = RandomExpressionGenerator.getRandomExpression(0, input);
			    	  }
		    	  evaluater.setExpression(input);
		    	  newFrame.setTitle(input);
		   
		    	  action2.execute(newCanvas.getPixmap());
		    	  //newCanvas.refresh();
		    	  newFrame.getContentPane().add(newCanvas);
		    	  newFrame.pack();
		    	  newFrame.setVisible(true);
		    	  newFrame.setLocation(800, 0);
		    	 
		      }
		});
		
		JButton button4 = new JButton("Clear");
		button4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  textField.setText("");
		      }
		});
		
		// make the textfield scrollable for longer expressions
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textField);
		scroll.setPreferredSize(new Dimension(150,50));


		inputPane.add(upArrow);
		inputPane.add(downArrow);
		inputPane.add(label);
		inputPane.add(scroll);
		inputPane.add(button4);
		inputPane.add(button2);
		inputPane.add(button);
		inputPane.add(button3);
		historyPane.add(list);
		
		getContentPane().add(splitPane, BorderLayout.CENTER);
		getContentPane().add(inputPane, BorderLayout.SOUTH);
		pack();
		

		}
		
	}
  	  


