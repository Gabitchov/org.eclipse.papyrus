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
	 * <pre>
	 * 7033 : DataTypeAttributeCompartmentEditPart
	 * 7034 : DataTypeOperationCompartmentEditPart
	 * 7036 : DataTypeAttributeCompartmentEditPartCN
	 * 7037 : DataTypeOperationCompartmentEditPartCN
	 * 
	 * 7043 : ClassAttributeCompartmentEditPart
	 * 7044 : ClassOperationCompartmentEditPart
	 * 7045 : ClassNestedClassifierCompartmentEditPart
	 * 
	 * 7048 : EnumerationEnumerationLiteralCompartmentEditPart
	 * 7049 : EnumerationEnumerationLiteralCompartmentEditPartCN
	 * 
	 * 7050 : ActivityCompositeCompartmentEditPartCN
	 * 7051 : InteractionCompositeCompartmentEditPartCN
	 * 7052 : ProtocolStateMachineCompositeCompartmentEditPartCN
	 * 7053 : StateMachineCompositeCompartmentEditPartCN
	 * 7054 : FunctionBehaviorCompositeCompartmentEditPartCN
	 * 7055 : OpaqueBehaviorCompositeCompartmentEditPartCN
	 * 7056 : ComponentCompositeCompartmentEditPartCN
	 * 7057 : DeviceCompositeCompartmentEditPartCN
	 * 7058 : ExecutionEnvironmentCompositeCompartmentEditPartCN
	 * 7059 : NodeCompositeCompartmentEditPartCN
	 * 7060 : ClassCompositeCompartmentEditPartCN
	 * 7061 : CollaborationCompositeCompartmentEditPartCN
	 * 7062 : InterfaceCompartmentEditPartCN
	 * 
	 * 7063 : ActivityCompositeCompartmentEditPart
	 * 7064 : InteractionCompositeCompartmentEditPart
	 * 7065 : ProtocolStateMachineCompositeCompartmentEditPart
	 * 7066 : StateMachineCompositeCompartmentEditPart
	 * 7067 : FunctionBehaviorCompositeCompartmentEditPart
	 * 7068 : OpaqueBehaviorCompositeCompartmentEditPart
	 * 7069 : ComponentCompositeCompartmentEditPart
	 * 7070 : DeviceCompositeCompartmentEditPart
	 * 7071 : ExecutionEnvironmentCompositeCompartmentEditPart
	 * 7072 : NodeCompositeCompartmentEditPart
	 * 7073 : ClassCompositeCompartmentEditPart
	 * 7075 : CollaborationCompositeCompartmentEditPart
	 * 7076 : InterfaceCompartmentEditPart
	 * 7077 : PropertyPartCompartmentEditPartCN
	 * </pre>
	 */
	public int[] notOrphanNode = { 7033, 7034, 7036, 7037, 7043, 7044, 7045, 7048, 7049, 7050, 7051, 7052, 7053, 7054,
			7055, 7056, 7057, 7058, 7059, 7060, 7061, 7062, 7063, 7064, 7065, 7066, 7067, 7068, 7069, 7070, 7071, 7072,
			7073, 7075, 7076, 7077 };

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode);
	}

}
