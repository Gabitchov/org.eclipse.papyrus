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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;

/**
 * 
 * This class provides methods to get the customizable LabelProvider for the CompareEditor and viewers
 * 
 */
//TODO : move this in the class EMFCompareLabelProvider (or not)
//warning : there is a subclass to EMFCompareLabelProvider, with specific action with the CustomizationEngine
public class LabelProviderUtil {

	/**
	 * This list contains the name of the wanted customization to applied by default
	 * TODO add the plugins providing these customizations as dependencies ?
	 */
	private static Collection<String> wantedCustomName;

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
		if(wantedCustomName == null) {
			wantedCustomName = new ArrayList<String>();
			// the appearance can be customized here:
			wantedCustomName.add("uml_compare_diff"); //$NON-NLS-1$
			wantedCustomName.add("uml_emf_compare_diff"); //$NON-NLS-1$
			wantedCustomName.add("compare_diff"); //$NON-NLS-1$
			wantedCustomName.add("UMLPapyrusDefaultBrowserCustomization"); //$NON-NLS-1$
			//		wantedCustomName.add("SysMLDefaultExplorerCustomization");
		}

		customizationManager.setShowDerivedLinks(true);

		try {


			final Collection<MetamodelView> wantedCustom = new ArrayList<MetamodelView>();
			for(final String current : wantedCustomName) {
				final MetamodelView custom = CustomizationsCatalog.getInstance().getCustomization(current);
				if(custom != null) {
					wantedCustom.add(custom);
				} else {
					Activator.log.warn(NLS.bind(Messages.LabelProviderUtil_CustomizationNotFound, current));
				}
			}

			// load customizations defined as default through the customization
			// extension

			for(final MetamodelView metamodelView : wantedCustom) {
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
