/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;

public class InheritedClassDiagramElementViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if((elementType == BlockDefinitionDiagramElementTypes.DEPENDENCY) || (elementType == BlockDefinitionDiagramElementTypes.USAGE) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_REALIZATION) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_EDGE) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_LINK) || (elementType == BlockDefinitionDiagramElementTypes.GENERALIZATION) || (elementType == BlockDefinitionDiagramElementTypes.GENERALIZATION_SET) || (elementType == BlockDefinitionDiagramElementTypes.COMMENT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_ADDED_LINK)) {

			return true;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if((elementType == BlockDefinitionDiagramElementTypes.PACKAGE) || (elementType == BlockDefinitionDiagramElementTypes.PACKAGE_CN)

		|| (elementType == BlockDefinitionDiagramElementTypes.MODEL) || (elementType == BlockDefinitionDiagramElementTypes.MODEL_CN)

		|| (elementType == BlockDefinitionDiagramElementTypes.CLASS) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_CN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_RECP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_NEST_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.INTERFACE) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_CN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_NEST_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.PRIMITIVETYPE) || (elementType == BlockDefinitionDiagramElementTypes.PRIMITIVETYPE_CN)

		|| (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION) || (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION_CN) || (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION_LITERAL_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.DATATYPE) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_CN) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_OPER_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPEC) || (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPEC_CN) || (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPEC_SLOT_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_NEST_CLN)

		|| (elementType == BlockDefinitionDiagramElementTypes.COMMENT) || (elementType == BlockDefinitionDiagramElementTypes.COMMENT_CN)

		|| (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT) || (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT_CN)

		|| (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_CIRCLE)) {
			return true;
		}

		// else : unknown element
		return false;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		System.err.println("WAR : InheritedClassDiagramElementViewProvider::createNode - not view for type : " + semanticHint);
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", BlockDefinitionDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
