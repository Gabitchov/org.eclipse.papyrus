/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * A LabelProvider for Papyrus
 * 
 */
//FIXME (2 classes with the same behavior)
public class CopyOfUMLLabelProvider implements ILabelProvider {

	/**
	 * the label provider
	 */
	private ILabelProvider provider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param feature
	 *        the feature
	 */
	public CopyOfUMLLabelProvider(final EStructuralFeature feature) {
		if(feature.getEType() instanceof EEnum) {
			this.provider = new EMFObjectLabelProvider();
		} else {
			this.provider = new org.eclipse.papyrus.properties.uml.providers.UMLLabelProvider();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		this.provider.addListener(listener);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void dispose() {
		this.provider.dispose();

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return this.provider.isLabelProperty(element, property);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		this.provider.removeListener(listener);

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		return this.provider.getImage(element);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getText(Object element) {
		return this.provider.getText(element);
	}
}
