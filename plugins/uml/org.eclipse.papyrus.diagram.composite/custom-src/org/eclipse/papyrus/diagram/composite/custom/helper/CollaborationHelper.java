/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.helper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.composite.custom.edit.command.CollaborationUseFromTypeCreateCommand;
import org.eclipse.papyrus.diagram.composite.custom.edit.command.CreateViewCommand;
import org.eclipse.papyrus.diagram.composite.edit.parts.CollaborationUseEditPartCN;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.StructuredClassifier;

public class CollaborationHelper extends ElementHelper {

	public CollaborationHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * This method returns drop command for a Collaboration dropped on Another Collaboration or Class in the diagram.
	 * This should result in the creation of a CollaborationUse typed by the dropped Collaboration.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the element to drop
	 * @return a CompositeCommand for Drop
	 */
	public CompoundCommand dropCollaborationAsCollaborationUse(GraphicalEditPart graphicalTarget, Collaboration semanticElement, Point location) {
		CompoundCommand cc = new CompoundCommand("DropCollaborationAsCollaborationUse");

		GraphicalEditPart graphicalParentEditPart = graphicalTarget;
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		IHintedType elementType = (IHintedType)UMLElementTypes.getElementType(CollaborationUseEditPartCN.VISUAL_ID);

		if(graphicalParentObject instanceof StructuredClassifier) {

			SemanticAdapter semanticAdapter = new SemanticAdapter(null, null);

			// Prepare a command for the Property creation and the drop in diagram
			// 1. Prepare creation command
			CreateElementRequest req = new CreateElementRequest(getEditingDomain(), graphicalParentObject, elementType);
			CollaborationUseFromTypeCreateCommand cUseCreateCommand = new CollaborationUseFromTypeCreateCommand(req, (StructuredClassifier)graphicalParentObject, semanticElement, semanticAdapter);

			// 2. Prepare the drop command
			ViewDescriptor descriptor = new ViewDescriptor((IAdaptable)cUseCreateCommand.getCommandResult().getReturnValue(), Node.class, elementType.getSemanticHint(), ViewUtil.APPEND, false, graphicalTarget.getDiagramPreferencesHint());
			CreateViewCommand viewCreateCommand = new CreateViewCommand(getEditingDomain(), descriptor, ((View)(graphicalTarget.getModel())));
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)viewCreateCommand.getCommandResult().getReturnValue(), location);

			// 3. Create the compound command
			cc.add(new ICommandProxy(cUseCreateCommand));
			cc.add(new ICommandProxy(viewCreateCommand));
			cc.add(new ICommandProxy(setBoundsCommand));
		}

		return cc;
	}
}
