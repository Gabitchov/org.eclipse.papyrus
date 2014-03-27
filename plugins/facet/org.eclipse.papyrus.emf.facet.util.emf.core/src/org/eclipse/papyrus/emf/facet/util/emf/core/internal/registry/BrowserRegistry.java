/**********************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *    Nicolas Bros (Mia-Software) - Bug 335218 - Extension point for registering EObject, EPackage, model editor
 *    Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios 
 ***********************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core.internal.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.papyrus.emf.facet.util.emf.core.IEObjectBrowserOpener;
import org.eclipse.papyrus.emf.facet.util.emf.core.IEPackageBrowserOpener;
import org.eclipse.papyrus.emf.facet.util.emf.core.IResourceBrowserOpener;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.preferences.PreferenceConstants;

/** A registry for the EObject, EPackage, and Resource browser opener extension point. */
public class BrowserRegistry implements IBrowserRegistry {

	private static final String EXTENSION_POINT_RESOURCE_VIEWER_ELT = "resourceViewer"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_EOBJECT_VIEWER_ELT = "eObjectViewer"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_EPACKAGE_VIEWER_ELT = "ePackageViewer"; //$NON-NLS-1$
	private final List<IEPackageBrowserOpener> epackageBrowserOpeners;
	private final List<IEObjectBrowserOpener> eobjectBrowserOpeners;
	private final List<IResourceBrowserOpener> resourceBrowserOpeners;

	public static final String EXTENSION_POINT_MODEL_VIEWER_ID = "org.eclipse.papyrus.emf.facet.util.emf.core.modelViewer"; //$NON-NLS-1$

	public static final String CLASS = "class"; //$NON-NLS-1$

	public BrowserRegistry() {
		this.epackageBrowserOpeners = new ArrayList<IEPackageBrowserOpener>();
		this.eobjectBrowserOpeners = new ArrayList<IEObjectBrowserOpener>();
		this.resourceBrowserOpeners = new ArrayList<IResourceBrowserOpener>();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry
				.getExtensionPoint(BrowserRegistry.EXTENSION_POINT_MODEL_VIEWER_ID);
		if (extensionPoint != null) {
			for (IExtension ext : extensionPoint.getExtensions()) {
				for (IConfigurationElement configElt : ext.getConfigurationElements()) {

					String kind = configElt.getName();
					String classID = configElt.getAttribute(BrowserRegistry.CLASS);
					try {
						if (classID != null) {
							if (kind.equals(BrowserRegistry.EXTENSION_POINT_EPACKAGE_VIEWER_ELT)) {
								this.epackageBrowserOpeners.add((IEPackageBrowserOpener) configElt
										.createExecutableExtension(BrowserRegistry.CLASS));
							} else if (kind
									.equals(BrowserRegistry.EXTENSION_POINT_EOBJECT_VIEWER_ELT)) {
								this.eobjectBrowserOpeners.add((IEObjectBrowserOpener) configElt
										.createExecutableExtension(BrowserRegistry.CLASS));
							} else if (kind
									.equals(BrowserRegistry.EXTENSION_POINT_RESOURCE_VIEWER_ELT)) {
								this.resourceBrowserOpeners.add((IResourceBrowserOpener) configElt
										.createExecutableExtension(BrowserRegistry.CLASS));
							}
						}
					} catch (CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		} else {
			Logger.logError(
					"Extension point not found: " + BrowserRegistry.EXTENSION_POINT_MODEL_VIEWER_ID, //$NON-NLS-1$
					Activator.getDefault());
		}
	}

	public void browseEPackage(final EPackage ePackage) {
		if (ePackage == null) {
			throw new IllegalArgumentException();
		}
		IEPackageBrowserOpener opener = getDefaultEPackageBrowserOpener();
		if (opener != null) {
			opener.openEPackage(ePackage);
		} else {
			Logger.logWarning(
					"No epackage browser opener is registered to open ePackage " + ePackage.getNsURI(), Activator.getDefault()); //$NON-NLS-1$
		}
	}

	public void browseResource(final Resource resource) {
		if (resource == null) {
			throw new IllegalArgumentException();
		}
		IResourceBrowserOpener opener = getDefaultResourceBrowserOpener();
		if (opener != null) {
			opener.openResource(resource);
		} else {
			Logger.logWarning(
					"No resource browser opener is registered to open " + resource.getURI(), Activator.getDefault()); //$NON-NLS-1$
		}
	}

	public void browseEObject(final EObject eObject) {
		if (eObject == null) {
			throw new IllegalArgumentException();
		}
		IEObjectBrowserOpener opener = getDefaultEObjectBrowserOpener();
		if (opener != null) {
			opener.openEObject(eObject);
		} else {
			Logger.logWarning(
					"No eobject browser opener is registered to open " + eObject.toString(), Activator.getDefault()); //$NON-NLS-1$
		}
	}

	public List<IEPackageBrowserOpener> getAllRegisteredEPackageBrowsers() {
		return Collections.unmodifiableList(this.epackageBrowserOpeners);
	}

	public List<IEObjectBrowserOpener> getAllRegisteredEObjectBrowsers() {
		return Collections.unmodifiableList(this.eobjectBrowserOpeners);
	}

	public List<IResourceBrowserOpener> getAllRegisteredResourceBrowsers() {
		return Collections.unmodifiableList(this.resourceBrowserOpeners);
	}

	/**
	 * @return the default EPackage browser opener, can be null
	 */
	public IEPackageBrowserOpener getDefaultEPackageBrowserOpener() {
		IEclipsePreferences preferenceNode = new InstanceScope().getNode(Activator.PLUGIN_ID);
		String className = preferenceNode.get(PreferenceConstants.P_DEFAULT_EPACKAGE_VIEWER, null);
		if (className != null) {
			for (IEPackageBrowserOpener ePackageBrowserFactory : this.epackageBrowserOpeners) {
				if (ePackageBrowserFactory.getClass().getName().equals(className)) {
					return ePackageBrowserFactory;
				}
			}
		}
		// By default return the first editor registered through the extension
		// point org.eclipse.papyrus.emf.facet.util.emf.core.modelViewer
		if (!this.epackageBrowserOpeners.isEmpty()) {
			return this.epackageBrowserOpeners.get(0);
		}

		return null;

	}

	/**
	 * @return the default EObject browser opener, can be null
	 */
	public IEObjectBrowserOpener getDefaultEObjectBrowserOpener() {
		IEclipsePreferences preferenceNode = new InstanceScope().getNode(Activator.PLUGIN_ID);
		String className = preferenceNode.get(PreferenceConstants.P_DEFAULT_EOBJECT_VIEWER, null);
		if (className != null) {
			for (IEObjectBrowserOpener eObjectBrowserFactory : this.eobjectBrowserOpeners) {
				if (eObjectBrowserFactory.getClass().getName().equals(className)) {
					return eObjectBrowserFactory;
				}
			}
		}
		// By default return the first editor registered through the extension
		// point org.eclipse.papyrus.emf.facet.util.emf.core.modelViewer
		if (!this.eobjectBrowserOpeners.isEmpty()) {
			return this.eobjectBrowserOpeners.get(0);
		}

		return null;

	}

	/**
	 * @return the default Resource browser opener, can be <code>null</code>
	 */
	public IResourceBrowserOpener getDefaultResourceBrowserOpener() {
		IEclipsePreferences preferenceNode = new InstanceScope().getNode(Activator.PLUGIN_ID);
		String className = preferenceNode.get(PreferenceConstants.P_DEFAULT_RESOURCE_VIEWER, null);
		if (className != null) {
			for (IResourceBrowserOpener resourceBrowserOpener : this.resourceBrowserOpeners) {
				if (resourceBrowserOpener.getClass().getName().equals(className)) {
					return resourceBrowserOpener;
				}
			}
		}
		// By default return the first editor registered through the extension
		// point org.eclipse.papyrus.emf.facet.util.emf.core.modelViewer
		if (!this.resourceBrowserOpeners.isEmpty()) {
			return this.resourceBrowserOpeners.get(0);
		}

		return null;
	}

}
