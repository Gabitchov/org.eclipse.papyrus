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
package org.eclipse.papyrus.tabbedproperties.core.forms;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.tabbedproperties.core.Activator;
import org.eclipse.papyrus.tabbedproperties.core.dialog.TabElementTreeSelectionDialog;
import org.eclipse.papyrus.tabbedproperties.core.listeners.CreateElementListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.INavigationListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.ListPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Base class for a complex section composite. This composite has a label, a table that describes a tree structure, and four buttons on the side of the table to add an element into the table, remove
 * selected element(s), move up or down the selected element.
 * 
 * @author Remi SCHNEKENBURGER
 * @author Patrick Tessier
 */
public class ReferencedTable<T extends EObject> extends AbstractPropertyEditor implements PropertyEditor {

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

	protected CreateElementListener createElement;

	/**
	 * the filter to look for a good element
	 */
	private ViewerFilter filter;

	private boolean isAbstractElement = false;

	/** BackboneContext from the selected edit part(s) * */
	protected BackboneContext backboneContext;

	/** The parent Composite */
	protected Composite parent;

	/** this is the listener to manage add remove and move element */
	protected ListPropertyChangeListener<T> listPropertyChangeListener;

	/** list of element that we want to display **/
	protected List<T> listElement;

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

	// Construction parameters for the composite

	private String labelToDisplay;

	private INavigationListener navigationListener;

	/**
	 * this is a navigation listener that is used when we doubleclick on element
	 * 
	 * @return return the navigationlistener
	 */
	public INavigationListener getNavigationListener() {
		return navigationListener;
	}

	/**
	 * this is a navigation listener that is used when we doubleclick on element
	 * 
	 */
	public void setNavigationListener(INavigationListener navigationListener) {
		this.navigationListener = navigationListener;
	}

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
	public ReferencedTable(String labeltoDisplay, ViewerFilter filter, BackboneContext backboneContext) {
		this.labelToDisplay = labeltoDisplay;
		this.filter = filter;
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
		data.right = new FormAttachment(downButton, -ITabbedPropertyConstants.HSPACE - 5/* 50 */);
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
				if (table.getSelection()[0].getData() instanceof org.eclipse.uml2.uml.Element) {
					navigationListener.navigateTo((org.eclipse.uml2.uml.Element) (table.getSelection()[0].getData()));
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
			tableViewer.setLabelProvider(getLabelProvider());
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
	public AdapterFactoryLabelProvider getLabelProvider() {
		if (backboneContext != null) {
			return new AdapterFactoryLabelProvider(backboneContext.getResourceSet().getAdapterFactory());
		}
		return null;
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
	 * Listener for the Add Button Specific behavior is implemented in {@link ReferencedTable#addButtonPressed()}.
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
			final int[] result = { IDialogConstants.CANCEL_ID };

			// create filter to choose operation
			ViewerFilter[] filters = { filter };
			// create the dialog box for selecting one operation in the model
			final TabElementTreeSelectionDialog elementSelectionDialog = new TabElementTreeSelectionDialog(parent.getShell(), backboneContext.getResourceSet().getTopPackageFromUMLResource(),
					backboneContext, filters, labelToDisplay, createElement, isAbstractElement);

			// open busy dialog window when loading the operationSelectionDialog
			BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

				public void run() {
					result[0] = elementSelectionDialog.open();
				}
			});

			// if ok button is pressed, and an operation is selected,
			// the selected operation is then set to the CallActionOperation
			if (IDialogConstants.OK_ID == result[0]) {
				// get selected operation
				if (elementSelectionDialog.getResult() instanceof NamedElement) {
					listPropertyChangeListener.addValue(getPropertyEditor(), (T) elementSelectionDialog.getResult());

				}
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
	 * Listener for the Remove Button Specific behavior is implemented in {@link ReferencedTable#removeButtonPressed()}.
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
				listPropertyChangeListener.removeValue(getPropertyEditor(), (T) (tableItems[i].getData()));
			}
		}
	}

	/**
	 * Listener for the Up Button Specific behavior is implemented in {@link ReferencedTable#upButtonPressed()}.
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
					listPropertyChangeListener.moveValue(getPropertyEditor(), (T) tableItems[i].getData(), newIndex);
				}
			}

		}
	}

	/**
	 * Listener for the Down Button Specific behavior is implemented in {@link ReferencedTable#downButtonPressed()}.
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
					listPropertyChangeListener.moveValue(getPropertyEditor(), (T) tableItems[i].getData(), newIndex);
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
	public List<T> getListElement() {
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
	public void setValue(List<T> listElement) {
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
	class TableContentProvider implements IStructuredContentProvider {

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
	public void setPropertyChangeListener(ListPropertyChangeListener<T> listPropertyChangeListener) {
		this.listPropertyChangeListener = listPropertyChangeListener;

	}

	/**
	 * used to set a listener to create an element
	 * 
	 * @param createElement
	 */
	public void setCreateElement(CreateElementListener createElement) {
		this.createElement = createElement;
	}

	/**
	 * used to know if the listener has to be connect on the "+" button or into treedialog
	 * 
	 * @param createElement
	 */
	public void setCreateElementOnButton(CreateElementListener createElement) {
		this.setCreateElement(createElement);
		this.addButton.removeMouseListener(addButtonlistener);
		this.addButton.addMouseListener(createElement);

	}

	/**
	 * set if the element that we look for is abstract
	 * 
	 * @param isAbstractElement
	 *            true if is abstract
	 */
	public void setAbstractElement(boolean isAbstractElement) {
		this.isAbstractElement = isAbstractElement;
	}
}
