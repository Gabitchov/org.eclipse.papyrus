/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.pathmap;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

public class PathMapService {

	private static PathMapService oursPathMapService = new PathMapService();

	private PathMapResolver myFolderResolver = new FolderPathMapResolver();

	private PathMapResolver myArchiveResolver = new ArchivePathMapResolver();

	private PathMapResolver myPlatformresourceResolver = new PlatformResourcePathMapResolver();

	private PathMapService() {
	}

	public static PathMapService getInstance() {
		return oursPathMapService;
	}

	public Collection<String> getProfiles(String varName, String varValue) throws Exception {
		URI uri = URI.createURI(varValue);
		if (myFolderResolver.isApplicable(uri)) {
			return myFolderResolver.getProfiles(uri, varName);
		}
		if (myArchiveResolver.isApplicable(uri)) {
			return myArchiveResolver.getProfiles(uri, varName);
		}
		if (myPlatformresourceResolver.isApplicable(uri)) {
			return myPlatformresourceResolver.getProfiles(uri, varName);
		}
		return null;
	}
}
