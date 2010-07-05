/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;


public class BlockViewFactory extends AbstractShapeViewFactory {

	/**
	 * Creates Block view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);

		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_NAME_LABEL_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_VALUE_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
	}

	/**
	 * Should be moved in a common abstract class...
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}

		String elementName = view.getType();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(view, store, elementName);

	}
}
