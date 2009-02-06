/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.LinkViewInitializer;

/**
 * @generated
 */
public class UsageViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createRoutingStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AppliedStereotypeUsageEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint().getPreferenceStore();

		if (store == null) {
			return;
		}

		LinkViewInitializer viewInitializer = new LinkViewInitializer(view, store);
		viewInitializer.initFont(IPapyrusPreferencesConstant.USAGE_PREF_FONT);
		viewInitializer.initFontColor(IPapyrusPreferencesConstant.USAGE_PREF_FONT_COLOR);
		viewInitializer.initLineColor(IPapyrusPreferencesConstant.USAGE_PREF_LINE_COLOR);

		viewInitializer.initAvoidObstructions(IPapyrusPreferencesConstant.USAGE_PREF_ROUTING_OBSTRUCTION_POLICY);
		viewInitializer.initClosestDistance(IPapyrusPreferencesConstant.USAGE_PREF_ROUTING_DISTANCE_POLICY);
		viewInitializer.initJumpLinkReverse(IPapyrusPreferencesConstant.USAGE_PREF_JUMPLINK_REVERSE);
		viewInitializer.initJumpLinkStatus(IPapyrusPreferencesConstant.USAGE_PREF_JUMPLINK_STATUS);
		viewInitializer.initJumpLinkType(IPapyrusPreferencesConstant.USAGE_PREF_JUMPLINK_TYPE);
		viewInitializer.initRouting(IPapyrusPreferencesConstant.USAGE_PREF_ROUTING_STYLE);
		viewInitializer.initSmoothness(IPapyrusPreferencesConstant.USAGE_PREF_SMOOTHNESS);
	}
}
