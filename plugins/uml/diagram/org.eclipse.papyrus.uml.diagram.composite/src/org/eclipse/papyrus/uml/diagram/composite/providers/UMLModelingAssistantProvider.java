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
package org.eclipse.papyrus.uml.diagram.composite.providers;

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
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.composite.part.Messages;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof CompositeStructureDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(49);
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.Comment_2109);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			return types;
		}
		if(editPart instanceof ActivityCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof InteractionCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof ProtocolStateMachineCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof StateMachineCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof FunctionBehaviorCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof OpaqueBehaviorCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof ComponentCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof DeviceCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof NodeCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ClassCompositeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof EnumerationEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.EnumerationLiteral_3066);
			return types;
		}
		if(editPart instanceof DataTypeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3101);
			types.add(UMLElementTypes.Operation_3102);
			return types;
		}
		if(editPart instanceof PropertyPartEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ActivityCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof InteractionCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof StateMachineCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof FunctionBehaviorCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			return types;
		}
		if(editPart instanceof ComponentCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof DeviceCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof NodeCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ClassCompositeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof EnumerationEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.EnumerationLiteral_3066);
			return types;
		}
		if(editPart instanceof DataTypeEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3101);
			types.add(UMLElementTypes.Operation_3102);
			return types;
		}
		if(editPart instanceof ActivityCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof InteractionCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ProtocolStateMachineCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof StateMachineCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof FunctionBehaviorCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof OpaqueBehaviorCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ComponentCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof DeviceCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof NodeCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ClassCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			types.add(UMLElementTypes.Node_3121);
			return types;
		}
		if(editPart instanceof CollaborationCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(9);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ActivityCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof InteractionCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ProtocolStateMachineCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof StateMachineCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof FunctionBehaviorCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof OpaqueBehaviorCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(31);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ComponentCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof DeviceCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof NodeCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof ClassCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(30);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.Constraint_3120);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			return types;
		}
		if(editPart instanceof CollaborationCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(9);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Comment_3097);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
			return types;
		}
		if(editPart instanceof PropertyPartCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.Comment_3097);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActivityCompositeEditPart) {
			return ((ActivityCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionCompositeEditPart) {
			return ((InteractionCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			return ((ProtocolStateMachineCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPart) {
			return ((StateMachineCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPart) {
			return ((FunctionBehaviorCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			return ((OpaqueBehaviorCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentCompositeEditPart) {
			return ((ComponentCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeviceCompositeEditPart) {
			return ((DeviceCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			return ((ExecutionEnvironmentCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NodeCompositeEditPart) {
			return ((NodeCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ClassCompositeEditPart) {
			return ((ClassCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPart) {
			return ((CollaborationCompositeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InformationItemEditPart) {
			return ((InformationItemEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SignalEventEditPart) {
			return ((SignalEventEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CallEventEditPart) {
			return ((CallEventEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof AnyReceiveEventEditPart) {
			return ((AnyReceiveEventEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ChangeEventEditPart) {
			return ((ChangeEventEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeEventEditPart) {
			return ((TimeEventEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LiteralBooleanEditPart) {
			return ((LiteralBooleanEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LiteralIntegerEditPart) {
			return ((LiteralIntegerEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LiteralNullEditPart) {
			return ((LiteralNullEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LiteralStringEditPart) {
			return ((LiteralStringEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			return ((LiteralUnlimitedNaturalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StringExpressionEditPart) {
			return ((StringExpressionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OpaqueExpressionEditPart) {
			return ((OpaqueExpressionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeExpressionEditPart) {
			return ((TimeExpressionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExpressionEditPart) {
			return ((ExpressionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationEditPart) {
			return ((DurationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeIntervalEditPart) {
			return ((TimeIntervalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationIntervalEditPart) {
			return ((DurationIntervalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof IntervalEditPart) {
			return ((IntervalEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InstanceValueEditPart) {
			return ((InstanceValueEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof IntervalConstraintEditPart) {
			return ((IntervalConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionConstraintEditPart) {
			return ((InteractionConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ParameterEditPart) {
			return ((ParameterEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PropertyPartEditPartCN) {
			return ((PropertyPartEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CollaborationRoleEditPartCN) {
			return ((CollaborationRoleEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CollaborationUseEditPartCN) {
			return ((CollaborationUseEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActivityCompositeEditPartCN) {
			return ((ActivityCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionCompositeEditPartCN) {
			return ((InteractionCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			return ((ProtocolStateMachineCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPartCN) {
			return ((StateMachineCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			return ((FunctionBehaviorCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			return ((OpaqueBehaviorCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentCompositeEditPartCN) {
			return ((ComponentCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeviceCompositeEditPartCN) {
			return ((DeviceCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			return ((ExecutionEnvironmentCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NodeCompositeEditPartCN) {
			return ((NodeCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ClassCompositeEditPartCN) {
			return ((ClassCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPartCN) {
			return ((CollaborationCompositeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActorEditPartCN) {
			return ((ActorEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPartCN) {
			return ((DeploymentSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InformationItemEditPartCN) {
			return ((InformationItemEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseEditPartCN) {
			return ((UseCaseEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeConstraintEditPartCN) {
			return ((TimeConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof IntervalConstraintEditPartCN) {
			return ((IntervalConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionConstraintEditPartCN) {
			return ((InteractionConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			return ((ActivityCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			return ((InteractionCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			return ((ProtocolStateMachineCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StateMachineCompositeEditPart) {
			return ((StateMachineCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			return ((FunctionBehaviorCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			return ((OpaqueBehaviorCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			return ((ComponentCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			return ((DeviceCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			return ((ExecutionEnvironmentCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			return ((NodeCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			return ((ClassCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			return ((CollaborationCompositeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			return ((InformationItemEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			return ((SignalEventEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CallEventEditPart) {
			return ((CallEventEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			return ((AnyReceiveEventEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			return ((ChangeEventEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			return ((TimeEventEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			return ((LiteralBooleanEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			return ((LiteralIntegerEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			return ((LiteralNullEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			return ((LiteralStringEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			return ((LiteralUnlimitedNaturalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			return ((StringExpressionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			return ((OpaqueExpressionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			return ((TimeExpressionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			return ((ExpressionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationEditPart) {
			return ((DurationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			return ((TimeIntervalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			return ((DurationIntervalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof IntervalEditPart) {
			return ((IntervalEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			return ((InstanceValueEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			return ((IntervalConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			return ((InteractionConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PortEditPart) {
			return ((PortEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ParameterEditPart) {
			return ((ParameterEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			return ((PropertyPartEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			return ((CollaborationRoleEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			return ((CollaborationUseEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			return ((ActivityCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			return ((InteractionCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			return ((ProtocolStateMachineCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			return ((StateMachineCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			return ((FunctionBehaviorCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			return ((OpaqueBehaviorCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			return ((ComponentCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			return ((DeviceCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			return ((ExecutionEnvironmentCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			return ((NodeCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			return ((ClassCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			return ((CollaborationCompositeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			return ((ActorEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			return ((DeploymentSpecificationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			return ((InformationItemEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			return ((UseCaseEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			return ((TimeConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			return ((IntervalConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			return ((InteractionConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActivityCompositeEditPart) {
			return ((ActivityCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionCompositeEditPart) {
			return ((InteractionCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			return ((ProtocolStateMachineCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPart) {
			return ((StateMachineCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPart) {
			return ((FunctionBehaviorCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			return ((OpaqueBehaviorCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentCompositeEditPart) {
			return ((ComponentCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeviceCompositeEditPart) {
			return ((DeviceCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			return ((ExecutionEnvironmentCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NodeCompositeEditPart) {
			return ((NodeCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ClassCompositeEditPart) {
			return ((ClassCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPart) {
			return ((CollaborationCompositeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InformationItemEditPart) {
			return ((InformationItemEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SignalEventEditPart) {
			return ((SignalEventEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CallEventEditPart) {
			return ((CallEventEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof AnyReceiveEventEditPart) {
			return ((AnyReceiveEventEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ChangeEventEditPart) {
			return ((ChangeEventEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeEventEditPart) {
			return ((TimeEventEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LiteralBooleanEditPart) {
			return ((LiteralBooleanEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LiteralIntegerEditPart) {
			return ((LiteralIntegerEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LiteralNullEditPart) {
			return ((LiteralNullEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LiteralStringEditPart) {
			return ((LiteralStringEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			return ((LiteralUnlimitedNaturalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StringExpressionEditPart) {
			return ((StringExpressionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OpaqueExpressionEditPart) {
			return ((OpaqueExpressionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeExpressionEditPart) {
			return ((TimeExpressionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExpressionEditPart) {
			return ((ExpressionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationEditPart) {
			return ((DurationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeIntervalEditPart) {
			return ((TimeIntervalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationIntervalEditPart) {
			return ((DurationIntervalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof IntervalEditPart) {
			return ((IntervalEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InstanceValueEditPart) {
			return ((InstanceValueEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof IntervalConstraintEditPart) {
			return ((IntervalConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionConstraintEditPart) {
			return ((InteractionConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ParameterEditPart) {
			return ((ParameterEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PropertyPartEditPartCN) {
			return ((PropertyPartEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CollaborationRoleEditPartCN) {
			return ((CollaborationRoleEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CollaborationUseEditPartCN) {
			return ((CollaborationUseEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActivityCompositeEditPartCN) {
			return ((ActivityCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionCompositeEditPartCN) {
			return ((InteractionCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			return ((ProtocolStateMachineCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPartCN) {
			return ((StateMachineCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			return ((FunctionBehaviorCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			return ((OpaqueBehaviorCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentCompositeEditPartCN) {
			return ((ComponentCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeviceCompositeEditPartCN) {
			return ((DeviceCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			return ((ExecutionEnvironmentCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NodeCompositeEditPartCN) {
			return ((NodeCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ClassCompositeEditPartCN) {
			return ((ClassCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPartCN) {
			return ((CollaborationCompositeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActorEditPartCN) {
			return ((ActorEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPartCN) {
			return ((DeploymentSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InformationItemEditPartCN) {
			return ((InformationItemEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseEditPartCN) {
			return ((UseCaseEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeConstraintEditPartCN) {
			return ((TimeConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof IntervalConstraintEditPartCN) {
			return ((IntervalConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionConstraintEditPartCN) {
			return ((InteractionConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			return ((ActivityCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			return ((InteractionCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			return ((ProtocolStateMachineCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPart) {
			return ((StateMachineCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			return ((FunctionBehaviorCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			return ((OpaqueBehaviorCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			return ((ComponentCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			return ((DeviceCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			return ((ExecutionEnvironmentCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			return ((NodeCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			return ((ClassCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			return ((CollaborationCompositeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			return ((InformationItemEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			return ((SignalEventEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			return ((CallEventEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			return ((AnyReceiveEventEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			return ((ChangeEventEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			return ((TimeEventEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			return ((LiteralBooleanEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			return ((LiteralIntegerEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			return ((LiteralNullEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			return ((LiteralStringEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			return ((LiteralUnlimitedNaturalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			return ((StringExpressionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			return ((OpaqueExpressionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			return ((TimeExpressionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			return ((ExpressionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationEditPart) {
			return ((DurationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			return ((TimeIntervalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			return ((DurationIntervalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			return ((IntervalEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			return ((InstanceValueEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			return ((IntervalConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			return ((InteractionConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PortEditPart) {
			return ((PortEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			return ((ParameterEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			return ((PropertyPartEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			return ((CollaborationRoleEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			return ((CollaborationUseEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			return ((ActivityCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			return ((InteractionCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			return ((ProtocolStateMachineCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			return ((StateMachineCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			return ((FunctionBehaviorCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			return ((OpaqueBehaviorCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			return ((ComponentCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			return ((DeviceCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			return ((ExecutionEnvironmentCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			return ((NodeCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			return ((ClassCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			return ((CollaborationCompositeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			return ((ActorEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			return ((DeploymentSpecificationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			return ((InformationItemEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			return ((UseCaseEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			return ((TimeConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			return ((IntervalConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			return ((InteractionConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActivityCompositeEditPart) {
			return ((ActivityCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionCompositeEditPart) {
			return ((InteractionCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			return ((ProtocolStateMachineCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPart) {
			return ((StateMachineCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPart) {
			return ((FunctionBehaviorCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			return ((OpaqueBehaviorCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentCompositeEditPart) {
			return ((ComponentCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeviceCompositeEditPart) {
			return ((DeviceCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			return ((ExecutionEnvironmentCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NodeCompositeEditPart) {
			return ((NodeCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ClassCompositeEditPart) {
			return ((ClassCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPart) {
			return ((CollaborationCompositeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPart) {
			return ((PrimitiveTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPart) {
			return ((DataTypeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InformationItemEditPart) {
			return ((InformationItemEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SignalEditPart) {
			return ((SignalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SignalEventEditPart) {
			return ((SignalEventEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CallEventEditPart) {
			return ((CallEventEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof AnyReceiveEventEditPart) {
			return ((AnyReceiveEventEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ChangeEventEditPart) {
			return ((ChangeEventEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeEventEditPart) {
			return ((TimeEventEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LiteralBooleanEditPart) {
			return ((LiteralBooleanEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LiteralIntegerEditPart) {
			return ((LiteralIntegerEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LiteralNullEditPart) {
			return ((LiteralNullEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LiteralStringEditPart) {
			return ((LiteralStringEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			return ((LiteralUnlimitedNaturalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StringExpressionEditPart) {
			return ((StringExpressionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OpaqueExpressionEditPart) {
			return ((OpaqueExpressionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeExpressionEditPart) {
			return ((TimeExpressionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExpressionEditPart) {
			return ((ExpressionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationEditPart) {
			return ((DurationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeIntervalEditPart) {
			return ((TimeIntervalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationIntervalEditPart) {
			return ((DurationIntervalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof IntervalEditPart) {
			return ((IntervalEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InstanceValueEditPart) {
			return ((InstanceValueEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof IntervalConstraintEditPart) {
			return ((IntervalConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionConstraintEditPart) {
			return ((InteractionConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ParameterEditPart) {
			return ((ParameterEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PropertyPartEditPartCN) {
			return ((PropertyPartEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CollaborationRoleEditPartCN) {
			return ((CollaborationRoleEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CollaborationUseEditPartCN) {
			return ((CollaborationUseEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActivityCompositeEditPartCN) {
			return ((ActivityCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionCompositeEditPartCN) {
			return ((InteractionCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			return ((ProtocolStateMachineCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StateMachineCompositeEditPartCN) {
			return ((StateMachineCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			return ((FunctionBehaviorCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			return ((OpaqueBehaviorCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentCompositeEditPartCN) {
			return ((ComponentCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeviceCompositeEditPartCN) {
			return ((DeviceCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			return ((ExecutionEnvironmentCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NodeCompositeEditPartCN) {
			return ((NodeCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ClassCompositeEditPartCN) {
			return ((ClassCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CollaborationCompositeEditPartCN) {
			return ((CollaborationCompositeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPartCN) {
			return ((InterfaceEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PrimitiveTypeEditPartCN) {
			return ((PrimitiveTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof EnumerationEditPartCN) {
			return ((EnumerationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DataTypeEditPartCN) {
			return ((DataTypeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActorEditPartCN) {
			return ((ActorEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeploymentSpecificationEditPartCN) {
			return ((DeploymentSpecificationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InformationItemEditPartCN) {
			return ((InformationItemEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SignalEditPartCN) {
			return ((SignalEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseEditPartCN) {
			return ((UseCaseEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeConstraintEditPartCN) {
			return ((TimeConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof IntervalConstraintEditPartCN) {
			return ((IntervalConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionConstraintEditPartCN) {
			return ((InteractionConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
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
		HashSet<EObject> elements = new HashSet<EObject>();
		for(Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
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
