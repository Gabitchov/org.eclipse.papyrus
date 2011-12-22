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

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Controller for Empty property editors, i.e. editors that are a simple Composite
 */
public class NullPropertyEditorController extends PropertyEditorController {

	/** id of this controller */
	public static final String ID = "nullPropertyEditorController";

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveCurrentValuesOperation(List<Integer> indexes, int move) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canMoveValues(List<Integer> indexes, int move) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getCreateValueOperations() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateValueOperations() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteValueOperation(List<Integer> indexes) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canDeleteValueOperation() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getEditValueOperation(int index, Composite parent, Object value) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateEditOperation(int index, Composite parent, Object value) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultLabel() {
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor) {
		return getPropertyEditor().init(descriptor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor) {
		setParent(parent);
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueInModel(Object value) {
		// Nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValueToEdit() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addListenersToModel() {
		// Nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeListenersFromModel() {
		// Nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateModel() {
		// Nothing to do
	}

}
