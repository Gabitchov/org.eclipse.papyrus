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
package org.eclipse.papyrus.views.properties.catalog;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * A catalog for property view URIs
 * 
 * Handles URIs with the ppe:/ scheme
 * 
 * @author Camille Letavernier
 */
public class PropertiesCatalog implements Factory {

	/**
	 * {@inheritDoc}
	 */
	public Resource createResource(URI sourceURI) {
		return new PropertiesXMIResource(sourceURI);
	}

	/**
	 * An XMIResource with a specific URI Converter, for handling
	 * the ppe:/ scheme
	 * 
	 * @author Camille Letavernier
	 */
	//TODO : This class should encapsulate a resource, and not extend it
	//Non-xmi resources which are relative to a XMI resource cannot be handled
	//Typically, xwt files cannot be handled by an XMIResource
	//Problem : local calls to getURIConverter will skip the encapsulation...
	public class PropertiesXMIResource extends XMIResourceImpl {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param sourceURI
		 *        The URI to associate to this resource
		 */
		public PropertiesXMIResource(URI sourceURI) {
			super(sourceURI);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public URIConverter getURIConverter() {
			return new ExtensibleURIConverterImpl() {

				@Override
				public org.eclipse.emf.ecore.resource.URIHandler getURIHandler(URI uri) {
					return new PropertiesURIHandler();
				}
			};
		}
	}
}
