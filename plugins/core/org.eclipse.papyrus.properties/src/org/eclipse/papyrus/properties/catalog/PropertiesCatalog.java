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
package org.eclipse.papyrus.properties.catalog;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;


public class PropertiesCatalog implements Factory {

	public Resource createResource(URI sourceURI) {
		return new PropertiesXMIResource(sourceURI);
	}

	public class PropertiesXMIResource extends XMIResourceImpl {

		public PropertiesXMIResource(URI sourceURI) {
			super(sourceURI);
		}

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
