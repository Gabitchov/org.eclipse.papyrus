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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;


public class MetamodelContentProvider implements ITreeContentProvider {

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
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */

	public Object[] getElements(Object inputElement) {
		List<VirtualElement> elements = new ArrayList<VirtualElement>();

		if(inputElement instanceof Facade) {
			elements.addAll(MetamodelUtils.getElements((Facade)inputElement));
		}

		return elements.toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */

	public Object[] getChildren(Object parentElement) {
		List<VirtualMetaclass> children = new ArrayList<VirtualMetaclass>();

		if(parentElement instanceof VirtualMetaclass)
			for(VirtualClassifier classifier : ((VirtualMetaclass)parentElement).getMetamodel().getVirtualClassifiers()) {

				if(classifier instanceof VirtualMetaclass)
					if(((VirtualMetaclass)classifier).getParents().contains(parentElement)) {
						children.add((VirtualMetaclass)classifier);
					}
			}

		return children.toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public Object getParent(Object element) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */

	public boolean hasChildren(Object element) {
		if(getChildren(element).length == 0) {
			return false;
		} else {
			return true;
		}
	}
}
