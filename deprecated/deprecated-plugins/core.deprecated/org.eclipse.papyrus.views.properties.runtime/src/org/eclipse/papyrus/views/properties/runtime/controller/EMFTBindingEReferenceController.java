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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Controller for {@link EReference}(s) that uses a binding label provider to display references
 */
public class EMFTBindingEReferenceController extends EMFTEReferenceController {

	/** identifier for this controller */
	public final static String ID = "emftBindingEReferenceController";

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
	 * {@inheritDoc}
	 */
	@Override
	public ILabelProvider getBrowserLabelProvider() {
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
				// retrieve message to display
				// the features are the features of the element referenced by the structural feature => has to compute this value
				if(element instanceof EObject) {
					if(((EObject)element).eIsProxy()) {
						return "Proxy - " + element;
					}

					return ((IBindingLabelProviderDescriptor)getDescriptor()).computeBindings((EObject)element);
				}
			}
			return referenceLabelProvider.getText(element);
		}
	}
}
