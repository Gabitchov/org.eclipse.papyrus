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

import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.emf.common.util.URI;

public class ArchivePathMapResolver extends PathMapResolver {

	@Override
	public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception {
		URL url = new URL(uri.toString());
		JarURLConnection urlConnection = (JarURLConnection) url.openConnection();
		JarFile jarFile = urlConnection.getJarFile();
		JarEntry pathmapEntry = urlConnection.getJarEntry();
		if (!pathmapEntry.isDirectory()) {
			return Collections.emptyList();
		}
		List<String> pathmaps = new ArrayList<String>();
		String pathmapEntryName = pathmapEntry.getName();
		for (Enumeration<?> entries = jarFile.entries(); entries.hasMoreElements();) {
			JarEntry entry = (JarEntry) entries.nextElement();
			String entryName = entry.getName();
			if (entryName.startsWith(pathmapEntryName) && isProfileFile(entryName)) {
				String profileName = entryName;
				profileName = profileName.substring(pathmapEntryName.length());
				String pathmap = PATHMAP_FORMAT.format(new Object[] { pathmapVarName, profileName });
				pathmaps.add(pathmap);
			}
		}
		return pathmaps;
	}

	@Override
	public boolean isApplicable(URI uri) {
		return uri.isArchive();
	}

}
