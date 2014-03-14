/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.BranchDependenctReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CTemplateBindingCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomAssociationBranchReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.SignalItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * this a specialization to manage creation of association and associationClass
 */
public class CustomSignalItemSemanticEditPolicyCN extends SignalItemSemanticEditPolicyCN {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget(), DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new CTemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationClassLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		case DependencyBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new BranchDependenctReorientCommand(req));
		case AssociationBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomAssociationBranchReorientCommand(req));
		case TemplateBindingEditPart.VISUAL_ID:
			return UnexecutableCommand.INSTANCE;
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget(), DiagramUtils.getDiagramFrom(getHost())));
		}
		//forbid creation of association branch from it.
		if(UMLElementTypes.Association_4019 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new CTemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
