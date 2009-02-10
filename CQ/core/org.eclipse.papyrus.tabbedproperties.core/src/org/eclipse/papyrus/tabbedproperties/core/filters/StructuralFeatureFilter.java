/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/

package org.eclipse.papyrus.tabbedproperties.core.filters;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * This is a filter to display list of Type 
 */
public class StructuralFeatureFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		//this is a resource display it only if it contains a operation
		if(element instanceof Resource){
			TreeIterator<EObject> iter=(((Resource)element)).getAllContents();
			while(iter.hasNext()){
				if (iter.next() instanceof org.eclipse.uml2.uml.Operation){
					return true;
				}
			}
		}
		if(element instanceof Package){
			//this is a package display it only if it contains a operation
			Iterator<Element> iter=(((Package)element)).allOwnedElements().iterator();
			while(iter.hasNext()){
				if (iter.next() instanceof org.eclipse.uml2.uml.StructuralFeature){
					return true;
				}
			}
			
		}
		if(element instanceof Classifier){
			Iterator<Element> iter=(((Classifier)element)).allOwnedElements().iterator();
			while(iter.hasNext()){
				if (iter.next() instanceof org.eclipse.uml2.uml.StructuralFeature){
					return true;
				}
			}
		}
		
		// ok this is finally a type
		if(element instanceof org.eclipse.uml2.uml.StructuralFeature){
			return true;
		}
		//else
		return false;
	}

}
