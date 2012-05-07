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

import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.ICustomizableEditor;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This class provides methods to manage the Labelprovider and the viewers for the CompareEditor.
 * 
 * 
 */
public class CustomizationAndViewerActionDispatcher {

	private CustomizationAndViewerActionDispatcher() {
		//to prevent instantiation
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         Create if it is necessary and returns the Labelprovider for this editor
	 */
	public static LabelProvider getLabelProvider(final IEditorPart editor) {
		if(editor instanceof ICustomizableEditor) {
			return ((ICustomizableEditor)editor).getLabelProvider();
		} else {
			return LabelProviderUtil.INSTANCE.getLabelProviderFor(editor);
		}
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the labelprovider associated to this editor. The returned value can be <code>null</code>
	 */
	public static LabelProvider getExistingLabelProvider(final IEditorPart editor) {
		if(editor instanceof ICustomizableEditor) {
			return ((ICustomizableEditor)editor).getLabelProvider();
		} else {
			return LabelProviderUtil.INSTANCE.getExistingLabelProviderFor(editor);
		}
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the CustomizationManager associated to this editor (via its LabelProvider)
	 */
	public static CustomizationManager getCustomizationManager(final IEditorPart editor) {
		if(editor instanceof ICustomizableEditor) {
			EMFCompareLabelProvider provider = ((ICustomizableEditor)editor).getLabelProvider();
			return provider.getCustomizationManager();
		} else {
			EMFCompareLabelProvider provider = LabelProviderUtil.INSTANCE.getExistingLabelProviderFor(editor);
			return provider.getCustomizationManager();
		}
	}

	/**
	 * Refresh the viewers of the editor
	 * 
	 * @param editor
	 *        an editor
	 */
	public static void refreshViewers(final IEditorPart editor) {
		if(editor instanceof ICustomizableEditor) {
			((ICustomizableEditor)editor).refreshViewers();
		} else {
			EMFCompareLabelProviderRefreshingViewer provider = LabelProviderUtil.INSTANCE.getExistingLabelProviderFor(editor);
			provider.refreshViewer();
		}
	}

	/**
	 * Break the couple viewer/labelprovider if necessary
	 * 
	 * @param viewer
	 *        a viewer
	 * @param provider
	 *        a label provider
	 */
	public static void dissociateTreeViewerAndLabelProvider(final TreeViewer viewer, final LabelProvider provider) {
		if(provider instanceof ILabelProviderRefreshingViewer) {
			((ILabelProviderRefreshingViewer)provider).unregisterViewer(viewer);
		}
	}

	/**
	 * Create the couple viewer/labelprovider if necessary
	 * 
	 * @param viewer
	 *        a viewer
	 * @param provider
	 *        a label provider
	 */
	public static void associateViewerAndLabelProvider(final TreeViewer viewer, final LabelProvider provider) {
		if(provider instanceof ILabelProviderRefreshingViewer) {
			((ILabelProviderRefreshingViewer)provider).registerViewer(viewer);
		}
	}
}
