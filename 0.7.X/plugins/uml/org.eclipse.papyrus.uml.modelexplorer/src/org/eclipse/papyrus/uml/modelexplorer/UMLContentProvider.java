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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this is a specific content provider used to not display UML stereotype applications
 * 
 */
public class UMLContentProvider extends MoDiscoContentProvider {
	
	/**
	 * Get the roots elements from the model resource provided as input.
	 * @return
	 */
	protected EObject[] getRootElements(Resource modelResource) {

		EList<EObject> contents = modelResource.getContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		Iterator<EObject> iterator = contents.iterator();
		while(iterator.hasNext()) {
			EObject eObject = (EObject)iterator.next();
			//functionality that comes from UML2 plugins
			if(UMLUtil.getStereotype(eObject) == null) {
				result.add(eObject);
			}
		}
		return result.toArray(new EObject[result.size()]);
	}
}
