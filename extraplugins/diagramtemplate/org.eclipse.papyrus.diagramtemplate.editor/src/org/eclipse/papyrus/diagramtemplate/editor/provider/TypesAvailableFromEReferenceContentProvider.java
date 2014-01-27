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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * Content provider for the types available from a EReference
 * 
 */
public class TypesAvailableFromEReferenceContentProvider implements IStructuredContentProvider {

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof EReference) {

			List<EObject> results = new ArrayList<EObject>();

			results.add(((EReference)inputElement).getEReferenceType());

			TreeIterator<EObject> it = ((EReference)inputElement).eResource().getAllContents();
			while(it.hasNext()) {
				EObject eObject = (EObject)it.next();
				if(eObject instanceof EClass) {
					List<EClass> superTypes = ((EClass)eObject).getEAllSuperTypes();
					if(superTypes.contains(((EReference)inputElement).getEReferenceType())) {

						results.add(eObject);
					}
				}
			}

			return results.toArray();

		}
		return null;
	}

}
