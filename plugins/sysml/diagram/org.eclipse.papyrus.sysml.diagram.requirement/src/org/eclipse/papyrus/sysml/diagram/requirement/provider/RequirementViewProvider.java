/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Olivier Mélois (ATOS) - Initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;

public class RequirementViewProvider extends UMLViewProvider {

	protected boolean provides(CreateNodeViewOperation op) {

		// This provider is registered for Requirement Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// This provider is registered for class only.
		IAdaptable semanticAdapter = op.getSemanticAdapter();
		IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
		if((elementType == RequirementDiagramElementTypes.CLASS) || (elementType == RequirementDiagramElementTypes.CLASS_CN)) {
			return true;
		}
		
		/*
		 * Case when the element is dragged from the model explorer. The semantic adapter will be an EObject adapter, from 
		 * which it can be determined whether the stereotype "requirement" is applied.
		 */
		if (semanticAdapter instanceof EObjectAdapter){
			Object domainElement = ((EObjectAdapter) semanticAdapter).getRealObject();
			if((domainElement instanceof org.eclipse.uml2.uml.Class)) {
				org.eclipse.uml2.uml.Class domainElementClass = (org.eclipse.uml2.uml.Class)domainElement;
				return domainElementClass.getAppliedStereotype(SysmlResource.REQUIREMENT_ID) != null;
			}
		}

		// else : unknown element
		return false;

	}

	/**
	 * {@inheritDoc} Overridden to add an additional compartment.
	 */
	@Override
	public Node createClass_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		//node.setType(UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
		node.setType(SysMLGraphicalTypes.SHAPE_SYSML_REQUIREMENT_AS_CLASSIFER_ID);
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Class");
		
		/*
		 * Name of the requirement
		 */
//		createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		
		/*
		 * Addition of the compartment, and the labels it contains.
		 */
		Node compartment = createCompartment(node, SysMLGraphicalTypes.COMPARTMENT_SYSML_REQUIREMENT_IDINFO_AS_LIST_ID, true, true, true, true);
		createLabel(compartment, SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_ID_ID);
		createLabel(compartment, SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_TEXT_ID);
		/*
		 * Other compartments.
		 */
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		
		return node;
	}

}
