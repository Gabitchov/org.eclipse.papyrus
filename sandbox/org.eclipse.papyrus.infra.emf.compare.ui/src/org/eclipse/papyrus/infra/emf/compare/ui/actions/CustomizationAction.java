/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.ui.dialogs.LoadCustomizationsDialog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.ILabelProviderRefreshingViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.Utils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * 
 * @author VL222926
 * 
 *         This action allows to choose the customization to apply on the viewer
 */
public class CustomizationAction extends Action {

	/**
	 * tooltip for this action
	 */
	private static final String TOOLTIPTEXT = "Manage the applied customizations";

	//FIXME : avoid to duplicate this image?
	private static final String CUSTOMIZATION_IMAGE_PATH = "icons/addUiCustom.gif";

	/**
	 * the registered metamodels for the customization manager
	 */
	private final Collection<EPackage> registeredMetamodel;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param registeredMetamodel
	 *        can be empty when the class is created
	 */
	public CustomizationAction(final Collection<EPackage> registeredMetamodel) {
		super(IAction.TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		setToolTipText(CustomizationAction.TOOLTIPTEXT);
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, CustomizationAction.CUSTOMIZATION_IMAGE_PATH));
		this.registeredMetamodel = registeredMetamodel;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	//TODO duplicate code from ModelExplorer
	//TODO vérifier que l'on n'a pas la même chose dans les tables également!
	@Override
	public void run() {

		final IEditorPart currentEditor = Utils.getCurrentEditor();
		final CustomizationManager customizationManager = LabelProviderUtil.INSTANCE.getCustomizationManager(currentEditor);
		final List<MetamodelView> initiallySelectedCustomizations = customizationManager.getRegisteredCustomizations();
		final LoadCustomizationsDialog loadCustomizationsDialog = new LoadCustomizationsDialog(Display.getCurrent().getActiveShell(), initiallySelectedCustomizations, this.registeredMetamodel);
		//TODO : override the dialog to hide the checkbox for the facet
		if(Window.OK == loadCustomizationsDialog.open()) {
			customizationManager.clearCustomizations();
			final List<MetamodelView> selectedCustomizations = loadCustomizationsDialog.getSelectedCustomizations();
			//before loading, clean all facet to prevent to let not interesting facets.
			customizationManager.clearFacets();
			if(loadCustomizationsDialog.isLoadRequiredFacetsSelected()) {
				// load facets corresponding to customizations
				//we ignore the facet in this dialog 
			}
			for(final MetamodelView metamodelView : selectedCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
		}
		//we refresh the viewers in the editor
		((ILabelProviderRefreshingViewer)LabelProviderUtil.INSTANCE.getLabelProviderFor(Utils.getCurrentEditor())).refreshViewer();
	}
}
