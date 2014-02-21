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
package org.eclipse.papyrus.views.modelexplorer;

import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.modelexplorer"; //$NON-NLS-1$

	/** The plug-in shared instance */
	private static Activator plugin;

	/** The log service */
	public static LogHelper log;

	/** Default constructor */
	public Activator() {
	}

	private ICustomizationManager fCustomizationManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
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
	 *        path of the image
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String pathString) {

		IPath path = new Path(pathString);
		URL uri = FileLocator.find(Activator.plugin.getBundle(), path, null);
		if(uri == null) {
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
	@Override
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
	public ICustomizationManager getCustomizationManager() {
		return org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager();
	}

	private void init(final ICustomizationManager customizationManager) {
		// the appearance can be customized here:

//		customizationManager.setShowDerivedLinks(true);
//
//		try {
//
//			// load customizations defined as default through the customization
//			// extension
//			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
//			for(MetamodelView metamodelView : registryDefaultCustomizations) {
//				customizationManager.registerCustomization(metamodelView);
//			}
//			customizationManager.loadCustomizations();
//			loadFacetsForCustomizations(registryDefaultCustomizations, customizationManager);
//
//		} catch (Throwable e) {
//			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
//		}
	}

//	/**
//	 * load the facets
//	 * 
//	 * @param customizations
//	 *        list of customization
//	 * @param customizationManager
//	 *        the Customization Manager
//	 */
//	protected void loadFacetsForCustomizations(final List<MetamodelView> customizations, final CustomizationManager customizationManager) {
//		final Set<Facet> referencedFacets = new HashSet<Facet>();
//		final Collection<FacetSet> facetSets = FacetSetCatalog.getSingleton().getAllFacetSets();
//
//		for(MetamodelView customization : customizations) {
//			String metamodelURI = customization.getMetamodelURI();
//			// find customized FacetSet
//			FacetSet customizedFacetSet = null;
//			if(metamodelURI != null) {
//				for(FacetSet facetSet : facetSets) {
//					if(metamodelURI.equals(facetSet.getNsURI())) {
//						customizedFacetSet = facetSet;
//						break;
//					}
//				}
//			}
//			if(customizedFacetSet == null) {
//				continue;
//			}
//
//			// find customized Facets
//			EList<TypeView> types = customization.getTypes();
//			for(TypeView typeView : types) {
//				String metaclassName = typeView.getMetaclassName();
//				Facet facet = findFacetWithFullyQualifiedName(metaclassName, customizedFacetSet);
//				if(facet != null) {
//					referencedFacets.add(facet);
//				} else {
//					Activator.log.warn(NLS.bind(Messages.BrowserActionBarContributor_missingRequiredFacet, new Object[]{ metaclassName, customizedFacetSet.getName(), customization.getName() }));
//				}
//			}
//
//			for(Facet referencedFacet : referencedFacets) {
//				customizationManager.loadFacet(referencedFacet);
//			}
//		}
//
//		//
//		// for modified facets
//		// customizationManager.getInstancesForMetaclasses().buildDerivationTree();
//		// customizationManager.getAppearanceConfiguration().touch();
//		// customizationManager.refreshDelayed(true);
//	}

//	/**
//	 * fin a facet from
//	 * 
//	 * @param metaclassName
//	 * @param customizedFacetSet
//	 * @return
//	 */
//	private Facet findFacetWithFullyQualifiedName(final String metaclassName, final FacetSet customizedFacetSet) {
//		EList<Facet> facets = customizedFacetSet.getFacets();
//		for(Facet facet : facets) {
//			String facetName = getMetaclassQualifiedName(facet);
//			if(metaclassName.equals(facetName)) {
//				return facet;
//			}
//		}
//		return null;
//	}

	/** @return the qualified name of the given metaclass */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while(ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for(int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

}
