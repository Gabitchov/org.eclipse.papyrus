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
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
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

		ICustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
		if(customizationManager != null) {
			if(event.getTrigger() instanceof Event) {
				if(((Event)event.getTrigger()).widget instanceof ToolItem) {
					ToolItem item = (ToolItem)((Event)event.getTrigger()).widget;
					ICustomizationCatalogManager customCatalog = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet());
					Customization simpleUMLCustomization = null;

					//look for SIMPLE UML Customization
					for(Customization customization : customCatalog.getRegisteredCustomizations()) {
						if(SIMPLE_UML_CUSTOMIZATION.equals(customization.getName())){
							simpleUMLCustomization=	customization;
						}
					}

					if(simpleUMLCustomization != null) {
						if(item.getSelection()) {

							//Advanced view
							List<Customization> registeredCustomizations = new LinkedList<Customization>(customizationManager.getManagedCustomizations());
							if(registeredCustomizations.remove(simpleUMLCustomization)) {
								customizationManager.getManagedCustomizations().clear();
								for(Customization customization : registeredCustomizations) {
									customizationManager.getManagedCustomizations().add(customization);
								}
							} else {
								//No change
								return null;
							}

						} else {
							//Simple view
							if(customizationManager.getManagedCustomizations().contains(simpleUMLCustomization)) {
								return null; //No change
							}

							customizationManager.getManagedCustomizations().add(0,simpleUMLCustomization);
						}

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
