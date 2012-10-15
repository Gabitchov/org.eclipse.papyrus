/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;


public class DiagramsUtil {

	/**
	 * Gets the diagrams associated to element.
	 * 
	 * @param element
	 * @param resourceSet
	 *        can be null, it will then try to retrieve it from the element.
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagrams(EObject element, ResourceSet resourceSet) {
		if(resourceSet == null) {
			if(element != null && element.eResource() != null) {
				resourceSet = element.eResource().getResourceSet();
			}
		}

		if(resourceSet instanceof ModelSet) {
			Resource notationResource = NotationUtils.getNotationResource((ModelSet)resourceSet);
			return getAssociatedDiagramsFromNotationResource(element, notationResource);
		}

		return Collections.emptyList();
	}

	/**
	 * Gets the diagrams associated to element.
	 * 
	 * @param element
	 * @param notationResource
	 *        the notation resource where to look for diagrams
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagramsFromNotationResource(EObject element, Resource notationResource) {
		if(notationResource != null) {
			LinkedList<Diagram> diagrams = new LinkedList<Diagram>();
			for(EObject eObj : notationResource.getContents()) {
				if(eObj instanceof Diagram) {
					Diagram diagram = (Diagram)eObj;
					if(element.equals(diagram.getElement())) {
						diagrams.add(diagram);
					}
				}
			}
			return diagrams;
		}
		return Collections.emptyList();
	}
}
