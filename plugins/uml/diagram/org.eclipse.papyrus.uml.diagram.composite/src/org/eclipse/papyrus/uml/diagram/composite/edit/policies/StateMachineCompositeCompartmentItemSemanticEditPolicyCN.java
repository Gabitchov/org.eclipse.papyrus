/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActivityCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActorCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ClassCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationUseCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ComponentCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeploymentSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeviceCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ExecutionEnvironmentCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.FunctionBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InformationItemCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InterfaceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.IntervalConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.NodeCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.OpaqueBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PortCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ProtocolStateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.SignalCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.StateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.UseCaseCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class StateMachineCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateMachineCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.StateMachine_3075);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
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
		if(UMLElementTypes.Port_3069 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PortCreateCommand(req));
		}
		if(UMLElementTypes.Parameter_3088 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ParameterCreateCommand(req));
		}
		if(UMLElementTypes.Property_3070 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PropertyPartCreateCommandCN(req));
		}
		if(UMLElementTypes.CollaborationUse_3071 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CollaborationUseCreateCommandCN(req));
		}
		if(UMLElementTypes.Activity_3072 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActivityCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Interaction_3073 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InteractionCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.ProtocolStateMachine_3074 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.StateMachine_3075 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new StateMachineCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.FunctionBehavior_3076 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.OpaqueBehavior_3077 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Component_3081 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ComponentCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Device_3082 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeviceCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.ExecutionEnvironment_3083 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Node_3084 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new NodeCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Class_3085 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ClassCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Collaboration_3086 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CollaborationCompositeCreateCommandCN(req));
		}
		if(UMLElementTypes.Interface_3087 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InterfaceCreateCommandCN(req));
		}
		if(UMLElementTypes.PrimitiveType_3078 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req));
		}
		if(UMLElementTypes.Enumeration_3079 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new EnumerationCreateCommandCN(req));
		}
		if(UMLElementTypes.DataType_3080 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DataTypeCreateCommandCN(req));
		}
		if(UMLElementTypes.Actor_3091 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActorCreateCommandCN(req));
		}
		if(UMLElementTypes.DeploymentSpecification_3092 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeploymentSpecificationCreateCommandCN(req));
		}
		if(UMLElementTypes.Artifact_3093 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ArtifactCreateCommandCN(req));
		}
		if(UMLElementTypes.InformationItem_3094 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InformationItemCreateCommandCN(req));
		}
		if(UMLElementTypes.Signal_3095 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SignalCreateCommandCN(req));
		}
		if(UMLElementTypes.UseCase_3096 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new UseCaseCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3097 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.DurationConstraint_3116 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.TimeConstraint_3117 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.IntervalConstraint_3118 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new IntervalConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.InteractionConstraint_3119 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InteractionConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_3120 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}
}
