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
package org.eclipse.papyrus.alf.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AcceptStatement;
import org.eclipse.papyrus.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.uml2.uml.Property;

public class AssignmentPolicy {

	public static AssignmentPolicy eInstance = new AssignmentPolicy() ;

	public String isAssignable(EObject namedElement) {
		String commonSuffix = " cannot be the target of an assignment" ;
		if (namedElement instanceof Property) {
			Property property = (Property)namedElement ;
			if (property.isReadOnly())
				return "A read-only property" + commonSuffix ;
			else
				return "";
		}
		else if (namedElement instanceof LocalNameDeclarationStatement) {
			return "" ;
		}
		else if (namedElement instanceof InvocationOrAssignementOrDeclarationStatement) {
			return "" ;
		}
		else if (namedElement instanceof LoopVariableDefinition) {
			return "A local loop variable" + commonSuffix ;
		}
		else if (namedElement instanceof AcceptClause) {
			return "A local accept variable" + commonSuffix ;
		}
		else if (namedElement instanceof AcceptStatement) {
			return "A local accept variable" + commonSuffix ;
		}
		return "Could not determine if the element is assignable";
	}
}
