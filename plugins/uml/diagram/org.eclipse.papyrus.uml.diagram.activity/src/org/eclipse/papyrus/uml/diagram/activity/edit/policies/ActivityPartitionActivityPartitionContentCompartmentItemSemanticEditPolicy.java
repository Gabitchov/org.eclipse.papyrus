/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.AcceptEventActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ActivityPartitionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.AddStructuralFeatureValueActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.AddVariableValueActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.BroadcastSignalActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CallOperationActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CentralBufferNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConditionalNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CreateObjectActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DataStoreNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DecisionNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DestroyObjectActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DurationConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DurationConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ExpansionRegionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ForkNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.InitialNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.IntervalConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.IntervalConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.JoinNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.LoopNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.MergeNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ReadSelfActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ReadStructuralFeatureActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ReadVariableActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.SendObjectActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.SendSignalActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.SequenceNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.StructuredActivityNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.TimeConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.TimeConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ValueSpecificationActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.ActivityPartition_3067);
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
		if(UMLElementTypes.InitialNode_3004 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InitialNodeCreateCommand(req));
		}
		if(UMLElementTypes.ActivityFinalNode_3005 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActivityFinalNodeCreateCommand(req));
		}
		if(UMLElementTypes.FlowFinalNode_3006 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new FlowFinalNodeCreateCommand(req));
		}
		if(UMLElementTypes.OpaqueAction_3007 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new OpaqueActionCreateCommand(req));
		}
		if(UMLElementTypes.CallBehaviorAction_3008 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CallBehaviorActionCreateCommand(req));
		}
		if(UMLElementTypes.CallOperationAction_3010 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CallOperationActionCreateCommand(req));
		}
		if(UMLElementTypes.DecisionNode_3038 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DecisionNodeCreateCommand(req));
		}
		if(UMLElementTypes.MergeNode_3039 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if(UMLElementTypes.ForkNode_3040 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ForkNodeCreateCommand(req));
		}
		if(UMLElementTypes.JoinNode_3041 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new JoinNodeCreateCommand(req));
		}
		if(UMLElementTypes.DataStoreNode_3078 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DataStoreNodeCreateCommand(req));
		}
		if(UMLElementTypes.SendObjectAction_3042 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SendObjectActionCreateCommand(req));
		}
		if(UMLElementTypes.SendSignalAction_3052 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SendSignalActionCreateCommand(req));
		}
		if(UMLElementTypes.AcceptEventAction_3063 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new AcceptEventActionCreateCommand(req));
		}
		if(UMLElementTypes.ValueSpecificationAction_3076 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ValueSpecificationActionCreateCommand(req));
		}
		if(UMLElementTypes.ConditionalNode_3069 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConditionalNodeCreateCommand(req));
		}
		if(UMLElementTypes.ExpansionRegion_3070 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExpansionRegionCreateCommand(req));
		}
		if(UMLElementTypes.LoopNode_3071 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LoopNodeCreateCommand(req));
		}
		if(UMLElementTypes.SequenceNode_3073 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SequenceNodeCreateCommand(req));
		}
		if(UMLElementTypes.StructuredActivityNode_3065 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new StructuredActivityNodeCreateCommand(req));
		}
		if(UMLElementTypes.ReadSelfAction_3081 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ReadSelfActionCreateCommand(req));
		}
		if(UMLElementTypes.ActivityPartition_3067 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActivityPartitionCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3034 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3035 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3036 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3037 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3032 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new IntervalConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3033 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new IntervalConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3011 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3012 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.CreateObjectAction_3086 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CreateObjectActionCreateCommand(req));
		}
		if(UMLElementTypes.ReadStructuralFeatureAction_3088 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ReadStructuralFeatureActionCreateCommand(req));
		}
		if(UMLElementTypes.AddStructuralFeatureValueAction_3091 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new AddStructuralFeatureValueActionCreateCommand(req));
		}
		if(UMLElementTypes.DestroyObjectAction_3095 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DestroyObjectActionCreateCommand(req));
		}
		if(UMLElementTypes.ReadVariableAction_3097 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ReadVariableActionCreateCommand(req));
		}
		if(UMLElementTypes.AddVariableValueAction_3099 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new AddVariableValueActionCreateCommand(req));
		}
		if(UMLElementTypes.BroadcastSignalAction_3102 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new BroadcastSignalActionCreateCommand(req));
		}
		if(UMLElementTypes.CentralBufferNode_3104 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CentralBufferNodeCreateCommand(req));
		}
		if(UMLElementTypes.Comment_3080 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3112 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}
}
