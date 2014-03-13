/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.utils;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.EObjectToExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.ExtendedURIToEObjects;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.ExtendedURIToIResource;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.ResourceToIFile;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.ResourceToURI;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.URIToExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.URIToExtendedURIWithContainment;

import com.google.common.base.Function;
import com.google.common.base.Functions;


/**
 * A factory for creating CollabFunctions objects.
 * This a factory used to gather all function that are often use to collaboration function
 */
public class CollabFunctionsFactory {

	/** The Constant RESOURCE__TO__URI. */
	public static final ResourceToURI RESOURCE__TO__URI = ResourceToURI.getInstance();

	/** The Constant URI__TO__EXTENDED_URI_CONTAINMENT. */
	public static final URIToExtendedURIWithContainment URI__TO__EXTENDED_URI_CONTAINMENT = URIToExtendedURIWithContainment.getInstance();

	/** The Constant RESOURCE__TO__EXTENDED_URI. */
	public static final Function<Resource, IExtendedURI> RESOURCE__TO__EXTENDED_URI = Functions.compose(URI__TO__EXTENDED_URI_CONTAINMENT, RESOURCE__TO__URI);

	/**
	 * Gets the {@link ExtendedURI} to {@link IResource}.
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @return the extended uri to i resource
	 */
	public static Function<IExtendedURI, IResource> getExtendedURIToIResource(ResourceSet resourceSet) {
		return new ExtendedURIToIResource(resourceSet);
	}

	/**
	 * Gets the {@link Resource} to {@link IFile}.
	 * 
	 * @return the resource to i file
	 */
	public static Function<Resource, IFile> getResourceToIFile() {
		return ResourceToIFile.getInstance();
	}

	/**
	 * Gets the {@link Resource} to {@link ExtendedURI} with containment.
	 * 
	 * @return the resource to extended uri with containment
	 */
	public static Function<Resource, IExtendedURI> getResourceToExtendedURIWithContainment() {
		return RESOURCE__TO__EXTENDED_URI;
	}

	/**
	 * Gets the {@link URI} to {@link ExtendedURI} with containment.
	 * 
	 * @return the uRI to extended uri with containment
	 */
	public static Function<URI, IExtendedURI> getURIToExtendedURIWithContainment() {
		return URIToExtendedURIWithContainment.getInstance();
	}

	public static Function<URI, IExtendedURI> getURIToExtendedURI() {
		return URIToExtendedURI.getInstance();
	}

	/**
	 * Gets the {@link ExtendedURI} to Collection of {@link EObject}.
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @return the extended uri to e objects
	 */
	public static Function<IExtendedURI, Collection<EObject>> getExtendedURIToEObjects(ResourceSet resourceSet) {
		return new ExtendedURIToEObjects(resourceSet);
	}

	/**
	 * Get the {@link IExtendedURI} from an {@link EObject}
	 * 
	 * @return
	 */
	public static Function<EObject, IExtendedURI> getEObjectToExtendedURI() {
		return EObjectToExtendedURI.getInstance();
	}

}
