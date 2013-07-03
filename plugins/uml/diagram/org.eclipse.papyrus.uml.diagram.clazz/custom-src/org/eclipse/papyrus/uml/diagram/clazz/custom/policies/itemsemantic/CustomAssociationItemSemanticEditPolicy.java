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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.BranchDependenctReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * this a specialization to manage creation of association and associationClass
 */
public class CustomAssociationItemSemanticEditPolicy extends org.eclipse.papyrus.uml.diagram.clazz.edit.policies.AssociationItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
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
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		EObject selectedEObject = req.getElementToDestroy();



		CompoundCommand cmd = new CompoundCommand();
		List<EObject> todestroy = new ArrayList<EObject>();
		EObject mainObjectToDelete = req.getElementToDestroy();
		todestroy.add(mainObjectToDelete);
		if(mainObjectToDelete instanceof Association) {
			// check end properties. If they do not belong to the association, they should be deleted also
			Association association = (Association)mainObjectToDelete;
			for(Property end : association.getMemberEnds()) {
				if(end.getOwner() != association) {
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(end);
					DestroyElementRequest Destructreq = new DestroyElementRequest(end, false);
					if(provider != null) {
						// Retrieve delete command from the Element Edit service
						ICommand deleteCommand = provider.getEditCommand(Destructreq);
						if(deleteCommand != null) {
							cmd.add(new ICommandProxy(deleteCommand));
						}
					}

				}
			}
		}
		cmd.add(super.getDestroyElementCommand(req));
		return cmd.unwrap();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getStartCreateRelationshipCommand(req);
	}
}
