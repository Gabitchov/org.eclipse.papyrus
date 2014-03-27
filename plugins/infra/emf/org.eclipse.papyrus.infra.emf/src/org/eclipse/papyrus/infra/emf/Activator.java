/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The plug-in's logger
	 */
	public static LogHelper log;

	private ICustomizationManager fCustomizationManager;
	//temp resourceSet
	private ResourceSet facetRecsourceSet= new ResourceSetImpl();

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
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
		if(this.fCustomizationManager == null) {
			this.fCustomizationManager = ICustomizationManagerFactory.DEFAULT.getOrCreateICustomizationManager(facetRecsourceSet);
			init(this.fCustomizationManager);
		}
		return this.fCustomizationManager;
	}

	/**
	 * Saves the current Customization Manager settings to the preferences
	 */
	public void saveCustomizationManagerState() {
		IDialogSettings dialogSettings = getBrowserCustomizationDialogSettings();
		List<Customization> appliedCustomizations = getCustomizationManager().getManagedCustomizations();

		final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(getCustomizationManager().getResourceSet()).getRegisteredCustomizations();

		for(Customization customization : registeredCustomizations) {

			boolean isApplied = appliedCustomizations.contains(customization);
			String settingKey = getSettingKey(customization);

			dialogSettings.put(settingKey, isApplied);
		}
	}

	private String getSettingKey(Customization customization) {
		// do not exist anymore
		return customization.eResource().getURI().toString();
		//return "";
	}

	protected IDialogSettings getBrowserCustomizationDialogSettings() {
		String sectionId = CUSTOMIZATION_MANAGER_SECTION;

		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(sectionId);
		if(settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(sectionId);
		}
		return settings;
	}

	private void init(final ICustomizationManager customizationManager) {
		// the appearance can be customized here:

		IDialogSettings settings = getBrowserCustomizationDialogSettings();

		try {

			// load customizations defined as default through the customization
			// extension
			ICustomizationCatalogManager customCatalog = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet());
			//no possibility to get default customization

			List<Customization> registryAllCustomizations = customCatalog.getRegisteredCustomizations();
			ArrayList<Customization> orderedCustomizationList= new ArrayList<Customization>();
			for(Customization customization : registryAllCustomizations) {
				String settingKey = getSettingKey(customization);

				boolean isActive = false;
				if(settings.get(settingKey) == null) { //Never customized
					isActive = customization.isMustBeLoadedByDefault(); //Loaded by default
					
				} else {
					isActive = settings.getBoolean(settingKey);
				}

				if(isActive) {
						orderedCustomizationList.add(customization);
					
				}
			}
			
			Collections.sort(orderedCustomizationList, new CustomizationComparator());
			customizationManager.getManagedCustomizations().addAll(orderedCustomizationList);



		} catch (Throwable e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

	/**
	 * The section name of the Dialog Settings for storing Customization Manager settings
	 */
	public static final String CUSTOMIZATION_MANAGER_SECTION = PLUGIN_ID + ".customizationManager";//$NON-NLS-1$

	/**
	 * Restores the default Customization Manager configuration
	 */
	public void restoreDefaultCustomizationManager() {
		ICustomizationManager manager = getCustomizationManager();

		DialogSettings settings = (DialogSettings)getDialogSettings();
		settings.removeSection(CUSTOMIZATION_MANAGER_SECTION);

		//		List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
		//
		//		manager.clearCustomizations();
		//		for(MetamodelView customization : registryDefaultCustomizations) {
		//			manager.registerCustomization(customization);
		//		}
		//		manager.loadCustomizations();
	}

	/**
	 * load the facets
	 * 
	 * @param customizations
	 *        list of customization
	 * @param customizationManager
	 *        the Customization Manager
	 */
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
	//					Activator.log.warn(String.format("Missing required facet \"%s\" in FacetSet \"%s\" for customization \"%s\"", metaclassName, customizedFacetSet.getName(), customization.getName()));
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
