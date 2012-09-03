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
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor;
import org.eclipse.pde.internal.ui.editor.actions.FormatOperation;

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
		if((this.manifest != null) && (this.manifestFile != null)) {
			return;
		}
		if(this.manifestFile == null) {
			this.manifestFile = getManifestFile();
		}
		if(this.manifestFile != null) {
			try {
				this.manifest = new Manifest(this.manifestFile.getContents());
			} catch (final IOException e) {
				Activator.log.error(e);
			} catch (final CoreException e) {
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
		final Name rqBundle = new Name(REQUIRED_BUNDLE);
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

	public void setDependenciesVersion(final String dependencyPattern, final String newVersion) {
		final Name rqBundle = new Name(REQUIRED_BUNDLE);
		final String requireBundles = this.manifest.getMainAttributes().getValue(rqBundle);
		final String[] bundles = requireBundles.split(",");
		String newRequiredBundles = "";
		for(int ii = 0; ii < bundles.length; ii++) {//we iterate on the declared dependencies
			final String currentDependency = bundles[ii];
			final String[] dependencyValue = currentDependency.split(";");
			if(dependencyValue[0].contains(dependencyPattern)) {
				final String newBundleVersion = BUNDLE_VERSION + "=" + '"' + newVersion + '"';
				newRequiredBundles += dependencyValue[0] + ";" + newBundleVersion;
				for(int i = 1; i < dependencyValue.length; i++) {
					final String declaration = dependencyValue[i];
					if(declaration.contains(BUNDLE_VERSION + "=")) {
						//we ignore it
					} else {
						newRequiredBundles += ";" + dependencyValue[i];//we add the others declaration
					}
				}
			} else {
				newRequiredBundles += currentDependency;//we copy the existing declaration
			}
			if(ii < (bundles.length - 1)) {
				newRequiredBundles += ",";
			}
		}
		setValue(REQUIRED_BUNDLE, newRequiredBundles);

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
		this.manifest.getMainAttributes().putValue(key, value);
		//		this.manifest.getAttributes(key).put(name, value);
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
		final IFile manifest = getProject().getFile("META-INF/MANIFEST.MF"); //$NON-NLS-1$
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
		return super.exists() && (getManifestFile() != null) && (getSymbolicBundleName() != null) && (getBundleVersion() != null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#save()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void save() {

		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			this.manifest.write(os);

			final StringReader reader = new StringReader(os.toString("UTF-8")); //$NON-NLS-1$
			this.manifestFile.setContents(new InputStream() {

				@Override
				public int read() throws IOException {
					return reader.read();
				}
			}, true, true, null);

			//Use the PDE formatter for ManifestFiles
			try {
				FormatOperation.format(this.manifestFile, new NullProgressMonitor());
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (final IOException ex) {
			Activator.log.error(ex);
		} catch (final CoreException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public Set<String> getMissingFiles() {
		final Set<String> files = super.getMissingFiles();
		final IFile classpath = getProject().getFile(MANIFEST_PATH);
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
					final String input = "Manifest-Version: 1.0\n"; //without the "/n", it doesn't work!!!!! //$NON-NLS-1$
					if(!this.manifestFile.getParent().exists()) {
						final IContainer parent = this.manifestFile.getParent();
						if(parent instanceof Folder) {
							if(!parent.exists()) {
								((Folder)parent).create(true, false, null);
							}
						}
					}
					this.manifestFile.create(getInputStream(input), true, null);
					this.manifestFile = getProject().getFile(MANIFEST_PATH);

					this.manifest = new Manifest(this.manifestFile.getContents());

					final int i;
					//					InputStream is = this.manifestFile.getContents();
					//					while((i = is.read()) > 0) {

					//						System.out.println(i);
					//					}
					//					this.manifest = new Manifest(this.manifestFile.getContents());

				} catch (final CoreException ex) {
					Activator.log.error(ex);
				} catch (final IOException e) {
					Activator.log.error(e);
				}

			}
		}

		if(getSymbolicBundleName() == null) {
			setSymbolicBundleName(getProject().getName());
		}

		if(getBundleVersion() == null) {
			setBundleVersion("0.0.1"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setSymbolicBundleName(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setSymbolicBundleName(String newName) {
		if(newName == null) {
			newName = "noName"; //$NON-NLS-1$
		}
		final Name symbolicName = new Name(BUNDLE_SYMBOLIC_NAME);
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
			final Name symbolicName = new Name(BUNDLE_SYMBOLIC_NAME);
			final String name = this.manifest.getMainAttributes().getValue(symbolicName);
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
			final Name symbolicName = new Name(BUNDLE_VERSION);
			final String version = this.manifest.getMainAttributes().getValue(symbolicName);
			return version;
		}
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setBundleVersion(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setBundleVersion(final String version) {
		if(this.manifest != null) {
			final Name bundleVersion = new Name(BUNDLE_VERSION);
			if(version == null) {
				this.manifest.getMainAttributes().remove(bundleVersion);
			} else {
				this.manifest.getMainAttributes().put(bundleVersion, version);
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#getBundleVendor()
	 * 
	 *      {@inheritDoc}
	 */
	public String getBundleVendor() {
		if(this.manifest != null) {
			final Name bundleVendor = new Name(BUNDLE_VENDOR);
			return this.manifest.getMainAttributes().getValue(bundleVendor);
		}
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor#setBundleVendor(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setBundleVendor(final String vendor) {
		if(this.manifest != null) {
			final Name bundleVendor = new Name(BUNDLE_VENDOR);
			if(vendor == null) {
				this.manifest.getMainAttributes().remove(bundleVendor);
			} else {
				this.manifest.getMainAttributes().put(bundleVendor, vendor);
			}
		}
	}

	public String getValue(final String key) {
		if(this.manifest != null) {
			String value = this.manifest.getMainAttributes().getValue(key);
			if(value == null) {
				final Attributes attributes = this.manifest.getAttributes(key);
				if(attributes != null) {
					value = attributes.getValue(key);
				}
			}
			return value;
		}
		return null;
	}

	public String getBundleName() {
		if(this.manifest != null) {
			final Name bundleName = new Name(BUNDLE_NAME);
			final String name = this.manifest.getMainAttributes().getValue(bundleName);
			return name;
		}
		return null;
	}

	public void setBundleName(String newName) {
		if(newName == null) {
			newName = "noName"; //$NON-NLS-1$
		}
		final Name bundleNameName = new Name(BUNDLE_SYMBOLIC_NAME);
		this.manifest.getMainAttributes().put(bundleNameName, newName);

	}

	public String getBundleLocalization() {
		if(this.manifest != null) {
			final Name bundleLocalization = new Name(BUNDLE_LOCALIZATION);
			final String name = this.manifest.getMainAttributes().getValue(bundleLocalization);
			return name;
		}
		return null;
	}

	public void setSingleton(final boolean singleton) {
		String value = this.manifest.getMainAttributes().getValue("bundle-symbolicName");
		final String[] directives = value.split(";");

		if(directives.length == 0) {
			return; //This should not happen if the Manifest is well-formed
		} else {
			value = directives[0];
			boolean isDefined = false;
			for(int i = 1; i < directives.length; i++) {
				String directive = directives[i];
				if(directive.startsWith("singleton:=")) {
					directive = "singleton:=" + singleton;
					isDefined = true;
				}
				value += ";" + directive;
			}
			if(!isDefined) {
				value += ";singleton:=" + singleton;
			}
		}

		this.manifest.getMainAttributes().putValue("bundle-symbolicName", value);
	}
}
