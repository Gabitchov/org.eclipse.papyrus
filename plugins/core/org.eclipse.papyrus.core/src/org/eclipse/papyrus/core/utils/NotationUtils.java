/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Utilities method to manage notation models. Should be moved in a more suitable plugin
 */
public class NotationUtils {

	/**
	 * Gets the direct associated diagram of the specified eObject.
	 * 
	 * @param eObject
	 * @param notationResource
	 * 
	 * @return the associated diagram
	 */
	public static Diagram getAssociatedDiagram(Resource notationResource, EObject eObject) {
		if(notationResource != null) {
			for(EObject obj : notationResource.getContents()) {
				if(obj instanceof Diagram) {
					Diagram diagram = (Diagram)obj;
					if(eObject != null && eObject.equals(diagram.getElement())) {
						return diagram;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the direct associated diagram of the specified eObject.
	 * 
	 * @param eObject
	 * @param notationResource
	 * @param resolve
	 *        the resource if true
	 * 
	 * @return the associated diagram
	 */
	public static Diagram getAssociatedDiagram(Resource notationResource, EObject eObject, boolean resolve) {
		if(notationResource != null && resolve) {
			EcoreUtil.resolveAll(notationResource);
		}
		return getAssociatedDiagram(notationResource, eObject);
	}

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject
	 * 
	 * @param notationResource
	 * @param eObject
	 * 
	 * @return all the contained diagrams
	 * 
	 */
	public static List<Diagram> getDiagrams(Resource notationResource, EObject eObject) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		if(notationResource != null) {
			for(EObject obj : notationResource.getContents()) {
				if(obj instanceof Diagram) {
					Diagram diagram = (Diagram)obj;
					if(EcoreUtil.isAncestor(eObject, diagram.getElement())) {
						diagrams.add(diagram);
					}
				}
			}
		}
		return diagrams;
	}

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject
	 * 
	 * @param notationResource
	 * @param eObject
	 * @param resolve
	 *        the resource if true
	 * 
	 * @return all the contained diagrams
	 */
	public static List<Diagram> getDiagrams(Resource notationResource, EObject eObject, boolean resolve) {
		if(notationResource != null && resolve) {
			EcoreUtil.resolveAll(notationResource);
		}
		return getDiagrams(notationResource, eObject);
	}

}
