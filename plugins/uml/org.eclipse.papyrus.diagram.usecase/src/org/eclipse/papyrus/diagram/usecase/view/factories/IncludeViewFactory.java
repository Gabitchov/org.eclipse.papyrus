/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.view.factories;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.LinkViewInitializer;

/**
 * @generated
 */
public class IncludeViewFactory extends ConnectionViewFactory {

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
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry
					.getType(IncludeEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(
				eObjectAdapter,
				view,
				UMLVisualIDRegistry
						.getType(IncludeLink_fixedEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint()
				.getPreferenceStore();

		if (store == null) {
			return;
		}

		LinkViewInitializer viewInitializer = new LinkViewInitializer(view,
				store);
		viewInitializer.initFont(IPapyrusPreferencesConstant.INCLUDE_PREF_FONT);
		viewInitializer
				.initFontColor(IPapyrusPreferencesConstant.INCLUDE_PREF_FONT_COLOR);
		viewInitializer
				.initLineColor(IPapyrusPreferencesConstant.INCLUDE_PREF_LINE_COLOR);

		viewInitializer
				.initAvoidObstructions(IPapyrusPreferencesConstant.INCLUDE_PREF_ROUTING_OBSTRUCTION_POLICY);
		viewInitializer
				.initClosestDistance(IPapyrusPreferencesConstant.INCLUDE_PREF_ROUTING_DISTANCE_POLICY);
		viewInitializer
				.initJumpLinkReverse(IPapyrusPreferencesConstant.INCLUDE_PREF_JUMPLINK_REVERSE);
		viewInitializer
				.initJumpLinkStatus(IPapyrusPreferencesConstant.INCLUDE_PREF_JUMPLINK_STATUS);
		viewInitializer
				.initJumpLinkType(IPapyrusPreferencesConstant.INCLUDE_PREF_JUMPLINK_TYPE);
		viewInitializer
				.initRouting(IPapyrusPreferencesConstant.INCLUDE_PREF_ROUTING_STYLE);
		viewInitializer
				.initSmoothness(IPapyrusPreferencesConstant.INCLUDE_PREF_SMOOTHNESS);
	}
}
