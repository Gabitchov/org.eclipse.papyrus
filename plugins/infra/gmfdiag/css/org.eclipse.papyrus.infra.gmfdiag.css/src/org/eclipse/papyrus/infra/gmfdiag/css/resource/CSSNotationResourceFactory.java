/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.emf.core.internal.util.EMFCoreConstants;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;

/**
 * A GMFResourceFactory which installs CSS Support on the produced
 * NotationResources.
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("restriction")
public class CSSNotationResourceFactory extends GMFResourceFactory {

	@Override
	public Resource createResource(URI uri) {

		XMIResource resource = new CSSNotationResource(uri);

		resource.getDefaultLoadOptions().putAll(GMFResourceFactory.getDefaultLoadOptions());
		resource.getDefaultSaveOptions().putAll(GMFResourceFactory.getDefaultSaveOptions());

		if(!resource.getEncoding().equals(EMFCoreConstants.XMI_ENCODING)) {
			resource.setEncoding(EMFCoreConstants.XMI_ENCODING);
		}

		return resource;
	}
}
