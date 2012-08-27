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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.utils.DisplayUtils;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFFeatureModelHandler;


/**
 * Controller for Structural features which uses a label provider to display elements
 */
public class EMFTLabelProviderStructuralFeatureController extends EMFTStructuralFeatureController implements ILabelProviderController {

	/** id of the controller */
	public final static String ID = "emftLabelProviderStructuralFeatureController";

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = initLabelProvider();

	/**
	 * Creates and return the label provider for this controller
	 * 
	 * @return the label provider for this controller
	 */
	protected ILabelProvider initLabelProvider() {
		final ILabelProvider provider = DisplayUtils.getLabelProvider();
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
	public ILabelProvider getEditorLabelProvider() {
		return labelProvider;
	}

	/**
	 * Returns the list of all available creation operation for this controller
	 * 
	 * @return the list of available operations
	 */
	public List<IUndoableOperation> getAvailableCreationOperations() {
		// retrieve the Eclass of the elements to edit
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			return new ArrayList<IUndoableOperation>();
		}
		EObject eObject = getObjectsToEdit().get(0);
		EStructuralFeature feature = ((EMFFeatureModelHandler)getModelHandler()).getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			return new ArrayList<IUndoableOperation>();
		}
		IElementType type = ElementTypeRegistry.getInstance().getElementType(eClass);
		IEditHelper helper = type.getEditHelper();
		List<?> values = helper.getContainedValues(eObject, (EReference)feature);
		if(values != null) {
			for(Iterator<?> i = values.iterator(); i.hasNext();) {
				Object nextValue = i.next();
				if(nextValue instanceof IElementType) {
					IElementType next = (IElementType)nextValue;
					System.err.println(next);
				}
			}
		}

		List<IUndoableOperation> operations = new ArrayList<IUndoableOperation>();

		Collection<?> list = getEditingDomain().getNewChildDescriptors(getObjectsToEdit().get(0), null);
		System.err.println(list);

		return operations;
	}

	/**
	 * Retrieves the common metaclass for all selected objects
	 * 
	 * @return the selected metaclass
	 * 
	 */
	protected EClass retrieveEClass() {
		@SuppressWarnings("unchecked")
		List<EObject> eObjects = (List<EObject>)getObjectsToEdit();
		if(eObjects == null) {
			return null;
		} else if(eObjects.size() > 0) {
			return eObjects.get(0).eClass();
		}
		return null;
	}

}
