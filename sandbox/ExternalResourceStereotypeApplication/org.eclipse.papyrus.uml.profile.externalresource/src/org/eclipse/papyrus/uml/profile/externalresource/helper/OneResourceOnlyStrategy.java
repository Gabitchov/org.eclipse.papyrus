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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Strategy for only one resource for all profile applications
 */
public class OneResourceOnlyStrategy extends AbstractStereotypeApplicationLocationStrategy {

	/** identifier of this strategy */
	public static final String ID = "OneResourceOnlyStrategy"; //$NON-NLS-1$
	
	/** default extension for the profile URI */
	public static final String PROFILE_DEFAULT_EXTENSION = "profiles";

	/** singleton instance */
	private static OneResourceOnlyStrategy instance;

	/**
	 * Returns the singleton instance for this strategy
	 * 
	 * @return the singleton instance for this strategy
	 */
	public static OneResourceOnlyStrategy getInstance() {
		if(instance == null) {
			instance = new OneResourceOnlyStrategy();
		}
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<EObject> getContainmentList(Element element, EClass definition) {
		// 1. only one resource => look if there is a custom name. Otherwise, use a standard name for the resource
		// compute the URI of the resource
		Resource baseResource = element.eResource();
		if(baseResource == null) {
			return null;
		}
		URI newURI = getProfileResourceURI(element, definition);
		ResourceSet resourceSet = baseResource.getResourceSet();
		if(resourceSet instanceof ModelSet && newURI != null) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource resource = ModelUtils.getOrCreateResource(modelSet, true, newURI, UMLResource.UML_CONTENT_TYPE_IDENTIFIER);
			return resource.getContents();
		}
		// by default, return the resource containing the element
		return getDefaultContainmentList(element, definition);
	}
	
	/**
	 * @param element
	 * @param definition
	 * @return
	 */
	protected URI getProfileResourceURI(Element element, EClass definition) {
		if(element.eResource() !=null) {
			URI uri = element.eResource().getURI();
			if(uri !=null) {
				return uri.trimFileExtension().appendFileExtension(PROFILE_DEFAULT_EXTENSION);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<URI> getProfileApplicationResourceURIs(EObject root) {
		URI uri = root.eResource().getURI();
		if(uri !=null) {
			return Collections.singleton(uri.trimFileExtension().appendFileExtension(PROFILE_DEFAULT_EXTENSION));
		}
		return Collections.emptySet();
	}

}
