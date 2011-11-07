/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.widgets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A content provider returning all metamodels used by
 * the input element's resourceSet.
 * 
 * May be expensive on big models.
 * 
 * @author Camille Letavernier
 */
public class MetamodelContentProvider implements IStructuredContentProvider {

	public void dispose() {
		//Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing
	}

	public Object[] getElements(Object inputElement) {
		EObject input;

		if(inputElement instanceof EObject) {
			input = (EObject)inputElement;
		} else {
			return new Object[0];
		}

		ResourceSet resourceSet = input.eResource().getResourceSet();
		EcoreUtil.resolveAll(resourceSet);

		Set<EPackage> reachablePackages = new HashSet<EPackage>();

		for(Resource resource : resourceSet.getResources()) {
			Iterator<EObject> iterator = resource.getAllContents();
			while(iterator.hasNext()) {
				EObject eObject = iterator.next();
				reachablePackages.add(eObject.eClass().getEPackage());
			}
		}

		return reachablePackages.toArray();
	}

}
