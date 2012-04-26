/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import java.util.List;

import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;

/**
 * 
 * This class provides methods to get the customizable LabelProvider for the CompareEditor and viewers
 * 
 */
//TODO : move this in the class EMFCompareLabelProvider (or not)
//warning : there is a subclass to EMFCompareLabelProvider, with specific action with the CustomizationEngine
public class LabelProviderUtil {

	private LabelProviderUtil() {
		//to prevent intentiation
	}

	public static final EMFCompareLabelProvider createLabelProvider() {
		CustomizationManager customizationManager = new CustomizationManager();
		init(customizationManager);
		return new EMFCompareLabelProvider(customizationManager);
	}

	/**
	 * FIXME : duplicated code with modelExplorer, table, ...?
	 * init the customization manager
	 * 
	 * @param customizationManager
	 */
	private static void init(final CustomizationManager customizationManager) {
		// the appearance can be customized here:

		customizationManager.setShowDerivedLinks(true);

		try {

			// load customizations defined as default through the customization
			// extension
			final List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
			for(final MetamodelView metamodelView : registryDefaultCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
			//TODO load the facets!
			//			loadFacetsForCustomizations(registryDefaultCustomizations,customizationManager);

		} catch (final Throwable e) {
			Activator.log.error(e);
		}
	}
}
