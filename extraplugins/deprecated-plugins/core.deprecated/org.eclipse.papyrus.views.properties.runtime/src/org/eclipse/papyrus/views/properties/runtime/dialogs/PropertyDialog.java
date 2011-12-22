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
package org.eclipse.papyrus.views.properties.runtime.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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

	/** ok button */
	protected Button okButton;

	/**
	 * Creates a new PropertyDialog.
	 * 
	 * @param parent
	 *        the parent shell for this dialog
	 * @param descriptor
	 *        the dialog descriptor used to create this dialog
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @param widgetFactory
	 *        the factory used to create the content of the dialog
	 */
	public PropertyDialog(Shell parent, DialogDescriptor descriptor, List<Object> objectsToEdit, TabbedPropertySheetWidgetFactory widgetFactory) {
		super(parent);
		this.descriptor = descriptor;
		this.objectsToEdit = objectsToEdit;
		this.widgetFactory = widgetFactory;
		// adding resize, close and trim abilities
		setShellStyle(getShellStyle() | SWT.SHELL_TRIM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		//no cancel button
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(640, 480);
		shell.setText(getTitle());
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

		getWidgetFactory().setBackground(composite.getBackground());

		// creates the content, given the configuration
		Label messageLabel = getWidgetFactory().createLabel(composite, getMessage(), SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		messageLabel.setLayoutData(data);

		Label separator = getWidgetFactory().createSeparator(composite, SWT.HORIZONTAL);
		separator.setLayoutData(data);

		Color defaultColor = getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		getWidgetFactory().setBackground(defaultColor);
		ScrolledComposite scrolledComposite = getWidgetFactory().createScrolledComposite(composite, SWT.BORDER);
		scrolledComposite.setAlwaysShowScrollBars(false);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		scrolledComposite.setLayout(layout);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		scrolledComposite.setLayoutData(data);

		Composite containerComposite = getWidgetFactory().createComposite(scrolledComposite);
		layout = new GridLayout(1, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		containerComposite.setLayout(layout);
		scrolledComposite.setLayout(layout);
		scrolledComposite.setContent(containerComposite);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);

		List<AbstractContainerDescriptor> containers = new ArrayList<AbstractContainerDescriptor>();
		for(IFragmentDescriptor fragmentDescriptor : getFragmentsId()) {
			if(fragmentDescriptor != null) {
				for(AbstractContainerDescriptor descriptor : fragmentDescriptor.getContainerDescriptors()) {
					descriptor.createContent(containerComposite, getWidgetFactory(), objectsToEdit);
					containers.add(descriptor);
				}
			}
		}

		return composite;
	}

	/**
	 * Returns the list of identifier of fragments for this dialog
	 * 
	 * @return the list of identifier of fragments for this dialog
	 */
	protected List<IFragmentDescriptor> getFragmentsId() {
		return descriptor.getFragmentDescriptors();
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
