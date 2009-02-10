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

import java.io.File;
import java.net.URL;
import java.util.Collection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;

public class PlatformResourcePathMapResolver extends PathMapResolver {

	@Override
	public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception {
		URL url = new URL(uri.toString());
		URL resolvedURL = FileLocator.resolve(url);
		File folder = new File(resolvedURL.getFile());
		return getProfilesFromFolder(folder, pathmapVarName);
	}

	@Override
	public boolean isApplicable(URI uri) {
		return uri.isPlatformResource();
	}

}
