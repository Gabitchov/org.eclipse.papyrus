/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsInEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsOutEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInAcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInValSpecActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SequenceNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated NOT
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof ActivityEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.Parameter_3001);
			types.add(UMLElementTypes.Constraint_3002);
			types.add(UMLElementTypes.Constraint_3003);
			return types;
		}
		if(editPart instanceof OpaqueActionEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			return types;
		}
		if(editPart instanceof CallBehaviorActionEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			return types;
		}
		if(editPart instanceof CallOperationActionEditPart) {
			ArrayList types = new ArrayList(7);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			return types;
		}
		if(editPart instanceof SendObjectActionEditPart) {
			ArrayList types = new ArrayList(6);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			return types;
		}
		if(editPart instanceof SendSignalActionEditPart) {
			ArrayList types = new ArrayList(6);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			return types;
		}
		if(editPart instanceof AcceptEventActionEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.OutputPin_3064);
			return types;
		}
		if(editPart instanceof ActivityActivityContentCompartmentEditPart) {
			ArrayList types = new ArrayList(23);
			types.add(UMLElementTypes.InitialNode_3004);
			types.add(UMLElementTypes.ActivityFinalNode_3005);
			types.add(UMLElementTypes.FlowFinalNode_3006);
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.CallOperationAction_3010);
			//			types.add(UMLElementTypes.DurationConstraint_3034);
			//			types.add(UMLElementTypes.DurationConstraint_3035);
			//			types.add(UMLElementTypes.TimeConstraint_3036);
			//			types.add(UMLElementTypes.TimeConstraint_3037);
			//			types.add(UMLElementTypes.InteractionConstraint_3030);
			//			types.add(UMLElementTypes.InteractionConstraint_3031);
			//			types.add(UMLElementTypes.IntervalConstraint_3032);
			//			types.add(UMLElementTypes.IntervalConstraint_3033);
			//			types.add(UMLElementTypes.Constraint_3011);
			//			types.add(UMLElementTypes.Constraint_3012);
			types.add(UMLElementTypes.DecisionNode_3038);
			types.add(UMLElementTypes.MergeNode_3039);
			types.add(UMLElementTypes.ForkNode_3040);
			types.add(UMLElementTypes.JoinNode_3041);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			return types;
		}
		if(editPart instanceof ActivityDiagramEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.Activity_2001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InitialNodeEditPart) {
			return ((InitialNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActivityFinalNodeEditPart) {
			return ((ActivityFinalNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof FlowFinalNodeEditPart) {
			return ((FlowFinalNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OpaqueActionEditPart) {
			return ((OpaqueActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInOpaqueActEditPart) {
			return ((ValuePinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			return ((ActionInputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInOpaqueActEditPart) {
			return ((InputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OutputPinInOpaqueActEditPart) {
			return ((OutputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CallBehaviorActionEditPart) {
			return ((CallBehaviorActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInCallBeActEditPart) {
			return ((ValuePinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInCallBeActEditPart) {
			return ((ActionInputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInCallBeActEditPart) {
			return ((InputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OutputPinInCallBeActEditPart) {
			return ((OutputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CallOperationActionEditPart) {
			return ((CallOperationActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActEditPart) {
			return ((ActionInputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInCallOpActEditPart) {
			return ((ValuePinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInCallOpActEditPart) {
			return ((InputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OutputPinInCallOpActEditPart) {
			return ((OutputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			return ((ValuePinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			return ((ActionInputPinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			return ((InputPinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DecisionNodeEditPart) {
			return ((DecisionNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof MergeNodeEditPart) {
			return ((MergeNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ForkNodeEditPart) {
			return ((ForkNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof JoinNodeEditPart) {
			return ((JoinNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SendObjectActionEditPart) {
			return ((SendObjectActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			return ((ValuePinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			return ((ActionInputPinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			return ((InputPinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			return ((ValuePinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			return ((ActionInputPinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			return ((InputPinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SendSignalActionEditPart) {
			return ((SendSignalActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActEditPart) {
			return ((ActionInputPinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInSendSigActEditPart) {
			return ((ValuePinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInSendSigActEditPart) {
			return ((InputPinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			return ((ValuePinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			return ((ActionInputPinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			return ((InputPinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActivityParameterNodeEditPart) {
			return ((ActivityParameterNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof AcceptEventActionEditPart) {
			return ((AcceptEventActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			return ((OutputPinInAcceptEventActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConditionalNodeEditPart) {
			return ((ConditionalNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExpansionRegionEditPart) {
			return ((ExpansionRegionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExpansionNodeAsInEditPart) {
			return ((ExpansionNodeAsInEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExpansionNodeAsOutEditPart) {
			return ((ExpansionNodeAsOutEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LoopNodeEditPart) {
			return ((LoopNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SequenceNodeEditPart) {
			return ((SequenceNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StructuredActivityNodeEditPart) {
			return ((StructuredActivityNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ValueSpecificationActionEditPart) {
			return ((ValueSpecificationActionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OutputPinInValSpecActEditPart) {
			return ((OutputPinInValSpecActEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataStoreNodeEditPart) {
			return ((DataStoreNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InitialNodeEditPart) {
			return ((InitialNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			return ((ActivityFinalNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			return ((FlowFinalNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			return ((OpaqueActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			return ((ValuePinInOpaqueActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			return ((ActionInputPinInOpaqueActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			return ((InputPinInOpaqueActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			return ((OutputPinInOpaqueActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			return ((CallBehaviorActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			return ((ValuePinInCallBeActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			return ((ActionInputPinInCallBeActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			return ((InputPinInCallBeActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			return ((OutputPinInCallBeActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			return ((CallOperationActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			return ((ActionInputPinInCallOpActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			return ((ValuePinInCallOpActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			return ((InputPinInCallOpActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			return ((OutputPinInCallOpActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			return ((ValuePinInCallOpActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			return ((ActionInputPinInCallOpActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			return ((InputPinInCallOpActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			return ((DurationConstraintAsLocalPrecondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			return ((DurationConstraintAsLocalPostcondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			return ((TimeConstraintAsLocalPrecondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			return ((TimeConstraintAsLocalPostcondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			return ((InteractionConstraintAsLocalPrecondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
			return ((InteractionConstraintAsLocalPostcondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			return ((IntervalConstraintAsLocalPrecondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			return ((IntervalConstraintAsLocalPostcondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			return ((ConstraintAsLocalPrecondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			return ((ConstraintAsLocalPostcondEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			return ((DecisionNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			return ((MergeNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			return ((ForkNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			return ((JoinNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			return ((SendObjectActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			return ((ValuePinInSendObjActAsReqEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			return ((ActionInputPinInSendObjActAsReqEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			return ((InputPinInSendObjActAsReqEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			return ((ValuePinInSendObjActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			return ((ActionInputPinInSendObjActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			return ((InputPinInSendObjActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			return ((SendSignalActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			return ((ActionInputPinInSendSigActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			return ((ValuePinInSendSigActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			return ((InputPinInSendSigActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			return ((ValuePinInSendSigActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			return ((ActionInputPinInSendSigActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			return ((InputPinInSendSigActAsTargetEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			return ((ActivityParameterNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			return ((AcceptEventActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			return ((OutputPinInAcceptEventActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			return ((ConditionalNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			return ((ExpansionRegionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			return ((ExpansionNodeAsInEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			return ((ExpansionNodeAsOutEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			return ((LoopNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			return ((SequenceNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			return ((StructuredActivityNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			return ((ValueSpecificationActionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			return ((OutputPinInValSpecActEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			return ((DataStoreNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InitialNodeEditPart) {
			return ((InitialNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActivityFinalNodeEditPart) {
			return ((ActivityFinalNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof FlowFinalNodeEditPart) {
			return ((FlowFinalNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OpaqueActionEditPart) {
			return ((OpaqueActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInOpaqueActEditPart) {
			return ((ValuePinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			return ((ActionInputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInOpaqueActEditPart) {
			return ((InputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OutputPinInOpaqueActEditPart) {
			return ((OutputPinInOpaqueActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CallBehaviorActionEditPart) {
			return ((CallBehaviorActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInCallBeActEditPart) {
			return ((ValuePinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInCallBeActEditPart) {
			return ((ActionInputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInCallBeActEditPart) {
			return ((InputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OutputPinInCallBeActEditPart) {
			return ((OutputPinInCallBeActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CallOperationActionEditPart) {
			return ((CallOperationActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActEditPart) {
			return ((ActionInputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInCallOpActEditPart) {
			return ((ValuePinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInCallOpActEditPart) {
			return ((InputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OutputPinInCallOpActEditPart) {
			return ((OutputPinInCallOpActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			return ((ValuePinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			return ((ActionInputPinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			return ((InputPinInCallOpActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DecisionNodeEditPart) {
			return ((DecisionNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof MergeNodeEditPart) {
			return ((MergeNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ForkNodeEditPart) {
			return ((ForkNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof JoinNodeEditPart) {
			return ((JoinNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SendObjectActionEditPart) {
			return ((SendObjectActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			return ((ValuePinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			return ((ActionInputPinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			return ((InputPinInSendObjActAsReqEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			return ((ValuePinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			return ((ActionInputPinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			return ((InputPinInSendObjActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SendSignalActionEditPart) {
			return ((SendSignalActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActEditPart) {
			return ((ActionInputPinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInSendSigActEditPart) {
			return ((ValuePinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInSendSigActEditPart) {
			return ((InputPinInSendSigActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			return ((ValuePinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			return ((ActionInputPinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			return ((InputPinInSendSigActAsTargetEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActivityParameterNodeEditPart) {
			return ((ActivityParameterNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof AcceptEventActionEditPart) {
			return ((AcceptEventActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			return ((OutputPinInAcceptEventActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConditionalNodeEditPart) {
			return ((ConditionalNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExpansionRegionEditPart) {
			return ((ExpansionRegionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExpansionNodeAsInEditPart) {
			return ((ExpansionNodeAsInEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExpansionNodeAsOutEditPart) {
			return ((ExpansionNodeAsOutEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LoopNodeEditPart) {
			return ((LoopNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SequenceNodeEditPart) {
			return ((SequenceNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StructuredActivityNodeEditPart) {
			return ((StructuredActivityNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ValueSpecificationActionEditPart) {
			return ((ValueSpecificationActionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OutputPinInValSpecActEditPart) {
			return ((OutputPinInValSpecActEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataStoreNodeEditPart) {
			return ((DataStoreNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InitialNodeEditPart) {
			return ((InitialNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			return ((ActivityFinalNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			return ((FlowFinalNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			return ((OpaqueActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			return ((ValuePinInOpaqueActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			return ((ActionInputPinInOpaqueActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			return ((InputPinInOpaqueActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			return ((OutputPinInOpaqueActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			return ((CallBehaviorActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			return ((ValuePinInCallBeActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			return ((ActionInputPinInCallBeActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			return ((InputPinInCallBeActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			return ((OutputPinInCallBeActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			return ((CallOperationActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			return ((ActionInputPinInCallOpActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			return ((ValuePinInCallOpActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			return ((InputPinInCallOpActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			return ((OutputPinInCallOpActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			return ((ValuePinInCallOpActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			return ((ActionInputPinInCallOpActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			return ((InputPinInCallOpActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			return ((DurationConstraintAsLocalPrecondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			return ((DurationConstraintAsLocalPostcondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			return ((TimeConstraintAsLocalPrecondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			return ((TimeConstraintAsLocalPostcondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			return ((InteractionConstraintAsLocalPrecondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
			return ((InteractionConstraintAsLocalPostcondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			return ((IntervalConstraintAsLocalPrecondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			return ((IntervalConstraintAsLocalPostcondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			return ((ConstraintAsLocalPrecondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			return ((ConstraintAsLocalPostcondEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			return ((DecisionNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			return ((MergeNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			return ((ForkNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			return ((JoinNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			return ((SendObjectActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			return ((ValuePinInSendObjActAsReqEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			return ((ActionInputPinInSendObjActAsReqEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			return ((InputPinInSendObjActAsReqEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			return ((ValuePinInSendObjActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			return ((ActionInputPinInSendObjActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			return ((InputPinInSendObjActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			return ((SendSignalActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			return ((ActionInputPinInSendSigActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			return ((ValuePinInSendSigActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			return ((InputPinInSendSigActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			return ((ValuePinInSendSigActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			return ((ActionInputPinInSendSigActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			return ((InputPinInSendSigActAsTargetEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			return ((ActivityParameterNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			return ((AcceptEventActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			return ((OutputPinInAcceptEventActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			return ((ConditionalNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			return ((ExpansionRegionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			return ((ExpansionNodeAsInEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			return ((ExpansionNodeAsOutEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			return ((LoopNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			return ((SequenceNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			return ((StructuredActivityNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			return ((ValueSpecificationActionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			return ((OutputPinInValSpecActEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			return ((DataStoreNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InitialNodeEditPart) {
			return ((InitialNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActivityFinalNodeEditPart) {
			return ((ActivityFinalNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof FlowFinalNodeEditPart) {
			return ((FlowFinalNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OpaqueActionEditPart) {
			return ((OpaqueActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInOpaqueActEditPart) {
			return ((ValuePinInOpaqueActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			return ((ActionInputPinInOpaqueActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInOpaqueActEditPart) {
			return ((InputPinInOpaqueActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OutputPinInOpaqueActEditPart) {
			return ((OutputPinInOpaqueActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CallBehaviorActionEditPart) {
			return ((CallBehaviorActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInCallBeActEditPart) {
			return ((ValuePinInCallBeActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInCallBeActEditPart) {
			return ((ActionInputPinInCallBeActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInCallBeActEditPart) {
			return ((InputPinInCallBeActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OutputPinInCallBeActEditPart) {
			return ((OutputPinInCallBeActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CallOperationActionEditPart) {
			return ((CallOperationActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActEditPart) {
			return ((ActionInputPinInCallOpActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInCallOpActEditPart) {
			return ((ValuePinInCallOpActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInCallOpActEditPart) {
			return ((InputPinInCallOpActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OutputPinInCallOpActEditPart) {
			return ((OutputPinInCallOpActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			return ((ValuePinInCallOpActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			return ((ActionInputPinInCallOpActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			return ((InputPinInCallOpActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DecisionNodeEditPart) {
			return ((DecisionNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof MergeNodeEditPart) {
			return ((MergeNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ForkNodeEditPart) {
			return ((ForkNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof JoinNodeEditPart) {
			return ((JoinNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SendObjectActionEditPart) {
			return ((SendObjectActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			return ((ValuePinInSendObjActAsReqEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			return ((ActionInputPinInSendObjActAsReqEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			return ((InputPinInSendObjActAsReqEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			return ((ValuePinInSendObjActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			return ((ActionInputPinInSendObjActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			return ((InputPinInSendObjActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SendSignalActionEditPart) {
			return ((SendSignalActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActEditPart) {
			return ((ActionInputPinInSendSigActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInSendSigActEditPart) {
			return ((ValuePinInSendSigActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInSendSigActEditPart) {
			return ((InputPinInSendSigActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			return ((ValuePinInSendSigActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			return ((ActionInputPinInSendSigActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			return ((InputPinInSendSigActAsTargetEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActivityParameterNodeEditPart) {
			return ((ActivityParameterNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof AcceptEventActionEditPart) {
			return ((AcceptEventActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			return ((OutputPinInAcceptEventActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConditionalNodeEditPart) {
			return ((ConditionalNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExpansionRegionEditPart) {
			return ((ExpansionRegionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExpansionNodeAsInEditPart) {
			return ((ExpansionNodeAsInEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExpansionNodeAsOutEditPart) {
			return ((ExpansionNodeAsOutEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LoopNodeEditPart) {
			return ((LoopNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SequenceNodeEditPart) {
			return ((SequenceNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StructuredActivityNodeEditPart) {
			return ((StructuredActivityNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ValueSpecificationActionEditPart) {
			return ((ValueSpecificationActionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OutputPinInValSpecActEditPart) {
			return ((OutputPinInValSpecActEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataStoreNodeEditPart) {
			return ((DataStoreNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if(types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram)editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for(Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject)it.next();
			if(isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if(elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[])elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if(dialog.open() == Window.OK) {
			selected = (EObject)dialog.getFirstResult();
		}
		return selected;
	}
}
