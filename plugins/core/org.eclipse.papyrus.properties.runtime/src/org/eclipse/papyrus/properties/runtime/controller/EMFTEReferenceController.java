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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.properties.runtime.Activator;


/**
 * Controller for EReferences controller
 */
public class EMFTEReferenceController extends EMFTStructuralFeatureController implements IBoundedValuesController {

	/** factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = initLabelProvider();

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues() {
		return getEditingDomain().getResourceSet();
	}

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
	public Object[] getCurrentValues() {
		List<Object> values = new ArrayList<Object>();
		for(EObject objectToEdit : getObjectsToEdit()) {
			values.add(getModelHandler().getValueToEdit(objectToEdit));
		}
		return values.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getBrowserLabelProvider() {
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
	public List<ViewerFilter> getViewerFilters() {
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ViewerFilter typeFilter = new ViewerFilter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				//return containsValidElements(element, getFeatureToEdit().getEType().getInstanceClass());
				return true;
			}
		};
		filters.add(typeFilter);
		return filters;
	}

	/**
	 * {@inheritDoc}
	 */
	public IContentProvider getContentProvider() {
		return new AdapterFactoryContentProvider(factory) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof ResourceSet) {
					ResourceSet resourceSet = (ResourceSet)inputElement;

					ArrayList<EObject> contents = new ArrayList<EObject>();
					for(Resource resource : resourceSet.getResources()) {
						contents.addAll(resource.getContents());
					}
					return contents.toArray();
				}
				return super.getElements(inputElement);
			}
		};
	}

	/**
	 * Returns <code>true</code> if the element contains valid elements
	 * 
	 * @param element
	 *        the element to check
	 * @param typeClass
	 *        the type of element to check
	 * @return <code>true</code> if the element contains valid elements
	 */
	protected static boolean containsValidElements(Object element, Class<?> typeClass) {
		if(element instanceof Resource) {
			TreeIterator<EObject> iter = (((Resource)element)).getAllContents();
			while(iter.hasNext()) {
				if(containsValidElements(iter.next(), typeClass))
					return true;
			}
		}
		if(element instanceof EObject) {
			EObject eObject = (EObject)element;
			if(typeClass.isAssignableFrom(eObject.getClass())) {
				return true;
			}

			for(EObject content : eObject.eContents()) {
				if(containsValidElements(content, typeClass)) {
					return true;
				}
			}
		}
		return false;
	}
}
