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
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeAssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName6EditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;

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
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AppliedStereotypeAssociationEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName3EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName4EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName5EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(AssociationName6EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}
}
