/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Adaptation for Composite Diagram

 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import java.util.ArrayList;

import org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.InterfaceCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.InterfaceCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeNameEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeNameEditPartCN;

/**
 * <pre>
 * This policy is used to suppress orphan node view in GMF view.
 * The policy to remove orphan connection is more complex. 
 * 
 * As this policy uses VisualID(s), this class obviously depends from
 * the diagram and may not be shared in Common plug-in.
 * 
 * See RemoveOrphanViewPolicy in Class Diagram
 * </pre>
 */
public class RemoveOrphanViewPolicy extends OrphanViewPolicy {

	protected ArrayList<Integer> notOrphanSemanticHint = new ArrayList<Integer>();

	/**
	 * List of EditPart from Composite Structure Diagram for the RemoveOrphanViewPolicy
	 */
	public int[] notOrphanNode = {

	/** DataType related EditParts */
	DataTypeAttributeCompartmentEditPart.VISUAL_ID, DataTypeOperationCompartmentEditPart.VISUAL_ID, DataTypeAttributeCompartmentEditPartCN.VISUAL_ID, DataTypeOperationCompartmentEditPartCN.VISUAL_ID,
	/** Class related EditParts */
	ClassAttributeCompartmentEditPart.VISUAL_ID, ClassOperationCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPart.VISUAL_ID,
	/** Enumeration related EditParts */
	EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID, EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID,
	/** Activity related EditParts */
	ActivityCompositeCompartmentEditPart.VISUAL_ID, ActivityCompositeCompartmentEditPartCN.VISUAL_ID, ActivityCompositeNameEditPart.VISUAL_ID, ActivityCompositeNameEditPartCN.VISUAL_ID,
	/** Interaction related EditParts */
	InteractionCompositeCompartmentEditPart.VISUAL_ID, InteractionCompositeCompartmentEditPartCN.VISUAL_ID, InteractionCompositeNameEditPart.VISUAL_ID, InteractionCompositeNameEditPartCN.VISUAL_ID,
	/** ProtocolStateMachine related EditParts */
	ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID, ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID, ProtocolStateMachineCompositeNameEditPart.VISUAL_ID, ProtocolStateMachineCompositeNameEditPartCN.VISUAL_ID,
	/** StateMachine related EditParts */
	StateMachineCompositeCompartmentEditPart.VISUAL_ID, StateMachineCompositeCompartmentEditPartCN.VISUAL_ID, StateMachineCompositeNameEditPart.VISUAL_ID, StateMachineCompositeNameEditPartCN.VISUAL_ID,
	/** FunctionBehavior related EditParts */
	FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID, FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID, FunctionBehaviorCompositeNameEditPart.VISUAL_ID, FunctionBehaviorCompositeNameEditPartCN.VISUAL_ID,
	/** OpaqueBehavior related EditParts */
	OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID, OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID, OpaqueBehaviorCompositeNameEditPart.VISUAL_ID, OpaqueBehaviorCompositeNameEditPartCN.VISUAL_ID,
	/** Component related EditParts */
	ComponentCompositeCompartmentEditPart.VISUAL_ID, ComponentCompositeCompartmentEditPartCN.VISUAL_ID, ComponentCompositeNameEditPart.VISUAL_ID, ComponentCompositeNameEditPartCN.VISUAL_ID,
	/** Device related EditParts */
	DeviceCompositeCompartmentEditPart.VISUAL_ID, DeviceCompositeCompartmentEditPartCN.VISUAL_ID, DeviceCompositeNameEditPart.VISUAL_ID, DeviceCompositeNameEditPartCN.VISUAL_ID,
	/** ExecutionEnvironment related EditParts */
	ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID, ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID, ExecutionEnvironmentCompositeNameEditPart.VISUAL_ID, ExecutionEnvironmentCompositeNameEditPartCN.VISUAL_ID,
	/** Node related EditParts */
	NodeCompositeCompartmentEditPart.VISUAL_ID, NodeCompositeCompartmentEditPartCN.VISUAL_ID, NodeCompositeNameEditPart.VISUAL_ID, NodeCompositeNameEditPartCN.VISUAL_ID,
	/** Class related EditParts */
	ClassCompositeCompartmentEditPart.VISUAL_ID, ClassCompositeCompartmentEditPartCN.VISUAL_ID, ClassCompositeNameEditPart.VISUAL_ID, ClassCompositeNameEditPartCN.VISUAL_ID,
	/** Collaboration related EditParts */
	CollaborationCompositeCompartmentEditPart.VISUAL_ID, CollaborationCompositeCompartmentEditPartCN.VISUAL_ID,
	/** Interface related EditParts */
	InterfaceCompartmentEditPart.VISUAL_ID, InterfaceCompartmentEditPartCN.VISUAL_ID,
	/** Property - Part related EditParts */
	PropertyPartCompartmentEditPartCN.VISUAL_ID, PropertyPartNameEditPartCN.VISUAL_ID };

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode);
	}
}
