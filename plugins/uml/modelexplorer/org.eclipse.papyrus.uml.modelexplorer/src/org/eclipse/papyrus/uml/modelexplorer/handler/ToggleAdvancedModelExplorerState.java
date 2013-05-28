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
package org.eclipse.papyrus.uml.modelexplorer.handler;

import org.eclipse.core.commands.State;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.views.modelexplorer.Activator;

/**
 * State for the AdvancedModelExplorer toggle action
 * 
 * @author Camille Letavernier
 * 
 * @see {@link ToggleAdvancedModelExplorerHandler}
 * 
 */
//EMF Facet 0.1 restricted & deprecated API
@SuppressWarnings({ "deprecation", "restriction" })
public class ToggleAdvancedModelExplorerState extends State {

	@Override
	public Boolean getValue() {
		MetamodelView simpleUMLCustomization = CustomizationsCatalog.getInstance().getCustomization(ToggleAdvancedModelExplorerHandler.SIMPLE_UML_CUSTOMIZATION);
		if(simpleUMLCustomization == null) {
			//The SimpleUML Customization doesn't exist. The advanced mode is activated
			return true;
		}

		CustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
		if(customizationManager == null) {
			//Should not happen, this is a singleton
			return false;
		}

		return !customizationManager.getRegisteredCustomizations().contains(simpleUMLCustomization);
	}

}
