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
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.AbstractPropertyEditor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.PropertyEditorService;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.services.IDisposable;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Controller for property editors
 */
public abstract class PropertyEditorController implements IDisposable, IPropertyEditorController {

	/** objects to edit */
	protected List<? extends Object> objectToEdit;

	/** parent composite for the viewer */
	protected Composite composite;

	/** property editor */
	protected AbstractPropertyEditor propertyEditor;

	/**
	 * Creates a new {@link PropertyEditorController}
	 */
	public PropertyEditorController() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void setObjectsToEdit(List<? extends Object> objectToEdit) {
		assert (objectToEdit != null && !objectToEdit.isEmpty()) : "List of object to edit should be neither null nor empty";
		this.objectToEdit = objectToEdit;
		addListenersToModel();
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeObjectsToEdit(List<? extends Object> objectToEdit) {
		removeListenersFromModel();
		setObjectsToEdit(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setParent(Composite composite) {
		this.composite = composite;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return true;
	}

	/**
	 * Returns the property editor associated to this controller
	 * 
	 * @return the propertyEditor controlled by this controller
	 */
	public AbstractPropertyEditor getPropertyEditor() {
		return propertyEditor;
	}

	/**
	 * Sets the property editor associated to this controller
	 * 
	 * @param propertyEditor
	 *        the property editor to set
	 */
	protected void setPropertyEditor(AbstractPropertyEditor propertyEditor) {
		this.propertyEditor = propertyEditor;
	}

	/**
	 * Returns the object to edit.
	 * <P>
	 * In case of a property editor that edits the name of a named element, the object to edit is the named element.
	 * </P>
	 * 
	 * @return the object to edit
	 */
	public List<? extends Object> getObjectsToEdit() {
		return objectToEdit;
	}

	/**
	 * Returns the parent composite of controls created by the property editor
	 * 
	 * @return the composite parent of controls of the property editor
	 */
	protected Composite getComposite() {
		return composite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param widgetFactory
	 */
	public void createPropertyEditor(IPropertyEditorDescriptor descriptor, TabbedPropertySheetWidgetFactory widgetFactory) {
		setPropertyEditor(PropertyEditorService.getInstance().createPropertyEditor(this, descriptor.getEditorId(), widgetFactory));
		IStatus status = initPropertyEditor(descriptor);
		if(IStatus.ERROR != status.getSeverity()) {
			getPropertyEditor().createContent(getComposite());
		} else {
			Activator.log.error("Could not create the property editor because of initialisation issues.", null);
		}
		refreshDisplay();
	}

	/**
	 * Returns the default label for the property editor
	 * 
	 * @return the default label for the property editor
	 */
	protected abstract String getDefaultLabel();

	/**
	 * Initializes the content of the property editor, in case the property editor contains enumeration or references for example
	 * 
	 * @param descriptor
	 *        the descriptor of the editor
	 * @return the status of the initialization
	 */
	protected abstract IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor);

	/**
	 * {@inheritDoc}
	 */
	public abstract IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor);

	/**
	 * Sets the value of the property in the model
	 * 
	 * @param value
	 *        the value to set
	 */
	protected abstract void setValueInModel(Object value);

	/**
	 * Returns the value currently in the property editor
	 * 
	 * @return the current value in the property editor
	 */
	protected Object getEditorValue() {
		if(isValid(getPropertyEditor())) {
			return getPropertyEditor().getValue();
		}
		return null;
	}

	/**
	 * Check if the proeprty editor is valid
	 * 
	 * @param propertyEditor
	 *        the editor to check
	 * @return <code>true</code> if the editor is not <code>null</code> and not disposed
	 */
	protected boolean isValid(AbstractPropertyEditor propertyEditor) {
		return getPropertyEditor() != null && !getPropertyEditor().isDisposed();
	}

	/**
	 * {@inheritDoc}
	 */
	public void refreshDisplay() {
		if(isValid(getPropertyEditor())) {
			getPropertyEditor().setValue(getValueToEdit());
		}
	}

	/**
	 * Returns the value of the property to edit, found in the model
	 * 
	 * @return the value of the property to edit
	 */
	protected abstract Object getValueToEdit();

	/**
	 * Adds listener in the model to have notification when the model changes and that the editor should be updated
	 */
	protected abstract void addListenersToModel();

	/**
	 * Removes listener in the model to have notification when the model changes. It should be the mirror of {@link #addListenersToModel()}
	 */
	protected abstract void removeListenersFromModel();

	/**
	 * Performs the action of updating the model.
	 */
	public abstract void updateModel();

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// remove added listeners
		removeListenersFromModel();

		// dispose the composite created by the property editor
		if(getPropertyEditor() != null) {
			getPropertyEditor().dispose();
		}
		setPropertyEditor(null);
	}
}
