/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class AssignableValuesContentProvider implements ITreeContentProvider {
	public Object[] getElements(final Object inputElement) {
		if (inputElement instanceof FeatureValuesInput) {
			FeatureValuesInput assignableValuesInput = (FeatureValuesInput) inputElement;
			EStructuralFeature feature = assignableValuesInput.getFeature();
			EClassifier eType = feature.getEType();
			EObject source = assignableValuesInput.getSource();
			List<?> featureValues = (List<?>) source.eGet(feature);

			// build a list of EObjects assignable to the EReference
			List<EObject> list = new ArrayList<EObject>();
			Resource eResource = source.eResource();
			if (eResource == null) {
				return new Object[0];
			}
			ResourceSet resourceSet = eResource.getResourceSet();
			TreeIterator<Notifier> allContents = resourceSet.getAllContents();
			while (allContents.hasNext()) {
				Notifier notifier = allContents.next();
				if (notifier instanceof EObject) {
					EObject eObject = (EObject) notifier;
					if (eType.isInstance(eObject)
							&& (!feature.isUnique() || !(featureValues != null && featureValues
									.contains(eObject)))) {
						list.add(eObject);
					}
				}
			}
			return list.toArray();
		} else if (inputElement instanceof List<?>) {
			return ((List<?>) inputElement).toArray();
		}
		throw new IllegalArgumentException(FeatureValuesInput.class.getSimpleName() + " expected"); //$NON-NLS-1$
	}

	public void dispose() {
		//
	}

	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		//
	}

	public Object[] getChildren(final Object parentElement) {
		return null;
	}

	public Object getParent(final Object element) {
		return null;
	}

	public boolean hasChildren(final Object element) {
		return false;
	}
}