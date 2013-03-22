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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;


/**
 * Abstract ItemSemanticEditPolicy for messages.
 * 
 * Try to fixed bugs about reorient target of messages, because all Message EditParts implementing ITreeBranchEditPart, if we want to reorient target
 * of a message to another message, the new target would be redirected to the target of the message. GMF use this to merge two links, but we doesn't
 * need them for message creation.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AbstractMessageItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	protected AbstractMessageItemSemanticEditPolicy(IElementType elementType) {
		super(elementType);
	}

	protected Command getReorientRelationshipTargetCommand(ReconnectRequest request) {
		EObject connectionSemElement = ViewUtil.resolveSemanticElement((View)request.getConnectionEditPart().getModel());
		EObject targetSemElement = ViewUtil.resolveSemanticElement((View)request.getTarget().getModel());
		EObject oldSemElement = ViewUtil.resolveSemanticElement((View)request.getConnectionEditPart().getTarget().getModel());

		// check if we need to redirect the semantic request because of a tree
		// gesture.
		//		String connectionHint = ViewUtil.getSemanticElementClassId((View)request.getConnectionEditPart().getModel());
		//		if(((View)request.getTarget().getModel()).getElement() != null) {
		//			String targetHint = ViewUtil.getSemanticElementClassId((View)request.getTarget().getModel());
		//			if(request.getConnectionEditPart() instanceof ITreeBranchEditPart && request.getTarget() instanceof ITreeBranchEditPart && connectionHint.equals(targetHint)) {
		//				ITreeBranchEditPart targetBranch = (ITreeBranchEditPart)request.getTarget();
		//
		//				targetSemElement = ViewUtil.resolveSemanticElement((View)targetBranch.getTarget().getModel());
		//			}
		//		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		ReorientRelationshipRequest semRequest = new ReorientRelationshipRequest(editingDomain, connectionSemElement, targetSemElement, oldSemElement, ReorientRelationshipRequest.REORIENT_TARGET);

		semRequest.addParameters(request.getExtendedData());

		return getSemanticCommand(semRequest);
	}

}
