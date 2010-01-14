/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceLinkMappingHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;

/**
 * A policy to support dNd from the Model Explorer in the sequence diagram
 * 
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** The specific drop node. */
	public int[] specificDropNode = { BehaviorExecutionSpecificationEditPart.VISUAL_ID, ActionExecutionSpecificationEditPart.VISUAL_ID, MessageEditPart.VISUAL_ID, Message2EditPart.VISUAL_ID, Message3EditPart.VISUAL_ID, Message4EditPart.VISUAL_ID, Message5EditPart.VISUAL_ID, Message6EditPart.VISUAL_ID, Message7EditPart.VISUAL_ID };

	public CustomDiagramDragDropEditPolicy() {
		super(SequenceLinkMappingHelper.getInstance());
		init(specificDropNode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		if(nodeVISUALID != -1) {
			switch(nodeVISUALID) {
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return dropExecutionSpecification(dropRequest, semanticLink, nodeVISUALID);
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}


		if(linkVISUALID != -1) {
			switch(linkVISUALID) {
			case MessageEditPart.VISUAL_ID:
			case Message2EditPart.VISUAL_ID:
			case Message3EditPart.VISUAL_ID:
			case Message4EditPart.VISUAL_ID:
			case Message5EditPart.VISUAL_ID:
			case Message6EditPart.VISUAL_ID:
			case Message7EditPart.VISUAL_ID:
				return dropMessage(dropRequest, semanticLink, linkVISUALID);
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}



	private Command dropExecutionSpecification(DropObjectsRequest dropRequest, Element semanticLink, int nodeVisualID) {
		if(semanticLink instanceof ExecutionSpecification) {
			List<View> existingViews = DiagramEditPartsUtil.findViews(semanticLink, getViewer());
			if(existingViews.isEmpty()) {
				// Find the lifeline of the ES
				ExecutionSpecification es = (ExecutionSpecification)semanticLink;
				if(es.getStart() != null) {
					// an Occurrence Specification covereds systematically a unique lifeline
					Lifeline lifeline = es.getStart().getCovereds().get(0);
					// Check that the container view is the view of the lifeline
					if(lifeline.equals(ViewUtil.resolveSemanticElement((View)getHost().getModel()))) {
						ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(semanticLink), Node.class, String.valueOf(nodeVisualID), ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());
						CreateCommand cc = new CreateCommand(getEditingDomain(), viewDescriptor, (View)getHost().getModel());
						return new ICommandProxy(cc);
					}
				}
			} else {
				//TODO : implements a move command of the existing view.
			}

		}
		return UnexecutableCommand.INSTANCE;
	}

	private Command dropMessage(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = SequenceLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = SequenceLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(!sources.isEmpty() && !targets.isEmpty()) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Message"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
