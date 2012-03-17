/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.gmf.diagram.common.factory.ShapeViewFactory;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class BlockClassifierViewFactory extends ShapeViewFactory {

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		
		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}
		
		// Get default size from preferences use set view size.
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(view, view.getType(), PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(view, view.getType(), PreferenceConstantHelper.HEIGHT);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(), store.getInt(preferenceConstantWitdh));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(), store.getInt(preferenceConstantHeight));
	}
	
	/**
	 * Creates Block view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {

		getViewService().createNode(element, view, SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID, ViewUtil.APPEND, persisted, getPreferencesHint());

		// this action needs to be done after the compartments creation
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
	}
}
