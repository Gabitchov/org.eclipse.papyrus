/**
 * Copyright (c) 2011, 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  Gregoire Dupe (Mia-Software) - Bug 334000 Simple catalog manager
 *    Nicolas Guyomar (Mia-Software) - Bug 334000 Simple catalog manager
 *    Nicolas Guyomar (Mia-Software) - Bug 334529 - ICatalogManager should be exposed in org.eclipse.emf.facet.common.core
 *    Nicolas Guyomar (Mia-Software) - Bug 338811 - A model registration method in the interface ICatalogSetManager
 *    Gregoire Dupe (Mia-Software) - Bug 338811 - A model registration method in the interface ICatalogSetManager
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *    Gregoire Dupe (Mia-Software) - Bug 362084 - Get the instance of a catalog manager
 *    Gregoire Dupe (Mia-Software) - Bug 362087 - [Deprecated] org.eclipse.emf.facet.util.emf.core.ICatalogSetManager
 */
package org.eclipse.emf.facet.util.emf.core.internal.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.catalog.CatalogFactory;
import org.eclipse.emf.facet.util.emf.catalog.CatalogSet;
import org.eclipse.emf.facet.util.emf.core.ICatalogManager;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager2;
import org.eclipse.emf.facet.util.emf.core.exception.InvalidFacetSetException;
import org.eclipse.emf.facet.util.emf.core.internal.Activator;
import org.eclipse.emf.facet.util.pde.core.internal.exported.PluginUtils;
import org.osgi.framework.Bundle;

@SuppressWarnings("deprecation") //TODO Bug 362087 - [Deprecated] org.eclipse.emf.facet.util.emf.core.ICatalogSetManager
public class CatalogSetManager implements ICatalogSetManager, ICatalogSetManager2, Adapter {

	private static final String CATALOG_MGR_EXTENSION_POINT_ID = "org.eclipse.emf.facet.util.emf.core.catalogmanager"; //$NON-NLS-1$
	private static final String MODEL_DECLARATION_EXTENSION_POINT_ID = "org.eclipse.emf.facet.util.emf.core.modeldeclaration"; //$NON-NLS-1$
	private static final String CLASS = "class"; //$NON-NLS-1$
	private static final String FILE = "file"; //$NON-NLS-1$

	/**
	 * The singleton instance of this {@link CatalogSetManager}.
	 */
	public static final CatalogSetManager INSTANCE = new CatalogSetManager();

	private final Map<Resource, Bundle> resourceToBundleMap = new HashMap<Resource, Bundle>();
	private final ResourceSet resourceSet;

	private final List<ICatalogManager> catalogManagers = new ArrayList<ICatalogManager>();
	private final CatalogSet catalogSet;

	public CatalogSetManager() {
		this.resourceSet = new ResourceSetImpl();
		this.catalogSet = CatalogFactory.eINSTANCE.createCatalogSet();
		initRegisteredEntries();
	}

	public CatalogSetManager(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.catalogSet = CatalogFactory.eINSTANCE.createCatalogSet();
		initRegisteredEntries();
	}

	private void initRegisteredEntries() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extPointCatalogMgr = registry
				.getExtensionPoint(CatalogSetManager.CATALOG_MGR_EXTENSION_POINT_ID);
		if (extPointCatalogMgr != null) {
			for (IExtension ext : extPointCatalogMgr.getExtensions()) {
				for (IConfigurationElement configElt : ext
						.getConfigurationElements()) {
					ICatalogManager catalogMgr;
					try {
						catalogMgr = (ICatalogManager) configElt
								.createExecutableExtension(CatalogSetManager.CLASS);
						this.catalogManagers.add(catalogMgr);
						catalogMgr.setCatalogSet(this.catalogSet);
					} catch (CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		}
		IExtensionPoint modelDeclarationExtPoint = registry
				.getExtensionPoint(CatalogSetManager.MODEL_DECLARATION_EXTENSION_POINT_ID);
		if (modelDeclarationExtPoint != null) {
			for (IExtension ext : modelDeclarationExtPoint.getExtensions()) {
				for (IConfigurationElement configElt : ext
						.getConfigurationElements()) {
					String filePath = configElt
							.getAttribute(CatalogSetManager.FILE);
					if (filePath != null) {
						String pluginName = ext.getNamespaceIdentifier();
						Bundle bundle = Platform.getBundle(pluginName);
						URI uri = URI.createPlatformPluginURI(pluginName + "/" //$NON-NLS-1$
								+ filePath, false);
						try {
							Resource resource = this.resourceSet.getResource(
									uri, true);
							this.resourceToBundleMap.put(resource, bundle);
							for (EObject root : resource.getContents()) {
								for (ICatalogManager catalogMgr : this.catalogManagers) {
									if (catalogMgr.canBeManaged(root)) {
										catalogMgr.manage(root);
									}
								}
							}
						} catch (Exception e) {
							Logger.logError(e, Activator.getDefault());
						}
					}
				}
			}
		}
	}

	public CatalogSet getCatalogSet() {
		return this.catalogSet;
	}

	/**
	 * @author Nicolas Guyomar
	 * Modified by Emmanuelle Rouillé
	 */
	public Bundle getBundleByResource(final Resource eResource) {
		if (eResource == null) {
			throw new IllegalArgumentException("The resource cannot be null"); //$NON-NLS-1$
		}
		if (eResource.getURI().scheme().equals("platform") && eResource.getURI().segment(0).equals("plugin")) { //$NON-NLS-1$//$NON-NLS-2$
			return Platform.getBundle(eResource.getURI().segment(1));
		}
		return this.resourceToBundleMap.get(eResource);
	}

	public void registerModelDeclaration(final IFile file) throws InvalidFacetSetException {
		PluginUtils.register(file, CatalogSetManager.MODEL_DECLARATION_EXTENSION_POINT_ID,
				"modeldeclaration"); //$NON-NLS-1$
	}

	public <T> List<T> getCatalogManagerByType(final Class<? extends T> catalogManagerClass) {
		List<T> result = new ArrayList<T>();
		for (ICatalogManager catalogManager : this.catalogManagers) {
			if (catalogManagerClass.isInstance(catalogManager)) {
				result.add((T) catalogManager);
			}
		}
		return result;
	}

	public void notifyChanged(final Notification notification) {
		// Nothing to do
	}

	public Notifier getTarget() {
		return this.resourceSet;
	}

	public void setTarget(final Notifier newTarget) {
		// Nothing to do
	}

	public boolean isAdapterForType(final Object type) {
		return type == ICatalogSetManager2.class;
	}

	

}
