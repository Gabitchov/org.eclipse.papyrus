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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

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
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ActivityFinalNode_3005 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.FlowFinalNode_3006 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.OpaqueAction_3007 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.CallBehaviorAction_3008 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.CallOperationAction_3010 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.DecisionNode_3038 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.MergeNode_3039 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ForkNode_3040 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.JoinNode_3041 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.DataStoreNode_3078 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.SendObjectAction_3042 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.SendSignalAction_3052 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.AcceptEventAction_3063 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ValueSpecificationAction_3076 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ConditionalNode_3069 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ExpansionRegion_3070 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.LoopNode_3071 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.SequenceNode_3073 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.StructuredActivityNode_3065 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ReadSelfAction_3081 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ActivityPartition_3067 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedGroup();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3034 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPrecondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3035 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPostcondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3036 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPrecondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3037 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPostcondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3032 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPrecondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3033 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPostcondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.Constraint_3011 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPrecondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.Constraint_3012 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getAction_LocalPostcondition();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.CreateObjectAction_3086 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ReadStructuralFeatureAction_3088 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.AddStructuralFeatureValueAction_3091 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.DestroyObjectAction_3095 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.ReadVariableAction_3097 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.AddVariableValueAction_3099 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.BroadcastSignalAction_3102 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.CentralBufferNode_3104 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getActivity_OwnedNode();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.Comment_3080 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getElement_OwnedComment();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		if(UMLElementTypes.Constraint_3112 == baseElementType) {
			// adjust the containment feature
			EReference containmentFeature = UMLPackage.eINSTANCE.getNamespace_OwnedRule();
			req.setContainmentFeature(containmentFeature);
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(getSemanticCreationCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
