/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;


/**
 * Interface implemented by all strategies in charge of the management of resources for stereotype applications 
 */
public interface IStereotypeApplicationLocationStrategy {
	
	/**
	 * Returns the containment list in which stereotype applications should be read/added.
	 * @param element the stereotyped element
	 * @param definition the definition of the stereotype to apply
	 * @return the containment list for the new stereotype application. if any problem, this will be the default location (direct content of the resource containing the element)
	 */
	public EList<EObject> getContainmentList(Element element, EClass definition);

	/**
	 * Returns the list of URIs of the resources in which stereotype applications are placed.
	 * @param root element of the model from which all profile applications are found
	 * @return the list of URIS, an empty collection if not URIs are found.
	 */
	public Set<URI> getProfileApplicationResourceURIs(EObject root);
	
	
	/**
	 * Returns the identifier of this strategy
	 * @return the identifier of this strategy, should never be <code>null</code>.
	 */
	public String getIdentifier();
	
}
