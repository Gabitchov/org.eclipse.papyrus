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
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;

public class TypedElementContentProvider implements ITreeContentProvider {

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
		ArrayList<VirtualElement> output = new ArrayList<VirtualElement>();
		if(inputElement instanceof VirtualMetaclass) {
			output.addAll(((VirtualMetaclass)inputElement).getProperties());
			output.addAll(((VirtualMetaclass)inputElement).getOperations());
		}
		if(inputElement instanceof VirtualEnum) {
			output.addAll(((VirtualEnum)inputElement).getLiterals());
		}

		return output.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		List<Object> result = new ArrayList<Object>();
		if(parentElement instanceof VirtualOperation) {
			result.addAll(((VirtualOperation)parentElement).getParameters());
		}

		return result.toArray();
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if(getChildren(element).length == 0) {
			return false;
		} else {
			return true;
		}
	}

}
