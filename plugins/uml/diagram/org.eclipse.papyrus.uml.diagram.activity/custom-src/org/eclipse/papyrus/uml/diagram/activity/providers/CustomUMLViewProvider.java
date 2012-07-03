/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366026 - [ActivityDiagram] Refactoring in order to try respect Generation Gap Pattern 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Extends UMLViewProvider in order to provide custom node creation.
 * List of custom node (has to be updated):
 * -> ControlFlow
 * -> Object Flow
 * -> Interruptible Edge Icon (for ControlFlow and ObjectFlow)
 * 
 * @author arthur daussy
 * 
 */
public class CustomUMLViewProvider extends UMLViewProvider {

	@Override
	public Edge createControlFlow_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = super.createControlFlow_4004(domainElement, containerView, index, persisted, preferencesHint);
		/*
		 * Withdraw the view create for ControlFlowInterruptibleFigure
		 * This implementation do the following:
		 * 1. (In super imp) Create View + InterruptibleIconView
		 * 2. (Here) Withdraw InterruptibleIconView
		 * This implementation was done in purpose to keep generated code intact and keep using the next generation code
		 */
		if(edge != null) {
			EObject semanticElement = edge.getElement();
			if(semanticElement != null) {
				if(!semanticElement.eIsSet(UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS)) {
					deleteView(edge, ControlFlowInterruptibleIconEditPart.VISUAL_ID);
				}
			} else {
				deleteView(edge, ControlFlowInterruptibleIconEditPart.VISUAL_ID);
			}
		}
		return edge;
	}

	@Override
	public Edge createObjectFlow_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = super.createObjectFlow_4003(domainElement, containerView, index, persisted, preferencesHint);
		/*
		 * Withdraw the view create for ControlFlowInterruptibleFigure
		 * This implementation do the following:
		 * 1. (In super imp) Create View + InterruptibleIconView
		 * 2. (Here) Withdraw InterruptibleIconView
		 * This implementation was done in purpose to keep generated code intact and keep using the next generation code
		 */
		if(edge != null) {
			EObject semanticElement = edge.getElement();
			if(semanticElement != null) {
				if(!semanticElement.eIsSet(UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS)) {
					deleteView(edge, ObjectFlowInterruptibleIconEditPart.VISUAL_ID);
				}
			} else {
				deleteView(edge, ObjectFlowInterruptibleIconEditPart.VISUAL_ID);
			}
		}
		return edge;
	}

	/**
	 * 
	 * @param edge
	 * @param semanticHint
	 */
	private void deleteView(Edge edge, int semanticHint) {
		View interruptibleIconView = ViewUtil.getChildBySemanticHint(edge, String.valueOf(semanticHint));
		if(interruptibleIconView != null) {
			ViewUtil.destroy(interruptibleIconView);
		}
	}

	/**
	 * Create an Interruptible Edge icon on Control Flow
	 * 
	 * @param edge
	 * @param prefStore
	 * @param InterruptibleEdgeVisualID
	 * @param elementName
	 */
	public Node createInterruptibleEdgeIconOnControlFlow(View edge, PreferencesHint preferencesHint) {
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		Node label = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowInterruptibleIconEditPart.VISUAL_ID));
		label.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "ControlFlow");
		return label;
	}

	/**
	 * Create an Interruptible Edge icon on Object Flow
	 * 
	 * @param edge
	 * @param prefStore
	 * @param InterruptibleEdgeVisualID
	 * @param elementName
	 */
	public Node createInterruptibleEdgeIconOnObjectlFlow(View containerView, PreferencesHint preferencesHint) {
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		Node label = createLabel(containerView, UMLVisualIDRegistry.getType(ObjectFlowInterruptibleIconEditPart.VISUAL_ID));
		label.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(containerView, prefStore, "ObjectFlow");
		return label;
	}

	/**
	 * Override in order to be able to accept custom node creation
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.providers.UMLViewProvider#createNode(org.eclipse.core.runtime.IAdaptable,
	 *      org.eclipse.gmf.runtime.notation.View, java.lang.String, int, boolean, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint)
	 * 
	 * @param semanticAdapter
	 * @param containerView
	 * @param semanticHint
	 * @param index
	 * @param persisted
	 * @param preferencesHint
	 * @return
	 */
	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		/**
		 * handle specific node creation
		 */
		Node node = createCustomNode(visualID, containerView, preferencesHint);
		return (node != null) ? node : super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	/**
	 * Override in order to handle custom node
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.providers.UMLViewProvider#provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation)
	 * 
	 * @param op
	 * @return
	 */
	@Override
	protected boolean provides(CreateNodeViewOperation op) {
		return super.provides(op) || isCustomNode(op);
	}

	/***
	 * return true if the operation asking a for custom node creation
	 * 
	 * @param op
	 * @return
	 */
	protected boolean isCustomNode(CreateNodeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(op.getContainerView() != null && op.getSemanticHint() != null && elementType == null) {
			int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			return isCustomNode(visualID);
		}
		return false;
	}

	/**
	 * Return true if the node is a custom node
	 * 
	 * @param visualID
	 * @return
	 */
	protected boolean isCustomNode(int visualID) {
		switch(visualID) {
		case ControlFlowInterruptibleIconEditPart.VISUAL_ID:
		case ObjectFlowInterruptibleIconEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * Create specific node
	 * 
	 * @param visualID
	 * @param containerView
	 * @param preferencesHint
	 * @return
	 */
	protected Node createCustomNode(int visualID, View containerView, PreferencesHint preferencesHint) {
		switch(visualID) {
		case ControlFlowInterruptibleIconEditPart.VISUAL_ID:
			return createInterruptibleEdgeIconOnControlFlow(containerView, preferencesHint);
		case ObjectFlowInterruptibleIconEditPart.VISUAL_ID:
			return createInterruptibleEdgeIconOnObjectlFlow(containerView, preferencesHint);
		}
		return null;
	}
}
