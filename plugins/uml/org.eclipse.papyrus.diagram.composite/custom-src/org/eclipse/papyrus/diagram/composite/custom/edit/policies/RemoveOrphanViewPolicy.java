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

import org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.InterfaceCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.InterfaceCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPartCN;

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

	/**
	 * List of EditPart from Composite Structure Diagram for the RemoveOrphanViewPolicy
	 */
	public int[] notOrphanNode = { DataTypeAttributeCompartmentEditPart.VISUAL_ID,
			DataTypeOperationCompartmentEditPart.VISUAL_ID, DataTypeAttributeCompartmentEditPartCN.VISUAL_ID,
			DataTypeOperationCompartmentEditPartCN.VISUAL_ID, ClassAttributeCompartmentEditPart.VISUAL_ID,
			ClassOperationCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPart.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID,
			ActivityCompositeCompartmentEditPartCN.VISUAL_ID, InteractionCompositeCompartmentEditPartCN.VISUAL_ID,
			ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID,
			StateMachineCompositeCompartmentEditPartCN.VISUAL_ID,
			FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID,
			OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID, ComponentCompositeCompartmentEditPartCN.VISUAL_ID,
			DeviceCompositeCompartmentEditPartCN.VISUAL_ID,
			ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID, NodeCompositeCompartmentEditPartCN.VISUAL_ID,
			ClassCompositeCompartmentEditPartCN.VISUAL_ID, CollaborationCompositeCompartmentEditPartCN.VISUAL_ID,
			InterfaceCompartmentEditPartCN.VISUAL_ID, ActivityCompositeCompartmentEditPart.VISUAL_ID,
			InteractionCompositeCompartmentEditPart.VISUAL_ID,
			ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID,
			StateMachineCompositeCompartmentEditPart.VISUAL_ID, FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID,
			OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID, ComponentCompositeCompartmentEditPart.VISUAL_ID,
			DeviceCompositeCompartmentEditPart.VISUAL_ID, ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID,
			NodeCompositeCompartmentEditPart.VISUAL_ID, ClassCompositeCompartmentEditPart.VISUAL_ID,
			CollaborationCompositeCompartmentEditPart.VISUAL_ID, InterfaceCompartmentEditPart.VISUAL_ID,
			PropertyPartCompartmentEditPartCN.VISUAL_ID };

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode);
	}

}
