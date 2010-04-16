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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Controller for EReferences controller
 */
public class EMFTEReferenceController extends EMFTStructuralFeatureController implements IBoundedValuesController {

	/** adapter factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory);

	/** editor label provider for EMF objects */
	protected ILabelProvider editorLabelProvider = new BindingLabelProvider(labelProvider);

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues() {
		return getEditingDomain().getResourceSet();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getCurrentValues() {
		List<Object> values = new ArrayList<Object>();
		for(EObject objectToEdit : getObjectsToEdit()) {
			values.add(objectToEdit.eGet(getFeatureToEdit()));
		}
		return values.toArray();
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
		return editorLabelProvider;
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
				return containsValidElements(element, getFeatureToEdit().getEType().getInstanceClass());
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


	/**
	 * Label provider which proposed binded messages if possible, otherwise relies on an other label provider
	 */
	public class BindingLabelProvider implements ILabelProvider {

		/** label provider used by default */
		protected final ILabelProvider referenceLabelProvider;

		/**
		 * Creates a new EMFTEReferenceController.BindingLabelProvider.
		 * 
		 * @param labelProvider
		 *        the referenced label provider, which is used by default when the label provider can not bind elements
		 */
		public BindingLabelProvider(ILabelProvider labelProvider) {
			this.referenceLabelProvider = labelProvider;
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {

		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {

		}

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			return referenceLabelProvider.getImage(element);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if(getDescriptor() instanceof IBindingLabelProviderDescriptor) {
				String message = ((IBindingLabelProviderDescriptor)getDescriptor()).getMessage();

				// retrieve message to display
				// the features are the features of the element referenced by the structural feature => has to compute this value
				if(element instanceof EObject) {
					Object[] bindings = computeBindings((EObject)element, (IBindingLabelProviderDescriptor)getDescriptor());

					// binds
					return NLS.bind(message, bindings);
				}
			}
			return referenceLabelProvider.getText(element);
		}

		/**
		 * computes bindings from the given descriptor
		 * 
		 * @param objectToEdit
		 *        the object edited
		 * @param descriptor
		 *        the descriptor which contributes to bindings
		 * @return the list of values to bind
		 */
		protected Object[] computeBindings(EObject objectToEdit, IBindingLabelProviderDescriptor descriptor) {
			List<Object> bindings = new ArrayList<Object>();
			for(String name : descriptor.getFeaturesNameToBind()) {
				EStructuralFeature feature = getFeatureByName(objectToEdit, name);
				if(feature != null) {
					Object value = objectToEdit.eGet(feature);
					bindings.add(value);
				} else {
					Activator.log.error("impossible to find the feature with name : " + name, null);
				}
			}

			return bindings.toArray();
		}

		/**
		 * Returns the feature given its name
		 * 
		 * @param objectToEdit
		 *        the object to edit
		 * @param name
		 *        the name of the feature to find
		 * @return the {@link StructuralFeature} found
		 */
		protected EStructuralFeature getFeatureByName(EObject objectToEdit, String name) {
			EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(name);
			if(feature != null) {
				return feature;
			}
			return null;
		}
	}
}
