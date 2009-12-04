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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.commands.ActivityCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ClassCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.CollaborationCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.DataTypeCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.EnumerationCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.FunctionBehaviorCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.InteractionCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.InterfaceCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.OpaqueBehaviorCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.PrimitiveTypeCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ProtocolStateMachineCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.edit.commands.StateMachineCreateCommandCLN;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class ClassNestedClassifierCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassNestedClassifierCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2074);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Activity_3103 == req.getElementType()) {
			return getGEFWrapper(new ActivityCreateCommandCLN(req));
		}
		if(UMLElementTypes.Interaction_3104 == req.getElementType()) {
			return getGEFWrapper(new InteractionCreateCommandCLN(req));
		}
		if(UMLElementTypes.ProtocolStateMachine_3105 == req.getElementType()) {
			return getGEFWrapper(new ProtocolStateMachineCreateCommandCLN(req));
		}
		if(UMLElementTypes.StateMachine_3106 == req.getElementType()) {
			return getGEFWrapper(new StateMachineCreateCommandCLN(req));
		}
		if(UMLElementTypes.FunctionBehavior_3107 == req.getElementType()) {
			return getGEFWrapper(new FunctionBehaviorCreateCommandCLN(req));
		}
		if(UMLElementTypes.OpaqueBehavior_3108 == req.getElementType()) {
			return getGEFWrapper(new OpaqueBehaviorCreateCommandCLN(req));
		}
		if(UMLElementTypes.Collaboration_3109 == req.getElementType()) {
			return getGEFWrapper(new CollaborationCreateCommandCLN(req));
		}
		if(UMLElementTypes.Interface_3110 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommandCLN(req));
		}
		if(UMLElementTypes.Enumeration_3111 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommandCLN(req));
		}
		if(UMLElementTypes.PrimitiveType_3112 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommandCLN(req));
		}
		if(UMLElementTypes.DataType_3113 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommandCLN(req));
		}
		if(UMLElementTypes.Class_3114 == req.getElementType()) {
			return getGEFWrapper(new ClassCreateCommandCLN(req));
		}
		return super.getCreateCommand(req);
	}

}
