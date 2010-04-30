/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.papyrus.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.ViewDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Dialog displaying properties of an element
 */
public class PropertyDialog extends StatusDialog {

	/** descriptor of this dialog */
	private final DialogDescriptor descriptor;

	/** list of objects to edit */
	private final List<Object> objectsToEdit;

	/** widget factory */
	private final TabbedPropertySheetWidgetFactory widgetFactory;

	/**
	 * Creates a new PropertyDialog.
	 * 
	 * @param parent
	 *        the parent shell for this dialog
	 */
	public PropertyDialog(Shell parent, DialogDescriptor descriptor, List<Object> objectsToEdit, TabbedPropertySheetWidgetFactory widgetFactory) {
		super(parent);
		this.descriptor = descriptor;
		this.objectsToEdit = objectsToEdit;
		this.widgetFactory = widgetFactory;
		setTitle(getTitle());
	}

	/**
	 * Returns the title, using the dialog descriptor
	 * 
	 * @return the string to display as title
	 */
	protected String getTitle() {
		return getMessageFromDescriptor(descriptor.getTitle());
	}

	/**
	 * Returns the message, using the dialog descriptor
	 * 
	 * @return the string to display as message
	 */
	protected String getMessage() {
		return getMessageFromDescriptor(descriptor.getMessage());
	}

	/**
	 * Returns a string, given an object
	 * 
	 * @param object
	 *        should be a {@link String} or a {@link IBindingLabelProviderDescriptor}
	 * @return the string given by the object
	 */
	protected String getMessageFromDescriptor(Object object) {
		if(object instanceof String) {
			return ((String)object);
		} else if(object instanceof IBindingLabelProviderDescriptor) {
			if(objectsToEdit.size() == 1) {
				return ((IBindingLabelProviderDescriptor)object).computeBindings(objectsToEdit.get(0));
			} else if(objectsToEdit.size() > 1) {
				return ((IBindingLabelProviderDescriptor)object).computeBindings(objectsToEdit.get(0)) + " (and others)";
			} else {
				// should never happen
				return "No object to edit";
			}
		} else {
			Activator.log.warn("the object from which string is computed is not a String either a label descriptor");
			return "";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		// creates the content, given the configuration
		Label messageLabel = new Label(composite, SWT.NONE);
		messageLabel.setText(getMessage());
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		messageLabel.setLayoutData(data);

		Label separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(data);

		List<AbstractContainerDescriptor> containers = new ArrayList<AbstractContainerDescriptor>();
		for(String viewId : getViewsId()) {
			ViewDescriptor viewDescriptor = PropertyViewService.getInstance().getViewDescriptor(viewId);
			for(AbstractContainerDescriptor descriptor : viewDescriptor.getContainerDescriptors()) {
				descriptor.createContent(composite, getWidgetFactory(), objectsToEdit);
				containers.add(descriptor);
			}

		}

		return composite;
	}

	/**
	 * Returns the list of identifier of views for this dialog
	 * 
	 * @return the list of identifier of views for this dialog
	 */
	protected List<String> getViewsId() {
		return descriptor.getContainerDescriptors();
	}

	/**
	 * Returns the objects edited in this dialog
	 * 
	 * @return the objects edited in this dialog
	 */
	protected List<Object> getObjectsToEdit() {
		return objectsToEdit;
	}

	/**
	 * Returns the widget factory
	 * 
	 * @return the widget factory
	 */
	protected TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}

}
