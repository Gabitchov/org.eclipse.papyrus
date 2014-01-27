/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagramtemplate.editor.provider;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;

/**
 * 
 * Content provider for the For selection
 * 
 */
public class ForContentProvider implements ITreeContentProvider {

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List<?>) {
			return ((List<Selection>)inputElement).toArray();
		}

		return null;
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof AbstractSelection) {
			List<SelectionRef> itemRefList = ((AbstractSelection)parentElement).getSelectionRef();
			if(!itemRefList.isEmpty()) {
				return itemRefList.toArray();
			}
		}

		return null;
	}

	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasChildren(Object element) {
		if(element instanceof AbstractSelection) {
			List<SelectionRef> itemRefList = ((AbstractSelection)element).getSelectionRef();
			return !itemRefList.isEmpty();
		}

		return false;
	}

}
