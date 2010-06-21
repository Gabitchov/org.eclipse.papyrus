/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.InternalBlockDiagramElementTypes;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;


public class FlowPortInViewFactory extends AbstractShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);

		// Set Semantic Hint
		view.setType(InternalBlockDiagramElementTypes.FLOWPORT_IN.getSemanticHint());

		// Show the following stereotype as icon (this command set the eAnnotation on the created node
		// No need to have a command here... 
		AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(EditorUtils.getTransactionalEditingDomain(), view, SysmlResource.FLOW_PORT_ID, VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION).execute();

		// Add the FlowPort node label
		getViewService().createNode(element, view, InternalBlockDiagramElementTypes.FLOWPORT_IN_NAME_LABEL_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
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

		// Retrieve preference constants
		String elementName = "FlowPort";
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(view, store, elementName);
	}
}
