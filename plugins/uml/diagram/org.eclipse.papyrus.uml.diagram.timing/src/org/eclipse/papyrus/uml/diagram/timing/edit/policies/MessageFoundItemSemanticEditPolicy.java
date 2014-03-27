/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageFoundCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageFoundReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageLostCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageLostReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageFoundItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MessageFoundItemSemanticEditPolicy() {
		super(UMLElementTypes.Message_53);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
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
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.Message_50 == baseElementType) {
			return null;
		}
		if(UMLElementTypes.Message_53 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageFoundCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.Message_50 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageLostCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_53 == baseElementType) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageLostEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageLostReorientCommand(req));
		case MessageFoundEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageFoundReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}
}
