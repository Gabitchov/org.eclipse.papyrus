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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Controller for {@link EReference}(s) that uses a binding label provider to display references
 */
public class EMFTBindingEReferenceController extends EMFTEReferenceController {

	/** editor label provider for EMF objects */
	protected ILabelProvider editorLabelProvider = new BindingLabelProvider(labelProvider);


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILabelProvider getEditorLabelProvider() {
		return editorLabelProvider;
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
