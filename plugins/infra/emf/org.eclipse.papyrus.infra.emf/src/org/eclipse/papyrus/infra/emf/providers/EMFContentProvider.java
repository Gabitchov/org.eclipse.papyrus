/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;

/**
 * A Content provider for EMF references
 * 
 * @author Camille Letavernier
 */
//TODO : Implement IHierarchicContentProvider, IGraphicalContentProvider
public class EMFContentProvider extends AbstractStaticContentProvider {

	private EObject eObject;

	private EStructuralFeature feature;

	private AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * 
	 * Constructor.
	 * 
	 * @param feature
	 *        The feature representing the reference for which we want to retrieve possible values
	 * @param eObject
	 */
	public EMFContentProvider(EObject eObject, EStructuralFeature feature) {
		this.feature = feature;
		this.eObject = eObject;
	}

	public Object[] getElements() {
		if(eObject == null || feature == null) {
			return new Object[0];
		}

		EClass eClass = eObject.eClass();
		if(eClass == null) {
			Activator.log.debug("problems during initialization, looking for availables values"); //$NON-NLS-1$
			return new Object[0];
		}

		if(!(feature instanceof EReference)) {
			Activator.log.debug("feature is not a reference, looking for availables values: " + feature);//$NON-NLS-1$
			return new Object[0];
		}

		IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(eObject, IItemPropertySource.class);
		if(itemPropertySource == null) {
			Activator.log.debug("impossible to find item Property source for " + eObject);//$NON-NLS-1$
			return new Object[0];
		}
		IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(eObject, feature);
		if(itemPropertyDescriptor == null) {
			Activator.log.debug("impossible to find item Property descriptor for " + eObject + " and " + feature);//$NON-NLS-1$ //$NON-NLS-2$
			return new Object[0];
		}

		Collection<?> values = itemPropertyDescriptor.getChoiceOfValues(eObject);

		values.remove(null); //Removes null values from the collection

		return values.toArray();
	}

}
