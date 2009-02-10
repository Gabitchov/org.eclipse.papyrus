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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.tabbedproperties.core.Activator;
import org.eclipse.papyrus.tabbedproperties.core.dialog.ElementTreeSelectionDialog;
import org.eclipse.papyrus.tabbedproperties.core.dialog.TabElementTreeSelectionDialog;
import org.eclipse.papyrus.tabbedproperties.core.listeners.CreateElementListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.NavigationListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This is an Abstract class use to display a label with the referenced named Element For example type of a property
 * 
 * @author Patrick Tessier
 * 
 */
public class ReferencedElementForm<T extends EObject> extends AbstractPropertyEditor implements PropertyEditor {

	/**
	 * the label to display in the label
	 */
	private String labelToDisplay = "";

	/**
	 * the filter to look for a good element
	 */
	private ViewerFilter filter;

	/** listener to change the model **/
	protected PropertyChangeListener<T> propertyChangeListener;

	/** listenr to create an element **/
	protected CreateElementListener createElement;

	/**
	 * used to set a listener to create an element
	 * 
	 * @param createElement
	 */
	public void setCreateElement(CreateElementListener createElement) {
		this.createElement = createElement;
	}

	/**
	 * the constructor of this display
	 * 
	 * @param labeltoDisplay
	 *            use to display the name is the label
	 * @param filter
	 *            use to look for the good element
	 */
	public ReferencedElementForm(String labeltoDisplay, ViewerFilter filter, BackboneContext backboneContext) {
		super();
		this.labelToDisplay = labeltoDisplay;
		this.filter = filter;
		this.backboneContext = backboneContext;
	}

	private NavigationListener navigationListener;

	/** Buttons used in the section */
	protected Button browseButton, removeButton;

	/** Associated label */
	protected CLabel label;

	/** The parent Composite */
	protected Composite parent;

	/** Listener for the delete button */
	protected MouseListener removeButtonListener;

	/** Listener for the browse button */
	protected MouseListener browseButtonListener;

	/** BackboneContext from the selected edit part(s) * */
	protected BackboneContext backboneContext;

	/** Image for the remove button */
	protected final org.eclipse.swt.graphics.Image remove_img = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "Delete_16x16.gif");

	/** Image for the add button */
	protected final org.eclipse.swt.graphics.Image add_img = Activator.getImage(Activator.PAPYRUS_ICONS_16x16 + "Add_16x16.gif");

	private boolean isAbstractElement = false;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		this.parent = parent;
		if (parent instanceof ExpandableComposite) {
			((ExpandableComposite) parent).setClient(composite);
		}
		FormData data;

		// removeButton layout
		removeButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		removeButton.setImage(remove_img);
		data = new FormData();
		// data.left = new FormAttachment(browseButton, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 1);
		removeButton.setLayoutData(data);

		// browseButton layout
		browseButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		browseButton.setImage(add_img);
		data = new FormData();
		data.right = new FormAttachment(removeButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 1);
		browseButton.setLayoutData(data);

		// label creation
		final CLabel displayLabel = getWidgetFactory().createCLabel(composite, labelToDisplay); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 1);
		displayLabel.setLayoutData(data);

		// value label
		label = getWidgetFactory().createCLabel(composite, "", SWT.BORDER);
		data = new FormData();
		data.left = new FormAttachment(displayLabel, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(browseButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 1);
		label.setLayoutData(data);
		label.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
				navigationListener.fireNavigation();
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
			}

		});

		// listeners setting
		browseButtonListener = new BrowseButtonlistener();
		browseButton.addMouseListener(browseButtonListener);
		removeButtonListener = new RemoveButtonlistener();
		removeButton.addMouseListener(removeButtonListener);
	}

	/**
	 * use to set the new Element for example( (Property)getElement()).setType((Type) element)
	 * 
	 * @param element
	 *            the element that will be set
	 */
	public void setValue(String newValue) {
		label.setText(newValue);
	}

	/**
	 * a new value has been added
	 * 
	 * @param newValue
	 *            a value
	 */
	public void firePropertyChanged(T newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	/**
	 * Listener for the RemoveButton. Specific behavior is implemented in removeButtonPressed.
	 */
	protected class RemoveButtonlistener implements MouseListener {

		/**
		 * Does nothing.
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Does nothing.
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Calls the removeButtonPressed() which does the job then refresh().
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseUp(MouseEvent e) {
			// send value null
			firePropertyChanged(null);
		}
	}

	/**
	 * Listener for the BrowseButton. Specific behavior is implemented in browseButtonPressed.
	 */
	protected class BrowseButtonlistener implements MouseListener {

		/**
		 * Does nothing.
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseDoubleClick(MouseEvent e) {
		}

		/**
		 * Does nothing.
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseDown(MouseEvent e) {
		}

		/**
		 * Calls the browseButtonPressed() which does the job then refresh().
		 * 
		 * @param e
		 *            MouseEvent.
		 */
		public void mouseUp(MouseEvent e) {
			browseButtonPressed();
		}
	}

	/**
	 * Behavior executed when browse button is pressed.
	 */
	protected void browseButtonPressed() {
		final int[] result = { IDialogConstants.CANCEL_ID };

		// create filter to choose operation
		ViewerFilter[] filters = { this.filter };
		// create the dialog box for selecting one operation in the model
		final ElementTreeSelectionDialog elementSelectionDialog = new TabElementTreeSelectionDialog(parent.getShell(), backboneContext.getResourceSet().getTopPackageFromUMLResource(),
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
				firePropertyChanged((T) elementSelectionDialog.getResult());
			}
		}

	}

	/**
	 * Disposes of the buttons and listeners.
	 */
	public void dispose() {
		if ((removeButton != null) && !removeButton.isDisposed()) {
			removeButton.removeMouseListener(removeButtonListener);
		}
		if ((browseButton != null) && !browseButton.isDisposed()) {
			browseButton.removeMouseListener(browseButtonListener);
		}
		super.dispose();
	}

	/***
	 * used to set the propertyChange listener
	 * 
	 * @param propertyChangeListener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<T> propertyChangeListener) {
		this.propertyChangeListener = propertyChangeListener;
	}

	/**
	 * set the context, very important to look for resource
	 * 
	 * @param backboneContext
	 *            the backbone
	 */
	public void setBackboneContext(BackboneContext backboneContext) {
		this.backboneContext = backboneContext;
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

	/**
	 * this is a navigation listener that is used when we doubleclick on element
	 * 
	 * @return return the navigationlistener
	 */
	public Object getNavigationListener() {
		return navigationListener;
	}

	/**
	 * this is a navigation listener that is used when we doubleclick on element
	 * 
	 */
	public void setNavigationListener(NavigationListener navigationListener) {
		this.navigationListener = navigationListener;
	}

}