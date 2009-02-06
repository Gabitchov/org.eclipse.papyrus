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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.LinkViewInitializer;

/**
 * @generated
 */
public class PackageMergeViewFactory extends ConnectionViewFactory {

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
			semanticHint = UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
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
		viewInitializer.initFont(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_FONT);
		viewInitializer.initFontColor(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_FONT_COLOR);
		viewInitializer.initLineColor(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_LINE_COLOR);

		viewInitializer.initAvoidObstructions(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_ROUTING_OBSTRUCTION_POLICY);
		viewInitializer.initClosestDistance(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_ROUTING_DISTANCE_POLICY);
		viewInitializer.initJumpLinkReverse(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_JUMPLINK_REVERSE);
		viewInitializer.initJumpLinkStatus(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_JUMPLINK_STATUS);
		viewInitializer.initJumpLinkType(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_JUMPLINK_TYPE);
		viewInitializer.initRouting(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_ROUTING_STYLE);
		viewInitializer.initSmoothness(IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_SMOOTHNESS);
	}
}
