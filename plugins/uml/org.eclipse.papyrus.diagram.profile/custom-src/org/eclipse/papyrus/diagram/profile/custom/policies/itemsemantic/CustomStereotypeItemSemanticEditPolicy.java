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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.profile.custom.policies.itemsemantic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationReorientCommand;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomExtensionCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.profile.edit.policies.StereotypeItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the Extension link element (when used in Profile Diagram)
 * </pre>
 */
public class CustomStereotypeItemSemanticEditPolicy extends StereotypeItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.policies.StereotypeItemSemanticEditPolicy#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomAssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of an Extension connected to a Stereotype
	 * on its source end. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Extension_1013 == req.getElementType()) {
			return getGEFWrapper(new CustomExtensionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		//forbid creation of association branch from it.
		if(UMLElementTypes.Association_4019 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getStartCreateRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

	/**
	 * Destroy the extensions associated to the metaclass and call the super method
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.policies.StereotypeItemSemanticEditPolicyCN#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = new CompoundCommand("Destroy Stereotype"); //$NON-NLS-1$
		EObject elementToDestroy = req.getElementToDestroy();
		if(elementToDestroy instanceof Stereotype) {
			Stereotype ste = (Stereotype)elementToDestroy;
			EList<Association> associationList = ste.getAssociations();
			for(Association association : associationList) {
				if(association instanceof Extension) {
					DestroyElementRequest destroyElementRequest = new DestroyElementRequest(association, false);
					DestroyElementCommand destroyElementCommand = new DestroyElementCommand(destroyElementRequest);
					cc.add(new ICommandProxy(destroyElementCommand));
				}
			}
		}

		cc.add(super.getDestroyElementCommand(req));
		return cc;
	}
}
