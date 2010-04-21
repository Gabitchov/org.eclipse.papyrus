/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.gmt.modisco.infra.browser.custom.MetamodelView;
import org.eclipse.gmt.modisco.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.modelexplorer"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	/** The shared log helper. */
	public static LogHelper log;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	private CustomizationManager fCustomizationManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);
		EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry();

	}

	/**
	 * get the image descriptor from a string path
	 * 
	 * @param pathString
	 *            path of the image
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String pathString) {

		IPath path = new Path(pathString);
		URL uri = FileLocator.find(Activator.plugin.getBundle(), path, null);
		if (uri == null) {
			return null;
		}
		return ImageDescriptor.createFromURL(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * 
	 * @return the customization manager in charge to adapt element in modisco
	 */
	public CustomizationManager getCustomizationManager() {
		if (this.fCustomizationManager == null) {
			this.fCustomizationManager = new CustomizationManager();
			init(this.fCustomizationManager);
		}
		return this.fCustomizationManager;
	}

	private void init(final CustomizationManager customizationManager) {
		// the appearance can be customized here:
		// customizationManager.setShowEmptyLinks(true);
		// customizationManager.setShowAttributes(true);
		try {
			// FacetSet facetSet = FacetSetCatalog.getSingleton().getFacetSet(
			//					"MyFacet"); //$NON-NLS-1$
			// if (facetSet != null) {
			// EList<Facet> facets = facetSet.getFacets();
			// for (Facet facet : facets) {
			// getCustomizationManager().loadFacet(facet);
			// }
			// }

			// load customizations defined as default through the customization
			// extension
			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog
					.getInstance().getRegistryDefaultCustomizations();
			for (MetamodelView metamodelView : registryDefaultCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
		} catch (Throwable e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

}
