/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;

public class CustomViewProvider extends InheritedActivityDiagramViewProvider {

	@Override
	protected boolean provides(final CreateNodeViewOperation op) {
		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}
		// Get the type of the container
		final String containerGraphicalType = op.getContainerView().getType();

		// This provider is registered for InteractionOverviewDiagram Diagram
		// only
		final String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its
		// expected container.
		// /////////////////////////////////////////////////////////////////////

		final IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == UMLElementTypes.CallBehaviorAction_5000) {

			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Node createNode(final IAdaptable semanticAdapter, final View containerView, final String semanticHint, final int index, final boolean persisted, final PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
		case CallBehaviorActionAsInteractionEditPart.VISUAL_ID:
			return createCallBehaviorAction_5000(domainElement, containerView, index, persisted, preferencesHint);
			// can't happen, provided #provides(CreateNodeViewOperation) is correct
		}
		return null;

	}

	public Node createCallBehaviorAction_5000(final EObject domainElement, final View containerView, final int index, final boolean persisted, final PreferencesHint preferencesHint) {
		final Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CallBehaviorActionAsInteractionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CallBehaviorAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CallBehaviorAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CallBehaviorAction");
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "CallBehaviorAction");
		return node;
	}
}
