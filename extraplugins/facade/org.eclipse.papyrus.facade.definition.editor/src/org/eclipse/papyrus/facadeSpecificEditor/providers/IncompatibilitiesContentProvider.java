/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.HashSet;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;

public class IncompatibilitiesContentProvider implements IStructuredContentProvider {

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */

	public void dispose() {

	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */

	public Object[] getElements(Object inputElement) {

		HashSet<Combination> output = new HashSet<Combination>();
		if(inputElement instanceof BaseMetaclass) {
			output.addAll(((BaseMetaclass)inputElement).getIncompatibleStereotypes());
			output.addAll(((BaseMetaclass)inputElement).getCompatibleStereotypes());
		}
		return output.toArray();
	}

}
