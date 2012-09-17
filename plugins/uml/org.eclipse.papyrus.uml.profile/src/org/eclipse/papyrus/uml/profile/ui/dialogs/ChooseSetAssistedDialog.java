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
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;


/**
 * Generic dialog that allows user to add/remove items to an element, with
 * a field with code assist to choose element.
 */
public class ChooseSetAssistedDialog extends Dialog implements IChooseDialog {

	/**
	 * debug channel.
	 */
	protected static final int channel = 19;

	/**
	 * Label above possible element list.
	 */
	protected String possibleText = "Choose Element";

	/**
	 * Label above selected elements list.
	 */
	protected String selectedText = "Selected Element(s)";

	// buttons
	/**
	 * add button.
	 */
	protected Button addButton;

	/**
	 * remove button.
	 */
	protected Button removeButton;

	/**
	 * up button.
	 */
	protected Button upButton;

	/**
	 * down button.
	 */
	protected Button downButton;

	// listeners for buttons
	/**
	 * listener for the add button.
	 */
	protected MouseListener addButtonListener = null;

	/**
	 * listener for the delete button.
	 */
	protected MouseListener deleteButtonListener = null;

	/**
	 * listener for the up button.
	 */
	protected MouseListener upButtonListener = null;

	/**
	 * listener for the down button.
	 */
	protected MouseListener downButtonListener = null;

	/**
	 * listener for the items to add the item from the possible table (action on double click).
	 */
	protected MouseListener addItemListener = null;

	/**
	 * listener for the items to remove the item from the selectedElement table (action on double click).
	 */
	protected MouseListener removeItemListener = null;

	/**
	 * listener for the text control that do action when Carriage Return is pressed.
	 */
	protected KeyTextListener keyTextListener = null;

	// tables that displays elements selected or available
	/**
	 * table for possible elements.
	 */
	protected Table possibleElementsTable;

	/**
	 * table for selected elements.
	 */
	protected Table selectedElementsTable;

	/**
	 * Tabler viewer associated to the Table of selected elements.
	 */
	protected TableViewer selectedElementsTableViewer;

	/**
	 * Tabler viewer associated to the Table of possible elements.
	 */
	protected TableViewer possibleElementsTableViewer;

	/**
	 * label provider for the table viewers.
	 */
	protected LabelProvider labelProvider;

	/**
	 * {@link DecoratedContentProposalProvider} for the assisted text area.
	 */
	protected DecoratedContentProposalProvider decoratedContentProposalProvider;

	/**
	 * List of selected elements.
	 */
	protected ElementList selectedElementList = new ElementList();

	/**
	 * List of possible elements.
	 */
	protected ElementList possibleElementList = new ElementList();

	/**
	 * Text control to select elements from possible element list.
	 */
	protected Text possibleElementsText;

	// label ubove tables
	/**
	 * Label ubove possible elements table.
	 */
	protected Label possibleElementsLabel;

	/**
	 * Label ubove possible elements table.
	 */
	protected Label selectedElementsLabel;

	/**
	 * The Constant IMG_UP_ARROW.
	 */
	private static final Image IMG_UP_ARROW = ImageManager.IMG_UP;

	/**
	 * The Constant IMG_DOWN_ARROW.
	 */
	private static final Image IMG_DOWN_ARROW = ImageManager.IMG_DOWN;

	/**
	 * The Constant IMG_LEFT_ARROW.
	 */
	private static final Image IMG_LEFT_ARROW = ImageManager.IMG_LEFT;

	/**
	 * The Constant IMG_RIGHT_ARROW.
	 */
	private static final Image IMG_RIGHT_ARROW = ImageManager.IMG_RIGHT;

	/**
	 * value that will be available after dialog is closed.
	 */
	protected Object value = null;

	/**
	 * Creates a new instance of this class.
	 * 
	 * @param parentShell
	 *        the parent shell for this dialog
	 * @param selectedText
	 *        the selected text
	 * @param possibleText
	 *        the possible text
	 */
	public ChooseSetAssistedDialog(Shell parentShell, String possibleText, String selectedText) {
		super(parentShell);

		// add the resize ability to the window
		setShellStyle(SWT.RESIZE | super.getShellStyle());

		// set the text for labels ubove elements lists
		if(possibleText != null) {
			this.possibleText = possibleText; //set possible Text
		}
		if(selectedText != null) {
			this.selectedText = selectedText;//set selected Label
		}

		// create listeners
		this.addButtonListener = new AddButtonListener();
		this.deleteButtonListener = new RemoveButtonListener();
		this.upButtonListener = new UpButtonListener();
		this.downButtonListener = new DownButtonListener();
		this.addItemListener = new AddItemListener();
		this.removeItemListener = new RemoveItemListener();
		this.keyTextListener = new KeyTextListener();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetDialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the buttons for button bar.
	 * 
	 * @param parent
	 *        the parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// remove default button = OK (enter pressed)
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		//place all composites
		Composite comp = (Composite)super.createDialogArea(parent);
		FormLayout layout = new FormLayout();
		comp.setLayout(layout);

		// create elements and layout them
		createElements(comp);
		setLayoutData();
		// add listenersS
		addButtonListeners();

		// set fonts for elements that require fonts
		setFonts();


		// set table viewers
		setTableViewers();

		installContentAssistantProvider();

		return comp;
	}

	/**
	 * Sets the table viewers.
	 */
	private void setTableViewers() {
		possibleElementsTableViewer = new TableViewer(possibleElementsTable);
		possibleElementsTableViewer.setLabelProvider(getLabelProvider());
		possibleElementsTableViewer.setContentProvider(new PossibleElementsContentProvider());
		possibleElementsTableViewer.setInput(possibleElementList);

		selectedElementsTableViewer = new TableViewer(selectedElementsTable);
		selectedElementsTableViewer.setLabelProvider(getLabelProvider());
		selectedElementsTableViewer.setContentProvider(new SelectedElementsContentProvider());
		selectedElementsTableViewer.setInput(selectedElementList);
	}

	/**
	 * Create elements in the dialog.
	 * 
	 * @param comp
	 *        the parent composite
	 */
	private void createElements(Composite comp) {
		// buttons
		addButton = new Button(comp, SWT.CENTER);
		addButton.setImage(IMG_RIGHT_ARROW);

		removeButton = new Button(comp, SWT.CENTER);
		removeButton.setImage(IMG_LEFT_ARROW);

		upButton = new Button(comp, SWT.CENTER);
		upButton.setImage(IMG_UP_ARROW);

		downButton = new Button(comp, SWT.CENTER);
		downButton.setImage(IMG_DOWN_ARROW);

		// texts
		possibleElementsLabel = new Label(comp, SWT.CENTER);
		possibleElementsLabel.setText(possibleText);

		selectedElementsLabel = new Label(comp, SWT.CENTER);
		selectedElementsLabel.setText(selectedText);

		// lists
		possibleElementsTable = new Table(comp, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		possibleElementsTable.addMouseListener(addItemListener);

		selectedElementsTable = new Table(comp, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		selectedElementsTable.addMouseListener(removeItemListener);

		possibleElementsText = new Text(comp, SWT.BORDER);
		possibleElementsText.addKeyListener(keyTextListener);
	}

	/**
	 * Apply Font to elements that display text.
	 */
	private void setFonts() {
		// FontData[] fontdata={new FontData("Arial", 9, SWT.NORMAL)};
		selectedElementsLabel.setFont(JFaceResources.getDialogFont());
		selectedElementsTable.setFont(JFaceResources.getDialogFont());
		possibleElementsLabel.setFont(JFaceResources.getDialogFont());
		possibleElementsTable.setFont(JFaceResources.getDialogFont());
	}

	/**
	 * Sets the layout data.
	 */
	private void setLayoutData() {
		// set data to the left elements: possible elements
		// Label: possible elements title
		FormData data;
		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		possibleElementsLabel.setLayoutData(data);

		// buttons
		// add button
		data = new FormData();
		data.top = new FormAttachment(40, 0);
		data.right = new FormAttachment(50, -(ITabbedPropertyConstants.HSPACE) / 2);
		addButton.setLayoutData(data);

		// right button
		data = new FormData();
		data.top = new FormAttachment(addButton, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.right = new FormAttachment(50, -(ITabbedPropertyConstants.HSPACE) / 2);
		removeButton.setLayoutData(data);

		// text assist field
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(addButton, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		possibleElementsText.setLayoutData(data);

		// List: possible elements list
		data = new FormData();
		data.height = 200;
		data.width = 300;
		data.top = new FormAttachment(possibleElementsLabel, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(possibleElementsText, -ITabbedPropertyConstants.VSPACE);
		data.right = new FormAttachment(addButton, -ITabbedPropertyConstants.HSPACE);
		possibleElementsTable.setLayoutData(data);

		// Right part
		// Label: selected elements title
		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.left = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		selectedElementsLabel.setLayoutData(data);

		// Label: selected elements list
		data = new FormData();
		data.left = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(selectedElementsLabel, ITabbedPropertyConstants.VSPACE);
		data.right = new FormAttachment(upButton, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		selectedElementsTable.setLayoutData(data);

		// up button
		data = new FormData();
		data.top = new FormAttachment(40, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		upButton.setLayoutData(data);

		// down button
		data = new FormData();
		data.top = new FormAttachment(upButton, ITabbedPropertyConstants.HSPACE, SWT.BOTTOM);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		downButton.setLayoutData(data);
	}

	/**
	 * Sets the focus.
	 */
	public void setFocus() {
		possibleElementsText.setFocus();
	}

	/**
	 * Add listeners to buttons.
	 */
	private void addButtonListeners() {
		addButton.addMouseListener(addButtonListener);
		removeButton.addMouseListener(deleteButtonListener);
		upButton.addMouseListener(upButtonListener);
		downButton.addMouseListener(downButtonListener);
	}

	/**
	 * Install content assistant provider.
	 */
	protected void installContentAssistantProvider() {
		KeyStroke keyStroke = null;
		char[] autoActivationCharacters = null;
		int autoActivationDelay = 500;

		ContentProposalAdapter adapter = new ContentProposalAdapter(possibleElementsText, new TextContentAdapter(), getContentProposalProvider(), keyStroke, autoActivationCharacters);
		adapter.setAutoActivationDelay(autoActivationDelay);

		// filter proposals as keys are pressed and proposals popup is present
		adapter.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);

		// replace all text
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

		//this listener is activated when a stereotype item in popup menu is selected and
		//the popup menu is closed. It is used to add the selected stereotype in to the right hand side part
		//of the dialog, so that uers can economize one key hit.
		//cf. proposalAccepted() operation in KeyTextListener
		adapter.addContentProposalListener(keyTextListener);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.IChooseDialog#getValue()
	 */
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Behavior for the add button.
	 */
	protected void runActionAdd() {
		IStructuredSelection selection = (IStructuredSelection)possibleElementsTableViewer.getSelection();
		Iterator it = selection.iterator();
		while(it.hasNext()) {
			runActionAdd(it.next());
		}
	}

	/**
	 * adds the element to the list of selected elements and remove it from the
	 * list of possible elements.
	 * 
	 * @param element
	 *        the element to add to the selected elements list
	 */
	public void runActionAdd(Object element) {
		// remove to possible list
		possibleElementList.removeElement(element);

		// add to selected list
		selectedElementList.addElement(element);

	}

	/**
	 * Behavior for the delete button.
	 */
	protected void runActionRemove() {
		IStructuredSelection selection = (IStructuredSelection)selectedElementsTableViewer.getSelection();
		Iterator it = selection.iterator();
		while(it.hasNext()) {
			runActionRemove(it.next());
		}
	}

	/**
	 * adds the element to the list of possible elements and remove it from the
	 * list of selected elements.
	 * 
	 * @param element
	 *        the element to remove from the selected elements list
	 */
	protected void runActionRemove(Object element) {
		// remove to selected list
		selectedElementList.removeElement(element);

		// add to possible list
		possibleElementList.addElement(element);
	}

	/**
	 * Behavior for the up button.
	 */
	protected void runActionUp() {
		IStructuredSelection selection = (IStructuredSelection)selectedElementsTableViewer.getSelection();
		Iterator it = selection.iterator();
		while(it.hasNext()) {
			runActionUp(it.next());
		}
	}

	/**
	 * Moves the given element up in the selected element list.
	 * 
	 * @param element
	 *        the element to move
	 */
	protected void runActionUp(Object element) {
		selectedElementList.moveElementUp(element);
	}

	/**
	 * Behavior for the bottom button.
	 */
	protected void runActionDown() {
		IStructuredSelection selection = (IStructuredSelection)selectedElementsTableViewer.getSelection();
		Iterator it = selection.iterator();
		while(it.hasNext()) {
			runActionDown(it.next());
		}
	}

	/**
	 * Moves the given element down in the selected element list.
	 * 
	 * @param element
	 *        the element to move
	 */
	protected void runActionDown(Object element) {
		selectedElementList.moveElementDown(element);
	}

	/**
	 * Behavior when item is double clicked in the possible element list.
	 * 
	 * @param item
	 *        the item
	 */
	protected void runAddItem(TableItem item) {
		if(item != null) {
			runActionAdd(item.getData());
		}
	}

	/**
	 * Behavior when item is double clicked in the selected element list.
	 * 
	 * @param item
	 *        the item
	 */
	protected void runRemoveItem(TableItem item) {
		if(item != null) {
			runActionRemove(item.getData());
		}
	}

	/**
	 * adds the element to the selected element list, given its name.
	 * 
	 * @param name
	 *        the name of the element to add
	 */
	protected void runAddElement(String name) {

	}

	/**
	 * Returns the default label provider.
	 * 
	 * @return the default label provider
	 */
	protected ILabelProvider getLabelProvider() {
		if(labelProvider == null) {
			labelProvider = new LabelProvider();
		}
		return labelProvider;
	}

	/**
	 * Returns the default content proposal provider which is added to the Text
	 * area (Singleton pattern).
	 * 
	 * @return the content proposal provider which is added to the Text area
	 */
	protected IContentProposalProvider getContentProposalProvider() {
		if(decoratedContentProposalProvider == null) {
			decoratedContentProposalProvider = new DecoratedContentProposalProvider();
		}
		return decoratedContentProposalProvider;
	}

	/**
	 * Checks if the element is selectable or not.
	 * 
	 * @param text
	 *        the text
	 * 
	 * @return <code>true</code> if the element is selectable
	 */
	protected boolean isSelectableElement(String text) {
		return false;
	}

	/**
	 * Returns the list of selected elements.
	 * 
	 * @return the list of selected elements
	 */
	public ArrayList getSelectedElements() {
		return selectedElementList.getElements();
	}

	///////////////////////////////////////////////////////////////////////////
	//	Inner classes: listener for the buttons and items of the list
	///////////////////////////////////////////////////////////////////////////
	/**
	 * listener of the button to add an element from possiblelist into selectedList.
	 * 
	 * @author Patrick Tessier
	 */
	protected class AddButtonListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public AddButtonListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
			runActionAdd();
		}
	};

	/**
	 * Listener of the button to move an element from selectedList into possiblelist.
	 * 
	 * @author Patrick Tessier
	 */
	protected class RemoveButtonListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public RemoveButtonListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
			runActionRemove();
		}
	};

	/**
	 * listener of the button to move up an element.
	 * 
	 * @author Patrick Tessier
	 */
	protected class UpButtonListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public UpButtonListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
			runActionUp();
		}
	};

	/**
	 * listener of the button to move down an element.
	 * 
	 * @author Patrick Tessier
	 */
	protected class DownButtonListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public DownButtonListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
			runActionDown();
		}
	};

	/**
	 * listener to add an item from the table.
	 * 
	 * @author Remi Schnekenburger
	 */
	protected class AddItemListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public AddItemListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			runAddItem(getItem(e));
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
		}
	};

	/**
	 * listener to remove an item from the table.
	 * 
	 * @author Remi Schnekenburger
	 */
	protected class RemoveItemListener implements MouseListener {

		/**
		 * The Constructor.
		 */
		public RemoveItemListener() {
		}

		/**
		 * Mouse double click.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			runRemoveItem(getItem(e));
		}

		/**
		 * Mouse down.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Mouse up.
		 * 
		 * @param e
		 *        the e
		 */
		public void mouseUp(MouseEvent e) {
		}
	};

	/**
	 * Listener for the {@link Text} area. On "Carriage Return"key event, tries
	 * to add the element entered in the text area in the selected element list
	 * and clear the Text area.
	 * 
	 * @author Remi Schnekenburger
	 */
	protected class KeyTextListener implements KeyListener, IContentProposalListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
		 */
		/**
		 * Key pressed.
		 * 
		 * @param e
		 *        the e
		 */
		public void keyPressed(KeyEvent e) {
			// if "enter" pressed and text is valid, add element to selected elements
			if(e.keyCode == SWT.CR) {
				if(isSelectableElement(possibleElementsText.getText())) {
					runAddElement(possibleElementsText.getText());
					possibleElementsText.setText("");
				}
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
		 */
		/**
		 * Key released.
		 * 
		 * @param e
		 *        the e
		 */
		public void keyReleased(KeyEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void proposalAccepted(IContentProposal proposal) {
			if(isSelectableElement(proposal.getContent())) {
				runAddElement(proposal.getContent());
			}

		}
	}

	/**
	 * Returns the item on which a mouse event happened.
	 * 
	 * @param event
	 *        the mouse event that happened on the item
	 * 
	 * @return the retrieved item
	 */
	protected TableItem getItem(MouseEvent event) {
		TableItem[] items = ((Table)event.getSource()).getSelection();
		if(items.length > 0) {
			return items[0];
		}
		return null;
	}

	///////////////////////////////////////////////////////////////////////////
	//	CONTENT PROPOSALS
	///////////////////////////////////////////////////////////////////////////
	/**
	 * The Class DecoratedContentProposal.
	 */
	protected class DecoratedContentProposal implements IContentProposal, Comparable<DecoratedContentProposal> {

		/**
		 * The label provider.
		 */
		protected LabelProvider labelProvider;

		/**
		 * The element.
		 */
		protected Object element;

		/**
		 * Default Constructor.
		 * 
		 * @param element
		 *        the element
		 * @param labelProvider
		 *        the {@link LabelProvider} to decorate text
		 */
		public DecoratedContentProposal(Object element, LabelProvider labelProvider) {
			this.labelProvider = labelProvider;
			this.element = element;
		}

		/**
		 * Gets the content.
		 * 
		 * @return the content
		 */
		public String getContent() {
			return labelProvider.getText(element);
		}

		/**
		 * Gets the cursor position.
		 * 
		 * @return the cursor position
		 */
		public int getCursorPosition() {
			return labelProvider.getText(element).length();
		}

		/**
		 * Gets the description.
		 * 
		 * @return the description
		 */
		public String getDescription() {
			return null;
		}

		/**
		 * Gets the label.
		 * 
		 * @return the label
		 */
		public String getLabel() {
			return labelProvider.getText(element);
		}

		/**
		 * Gets the image.
		 * 
		 * @return the image
		 */
		public Image getImage() {
			return labelProvider.getImage(element);
		}

		/**
		 * Compare to.
		 * 
		 * @param o
		 *        the o
		 * 
		 * @return the int
		 */
		public int compareTo(DecoratedContentProposal o) {
			return this.getLabel().compareTo(o.getLabel());
		}

	}

	/**
	 * Base class to propose content with a label and an image.
	 * NOTA: quick asssist processor does not actually support decorated
	 * proposals. Should be implemented...
	 * 
	 * @author Remi Schnekenburger
	 */
	protected class DecoratedContentProposalProvider implements IContentProposalProvider {

		/**
		 * Gets the proposals.
		 * 
		 * @param contents
		 *        the contents
		 * @param position
		 *        the position
		 * 
		 * @return the proposals
		 */
		public DecoratedContentProposal[] getProposals(String contents, int position) {
			// give all proposals for possible elements.
			return new DecoratedContentProposal[0];
		}
	}

	/**
	 * Content provider for the possible elements list.
	 */
	class PossibleElementsContentProvider implements IStructuredContentProvider, IListViewer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		/**
		 * Input changed.
		 * 
		 * @param newInput
		 *        the new input
		 * @param oldInput
		 *        the old input
		 * @param v
		 *        the v
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if(newInput != null) {
				((ElementList)newInput).addChangeListener(this);
			}
			if(oldInput != null) {
				((ElementList)oldInput).removeChangeListener(this);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		/**
		 * Dispose.
		 */
		public void dispose() {
			possibleElementList.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		/**
		 * Gets the elements.
		 * 
		 * @param parent
		 *        the parent
		 * 
		 * @return the elements
		 */
		public Object[] getElements(Object parent) {
			return possibleElementList.getElements().toArray();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#addElement(java.lang.Object)
		 */
		/**
		 * Adds the element.
		 * 
		 * @param element
		 *        the element
		 */
		public void addElement(Object element) {
			possibleElementsTableViewer.add(element);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#removeElement(java.lang.Object)
		 */
		/**
		 * Removes the element.
		 * 
		 * @param element
		 *        the element
		 */
		public void removeElement(Object element) {
			possibleElementsTableViewer.remove(element);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#updateElement(java.lang.Object)
		 */
		/**
		 * Update element.
		 * 
		 * @param element
		 *        the element
		 */
		public void updateElement(Object element) {
			possibleElementsTableViewer.refresh();
		}
	}


	/**
	 * Content provider for the selected elements list.
	 */
	class SelectedElementsContentProvider implements IStructuredContentProvider, IListViewer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		/**
		 * Input changed.
		 * 
		 * @param newInput
		 *        the new input
		 * @param oldInput
		 *        the old input
		 * @param v
		 *        the v
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if(newInput != null) {
				((ElementList)newInput).addChangeListener(this);
			}
			if(oldInput != null) {
				((ElementList)oldInput).removeChangeListener(this);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		/**
		 * Dispose.
		 */
		public void dispose() {
			selectedElementList.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		/**
		 * Gets the elements.
		 * 
		 * @param parent
		 *        the parent
		 * 
		 * @return the elements
		 */
		public Object[] getElements(Object parent) {
			return selectedElementList.getElements().toArray();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#addElement(java.lang.Object)
		 */
		/**
		 * Adds the element.
		 * 
		 * @param element
		 *        the element
		 */
		public void addElement(Object element) {
			selectedElementsTableViewer.add(element);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#removeElement(java.lang.Object)
		 */
		/**
		 * Removes the element.
		 * 
		 * @param element
		 *        the element
		 */
		public void removeElement(Object element) {
			selectedElementsTableViewer.remove(element);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.IListViewer#updateElement(java.lang.Object)
		 */
		/**
		 * Update element.
		 * 
		 * @param element
		 *        the element
		 */
		public void updateElement(Object element) {
			selectedElementsTableViewer.refresh();
		}

	}



	/**
	 * Long running class to set input.
	 * 
	 * @see WorkspaceModifyOperation
	 */
	private class InputOperation implements IRunnableWithProgress {


		/**
		 * 
		 * 
		 * @param monitor
		 * 
		 * @throws CoreException
		 * @throws InterruptedException
		 * @throws InvocationTargetException
		 */
		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
			//  should run in a separate process
			possibleElementsTableViewer = new TableViewer(possibleElementsTable);
			possibleElementsTableViewer.setLabelProvider(getLabelProvider());
			possibleElementsTableViewer.setContentProvider(new PossibleElementsContentProvider());
			possibleElementsTableViewer.setInput(possibleElementList);

			selectedElementsTableViewer = new TableViewer(selectedElementsTable);
			selectedElementsTableViewer.setLabelProvider(getLabelProvider());
			selectedElementsTableViewer.setContentProvider(new SelectedElementsContentProvider());
			selectedElementsTableViewer.setInput(selectedElementList);
		}

		/**
		 * The <code>WorkspaceModifyOperation</code> implementation of this <code>IRunnableWithProgress</code> method initiates a batch of changes by
		 * invoking the <code>execute</code> method as a workspace runnable
		 * (<code>IWorkspaceRunnable</code>).
		 * 
		 * @param monitor
		 * 
		 * @throws InterruptedException
		 * @throws InvocationTargetException
		 */
		public synchronized final void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			final InvocationTargetException[] iteHolder = new InvocationTargetException[1];
			try {
				IWorkspaceRunnable workspaceRunnable = new IWorkspaceRunnable() {

					public void run(IProgressMonitor pm) throws CoreException {
						try {
							execute(pm);
						} catch (InvocationTargetException e) {
							// Pass it outside the workspace runnable
							iteHolder[0] = e;
						} catch (InterruptedException e) {
							// Re-throw as OperationCanceledException, which will be
							// caught and re-thrown as InterruptedException below.
							throw new OperationCanceledException(e.getMessage());
						}
						// CoreException and OperationCanceledException are propagated
					}
				};
				ResourcesPlugin.getWorkspace().run(workspaceRunnable, monitor);
			} catch (CoreException e) {
				throw new InvocationTargetException(e);
			} catch (OperationCanceledException e) {
				throw new InterruptedException(e.getMessage());
			}
			// Re-throw the InvocationTargetException, if any occurred
			if(iteHolder[0] != null) {
				throw iteHolder[0];
			}
		}
	}

}
