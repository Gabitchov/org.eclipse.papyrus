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
package org.eclipse.papyrus.properties.runtime.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Controller for Structural features which uses a label provider to display elements
 */
public class EMFTLabelProviderStructuralFeatureController extends EMFTStructuralFeatureController implements ILabelProviderController, IWizardPropertyEditorController {

	/** adapter factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory);

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getEditorLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getAvailableCreationOperations() {
		List<IUndoableOperation> operations = new ArrayList<IUndoableOperation>();

		Collection<?> list = getEditingDomain().getNewChildDescriptors(getObjectsToEdit().get(0), null);
		System.err.println(list);

		return operations;
	}

	/**
	 * {@inheritDoc}
	 */
	public int openPostCreationDialog(Shell shell) {
		return 0;
	}

}
