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

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.ui.dialogs.LoadCustomizationsDialog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.CustomizationAndViewerActionDispatcher;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

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
	private static final String TOOLTIPTEXT = Messages.CustomizationAction_ManageAppliedCustomization;

	//FIXME imageProvider: avoid to duplicate this image, use the future service image provider?
	private static final String CUSTOMIZATION_IMAGE_PATH = "icons/add_ui_custom.gif"; //$NON-NLS-1$

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
		ImageDescriptor desc = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(Activator.PLUGIN_ID, CustomizationAction.CUSTOMIZATION_IMAGE_PATH);
		setImageDescriptor(desc);
		this.registeredMetamodel = registeredMetamodel;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	//FIXME duplicate code from ModelExplorer
	//FIXME duplicate in the table ?
	@Override
	public void run() {
		IEditorPart currentEditor = EditorHelper.getCurrentEditor();
		if(currentEditor instanceof IMultiPageEditorPart) {
			currentEditor = ((IMultiPageEditorPart)currentEditor).getActiveEditor();
		}

		final CustomizationManager customizationManager = CustomizationAndViewerActionDispatcher.getCustomizationManager(currentEditor);
		assert customizationManager != null;

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


		if(currentEditor instanceof IPropertyChangeListener) {//implemented by CompareEditor
			//we refresh the name of the tab in Papyrus
			((IPropertyChangeListener)currentEditor).propertyChange(new PropertyChangeEvent(IAction.class, CompareEditorInput.PROP_TITLE, "", "")); //$NON-NLS-1$ //$NON-NLS-2$
		}

		CustomizationAndViewerActionDispatcher.refreshViewers(currentEditor);
	}
}
