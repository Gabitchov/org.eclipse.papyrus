/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.operation.editor.xtext.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.validation.typing.AssignmentPolicy;
import org.eclipse.papyrus.operation.editor.xtext.operation.FormalParameter;
import org.eclipse.papyrus.operation.editor.xtext.operation.ParameterDirection;

public class OperationEditorAssignmentPolicy extends AssignmentPolicy {

	@Override
	public String isAssignable(EObject namedElement) {
		if (namedElement instanceof FormalParameter) {
			FormalParameter param = (FormalParameter)namedElement ;
			if (param.getDirection() == ParameterDirection.IN)
				return param.getName() + " is an input parameter. It cannot be the target of an assignment" ;
			else
				return "" ;
		}
		return super.isAssignable(namedElement);
	}
	
}
