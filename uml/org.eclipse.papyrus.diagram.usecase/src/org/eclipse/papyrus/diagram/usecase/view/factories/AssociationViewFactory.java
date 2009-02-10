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
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.LinkViewInitializer;

/**
 * @generated
 */
public class AssociationViewFactory extends ConnectionViewFactory {

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
			semanticHint = UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
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
		viewInitializer.initFont(IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT);
		viewInitializer.initFontColor(IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT_COLOR);
		viewInitializer.initLineColor(IPapyrusPreferencesConstant.ASSOCIATION_PREF_LINE_COLOR);

		viewInitializer.initAvoidObstructions(IPapyrusPreferencesConstant.ASSOCIATION_PREF_ROUTING_OBSTRUCTION_POLICY);
		viewInitializer.initClosestDistance(IPapyrusPreferencesConstant.ASSOCIATION_PREF_ROUTING_DISTANCE_POLICY);
		viewInitializer.initJumpLinkReverse(IPapyrusPreferencesConstant.ASSOCIATION_PREF_JUMPLINK_REVERSE);
		viewInitializer.initJumpLinkStatus(IPapyrusPreferencesConstant.ASSOCIATION_PREF_JUMPLINK_STATUS);
		viewInitializer.initJumpLinkType(IPapyrusPreferencesConstant.ASSOCIATION_PREF_JUMPLINK_TYPE);
		viewInitializer.initRouting(IPapyrusPreferencesConstant.ASSOCIATION_PREF_ROUTING_STYLE);
		viewInitializer.initSmoothness(IPapyrusPreferencesConstant.ASSOCIATION_PREF_SMOOTHNESS);
	}
}
