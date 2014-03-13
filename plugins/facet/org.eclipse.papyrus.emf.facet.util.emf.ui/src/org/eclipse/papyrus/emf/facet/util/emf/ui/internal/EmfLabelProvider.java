/**
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 406578 - Generic Label Provider for EMF objects
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.utils.ImageProvider;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.utils.ImageUtils;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class EmfLabelProvider extends LabelProvider {

	@Override
	public String getText(final Object element) {
		String result = super.getText(element);
		if (element instanceof ResourceSet) {
			final ResourceSet resourceSet = (ResourceSet) element;
			result = getResourceSetLabel(resourceSet);
		} else if (element instanceof Resource) {
			final Resource resource = (Resource) element;
			result = getResourceLabel(resource);
		} else if (element instanceof EObject) {
			final EObject eObject = (EObject) element;
			result = ModelUtils.getName(eObject);
		} else if (element instanceof IAdaptable) {
			final IAdaptable adaptable = (IAdaptable) element;
			result = adaptAndGetResourceLabel(adaptable);
			if (result == null) {
				result = adaptAndGetResourceSetLabel(adaptable);
			}
		} else {
			result = element.toString();
		}
		return result;
	}

	private static String adaptAndGetResourceLabel(final IAdaptable adaptable) {
		String result = null;
		final Resource resource = (Resource) adaptable
				.getAdapter(Resource.class);
		if (resource != null) {
			result = getResourceLabel(resource);
		}
		return result;
	}

	private static String adaptAndGetResourceSetLabel(final IAdaptable adaptable) {
		String result = null;
		final ResourceSet resourceSet = (ResourceSet) adaptable
				.getAdapter(ResourceSet.class);
		if (resourceSet != null) {
			result = getResourceSetLabel(resourceSet);
		}
		return result;
	}

	private static String getResourceSetLabel(final ResourceSet resourceSet) {
		String result;
		result = ResourceSet.class.getSimpleName() + ' '
				+ resourceSet.hashCode();
		return result;
	}

	private static String getResourceLabel(final Resource resource) {
		String result;
		EObject firstRoot = null;
		if (resource.getContents().size() > 0) {
			firstRoot = resource.getContents().get(0);
		}
		final StringBuffer strBuffer = new StringBuffer();
		final URI uri = resource.getURI();
		final String lastSegment = uri.lastSegment();
		strBuffer.append(lastSegment);
		if (firstRoot != null) {
			strBuffer.append(" - "); //$NON-NLS-1$
			final EPackage ePackage = firstRoot.eClass().getEPackage();
			final String nsURI = ePackage.getName();
			strBuffer.append(nsURI);
		}
		if (resource.isModified()) {
			strBuffer.append(" *"); //$NON-NLS-1$
		}
		result = strBuffer.toString();
		return result;
	}

	@Override
	public Image getImage(final Object element) {
		Image result = super.getImage(element);
		if (element instanceof Resource) {
			final Resource resource = (Resource) element;
			result = getResourceImage(resource);
		} else if (element instanceof IAdaptable) {
			final IAdaptable adaptable = (IAdaptable) element;
			result = adaptAndGetResourceImage(adaptable);
		} else if (element instanceof EObject) {
			final EObject eObject = (EObject) element;
			result = ImageUtils.getImage(eObject);
		}
		return result;
	}

	private static Image adaptAndGetResourceImage(final IAdaptable adaptable) {
		Image result = null;
		final Resource resource = (Resource) adaptable
				.getAdapter(Resource.class);
		if (resource != null) {
			result = getResourceImage(resource);
		}
		return result;
	}

	private static Image getResourceImage(final Resource resource) {
		Image result = null;
		if (resource.getContents().size() > 0) {
			final EObject firstRoot = resource.getContents().get(0);
			result = ImageUtils.getImage(firstRoot);
			if (result == null) {
				result = ImageProvider.DEFAULT.getImage(ImageProvider.MODEL);
			}
		}
		return result;
	}

}
