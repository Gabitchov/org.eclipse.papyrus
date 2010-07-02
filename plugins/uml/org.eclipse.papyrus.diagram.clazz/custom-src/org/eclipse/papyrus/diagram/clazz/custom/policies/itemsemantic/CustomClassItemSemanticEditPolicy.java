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
package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationClassCreateCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ClassItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * this class is used to call our own association class create command
 * 
 */
public class CustomClassItemSemanticEditPolicy extends ClassItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		//forbid creation of association branch from it.
		if(UMLElementTypes.Association_4019 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getStartCreateRelationshipCommand(req);
	}


	/**
	 * /*
	 * * {@inheritDoc}
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case AddedLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ContainmentLinkReorientCommand(req, getHost()));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getReorientRefRelationshipTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		int visualId = getVisualID(request);
		if(AddedLinkEditPart.VISUAL_ID == visualId) {
			Object view = request.getConnectionEditPart().getModel();
			if(view instanceof View) {
				request.getExtendedData().put(ContainmentHelper.KEY_CONNECTION_VIEW, view);
			}
		}
		return super.getReorientRefRelationshipSourceCommand(request);
	}

	/**
	 * Gets the visual id.
	 *
	 * @param request the request
	 * @return the visual id
	 */
	private int getVisualID(ReconnectRequest request) {
		Object id = request.getExtendedData().get(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer)id).intValue() : -1;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for(Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == AddedLinkEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				Shape containmentCircle = (Shape)incomingLink.getSource();
				if(((View)containmentCircle).getSourceEdges().size() == 1) {
					cmd.add(new DeleteCommand(getEditingDomain(), (View)containmentCircle));
				}
				continue;
			} else {
				return super.getDestroyElementCommand(req);
			}
		}
		for(Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == AddedLinkEditPart.VISUAL_ID) {

				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			} else {
				return super.getDestroyElementCommand(req);
			}


		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			addDestroyShortcutsCommand(cmd, view);
			List<EditPart> editParts = getHost().getChildren();
			Iterator<EditPart> editPartIterator = editParts.iterator();
			while(editPartIterator.hasNext()) {
				EditPart currentEditPart = editPartIterator.next();
				if(currentEditPart instanceof CContainmentCircleEditPart) {
					List<AddedLinkEditPart> links = ((CContainmentCircleEditPart)currentEditPart).getSourceConnections();
					Iterator<AddedLinkEditPart> nestedClassIterator = links.iterator();
					while(nestedClassIterator.hasNext()) {
						AddedLinkEditPart currentNestedClass = nestedClassIterator.next();
						if((currentNestedClass.getTarget() instanceof ClassEditPart)) {
							cmd.add(new DeleteCommand(getEditingDomain(), (View)currentNestedClass.getTarget().getModel()));
						}
					}

				}
			}

			cmd.add(new DestroyElementCommand(req));

		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}


}
