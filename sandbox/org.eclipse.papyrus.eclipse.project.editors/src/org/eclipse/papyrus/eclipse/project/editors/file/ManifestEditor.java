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
package org.eclipse.papyrus.eclipse.project.editors.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor;

public class ManifestEditor extends ProjectEditor implements IManifestEditor {

	/** the manifest file */
	private IFile manifestFile;

	/** the manifest itself */
	private Manifest manifest;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 * @throws IOException
	 * @throws CoreException
	 */
	public ManifestEditor(final IProject project) throws IOException, CoreException {
		super(project);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#addDependency(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addDependency(final String dependency) {
		addDependency(dependency, null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#init()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void init() {
		super.init();
		if(this.manifest != null && this.manifestFile != null) {
			return;
		}
		if(this.manifestFile == null) {
			this.manifestFile = getManifestFile();
		}
		if(this.manifestFile!=null){
			try {
				this.manifest = new Manifest(this.manifestFile.getContents());
			} catch (IOException e) {
				Activator.log.error(e);
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#addDependency(java.lang.String, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addDependency(final String dependency, final String version) {
		Name rqBundle = new Name(REQUIRED_BUNDLE);
		String requireBundle = this.manifest.getMainAttributes().getValue(rqBundle);

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
		this.manifest.getMainAttributes().put(rqBundle, requireBundle);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setValue(java.lang.String, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setValue(final String key, final String value) {
		setValue(key, "", value); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setValue(java.lang.String, java.lang.String, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setValue(final String key, final String name, final String value) {
		this.manifest.getAttributes(key).put(name, value);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#removeValue(java.lang.String, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void removeValue(final String key, final String value) {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#removeValue(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void removeValue(final String key) {
		this.manifest.getAttributes(key).remove(key);
	}

	/**
	 * 
	 * @return
	 */
	private IFile getManifestFile() {
		IFile manifest = getProject().getFile("META-INF/MANIFEST.MF"); //$NON-NLS-1$
		if(manifest.exists()) {
			return manifest;
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		return super.exists() && getManifestFile() != null && getSymbolicBundleName() != null && getBundleVersion() != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#save()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void save() throws IOException, CoreException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		this.manifest.write(os);

		final StringReader reader = new StringReader(os.toString("UTF-8")); //$NON-NLS-1$
		this.manifestFile.setContents(new InputStream() {

			@Override
			public int read() throws IOException {
				return reader.read();
			}
		}, true, true, null);
	}

	@Override
	public Set<String> getMissingFiles() {
		Set<String> files = super.getMissingFiles();
		IFile classpath = getProject().getFile(MANIFEST_PATH);
		if(!classpath.exists()) {
			files.add(MANIFEST_PATH);
		}
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#createFiles(java.util.Set)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void createFiles(final Set<String> files) {
		if(files.contains(MANIFEST_PATH)) {
			this.manifestFile = getProject().getFile(MANIFEST_PATH);
			if(!this.manifestFile.exists()) {
				try {
					String input = "Manifest-Version: 1.0\n"; //without the "/n", it doesn't work!!!!! //$NON-NLS-1$
					if(!this.manifestFile.getParent().exists()) {
						IContainer parent = this.manifestFile.getParent();
						if(parent instanceof Folder) {
							if(!parent.exists()) {
								((Folder)parent).create(true, false, null);
							}
						}
					}
					this.manifestFile.create(getInputStream(input), true, null);
					this.manifestFile = getProject().getFile(MANIFEST_PATH);
					int i;
					//					InputStream is = this.manifestFile.getContents();
					//					while((i = is.read()) > 0) {

					//						System.out.println(i);
					//					}
					//					this.manifest = new Manifest(this.manifestFile.getContents());

				} catch (CoreException ex) {
					Activator.log.error(ex);
				}
				/*
				 * catch (IOException e) {
				 * Activator.log.error(e);
				 * }
				 */
			}
		}

		if(getSymbolicBundleName() == null) {
			setBundleName(getProject().getName());
		}

		if(getBundleVersion()==null){
			setBundleVersion("0.0.1"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setBundleName(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setBundleName(String newName) {
		if(newName == null) {
			newName = "noName"; //$NON-NLS-1$
		}
		Name symbolicName = new Name(BUNDLE_SYMBOLIC_NAME);
		this.manifest.getMainAttributes().put(symbolicName, newName);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#getSymbolicBundleName()
	 * 
	 *      {@inheritDoc}
	 */
	public String getSymbolicBundleName() {
		if(this.manifest != null) {
			Name symbolicName = new Name(BUNDLE_SYMBOLIC_NAME);
			String name = this.manifest.getMainAttributes().getValue(symbolicName);
			return name;
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#getBundleVersion()
	 * 
	 *      {@inheritDoc}
	 */
	public String getBundleVersion() {
		if(this.manifest != null) {
			Name symbolicName = new Name(BUNDLE_VERSION);
			String version = this.manifest.getMainAttributes().getValue(symbolicName);
			return version;
		}
		return null;
	}

	/**
	 * 
	 * @param version
	 */
	public void setBundleVersion(String version) {
		if(this.manifest != null) {

			if(version == null) {
				version = "0.0.1"; //$NON-NLS-1$
			}
			Name bundleVersion = new Name(BUNDLE_VERSION);
			//			this.manifest.getMainAttributes().put(bundleVersion, version);
		}
	}
}
