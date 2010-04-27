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
package org.eclipse.papyrus.properties.runtime.propertyeditor;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.services.IDisposable;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Abstract class for all proprty editors
 */
public abstract class AbstractPropertyEditor implements IDisposable {

	/** controller that manages this editor */
	private PropertyEditorController controller;

	/** widget factory used to create controls. Not a {@link FormToolkit} because there are missing elements (CCombo, CLabel, etc.) */
	private TabbedPropertySheetWidgetFactory widgetFactory;

	/** read oonly status for the editor */
	private boolean isReadOnly = false;

	/** configuration for the property editor */
	private IPropertyEditorDescriptor descriptor = null;

	/**
	 * Creates a new {@link AbstractPropertyEditor}. It uses a created widget factory each time a property editor is created, the other constructor
	 * {@link #AbstractPropertyEditor(TabbedPropertySheetWidgetFactory)} should be used instead.
	 */
	public AbstractPropertyEditor() {
		this(new TabbedPropertySheetWidgetFactory());
	}

	/**
	 * Creates a new {@link AbstractPropertyEditor}.
	 * @param widgetFactory
	 * 		  widget factory used to create {@link Control}
	 */
	public AbstractPropertyEditor(TabbedPropertySheetWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}


	/**
	 * Returns the controller that manages this editor
	 * 
	 * @return the controller that manages this editor
	 */
	protected PropertyEditorController getController() {
		return controller;
	}

	/**
	 * Returns the widget factory used to create composites in tabbed property sheet pages
	 * 
	 * @return the widget factory
	 */
	public TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}


	/**
	 * Sets the new widget factory used to create composites
	 * 
	 * @param widgetFactory
	 *        the widgetFactory to set
	 */
	public void setWidgetFactory(TabbedPropertySheetWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}

	/**
	 * Sets the new controller.
	 * 
	 * @param controller
	 *        the new controller
	 */
	public void setController(PropertyEditorController controller) {
		this.controller = controller;
	}

	/**
	 * Sets the read only status of the editor
	 * 
	 * @param isReadOnly
	 *        <code>true</code> if the editor should be read-only.
	 */
	public void setIsReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	/**
	 * Returns the read-only status of the editor
	 * 
	 * @return <code>true</code> if the editor is in read-only mode
	 */
	public boolean getIsReadOnly() {
		return isReadOnly;
	}

	/**
	 * Creates the display for this editor
	 * 
	 * @param parent
	 *        the parent composite for created elements
	 * @return the newly created composite
	 */
	public abstract Composite createContent(Composite parent);

	/**
	 * Indicates that the content of the editor has changed, and that the model should be updated
	 */
	public abstract void handleContentChanged();

	/**
	 * Initializes the content of the property editor, for example enumeration literals for enumeration, etc.
	 * 
	 * @param descriptor
	 *        the descriptor used for initialization
	 * @return the result of the initialization
	 */
	public abstract IStatus init(IPropertyEditorDescriptor descriptor);

	/**
	 * Returns the configuration for this editor
	 * 
	 * @return the configuration for this editor
	 */
	public IPropertyEditorDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * Sets the configuration for this editor.
	 * 
	 * @param descriptor
	 *        the configuration for this editor
	 */
	public void setDescriptor(IPropertyEditorDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	/**
	 * Returns the current value in the editor
	 * 
	 * @return the current value in the editor
	 */
	public abstract Object getValue();

	/**
	 * Sets the value to edit
	 * 
	 * @param valueToEdit
	 *        the value to edit
	 */
	public abstract void setValue(Object valueToEdit);

	/**
	 * {@inheritDoc}
	 */
	public abstract void dispose();

	/**
	 * Indicates if the control is valid, i.e. not null and not disposed
	 * 
	 * @param control
	 *        the control to test
	 * @return
	 */
	protected boolean isValid(Control control) {
		return (control != null && !control.isDisposed());
	}

	/**
	 * Creates the label area for the property editor
	 * 
	 * @param parent
	 *        the composite parent of the label
	 * @return the label
	 */
	protected Control createLabel(Composite parent) {
		GridData data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		// data.minimumWidth = 80;
		data.widthHint = 80;
		return createLabel(parent, data);
	}

	/**
	 * Creates the label area for the property editor
	 * 
	 * @param parent
	 *        the composite parent of the label
	 * @return the label
	 */
	protected Control createLabel(Composite parent, Object layoutData) {
		CLabel label = getWidgetFactory().createCLabel(parent, getDescriptor().getLabel());
		if(getDescriptor().getLabelImageDescriptor() != null) {
			label.setImage(Activator.getImageFromDescriptor(getDescriptor().getLabelImageDescriptor()));
		}
		label.setToolTipText(getDescriptor().getLabel());
		label.setLayoutData(layoutData);
		return label;
	}
}
