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
package org.eclipse.papyrus.uml.diagram.activity.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if(element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem)element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if(element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}
		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3065); //$NON-NLS-1$
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?ExceptionHandler", UMLElementTypes.ExceptionHandler_4005); //$NON-NLS-1$
		case JoinNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3041); //$NON-NLS-1$
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3050); //$NON-NLS-1$
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3013); //$NON-NLS-1$
		case LoopNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?LoopNode", UMLElementTypes.LoopNode_3071); //$NON-NLS-1$
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3022); //$NON-NLS-1$
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?IntervalConstraint", UMLElementTypes.IntervalConstraint_3033); //$NON-NLS-1$
		case ActivityPartitionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActivityPartition", UMLElementTypes.ActivityPartition_3067); //$NON-NLS-1$
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3062); //$NON-NLS-1$
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3096); //$NON-NLS-1$
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3094); //$NON-NLS-1$
		case DataStoreNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3078); //$NON-NLS-1$
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3077); //$NON-NLS-1$
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DurationConstraint", UMLElementTypes.DurationConstraint_3035); //$NON-NLS-1$
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3093); //$NON-NLS-1$
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?NamedElement", UMLElementTypes.NamedElement_3085); //$NON-NLS-1$
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InterruptibleActivityRegion", UMLElementTypes.InterruptibleActivityRegion_3068); //$NON-NLS-1$
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?AddVariableValueAction", UMLElementTypes.AddVariableValueAction_3099); //$NON-NLS-1$
		case ActivityEditPartCN.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Activity", UMLElementTypes.Activity_3083); //$NON-NLS-1$
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3089); //$NON-NLS-1$
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3064); //$NON-NLS-1$
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3017); //$NON-NLS-1$
		case CommentEditPartCN.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Comment", UMLElementTypes.Comment_3080); //$NON-NLS-1$
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3092); //$NON-NLS-1$
		case CallOperationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3010); //$NON-NLS-1$
		case MergeNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?MergeNode", UMLElementTypes.MergeNode_3039); //$NON-NLS-1$
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3047); //$NON-NLS-1$
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3053); //$NON-NLS-1$
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3024); //$NON-NLS-1$
		case CreateObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3086); //$NON-NLS-1$
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3020); //$NON-NLS-1$
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Constraint", UMLElementTypes.Constraint_3003); //$NON-NLS-1$
		case AcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3063); //$NON-NLS-1$
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Constraint", UMLElementTypes.Constraint_3012); //$NON-NLS-1$
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3055); //$NON-NLS-1$
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3046); //$NON-NLS-1$
		case DecisionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3038); //$NON-NLS-1$
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3060); //$NON-NLS-1$
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3015); //$NON-NLS-1$
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?BroadcastSignalAction", UMLElementTypes.BroadcastSignalAction_3102); //$NON-NLS-1$
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3014); //$NON-NLS-1$
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ExpansionNode", UMLElementTypes.ExpansionNode_3075); //$NON-NLS-1$
		case ControlFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?ControlFlow", UMLElementTypes.ControlFlow_4004); //$NON-NLS-1$
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?TimeConstraint", UMLElementTypes.TimeConstraint_3036); //$NON-NLS-1$
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3019); //$NON-NLS-1$
		case OpaqueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3007); //$NON-NLS-1$
		case ForkNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3040); //$NON-NLS-1$
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DestroyObjectAction", UMLElementTypes.DestroyObjectAction_3095); //$NON-NLS-1$
		case ActivityEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/4.0.0/UML?Activity", UMLElementTypes.Activity_2001); //$NON-NLS-1$
		case ReadSelfActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ReadSelfAction", UMLElementTypes.ReadSelfAction_3081); //$NON-NLS-1$
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3018); //$NON-NLS-1$
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3021); //$NON-NLS-1$
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3008); //$NON-NLS-1$
		case SequenceNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?SequenceNode", UMLElementTypes.SequenceNode_3073); //$NON-NLS-1$
		case ReadVariableActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ReadVariableAction", UMLElementTypes.ReadVariableAction_3097); //$NON-NLS-1$
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3087); //$NON-NLS-1$
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3084); //$NON-NLS-1$
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActivityParameterNode", UMLElementTypes.ActivityParameterNode_3059); //$NON-NLS-1$
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3027); //$NON-NLS-1$
		case SendObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?SendObjectAction", UMLElementTypes.SendObjectAction_3042); //$NON-NLS-1$
		case CommentLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4006); //$NON-NLS-1$
		case ActivityDiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/4.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Action?localPostcondition", UMLElementTypes.ActionLocalPostcondition_4002); //$NON-NLS-1$
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?Action?localPrecondition", UMLElementTypes.ActionLocalPrecondition_4001); //$NON-NLS-1$
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3049); //$NON-NLS-1$
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3005); //$NON-NLS-1$
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3104); //$NON-NLS-1$
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ReadStructuralFeatureAction", UMLElementTypes.ReadStructuralFeatureAction_3088); //$NON-NLS-1$
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3016); //$NON-NLS-1$
		case SendSignalActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?SendSignalAction", UMLElementTypes.SendSignalAction_3052); //$NON-NLS-1$
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Constraint", UMLElementTypes.Constraint_3011); //$NON-NLS-1$
		case ObjectFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/4.0.0/UML?ObjectFlow", UMLElementTypes.ObjectFlow_4003); //$NON-NLS-1$
		case ConditionalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ConditionalNode", UMLElementTypes.ConditionalNode_3069); //$NON-NLS-1$
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3101); //$NON-NLS-1$
		case ParameterEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Parameter", UMLElementTypes.Parameter_3001); //$NON-NLS-1$
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3100); //$NON-NLS-1$
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3098); //$NON-NLS-1$
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3091); //$NON-NLS-1$
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3025); //$NON-NLS-1$
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3051); //$NON-NLS-1$
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?DurationConstraint", UMLElementTypes.DurationConstraint_3034); //$NON-NLS-1$
		case ExpansionRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ExpansionRegion", UMLElementTypes.ExpansionRegion_3070); //$NON-NLS-1$
		case InitialNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InitialNode", UMLElementTypes.InitialNode_3004); //$NON-NLS-1$
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValueSpecificationAction", UMLElementTypes.ValueSpecificationAction_3076); //$NON-NLS-1$
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ExpansionNode", UMLElementTypes.ExpansionNode_3074); //$NON-NLS-1$
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3048); //$NON-NLS-1$
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3026); //$NON-NLS-1$
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?Constraint", UMLElementTypes.Constraint_3002); //$NON-NLS-1$
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3103); //$NON-NLS-1$
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?TimeConstraint", UMLElementTypes.TimeConstraint_3037); //$NON-NLS-1$
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ValuePin", UMLElementTypes.ValuePin_3054); //$NON-NLS-1$
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?InputPin", UMLElementTypes.InputPin_3023); //$NON-NLS-1$
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?IntervalConstraint", UMLElementTypes.IntervalConstraint_3032); //$NON-NLS-1$
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3090); //$NON-NLS-1$
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3006); //$NON-NLS-1$
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/4.0.0/UML?ActionInputPin", UMLElementTypes.ActionInputPin_3061); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if(image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}
		if(image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if(element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)element;
			return group.getGroupName();
		}
		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if(view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3065Text(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005Text(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3041Text(view);
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3050Text(view);
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return getInputPin_3013Text(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3071Text(view);
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return getValuePin_3022Text(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033Text(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3067Text(view);
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3062Text(view);
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return getInputPin_3096Text(view);
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3094Text(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3078Text(view);
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return getOutputPin_3077Text(view);
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getDurationConstraint_3035Text(view);
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3093Text(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3085Text(view);
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return getInterruptibleActivityRegion_3068Text(view);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getAddVariableValueAction_3099Text(view);
		case ActivityEditPartCN.VISUAL_ID:
			return getActivity_3083Text(view);
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return getInputPin_3089Text(view);
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return getOutputPin_3064Text(view);
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return getValuePin_3017Text(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3080Text(view);
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return getInputPin_3092Text(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010Text(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3039Text(view);
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getActionInputPin_3047Text(view);
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return getActionInputPin_3053Text(view);
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return getOutputPin_3024Text(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3086Text(view);
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return getOutputPin_3020Text(view);
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getConstraint_3003Text(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3063Text(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012Text(view);
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return getInputPin_3055Text(view);
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return getValuePin_3046Text(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3038Text(view);
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3060Text(view);
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return getValuePin_3015Text(view);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getBroadcastSignalAction_3102Text(view);
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return getOutputPin_3014Text(view);
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return getExpansionNode_3075Text(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004Text(view);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getTimeConstraint_3036Text(view);
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return getInputPin_3019Text(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007Text(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3040Text(view);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getDestroyObjectAction_3095Text(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001Text(view);
		case ReadSelfActionEditPart.VISUAL_ID:
			return getReadSelfAction_3081Text(view);
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return getActionInputPin_3018Text(view);
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return getActionInputPin_3021Text(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008Text(view);
		case SequenceNodeEditPart.VISUAL_ID:
			return getSequenceNode_3073Text(view);
		case ReadVariableActionEditPart.VISUAL_ID:
			return getReadVariableAction_3097Text(view);
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3087Text(view);
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return getOutputPin_3084Text(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3059Text(view);
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3027Text(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_3042Text(view);
		case CommentLinkEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4006Text(view);
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getActionLocalPostcondition_4002Text(view);
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getActionLocalPrecondition_4001Text(view);
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3049Text(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005Text(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3104Text(view);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getReadStructuralFeatureAction_3088Text(view);
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return getActionInputPin_3016Text(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3052Text(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011Text(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003Text(view);
		case ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3069Text(view);
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3101Text(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001Text(view);
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return getInputPin_3100Text(view);
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3098Text(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3091Text(view);
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3025Text(view);
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3051Text(view);
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getDurationConstraint_3034Text(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3070Text(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004Text(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3076Text(view);
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return getExpansionNode_3074Text(view);
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getInputPin_3048Text(view);
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3026Text(view);
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getConstraint_3002Text(view);
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return getInputPin_3103Text(view);
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getTimeConstraint_3037Text(view);
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return getValuePin_3054Text(view);
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return getInputPin_3023Text(view);
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032Text(view);
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return getOutputPin_3090Text(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006Text(view);
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3061Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivity_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Activity_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getParameter_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Parameter_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintInActivityAsPrecondEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintInActivityAsPostcondEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitialNode_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InitialNode_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InitialNodeAppliedStereotypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5080); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivity_3083Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Activity_3083, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActivityNameEditPartCN.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5142); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3087Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3087, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5146); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3090Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3090, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5151); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityFinalNode_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActivityFinalNodeAppliedStereotypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5081); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3092Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3092, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5154); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.FlowFinalNode_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(FlowFinalNodeAppliedStereotypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5082); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OpaqueAction_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddVariableValueAction_3099Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AddVariableValueAction_3099, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AddVariableValueActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5171); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallBehaviorAction_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInCBActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3089Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3089, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5149); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInCBActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInCBActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3020Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3020, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInCBActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3010Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallOperationAction_3010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CallOperationActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3021Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3021, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInCOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3022Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3022, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInCOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3103Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3103, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5172); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3023Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3023, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInCOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3098Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3098, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5164); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3084Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3084, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInReadSelfActionLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5144); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3024Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3024, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInCOActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3025Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3025, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3026Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3026, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3027Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3027, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInCOActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3094Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3094, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultLabel3EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5158); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_3080Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_3080, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5138); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3096Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3096, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5161); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3038Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DecisionNode_3038, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DecisionInputEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMergeNode_3039Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.MergeNode_3039, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MergeNodeAppliedStereotypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5099); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3104Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CentralBufferNode_3104, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CentralBufferNodeLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5176); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3040Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ForkNode_3040, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ForkNodeAppliedStereotypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5100); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3041Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.JoinNode_3041, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(JoinSpecEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSendObjectAction_3042Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.SendObjectAction_3042, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SendObjectActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5059); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3046Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3046, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5049); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getReadSelfAction_3081Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ReadSelfAction_3081, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ReadSelfActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5139); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3047Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3047, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5051); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getReadVariableAction_3097Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ReadVariableAction_3097, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ReadVariableActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5166); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3048Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3048, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5053); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3049Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3049, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5054); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3050Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3050, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5056); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3051Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3051, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5058); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3091Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AddStructuralFeatureValueAction_3091, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5160); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSendSignalAction_3052Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.SendSignalAction_3052, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SendSignalActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5060); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3053Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3053, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5061); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3054Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3054, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInSendSigActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5063); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getReadStructuralFeatureAction_3088Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ReadStructuralFeatureAction_3088, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ReadStructuralFeatureActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5153); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3055Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3055, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInSendSigActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5065); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValuePin_3060Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValuePin_3060, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5072); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3093Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3093, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueLabel2EditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5156); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionInputPin_3061Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionInputPin_3061, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3062Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3062, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5076); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityParameterNode_3059Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityParameterNode_3059, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ParameterNodeNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5071); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3063Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3063, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(AcceptEventActionLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5078); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3086Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CreateObjectAction_3086, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CreateObjectActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5148); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3064Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3064, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5077); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDestroyObjectAction_3095Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DestroyObjectAction_3095, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DestroyObjectActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5163); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3065Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StructuredActivityNode_3065, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(StructuredActivityNodeKeywordEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5117); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityPartition_3067Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityPartition_3067, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActivityPartitionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5118); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterruptibleActivityRegion_3068Text(View view) {
		InterruptibleActivityRegion domainModelElement = (InterruptibleActivityRegion)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3068); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValueSpecificationAction_3076Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValueSpecificationAction_3076, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ValueSpecificationActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5126); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3077Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3077, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OutputPinInValSpecActLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5124); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3078Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataStoreNode_3078, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DataStoreNodeLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5127); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalNode_3069Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConditionalNode_3069, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConditionalNodeKeywordEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5119); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionRegion_3070Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExpansionRegion_3070, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExpansionRegionKeywordEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5120); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionNode_3074Text(View view) {
		ExpansionNode domainModelElement = (ExpansionNode)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3100Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3100, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5167); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionNode_3075Text(View view) {
		ExpansionNode domainModelElement = (ExpansionNode)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3075); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBroadcastSignalAction_3102Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.BroadcastSignalAction_3102, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(BroadcastSignalActionNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5175); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoopNode_3071Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LoopNode_3071, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(LoopNodeKeywordEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5121); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSequenceNode_3073Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.SequenceNode_3073, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SequenceNodeKeywordEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5123); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIntervalConstraint_3032Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.IntervalConstraint_3032, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIntervalConstraint_3033Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.IntervalConstraint_3033, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_3034Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_3034, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_3035Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_3035, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeConstraint_3036Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeConstraint_3036, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeConstraint_3037Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeConstraint_3037, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionLocalPrecondition_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getNamedElement_3085Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.NamedElement_3085, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ShapeNamedElementNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5129); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionLocalPostcondition_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getObjectFlow_4003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ObjectFlow_4003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ObjectFlowNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getControlFlow_4004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ControlFlow_4004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ControlFlowNameEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExceptionHandler_4005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExceptionHandler_4005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExceptionHandlerTypeEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3101Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3101, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5169); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ActivityDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}
}
