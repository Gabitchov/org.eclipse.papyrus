/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.ShapeViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;

public class BlockCompositeClassifierViewFactory extends ShapeViewFactory {

	/**
	 * Creates BlockComposite view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		getViewService().createNode(element, view, SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		// this action needs to be done after the compartments creation
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
	}

	// Start of user code preferences
	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		org.eclipse.jface.preference.IPreferenceStore store = (org.eclipse.jface.preference.IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}
		// Get default size from preferences use set view size.
		String preferenceConstantWitdh = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(view, view.getType(), org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(view, view.getType(), org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.HEIGHT);
		ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width(), store.getInt(preferenceConstantWitdh));
		ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height(), store.getInt(preferenceConstantHeight));
	}
	// End of user code
}
