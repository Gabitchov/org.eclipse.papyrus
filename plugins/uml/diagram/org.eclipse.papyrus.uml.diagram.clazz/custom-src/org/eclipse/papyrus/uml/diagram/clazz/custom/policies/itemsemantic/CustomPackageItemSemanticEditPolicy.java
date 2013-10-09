/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.BranchDependenctReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CTemplateBindingCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentSubLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

public class CustomPackageItemSemanticEditPolicy extends PackageItemSemanticEditPolicy {

	/**
	 * /*
	 * * {@inheritDoc}
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ContainmentSubLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ContainmentLinkReorientCommand(req, getHost()));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case DependencyBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new BranchDependenctReorientCommand(req));
		case TemplateBindingEditPart.VISUAL_ID:
			return UnexecutableCommand.INSTANCE;
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getReorientRefRelationshipTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		if(ContainmentHelper.isReorientContainmentLink(request)) {
			request = ContainmentHelper.extendReorientTargetRequest(request);
		}
		return super.getReorientRefRelationshipTargetCommand(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getReorientRefRelationshipSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReorientRefRelationshipSourceCommand(ReconnectRequest request) {
		if(ContainmentHelper.isReorientContainmentLink(request)) {
			request = ContainmentHelper.extendReorientSourceRequest(request);
		}
		return super.getReorientRefRelationshipSourceCommand(request);
	}

	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new CTemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new CTemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}

	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		// TODO Auto-generated method stub
		return super.getDestroyReferenceCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		ICommandProxy command = (ICommandProxy)super.getDestroyElementCommand(req);
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.add(command.getICommand());
		//to ensure the deletion of link and also the undo!
		addDestroyIncomingContainmentLinksCommand(cmd);
		ContainmentHelper.addDeleteOutgoingContainmentLinkViewCommands(getEditingDomain(), (View)getHost().getModel(), cmd);
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * Adds the destroy incoming containment links command.
	 * 
	 * @param cmd
	 *        the cmd
	 */
	private void addDestroyIncomingContainmentLinksCommand(ICompositeCommand cmd) {
		View view = (View)getHost().getModel();
		for(Object next : view.getTargetEdges()) {
			Edge incomingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(incomingLink)) {
				cmd.add(ContainmentHelper.deleteIncomingContainmentLinkCommand(getEditingDomain(), incomingLink));
			}
		}
	}
}
