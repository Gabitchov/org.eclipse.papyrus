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
package org.eclipse.papyrus.infra.emf.compare.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.infra.emf.compare.ui.listeners.CloseEditorListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf.compare.ui"; //$NON-NLS-1$

	/** the activator */
	private static Activator plugin;

	/** this map store a customization manager associted to an editor (a CompareEditor) */
	private Map<IEditorPart, CustomizationManager> customizationMap;

	/** this listener listen the closing editors to clean the previous map */
	private IPartListener2 closingEditorlistener;

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
		Activator.plugin = this;
		this.customizationMap = new HashMap<IEditorPart, CustomizationManager>();
		this.closingEditorlistener = new CloseEditorListener();
		addListener();
	}

	/**
	 * add a listener on the part service
	 */
	private void addListener() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(this.closingEditorlistener);
	}

	/**
	 * remove the listener of the part service
	 */
	private void removeListener() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(this.closingEditorlistener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.plugin = null;
		super.stop(context);
		this.customizationMap.clear();
		removeListener();
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * 
	 * @param anEditor
	 *        an editor
	 * @return
	 *         a customization manager for this editor
	 */
	public CustomizationManager getCustomizationManager(final IEditorPart anEditor) {
		CustomizationManager manager = this.customizationMap.get(anEditor);
		if(manager == null) {
			manager = new CustomizationManager();
			init(manager);
			this.customizationMap.put(anEditor, manager);
		}
		return manager;
	}

	/**
	 * FIXME : duplicated code with modelExplorer, table, ...?
	 * init the customization manager
	 * 
	 * @param customizationManager
	 */
	private void init(final CustomizationManager customizationManager) {
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
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

	/**
	 * remove the customization manager for the part
	 * 
	 * @param part
	 */
	public void remove(final IEditorPart part) {
		this.customizationMap.remove(part);
	}
}
