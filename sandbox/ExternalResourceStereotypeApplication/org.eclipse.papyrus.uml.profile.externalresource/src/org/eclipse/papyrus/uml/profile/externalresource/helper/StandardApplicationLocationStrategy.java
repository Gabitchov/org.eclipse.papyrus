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

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;


/**
 * Usual stereotype application strategy
 */
public class StandardApplicationLocationStrategy implements IStereotypeApplicationLocationStrategy {

	/** identifier of this strategy */
	public static final String ID = "standardStrategy"; //$NON-NLS-1$
	
	/** singleton instance */
	protected static StandardApplicationLocationStrategy instance;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<EObject> getContainmentList(Element element, EClass definition) {
		if(element.eResource() !=null) {
			return element.eResource().getContents();
		}
		return null;
	}

	/**
	 * @return
	 */
	public static StandardApplicationLocationStrategy getInstance() {
		if(instance ==null) {
			instance = new StandardApplicationLocationStrategy();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<URI> getProfileApplicationResourceURIs(EObject root) {
		return Collections.emptySet();
	}
}
