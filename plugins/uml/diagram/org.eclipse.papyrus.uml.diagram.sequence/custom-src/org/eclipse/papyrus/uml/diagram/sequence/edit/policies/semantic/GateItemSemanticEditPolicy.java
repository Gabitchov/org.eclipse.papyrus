/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage4ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Gate;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * Constructor.
	 * 
	 * @param elementType
	 */
	public GateItemSemanticEditPolicy() {
		super(null);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getSemanticCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		if(request instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest)request);
		} else if(request instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest)request);
		} else if(request instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest)request);
		}
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		if(completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest)completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		if(selectedEObject instanceof Gate && ((Gate)selectedEObject).getMessage() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if(deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage2ReorientCommand(req));
		case Message3EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage3ReorientCommand(req));
		case Message4EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage4ReorientCommand(req));
		case Message5EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage5ReorientCommand(req));
		case Message6EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage6ReorientCommand(req));
		case Message7EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {
		return super.getReorientReferenceRelationshipCommand(request);
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return new ICommandProxy(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		} else if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return new ICommandProxy(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		} else if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return new ICommandProxy(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		} else if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return new ICommandProxy(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCreateRelationshipCommand(req);
	}
}
