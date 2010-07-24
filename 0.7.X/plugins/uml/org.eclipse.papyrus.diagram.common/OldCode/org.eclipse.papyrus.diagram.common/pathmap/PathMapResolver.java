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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.resource.UMLResource;

public abstract class PathMapResolver {

	abstract public boolean isApplicable(URI uri);

	abstract public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception;

	protected boolean isProfileFile(String fileName) {
		return fileName.endsWith(UMLResource.PROFILE_FILE_EXTENSION);
	}

	protected Collection<String> getProfilesFromFolder(File folder, String pathmapVarName) {
		if (!folder.isDirectory()) {
			return Collections.emptyList();
		}
		List<String> pathmaps = new ArrayList<String>();
		String[] files = folder.list();
		for (int i = 0; i < files.length; i++) {
			String currFile = files[i];
			if (isProfileFile(currFile)) {
				String pathmap = PATHMAP_FORMAT.format(new Object[] { pathmapVarName, currFile });
				pathmaps.add(pathmap);
			}
		}
		return pathmaps;
	}

	protected static final MessageFormat PATHMAP_FORMAT = new MessageFormat("pathmap://{0}/{1}"); //$NON-NLS-1$

}
