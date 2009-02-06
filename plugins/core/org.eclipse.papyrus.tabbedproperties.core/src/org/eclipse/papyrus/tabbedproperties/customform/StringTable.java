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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.customform;

import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.tabbedproperties.core.Activator;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.ListPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * It is used to display list of Strings used form ReferencedTable
 * 
 * @author Patrick Tessier
 */
public class StringTable extends AbstractCustomForm {

	/**
	 * Image for the add element button.
	 */
	final protected static Image NEW_ELEMENT_IMG = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "Add_16x16.gif");

	/**
	 * Image for the delete element button.
	 */
	final protected static Image DELETE_ELEMENT_IMG = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "Delete_16x16.gif");

	/**
	 * Image for the up button.
	 */
	final protected static Image UP_ELEMENT_IMG = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "ArrowUp_16x16.gif");

	/**
	 * Image for the down button.
	 */
	final protected static Image DOWN_ELEMENT_IMG = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "ArrowDown_16x16.gif");

	/** The parent Composite */
	protected Composite parent;

	/** this is the listener to manage add remove and move element */
	protected ListPropertyChangeListener<String> listPropertyChangeListener;

	/** list of element that we want to display **/
	protected List<String> listElement;

	/**
	 * main composite of this complex composite.
	 */
	protected Composite composite;

	/**
	 * Label above the table.
	 */
	protected CLabel label;

	/**
	 * Table that displays a property for the current element.
	 */
	protected Table table;

	/** the table viewer to associate the label provider **/
	protected TableViewer tableViewer;

	/**
	 * Button that adds an element.
	 */
	protected Button addButton;

	/**
	 * Button that removes an element.
	 */
	protected Button removeButton;

	/**
	 * button that moves the element up.
	 */
	protected Button upButton;

	/**
	 * button that moves the element down.
	 */
	protected Button downButton;

	// listeners for buttons
	/**
	 * Listener for the add button.
	 */
	protected MouseListener addButtonlistener;

	/**
	 * Listener for the delete button.
	 */
	protected MouseListener removeButtonlistener;

	/**
	 * Listener for the up button.
	 */
	protected MouseListener upButtonlistener;

	/**
	 * Listener for the down button.
	 */
	protected MouseListener downButtonlistener;

	/**
	 * 
	 */
	protected Listener tableListener;

	/**
	 * the constructor
	 * 
	 * @param labeltoDisplay
	 *            the label to display
	 * @param filter
	 *            the filter in order to choose an adding element
	 * @param backboneContext
	 *            very important to acces to ressources
	 */
	public StringTable(String labeltoDisplay, BackboneContext backboneContext) {
		super(labeltoDisplay, backboneContext);
		this.addButtonlistener = new AddButtonlistener();
		this.removeButtonlistener = new RemoveButtonlistener();
		this.upButtonlistener = new UpButtonlistener();
		this.downButtonlistener = new DownButtonlistener();
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		this.parent = parent;
		composite = getWidgetFactory().createFlatFormComposite(parent);
		if (parent instanceof ExpandableComposite) {
			((ExpandableComposite) parent).setClient(composite);
		}

		FormData data;
		// ///////////////////////////////////////////////////////////////////////////
		// Create and place button vertically on the left side
		// Button : Add Element
		// Button Delete Element
		// //////////////////////////////////////////////////////////////////////////////////
		removeButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		removeButton.setVisible(true);
		removeButton.setImage(DELETE_ELEMENT_IMG);
		removeButton.setToolTipText("Delete selected element(s)");
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		removeButton.setLayoutData(data);
		removeButton.addMouseListener(removeButtonlistener);

		addButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		addButton.setVisible(true);
		addButton.setImage(NEW_ELEMENT_IMG);
		addButton.setToolTipText("Add a new element");

		data = new FormData();
		// data.top = new FormAttachment(label, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(removeButton, -ITabbedPropertyConstants.HSPACE);
		addButton.setLayoutData(data);
		addButton.addMouseListener(addButtonlistener);

		// Button Up
		upButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		upButton.setVisible(true);
		upButton.setImage(UP_ELEMENT_IMG);
		upButton.setToolTipText("Up");

		data = new FormData();
		// data.top = new FormAttachment(removeButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(addButton, -ITabbedPropertyConstants.HSPACE);
		upButton.setLayoutData(data);
		upButton.addMouseListener(upButtonlistener);

		// Button Down
		downButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		downButton.setVisible(true);
		downButton.setImage(DOWN_ELEMENT_IMG);
		downButton.setToolTipText("Down");

		data = new FormData();
		// data.top = new FormAttachment(upButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(upButton, -ITabbedPropertyConstants.HSPACE);
		downButton.setLayoutData(data);
		downButton.addMouseListener(downButtonlistener);

		// Create label
		label = getWidgetFactory().createCLabel(composite, labelToDisplay + ":", SWT.NONE);
		label.setLayout(new FormLayout());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(downButton, -ITabbedPropertyConstants.HSPACE - 50);
		data.top = new FormAttachment(0, 0);
		label.setLayoutData(data);

		// ///////////////////////////////////////////////////////////////////////////
		// Create and place Table
		table = getWidgetFactory().createTable(composite, SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		table.setLayout(new FormLayout());
		table.setVisible(true);
		table.addListener(SWT.MouseDoubleClick, tableListener = new EditItemListener());
		// createTable
		tableViewer = new TableViewer(table);

		data = new FormData();
		data.height = 100;
		data.top = new FormAttachment(label, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);

		table.setLayoutData(data);
		table.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
				if (table.getSelection()[0].getData() instanceof String) {
					InputStringDialog textDialog = new InputStringDialog(new Shell(), "Write a value: ", (String) table.getSelection()[0].getData());
					textDialog.open();
					textDialog.getValue();
					if (textDialog.getReturnCode() == Window.OK) {
						int location = listElement.indexOf(table.getSelection()[0].getData());
						listPropertyChangeListener.removeValue(getPropertyEditor(), (String) table.getSelection()[0].getData());
						listPropertyChangeListener.addValue(getPropertyEditor(), textDialog.getValue());
						listPropertyChangeListener.moveValue(getPropertyEditor(), textDialog.getValue(), location);
					}
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
			}
		});
	}

	/**
	 * display the content of the table
	 */
	public void initLabelProvider() {
		if (!table.isDisposed()) {
			// set the label provider
			tableViewer.setLabelProvider(new LabelProvider());
		}
	}

	/**
	 * Sets the layout data to the main composite of this complex element.
	 * 
	 * @param data
	 *            the new LayoutData
	 */
	public void setLayoutData(Object data) {
		composite.setLayoutData(data);
	}

	/**
	 * Returns the label provider for the composite
	 * 
	 * @return the label provider or <code>null</code>
	 */
	public IContentProvider getContentProvider() {

		return new TableContentProvider();

	}

	/**
	 * Listener for the Add Button Specific behavior is implemented in {@link StringTable#addButtonPressed()}.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class AddButtonlistener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			InputStringDialog textDialog = new InputStringDialog(new Shell(), "Write a value: ");
			textDialog.open();
			if (textDialog.getReturnCode() == Window.OK) {
				listPropertyChangeListener.addValue(getPropertyEditor(), textDialog.getValue());
			}
		}

	}

	/**
	 * to get the property editor , used in nested class
	 * 
	 * @return the property editor
	 */
	protected PropertyEditor getPropertyEditor() {
		return this;
	}

	/**
	 * Listener for the Remove Button Specific behavior is implemented in {@link StringTable#removeButtonPressed()}.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class RemoveButtonlistener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			// Keep selection
			TableItem[] tableItems = table.getSelection();

			for (int i = (tableItems.length - 1); i >= 0; i--) {
				listPropertyChangeListener.removeValue(getPropertyEditor(), (String) (tableItems[i].getData()));
			}
		}
	}

	/**
	 * Listener for the Up Button Specific behavior is implemented in {@link StringTable#upButtonPressed()}.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class UpButtonlistener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			// Keep selection
			CompoundCommand compoundCommand = new CompoundCommand();
			TableItem[] tableItems = table.getSelection();

			for (int i = (tableItems.length - 1); i >= 0; i--) {
				// Get use case

				int newIndex = listElement.indexOf(tableItems[i].getData()) - 1;
				if (newIndex < listElement.size()) {
					// Move
					listPropertyChangeListener.moveValue(getPropertyEditor(), (String) tableItems[i].getData(), newIndex);
				}
			}

		}
	}

	/**
	 * Listener for the Down Button Specific behavior is implemented in {@link StringTable#downButtonPressed()}.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class DownButtonlistener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			CompoundCommand compoundCommand = new CompoundCommand();
			TableItem[] tableItems = table.getSelection();

			for (int i = (tableItems.length - 1); i >= 0; i--) {
				// Get use case
				int newIndex = listElement.indexOf(tableItems[i].getData()) + 1;
				if (newIndex >= 0) {
					// Move
					listPropertyChangeListener.moveValue(getPropertyEditor(), (String) tableItems[i].getData(), newIndex);
				}
			}
		}
	}

	/**
	 * 
	 */
	private class EditItemListener implements Listener {

		/** @{inheritDoc */
		public void handleEvent(Event event) {
			if (table.getSelection().length > 0) {
				TableItem item = table.getSelection()[0];
				// editItem(item);
			}
		}
	}

	/**
	 * removes listeners from buttons.
	 */
	public void dispose() {
		if (addButton != null && !addButton.isDisposed())
			addButton.removeMouseListener(addButtonlistener);
		if (removeButton != null && !removeButton.isDisposed())
			removeButton.removeMouseListener(removeButtonlistener);
		if (upButton != null && !upButton.isDisposed())
			upButton.removeMouseListener(upButtonlistener);
		if (downButton != null && !downButton.isDisposed())
			downButton.removeMouseListener(downButtonlistener);
		if (table != null && !table.isDisposed())
			table.removeListener(SWT.MouseDoubleClick, tableListener);
	}

	/**
	 * get the list of element to display
	 * 
	 * @return the list of element
	 */
	public List<String> getListElement() {
		return listElement;
	}

	/**
	 * set the backboneContext
	 * 
	 * @param backboneContext
	 */
	public void setBackboneContext(BackboneContext backboneContext) {
		this.backboneContext = backboneContext;
	}

	/**
	 * set list of element to display
	 * 
	 * @param listElement
	 */
	public void setValue(List<String> listElement) {
		this.listElement = listElement;
		initLabelProvider();
		tableViewer.setContentProvider(getContentProvider());
		tableViewer.setInput(listElement);
	}

	/**
	 * this is the content provider to display the list of element
	 * 
	 * @author Patrick Tessietr
	 * 
	 */
	public class TableContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return listElement.toArray();
		}
	}

	/**
	 * set the listener of the table
	 * 
	 * @param listPropertyChangeListener
	 *            it do the job to move remove and add element
	 */
	public void setPropertyChangeListener(ListPropertyChangeListener<String> listPropertyChangeListener) {
		this.listPropertyChangeListener = listPropertyChangeListener;

	}

}
