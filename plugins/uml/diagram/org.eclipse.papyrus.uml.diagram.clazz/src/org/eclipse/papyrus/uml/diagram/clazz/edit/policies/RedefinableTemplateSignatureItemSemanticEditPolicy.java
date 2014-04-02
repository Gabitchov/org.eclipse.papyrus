/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AbstractionCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AbstractionReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConnectorDurationObservationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConnectorTimeObservationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.Dependency2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.Dependency3CreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DependencyReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InformationFlowCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InformationFlowReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.RealizationCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.RealizationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationFlowEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class RedefinableTemplateSignatureItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RedefinableTemplateSignatureItemSemanticEditPolicy() {
		super(UMLElementTypes.RedefinableTemplateSignature_3015);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);

			if (deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ?
				getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if (requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if (baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType) requestElementType);
				isExtendedType = true;
			}
		}
		if (UMLElementTypes.Realization_4005 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new RealizationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Abstraction_4006 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new AbstractionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4007 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new UsageCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4008 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DependencyCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4018 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new Dependency3CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4013 == baseElementType) {
			return null;
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4014 == baseElementType) {
			return null;
		}
		if (UMLElementTypes.TimeObservationEvent_4024 == baseElementType) {
			return null;
		}
		if (UMLElementTypes.DurationObservationEvent_4025 == baseElementType) {
			return null;
		}
		if (UMLElementTypes.InformationFlow_4026 == baseElementType) {
			if (isExtendedType) {
				return getExtendedStartCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InformationFlowCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if (requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if (baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType) requestElementType);
				isExtendedType = true;
			}
		}
		if (UMLElementTypes.Realization_4005 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new RealizationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Abstraction_4006 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new AbstractionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4007 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new UsageCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4008 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DependencyCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4018 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new Dependency3CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4013 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4014 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.TimeObservationEvent_4024 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConnectorTimeObservationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DurationObservationEvent_4025 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConnectorDurationObservationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.InformationFlow_4026 == baseElementType) {
			if (isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InformationFlowCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new RealizationReorientCommand(req));
		case AbstractionEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractionReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		case DependencyBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new Dependency2ReorientCommand(req));
		case InformationFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new InformationFlowReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case ConnectorTimeObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorTimeObservationReorientCommand(req));
		case ConnectorDurationObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorDurationObservationReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
