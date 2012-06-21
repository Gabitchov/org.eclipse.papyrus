/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.interfaces;



/**
 * 
 * Editor for the Manifest
 * 
 */
public interface IManifestEditor extends IProjectEditor, IFileEditor {

	/** the path for the manifest file */
	public static final String MANIFEST_PATH = "META-INF/MANIFEST.MF"; //$NON-NLS-1$

	/** the path for the META-INF folder */
	public static final String META_INF_PATH = "META-INF/"; //$NON-NLS-1$

	/** the key for the bundle symbolic name */
	public static final String BUNDLE_SYMBOLIC_NAME = "Bundle-SymbolicName"; //$NON-NLS-1$

	/** the key for the bundle name */
	public static final String BUNDLE_NAME = "Bundle-Name";//$NON-NLS-1$

	/** the key for the required bundle */
	public static final String REQUIRED_BUNDLE = "Require-Bundle"; //$NON-NLS-1$

	/** the key for the bundle version */
	public static final String BUNDLE_VERSION = "Bundle-Version"; //$NON-NLS-1$

	/** the key for the bundle vendor */
	public static final String BUNDLE_VENDOR = "Bundle-Vendor"; //$NON-NLS-1$

	/** the build command for the manifest */
	public static final String MANIFEST_BUILD_COMMAND = "org.eclipse.pde.ManifestBuilder"; //$NON-NLS-1$

	/** the key for the bundle localization */
	public static final String BUNDLE_LOCALIZATION = "Bundle-Localization"; //$NON-NLS-1$

	/**
	 * 
	 * @param dependency
	 *        the dependency to add
	 */
	public void addDependency(final String dependency);

	/**
	 * 
	 * @param dependency
	 *        the dependency to add
	 * @param version
	 *        the version of the dependency
	 */
	public void addDependency(final String dependency, final String version);


	/**
	 * 
	 * @param key
	 *        the key
	 * @param value
	 *        the new value for the key
	 */
	public void setValue(final String key, final String value);

	public String getValue(final String key);

	/**
	 * 
	 * @param key
	 *        the key
	 * @param name
	 *        the name
	 * @param value
	 *        the new value for the key
	 */
	public void setValue(final String key, final String name, final String value);

	/**
	 * 
	 * @param key
	 *        the key
	 * @param value
	 *        the value to remove for this key
	 */
	public void removeValue(final String key, final String value);

	/**
	 * 
	 * @param key
	 *        a key to remove from the manifest
	 * 
	 */
	public void removeValue(final String key);

	/**
	 * 
	 * @param name
	 *        the symbolic name for the bundle
	 */
	public void setSymbolicBundleName(final String name);


	/**
	 * 
	 * @return
	 *         the bundle name for the project
	 */
	public String getSymbolicBundleName();

	/**
	 * 
	 * @return
	 *         the symbolic bundle name for the project
	 */
	public String getBundleName();

	/**
	 * 
	 * @param name
	 *        the bundle name for the bundle
	 */
	public void setBundleName(final String name);

	/**
	 * 
	 * @return
	 *         the version of the bundle
	 */
	public String getBundleVersion();

	/**
	 * Set the version of the bundle
	 */
	public void setBundleVersion(final String version);

	/**
	 * Gets this plug-in's provider
	 * 
	 * @return
	 *         this plug-in's provider
	 */
	public String getBundleVendor();

	/**
	 * Sets this plug-in's provider
	 * 
	 * @param vendor
	 *        this plug-in's provider
	 */
	public void setBundleVendor(final String vendor);

	/**
	 * Get the bundle localization
	 * 
	 * @return
	 *         the bundle localization
	 */
	public String getBundleLocalization();

	/**
	 * Sets the Manifest's singleton directive
	 * 
	 * @param singleton
	 *        Whether this plug-in should be a singleton
	 */
	public void setSingleton(boolean singleton);
}
