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
package org.eclipse.papyrus.infra.emf.compare.ui.internal.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class provides usefull methods to get a LabelProvider for the Editor.
 * It allows to instanciate only 1 LabelProvider and one CustomizationManager for 1 Editor even if there are 2 customizable viewers in the editor
 * 
 */
//FIXME use the futur service for the label provider
//this class must have a package visibility
class LabelProviderUtil {

	/**
	 * This map associates an IEditorPart with an ILabelProvider
	 */
	private final Map<IEditorPart, EMFCompareLabelProviderRefreshingViewer> labelProviderMap;

	/**
	 * This map associates an IEditorPart with a CustomizationManager
	 */
	private final Map<IEditorPart, CustomizationManager> customizationMap;

	/** LabelProviderUtil is a singleton */
	public final static LabelProviderUtil INSTANCE = new LabelProviderUtil();

	/**
	 * Constructor
	 */
	private LabelProviderUtil() {
		labelProviderMap = new HashMap<IEditorPart, EMFCompareLabelProviderRefreshingViewer>();
		customizationMap = new HashMap<IEditorPart, CustomizationManager>() {

			@Override
			public String toString() {
				String str = super.toString();
				return str.replaceAll(", ", "\n");

			}
		};
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(new CloseCompareEditorListener());
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the ILabelProvider associated to this editor
	 */
	public EMFCompareLabelProviderRefreshingViewer getLabelProviderFor(final IEditorPart editor/* , final Set<EPackage> packages */) {
		if(editor instanceof IMultiPageEditorPart) {
			/*
			 * I set this exception because I think that we never want a customizable label provider for CoreMultiDiagramEditor.
			 * We want a label provider for embedded editor (or eclipse editor)
			 * -> when you get this exce^ption, it an error of the developper
			 */
			throw new IllegalArgumentException(NLS.bind(Messages.LabelProviderUtil_CantProvideLabelProviderMessage, IMultiPageEditorPart.class));
		}
		EMFCompareLabelProviderRefreshingViewer provider = labelProviderMap.get(editor);
		if(provider == null) {
			CustomizationManager customizationManager = getCustomizationManager(editor);
			provider = new EMFCompareLabelProviderRefreshingViewer(customizationManager);
			labelProviderMap.put(editor, provider);
		}
		return provider;
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the LabelProvider associated to this editor
	 * @throws NullPointerException
	 *         when no LabelProvider is associated to the editor
	 */
	public EMFCompareLabelProviderRefreshingViewer getExistingLabelProviderFor(final IEditorPart editor) throws NullPointerException {
		if(editor instanceof IMultiPageEditorPart) {
			/*
			 * I set this exception because I think that we never want a customizable label provider for CoreMultiDiagramEditor.
			 * We want a label provider for embedded editor (or eclipse editor)
			 * -> when you get this exce^ption, it an error of the developper
			 */
			throw new IllegalArgumentException(NLS.bind(Messages.LabelProviderUtil_CantProvideLabelProviderMessage, IMultiPageEditorPart.class));
		}
		final EMFCompareLabelProviderRefreshingViewer provider = labelProviderMap.get(editor);
		if(provider == null) {
			throw new NullPointerException();
		}
		return provider;
	}

	/**
	 * Remove the LabelProvider and the CustomizationManager registered for this editor
	 * 
	 * @param editor
	 *        an editor
	 */
	public void destroyConfigurationFor(final IEditorPart editor) {
		labelProviderMap.remove(editor);
		customizationMap.remove(editor);
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
			Activator.log.error(e);
		}
	}

	/**
	 * 
	 * @param anEditor
	 *        an editor
	 * @return
	 *         a customization manager for this editor
	 */
	public CustomizationManager getCustomizationManager(final IEditorPart anEditor) {
		CustomizationManager manager = customizationMap.get(anEditor);
		if(manager == null) {
			manager = new CustomizationManager();
			init(manager);
			customizationMap.put(anEditor, manager);
		}
		return manager;
	}

	/**
	 * 
	 * This listener allows to listen the close of the CompareEditor to remove it from the map
	 * 
	 * 
	 */
	public class CloseCompareEditorListener implements IPartListener {

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partActivated(final IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partBroughtToTop(final IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partClosed(final IWorkbenchPart part) {
			if(part instanceof CompareEditor) {
				customizationMap.remove(part);
				labelProviderMap.remove(part);
			}
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partDeactivated(final IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partOpened(final IWorkbenchPart part) {
			//nothing to do
		}

	}
}
