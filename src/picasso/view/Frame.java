package picasso.view;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Dimension;
import picasso.parser.IdentifierAnalyzer;
import picasso.parser.ParseException;
import picasso.parser.TraversingException;
import picasso.parser.language.ExpressionTreeNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.table.DefaultTableModel;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
import picasso.view.equalsDisplay; 

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

		

		ArrayList<ExpressionTreeNode> expr = new ArrayList<ExpressionTreeNode>();
		
		//Object[] ar = exMap.entrySet().toArray();
	
		//Object[] objects = name.toArray();
		//System.out.println(Arrays.toString(objects));
		
		//DefaultTableModel model = new DefaultTableModel(objects, 1);
		//JTable table = new JTable( model ); 
		
		//customComponent
		JLabel assignName = new JLabel("Assignment Name");
		ImageIcon imageThumb = new ImageIcon("images/foo.jpg");
		


		
		//history window + canvas
		JSplitPane splitPane = new JSplitPane();
		
		//JScrollBar scrollBar = new JScrollBar();
		splitPane.setLeftComponent(scrollableList);
		splitPane.setRightComponent(canvas);
		
		
		
		//add image+expression bar
		Map<String, ExpressionTreeNode> exMap = IdentifierAnalyzer.getIdToExpression(); 
		ArrayList<String> name = new ArrayList<String>();
		for (Map.Entry<String, ExpressionTreeNode> set :
            exMap.entrySet()) {

           // Printing all elements of a Map
           name.add(set.getKey());}

		Object[] objects = name.toArray();
		DefaultListModel refreshableList = new DefaultListModel<String>(); 
		for (String key: exMap.keySet()) {
			refreshableList.addElement(key);
		}
	
		//DefaultListModel dlm = new DefaultListModel();
		
		JList objList = new JList(refreshableList);
		//JScrollPane scrollPane2 = new JScrollPane(objList);
		JPanel scrollFrameHolder = new JPanel(); 
		
		JList lista = new JList(refreshableList);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista.setVisibleRowCount(4);


		//scrollFrameHolder.add(scrollPane2);
		scrollFrameHolder.add(lista);
		scrollFrameHolder.setLayout(new FlowLayout());
		
		
		ArrayList<String> history =  new ArrayList<String>();
		
		/*
		for (Object item: objects) {
			dlm.addElement(item);
		}*/
		
		//System.out.println(objects.toString());
		
		JList historyList = new JList(history.toArray());
		historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton button = new JButton("Evaluate");
		Evaluater evaluater = new Evaluater();
		Command<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, evaluater);
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  evaluater.setExpression(textField.getText());
		    	  action.execute(canvas.getPixmap());
		    	  history.add(textField.getText());
		    	  JList historyList = new JList(history.toArray());
		    	  canvas.refresh();
		    	  System.out.println(exMap.toString());
		    	  //objects = name.toArray();
		    	  System.out.println(history.toString());
		    	  for (String key: exMap.keySet()) {
		  				refreshableList.addElement(key);
		  			}
		    	  lista.ensureIndexIsVisible(refreshableList.getSize());
		    	  System.out.println(lista.getModel().getElementAt(2));
		    	  scrollFrameHolder.add(lista);


		    	  
		    	  /*
		    	  Map<String, ExpressionTreeNode> exMap = IdentifierAnalyzer.getIdToExpression(); 
		    	  ArrayList<String> name = new ArrayList<String>();
		    	  for (Map.Entry<String, ExpressionTreeNode> set :
		            exMap.entrySet()) {

		           // Printing all elements of a Map
		           name.add(set.getKey());
		    	  }
		           Object[] objects = name.toArray();
		    	  
		    	  DefaultTableModel model = new DefaultTableModel(objects, 1);
		    	  JTable table = new JTable( model ); 
		    	  */
		      
		}});
		
		//arrows (NOT FUNCTIONAL YET - NO EVENT LISTENER)

		BasicArrowButton upArrow = new BasicArrowButton(BasicArrowButton.NORTH);
		upArrow.addMouseListener(new BasicButtonListener(upArrow) {
			int position =0;
			public void mousePressed(MouseEvent e) {
		    	  textField.setText(history.get(position).toString());
		    	  
		    	  if (position < history.size()-1) {
		    	  position+=1;
		      }
		    	  else {
		  			throw new TraversingException("End of Up Arrow History ");
		    	}
			}
		});
		BasicArrowButton downArrow = new BasicArrowButton(BasicArrowButton.SOUTH);
		downArrow.addMouseListener(new BasicButtonListener(downArrow) {
			int position =0;
			public void mousePressed(MouseEvent e) {
		    	  textField.setText(history.get(position).toString());
		    	  
		    	  if (position < history.size()-1) {
		    	  position+=1;
		      }
		    	  else {
		  			throw new TraversingException("End of Down Arrow History ");
		    	}
			}
		});
		

		
		ArrayList<Object> result = new ArrayList<Object>();
		
		for (int i=0; i < objects.length; i++) {
			Evaluater evaluater1 = new Evaluater();
			Command<Pixmap> action1 = new ThreadedCommand<Pixmap>(canvas, evaluater1);
			evaluater1.setExpression(objects[i].toString());
			action1.execute(canvas.getPixmap());
			new AutoSaveImage().execute(canvas.getPixmap(),objects[i].toString());
			
			
			//assignWithImage lista = new assignWithImage(objects[i].toString(), objects[i].toString()+".jpg" );
			//result.add(lista);
	
		}


		
		//Saved Variables Tab 
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
				
		tabbedPane.addTab("Currently Defined Variables", null, scrollFrameHolder, "Display the defined variable names and their values");

		inputPane.add(upArrow);
		inputPane.add(downArrow);
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

