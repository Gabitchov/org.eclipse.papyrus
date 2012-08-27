/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

package org.eclipse.papyrus.uml.properties.tabbed.profile.composite;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;


/**
 * Composite that displays a label and a text area (ex: modification of the name of an element)
 */
public abstract class SimpleTextComposite implements ISectionComposite {

	/** Text Area that displays a property for the current element */
	protected Text text;

	/** label to display before the text area */
	protected String label;

	/** Label widget to display the label before the text area */
	protected CLabel cLabel;

	/** key adapter to listen for CR key or ESC key when editing text */
	final protected KeyAdapter keyAdapter = new EditKeyAdapter();

	/** focus listener to detect when the changes need to be stored in the model **/
	final protected FocusListener focusListener = new FocusListener();

	/** Element selected in the Papyrus modeler */
	protected Element element;


	/**
	 * Creates a new SimpleTextComposite.
	 * @param label the label to display in the property view
	 */
	public SimpleTextComposite(String label) {
		// avoid SWT error in case of null label, using the empty string
		this.label = (label != null) ? label : "";
	}

	/**
	 * returns the element that is selected in Papyrus tool, for which properties are displayed in
	 * the property section.
	 * 
	 * @return the element currently selected in Papyrus
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * Sets the element that holds property displayed in property section.
	 * 
	 * @param element
	 *            the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}

	/**
	 * {@inheritDoc}
	 */
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		Composite composite = factory.createFlatFormComposite(parent);

		text = factory.createText(composite, ""); //$NON-NLS-1$
		FormData data = new FormData();
		data.width = 150;
		data.left = new FormAttachment(0, AbstractPropertySection.STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		text.setLayoutData(data);
		text.addKeyListener(keyAdapter);
		text.addFocusListener(focusListener);

		cLabel = factory.createCLabel(composite, label); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(text, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(text, 0, SWT.CENTER);
		cLabel.setLayoutData(data);

		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		if (isValid(text)) {
			// checkListener ?!
			text.setText(getTextFromModel(getElement()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		if (isValid(text)) {
			text.removeKeyListener(keyAdapter);
			text.removeFocusListener(focusListener);
			text.dispose();
		}
		if (isValid(cLabel)) {
			cLabel.dispose();
		}
	}

	/**
	 * this method should take the text in the text area and modify the model using this information
	 *@param element the UML element that will be modify
	 *@return a string from the model information
	 */
	public abstract String getTextFromModel(Element element);

	/**
	 * This method should restore the value of the text area for the specified element
	 * @param element the UML element that will be modified
	 * @param newValue the value that will be affected to this element
	 */
	public abstract void setModelFromText(Element element, String newValue);

	/**
	 * checks that a widget is always available and not already disposed
	 * 
	 * @param widget
	 *            the widget to check
	 * @return <code>true</code> if the widget is available
	 */
	protected boolean isValid(Widget widget) {
		return (widget != null && !widget.isDisposed());
	}

	/**
	 * Apply the new value using the
	 */
	public void applyNewValue() {
		final TransactionalEditingDomain domain=	EditorUtils.getTransactionalEditingDomain();
		if (domain!=null && isValid(text)) {
			final Runnable runnable = new Runnable() {

				/**
				 * {@inheritDoc}
				 */
				public void run() {
					setModelFromText(getElement(), text.getText().trim());
				}
			};
			Command emfCommand = new ChangeCommand(domain, runnable, "Edit " + label);
			domain.getCommandStack().execute(emfCommand);
			EditorUtils.getMultiDiagramEditor().setFocus();
		} else {
			System.err.println( "could not commit changes to the model");
		}
	}

	/**
	 * Key adapter to listen for enter and esc key
	 */
	private class EditKeyAdapter extends KeyAdapter {

		/**
		 * {@inheritDoc}
		 */
		public void keyPressed(KeyEvent e) {
			// close the text editor and copy the data over
			// when the user hits "ENTER"
			switch (e.character) {
			case SWT.CR:
				applyNewValue();
				refresh();
				break;
			case SWT.ESC:
				refresh();
				break;
			default:
				// do nothing
			}
		}
	}

	/**
	 * Listener for a direct edit manager.
	 * 
	 */
	protected class FocusListener implements org.eclipse.swt.events.FocusListener {

		/**
		 * @param e
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @param e
		 */
		public void focusLost(FocusEvent e) {
			applyNewValue();
		}
	};

}
