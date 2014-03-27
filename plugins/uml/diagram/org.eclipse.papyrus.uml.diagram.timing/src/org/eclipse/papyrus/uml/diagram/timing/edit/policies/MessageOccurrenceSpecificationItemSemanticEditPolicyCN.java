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
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageAsyncCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageAsyncReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageCreateCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageCreateReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageDeleteCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageDeleteReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageFoundCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageFoundReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageLostCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageLostReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageReplyCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageReplyReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageSyncCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageSyncReorientCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageOccurrenceSpecificationItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MessageOccurrenceSpecificationItemSemanticEditPolicyCN() {
		super(UMLElementTypes.MessageOccurrenceSpecification_13);
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
		if(UMLElementTypes.Message_3 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageSyncCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageAsyncCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_41 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageReplyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_44 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageCreateCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_47 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageDeleteCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_50 == baseElementType) {
			if(isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageLostCreateCommand(req, req.getSource(), req.getTarget()));
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
		if(UMLElementTypes.Message_3 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageSyncCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageAsyncCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_41 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageReplyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_44 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageCreateCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_47 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageDeleteCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_50 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageLostCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_53 == baseElementType) {
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MessageFoundCreateCommand(req, req.getSource(), req.getTarget()));
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
		case MessageSyncEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageSyncReorientCommand(req));
		case MessageAsyncEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageAsyncReorientCommand(req));
		case MessageReplyEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReplyReorientCommand(req));
		case MessageCreateEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageCreateReorientCommand(req));
		case MessageDeleteEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageDeleteReorientCommand(req));
		case MessageLostEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageLostReorientCommand(req));
		case MessageFoundEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageFoundReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}
}
