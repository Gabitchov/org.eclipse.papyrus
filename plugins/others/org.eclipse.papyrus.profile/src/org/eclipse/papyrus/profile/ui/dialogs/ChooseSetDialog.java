/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.profile.FontManager;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;


// TODO: Auto-generated Javadoc
/**
 * Generic dialog that allows user to add/remove items to an element.
 * 
 * @author Patrick Tessier, Remi Schnekenburger
 */
public class ChooseSetDialog extends Dialog implements IChooseDialog {
	
	/**
	 * The combo.
	 */
	protected Combo combo;
	
	/**
	 * The element list.
	 */
	protected String[] elementList= {"test","test1","test2"};
	
	/**
	 * The name field.
	 */
	protected Text nameField;
	
	/**
	 * The announce.
	 */
	protected String announce="Choose your element";
	
	/**
	 * The Constant channel.
	 */
	protected static final int channel=19;
	
	/**
	 * The value.
	 */
	protected Object value=null;
	
	/**
	 * The possible element list.
	 */
	protected List possibleElementList;
	
	/**
	 * The selected element list.
	 */
	protected List selectedElementList;
	
	/**
	 * The add button.
	 */
	protected Button addButton;
	
	/**
	 * The delete button.
	 */
	protected Button deleteButton;
	
	/**
	 * The possible set text.
	 */
	protected Label possibleSetText;
	
	/**
	 * The selected element text.
	 */
	protected Label selectedElementText;
	
	/**
	 * The possible text.
	 */
	protected String possibleText="Choose Element";
	
	/**
	 * The selected text.
	 */
	protected String selectedText="Selected Element";
	
	/**
	 * The add button listener.
	 */
	protected MouseListener addButtonListener=null;
	
	/**
	 * The delete button listener.
	 */
	protected MouseListener deleteButtonListener=null;
	
	/**
	 * The up button.
	 */
	protected Button upButton;
	
	/**
	 * The bottom button.
	 */
	protected Button bottomButton;
	
	/**
	 * The up button listener.
	 */
	protected MouseListener upButtonListener=null;
	
	/**
	 * The bottom button listener.
	 */
	protected MouseListener bottomButtonListener=null;
	
	/**
	 * The Constant IMG_UP_ARROW.
	 */
	private static final Image IMG_UP_ARROW    = ImageManager.IMG_UP;
	
	/**
	 * The Constant IMG_DOWN_ARROW.
	 */
	private static final Image IMG_DOWN_ARROW  = ImageManager.IMG_DOWN;
	
	/**
	 * The Constant IMG_LEFT_ARROW.
	 */
	private static final Image IMG_LEFT_ARROW  = ImageManager.IMG_LEFT;
	
	/**
	 * The Constant IMG_RIGHT_ARROW.
	 */
	private static final Image IMG_RIGHT_ARROW = ImageManager.IMG_RIGHT;
	
	/**
	 * listener of the button to add an elment form possiblelist into selectedList.
	 * 
	 * @author Patrick Tessier
	 */
	protected class AddButtonListener implements MouseListener{
		
		/**
		 * The Constructor.
		 */
		public  AddButtonListener(){}
		
		/**
		 * Mouse double click.
		 * 
		 * @param e the e
		 */
		public void mouseDoubleClick(MouseEvent e){}
		
		/**
		 * Mouse down.
		 * 
		 * @param e the e
		 */
		public void mouseDown(MouseEvent e){}
		
		/**
		 * Mouse up.
		 * 
		 * @param e the e
		 */
		public void mouseUp(MouseEvent e){
			runActionAdd();
		}
	};
	
	/**
	 * Listener of the button to add an element form selectedList into selectedList possiblelist.
	 * 
	 * @author Patrick Tessier
	 */
	protected class DeleteButtonListener implements MouseListener{
		
		/**
		 * The Constructor.
		 */
		public  DeleteButtonListener(){}
		
		/**
		 * Mouse double click.
		 * 
		 * @param e the e
		 */
		public void mouseDoubleClick(MouseEvent e){}
		
		/**
		 * Mouse down.
		 * 
		 * @param e the e
		 */
		public void mouseDown(MouseEvent e){}
		
		/**
		 * Mouse up.
		 * 
		 * @param e the e
		 */
		public void mouseUp(MouseEvent e){
			runActionDelete();
		}
	};
	
	/**
	 * listener of the button to  move up an element.
	 * 
	 * @author Patrick Tessier
	 */
	protected class UpButtonListener implements MouseListener{
		
		/**
		 * The Constructor.
		 */
		public  UpButtonListener(){}
		
		/**
		 * Mouse double click.
		 * 
		 * @param e the e
		 */
		public void mouseDoubleClick(MouseEvent e){}
		
		/**
		 * Mouse down.
		 * 
		 * @param e the e
		 */
		public void mouseDown(MouseEvent e){}
		
		/**
		 * Mouse up.
		 * 
		 * @param e the e
		 */
		public void mouseUp(MouseEvent e){
			runActionUp();
		}
	};
	
	/**
	 * listener of the button to  move bottom an element.
	 * 
	 * @author Patrick Tessier
	 */
	protected class BottomButtonListener implements MouseListener{
		
		/**
		 * The Constructor.
		 */
		public  BottomButtonListener(){}
		
		/**
		 * Mouse double click.
		 * 
		 * @param e the e
		 */
		public void mouseDoubleClick(MouseEvent e){}
		
		/**
		 * Mouse down.
		 * 
		 * @param e the e
		 */
		public void mouseDown(MouseEvent e){}
		
		/**
		 * Mouse up.
		 * 
		 * @param e the e
		 */
		public void mouseUp(MouseEvent e){
			runActionBottom();
		}
	};
	
	
	/**
	 * The Constructor.
	 * 
	 * @param parentShell the parent shell
	 * @param selectedText the selected text
	 * @param possibleText the possible text
	 */
	public ChooseSetDialog(Shell parentShell,
							String possibleText,
							String selectedText){
		super(parentShell);
		setShellStyle(SWT.RESIZE | super.getShellStyle());
		if(possibleText!=null) {
			this.possibleText=possibleText; //set possible Text
		}
		if(selectedText!=null) {
			this.selectedText=selectedText;//set selected Label
		}
		//Add listener
		this.addButtonListener=new AddButtonListener();
		this.deleteButtonListener= new DeleteButtonListener();
		this.upButtonListener=new UpButtonListener();
		this.bottomButtonListener=new BottomButtonListener();
	}
	
	/**
	 * Creates the dialog area.
	 * 
	 * @param parent the parent
	 * 
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		//place all buttons
		Composite comp = (Composite) super.createDialogArea(parent);
		FormLayout layout = new FormLayout();
		comp.setLayout(layout);

		// initializes data
		FormData data;
		
		// create elements
		createElements(comp);
		
		// set fonts for elements that require fonts
		setFonts();
		
		// set data to the left elements: possible elements
		// Label: available elements title
		data = new FormData();
		data.top=new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.left=new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		possibleSetText.setLayoutData(data);
		
		// List: available elements list
		data =new FormData();
		data.height=200;
		data.width=300;
		data.top	= new FormAttachment(possibleSetText,ITabbedPropertyConstants.VSPACE);
		data.left	= new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		data.right 	= new FormAttachment(addButton, -ITabbedPropertyConstants.HSPACE);
		possibleElementList.setLayoutData(data);
		
		// buttons
		// add button
		data      	= new FormData();
		data.top   	= new FormAttachment(40, 0);
		data.right 	= new FormAttachment(50, -(ITabbedPropertyConstants.HSPACE)/2);
		addButton.setLayoutData(data);

		// right button
		data       = new FormData();
		data.top   = new FormAttachment(addButton, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.right = new FormAttachment(50, -(ITabbedPropertyConstants.HSPACE)/2);
		deleteButton.setLayoutData(data);
		
		// Right part
		// Label: selected elements title
		data 		= new FormData();
		data.top	= new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.left	= new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		selectedElementText.setLayoutData(data);
		
		// Label: selected elements list
		data 		= new FormData();
		data.left	= new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top 	= new FormAttachment(selectedElementText, ITabbedPropertyConstants.VSPACE);
		data.right 	= new FormAttachment(upButton, - ITabbedPropertyConstants.HSPACE);
		data.bottom	= new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		selectedElementList.setLayoutData(data);
		
		// up button
		data      	= new FormData();
		data.top   	= new FormAttachment(40, 0);
		data.right 	= new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		upButton.setLayoutData(data);

		// down button
		data       = new FormData();
		data.top   = new FormAttachment(upButton, ITabbedPropertyConstants.HSPACE, SWT.BOTTOM);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		bottomButton.setLayoutData(data);
		
		// refresh both lists
		fillSelectedElementList();
		fillPossibleElementList();
		
		// add listeners to button
		addButtonListeners();
		
		// end of the dialog
		return comp;
	}
	
	/**
	 * Create elements in the  dialog.
	 * 
	 * @param comp the parent composite
	 */
	private void createElements(Composite comp) {
		// buttons
		addButton=new Button(comp, SWT.CENTER);
		addButton.setImage(IMG_RIGHT_ARROW);
		
		deleteButton=new Button(comp, SWT.CENTER);
		deleteButton.setImage(IMG_LEFT_ARROW);
		
		upButton	= new Button(comp, SWT.CENTER);
		upButton.setImage(IMG_UP_ARROW);
		
		bottomButton = new Button(comp, SWT.CENTER);
		bottomButton.setImage(IMG_DOWN_ARROW);
		
		// texts
		selectedElementText= new Label(comp, SWT.CENTER);
		selectedElementText.setText(selectedText);
		
		possibleSetText= new Label(comp, SWT.CENTER);
		possibleSetText.setText(possibleText);
		
		// lists
		selectedElementList = new List(comp, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		possibleElementList = new List(comp, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
	}

	/**
	 * Apply Font to elements that display text.
	 */
	private void setFonts() {
		FontData[] fontdata={new FontData("Arial", 9, SWT.NORMAL)};
		Font font = new FontManager().get(fontdata);
		selectedElementText.setFont(font);
		selectedElementList.setFont(font);
		possibleSetText.setFont(font);
		possibleElementList.setFont(font);
	}

	/**
	 * Add listeners to buttons.
	 */
	private void addButtonListeners() {
		addButton.addMouseListener( addButtonListener);
		deleteButton.addMouseListener( deleteButtonListener);
		upButton.addMouseListener( upButtonListener);
		bottomButton.addMouseListener( bottomButtonListener);
	}
	
	/**
	 * Creates the composite.
	 * 
	 * @param parent the parent
	 */
	protected void createComposite(Composite parent){
		Composite comp= new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout());
	}
	
	/**
	 * fill the possible list.
	 */
	protected void fillPossibleElementList(){
		for (int i=0;i<20;i++){
			possibleElementList.add("item"+i);
		}
	}
	
	/**
	 * fill the selected list.
	 */
	protected void fillSelectedElementList(){
		for (int i=0;i<20;i++){
			selectedElementList.add("itemSelected"+i);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the buttons for button bar.
	 * 
	 * @param parent the parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		super.createButtonsForButtonBar(parent);	
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 */
	/**
	 * Button pressed.
	 * 
	 * @param buttonId the button id
	 */
	@Override
	protected void buttonPressed(int buttonId){
		super.buttonPressed(buttonId);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	/**
	 * Ok pressed.
	 */
	@Override
	protected void okPressed(){
		super.okPressed();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	/**
	 * Cancel pressed.
	 */
	@Override
	protected void cancelPressed() {
		value=null;
		super.cancelPressed();
		
	}
	
	/* (non-Javadoc)
	 * @see com.cea.papyrus.ui.dialogs.IChooseDialog#getValue()
	 */
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue(){
		return value;
	}

	/**
	 * Behavior for the add button.
	 */
	protected void runActionAdd(){
	}
	
	/**
	 * Behavior for the delete button.
	 */
	protected void runActionDelete(){
	}
	
	/**
	 * Behavior for the up button.
	 */
	protected void runActionUp(){
	}

	/**
	 * Behavior for the bottom button.
	 */
	protected void runActionBottom(){
	}
}
