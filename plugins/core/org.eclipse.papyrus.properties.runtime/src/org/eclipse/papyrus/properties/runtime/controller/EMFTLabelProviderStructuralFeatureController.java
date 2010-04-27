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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.swt.widgets.Shell;


/**
 * Controller for Structural features which uses a label provider to display elements
 */
public class EMFTLabelProviderStructuralFeatureController extends EMFTStructuralFeatureController implements ILabelProviderController, IWizardPropertyEditorController {

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = initLabelProvider();

	/**
	 * Creates and return the label provider for this controller
	 * 
	 * @return the label provider for this controller
	 */
	protected ILabelProvider initLabelProvider() {
		final ILabelProvider provider = EditorUtils.getLabelProvider();
		if(provider != null) {
			return provider;
		}
		Activator.log.warn("Impossible to find the label provider from the service registry");
		//adapter factory used by EMF objects 
		AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		return new AdapterFactoryLabelProvider(factory) {

			/**
			 * This implements {@link ILabelProvider}.getText by forwarding it to an object that implements {@link IItemLabelProvider#getText
			 * IItemLabelProvider.getText}
			 */
			public String getText(Object object) {
				// Get the adapter from the factory.
				//
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProvider.class);
				if(object instanceof EObject) {
					if(((EObject)object).eIsProxy()) {
						return "Proxy - " + object;
					}
				}
				return itemLabelProvider != null ? itemLabelProvider.getText(object) : object == null ? "" : object.toString();
			}
		};
	}

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
