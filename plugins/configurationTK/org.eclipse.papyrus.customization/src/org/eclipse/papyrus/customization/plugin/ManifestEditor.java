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
package org.eclipse.papyrus.customization.plugin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

public class ManifestEditor {

	private IProject project;

	private IFile manifestFile;

	private Manifest manifest;

	public ManifestEditor(IProject project) throws IOException, CoreException {
		this.project = project;
		manifestFile = getManifestFile();

		manifest = new Manifest(manifestFile.getContents());
	}

	public void addDependency(String dependency) {
		addDependency(dependency, null);
	}

	public void addDependency(String dependency, String version) {
		Name rqBundle = new Name("Require-Bundle"); //$NON-NLS-1$
		String requireBundle = manifest.getMainAttributes().getValue(rqBundle);

		//TODO : Improve the detection of existing dependency
		//If a.b.c exists, then a.b cannot be added (Because it is already contained)
		//Moreover, the Manifest allows newlines anywhere (Including in the 
		//middle of a word) : check if these newlines appear in this map, 
		//or if they have already been parsed. If the manifest value is copied as-is in the map,
		//then we need to take care of newlines when parsing it

		if(requireBundle == null) {
			requireBundle = dependency;
			if(version != null) {
				requireBundle += ";" + version; //$NON-NLS-1$
			}
		} else if(!requireBundle.contains(dependency)) {
			requireBundle += "," + dependency; //$NON-NLS-1$
			if(version != null) {
				requireBundle += ";" + version; //$NON-NLS-1$
			}
		}

		manifest.getMainAttributes().put(rqBundle, requireBundle);
	}

	public void setValue(String key, String value) {
		setValue(key, "", value); //$NON-NLS-1$
	}

	public void setValue(String key, String name, String value) {
		manifest.getAttributes(key).put(name, value);
	}

	public void removeValue(String key, String value) {

	}

	public void removeValue(String key) {
		manifest.getAttributes(key).remove(key);
	}

	private IFile getManifestFile() {
		IFile manifest = project.getFile("META-INF/MANIFEST.MF"); //$NON-NLS-1$
		if(manifest.exists()) {
			return manifest;
		}

		//TODO : Manifest creation not supported
		return null;
	}

	public void save() throws IOException, CoreException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		manifest.write(os);

		final StringReader reader = new StringReader(os.toString("UTF-8")); //$NON-NLS-1$
		manifestFile.setContents(new InputStream() {

			@Override
			public int read() throws IOException {
				return reader.read();
			}
		}, true, true, null);
	}
}
