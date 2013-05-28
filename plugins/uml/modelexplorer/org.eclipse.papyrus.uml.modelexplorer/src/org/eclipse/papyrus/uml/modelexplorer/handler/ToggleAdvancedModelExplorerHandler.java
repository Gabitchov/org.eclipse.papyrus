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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * A Handler to toggle the Advanced/Simple UML ModelExplorer customization
 * 
 * @author Camille Letavernier
 * 
 */
//EMF Facet 0.1 restricted & deprecated API
@SuppressWarnings({ "deprecation", "restriction" })
public class ToggleAdvancedModelExplorerHandler extends AbstractHandler {

	/**
	 * The SimpleUML customization ID
	 */
	//The filename of SimpleUML.uiCustom, without extension 
	public static final String SIMPLE_UML_CUSTOMIZATION = "SimpleUML"; //$NON-NLS-1$ 

	@Override
	public void setEnabled(Object evaluationContext) {
		super.setEnabled(evaluationContext);
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		//State state = event.getCommand().getState("org.eclipse.papyrus.uml.modelexplorer.customization.advanced.state");


		CustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
		if(customizationManager != null) {
			if(event.getTrigger() instanceof Event) {
				if(((Event)event.getTrigger()).widget instanceof ToolItem) {
					ToolItem item = (ToolItem)((Event)event.getTrigger()).widget;

					MetamodelView simpleUMLCustomization = CustomizationsCatalog.getInstance().getCustomization(SIMPLE_UML_CUSTOMIZATION);
					if(simpleUMLCustomization != null) {
						if(item.getSelection()) {

							//Advanced view
							List<MetamodelView> registeredCustomizations = new LinkedList<MetamodelView>(customizationManager.getRegisteredCustomizations());
							if(registeredCustomizations.remove(simpleUMLCustomization)) {
								customizationManager.clearCustomizations();
								for(MetamodelView customization : registeredCustomizations) {
									customizationManager.registerCustomization(customization);
								}
							} else {
								//No change
								return null;
							}

						} else {
							//Simple view
							if(customizationManager.getRegisteredCustomizations().contains(simpleUMLCustomization)) {
								return null; //No change
							}

							customizationManager.registerCustomization(simpleUMLCustomization);
						}

						customizationManager.loadCustomizations();
						//Save the current state of the customizations
						org.eclipse.papyrus.infra.emf.Activator.getDefault().saveCustomizationManagerState();
					}
				}

			}
		}

		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof ModelExplorerPageBookView) {
			IViewPart page = ((ModelExplorerPageBookView)activePart).getActiveView();
			if(page instanceof CommonNavigator) {
				((CommonNavigator)page).getCommonViewer().refresh();
			}
		}

		return null;
	}


}
