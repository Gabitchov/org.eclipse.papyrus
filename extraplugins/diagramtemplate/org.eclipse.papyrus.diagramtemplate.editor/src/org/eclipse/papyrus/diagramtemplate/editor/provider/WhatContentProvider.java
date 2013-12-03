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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;

/**
 * 
 * Content provider for the What selection
 * 
 */
public class WhatContentProvider implements IStructuredContentProvider {

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		List<EReference> refsToShow = new ArrayList<EReference>();
		if(inputElement instanceof ITreeSelection) {


			Object firstElement = ((ITreeSelection)inputElement).getFirstElement();

			if(firstElement instanceof AbstractSelection) {
				List<EReference> refs = null;

				if(((AbstractSelection)firstElement).getKind() == SelectionKind.FOR_ALL) {
					refs = ((EClass)((AbstractSelection)firstElement).getElement()).getEAllReferences();
				} else if(((AbstractSelection)firstElement).getKind() == SelectionKind.SPECIFIC) {
					refs = ((AbstractSelection)firstElement).getElement().eClass().getEAllReferences();
				}

				if(refs != null) {
					for(EReference eReference : refs) {
						if(!eReference.isDerived() && eReference.isContainment()) {

							refsToShow.add(eReference);

						}
					}
				}

				return refsToShow.toArray();
			}
		}

		return refsToShow.toArray();
	}
}
