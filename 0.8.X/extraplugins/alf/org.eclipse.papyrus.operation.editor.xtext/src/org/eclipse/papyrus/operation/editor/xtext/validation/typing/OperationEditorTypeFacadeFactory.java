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
import org.eclipse.papyrus.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.alf.alf.NameExpression;
import org.eclipse.papyrus.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.alf.validation.typing.TypeUtils;
import org.eclipse.papyrus.operation.editor.xtext.operation.FormalParameter;

public class OperationEditorTypeFacadeFactory extends TypeFacadeFactory {

	public TypeFacade createTypeFacade(EObject typeObject) {
		if (typeObject instanceof InvocationOrAssignementOrDeclarationStatement) {
			InvocationOrAssignementOrDeclarationStatement statement = 
				(InvocationOrAssignementOrDeclarationStatement) typeObject ;
			NameExpression typePart = statement.getTypePart_OR_assignedPart_OR_invocationPart() ;
			TypeFacade cddVoidFacade = TypeFacadeFactory.eInstance.createVoidFacade(typePart) ;
			return cddVoidFacade ;
		}
		else if (typeObject instanceof FormalParameter) {
			FormalParameter param = (FormalParameter)typeObject ;
			if (param.getType() == null)
				return TypeUtils._undefined ;
			if (param.getType().getTypeName() == null)
				return TypeUtils._undefined ;
			if (param.getType().getTypeName().getQualifiedName() == null)
				return TypeUtils._undefined ;
			return TypeFacadeFactory.eInstance.createVoidFacade(param.getType().getTypeName().getQualifiedName()) ;
		}
		else
			return super.createTypeFacade(typeObject);
	}
	
}
