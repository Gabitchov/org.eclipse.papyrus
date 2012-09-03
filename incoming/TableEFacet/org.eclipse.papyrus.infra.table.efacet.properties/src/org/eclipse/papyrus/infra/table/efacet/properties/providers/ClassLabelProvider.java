/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.properties.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;


public class ClassLabelProvider implements ILabelProvider {

	public void addListener(final ILabelProviderListener listener) {
		//nothing to do

	}

	public void dispose() {
		//nothing to do
	}

	public boolean isLabelProperty(final Object element, final String property) {
		//nothing to do
		return false;
	}

	public void removeListener(final ILabelProviderListener listener) {
		//nothing to do

	}

	public Image getImage(final Object element) {
		//nothing to do
		return null;
	}

	public String getText(final Object element) {
		//nothing to do
		return ""; //$NON-NLS-1$
	}

}
