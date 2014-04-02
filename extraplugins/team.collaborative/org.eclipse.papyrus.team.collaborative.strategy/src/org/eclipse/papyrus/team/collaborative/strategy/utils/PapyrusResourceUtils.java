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
package org.eclipse.papyrus.team.collaborative.strategy.utils;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.team.collaborative.core.utils.URIUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;


public class PapyrusResourceUtils {

	private static final String[] FILE_EXTENSIONS = new String[]{ UmlModel.UML_FILE_EXTENSION, NotationModel.NOTATION_FILE_EXTENSION, DiModel.MODEL_FILE_EXTENSION };


	public static void addExtraResources(ResourceSet ressourceSet, Collection<URI> uris, URI uri) {
		String currentExtension = uri.fileExtension();
		for(String ext : FILE_EXTENSIONS) {
			if(!ext.equals(currentExtension)) {
				URI sateliteResource = URIUtils.getSateliteResource(uri, ext);
				if(URIUtils.isResourceURI(sateliteResource, ressourceSet)) {
					uris.add(sateliteResource);
				}
			}
		}
	}

}
