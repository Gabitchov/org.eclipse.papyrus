/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.services.nested;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.match.engine.DefaultMatchScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * This class allows to know which stereotype application should be known by the element to do the comparison
 * see bug 384490: [UML Compare] Comparison between stereotyped elements doesn't work in the nested Compare Editor
 */
public class NestedUMLStereotypeApplicationMatchScope extends DefaultMatchScope {

	/**
	 * The stereotype application known by the scope
	 */
	private List<EObject> stereotypeApplication;

	/**
	 * 
	 * Constructor.
	 *
	 * @param el
	 * @param stereotypeApplication
	 */
	public NestedUMLStereotypeApplicationMatchScope(final EObject el, final List<EObject> stereotypeApplication) {
		super(el);
		this.stereotypeApplication = new ArrayList<EObject>(stereotypeApplication);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param el
	 *        the element
	 * @param stereotypeApplication
	 *        the list of the stereotype application known by this scope
	 */
	public NestedUMLStereotypeApplicationMatchScope(final Resource res, final List<EObject> stereotypeApplication){
		super(res);
		this.stereotypeApplication = new ArrayList<EObject>(stereotypeApplication);
	}
	/**
	 * 
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchScope#isInScope(org.eclipse.emf.ecore.EObject)
	 *
	 * @param eObject
	 * @return
	 */
	@Override
	public boolean isInScope(EObject eObject) {
		if(UMLUtil.getStereotype(eObject) != null) {
			return stereotypeApplication.contains(eObject);
		}
		return super.isInScope(eObject);
	}
}
