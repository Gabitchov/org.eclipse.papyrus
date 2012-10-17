/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeUtils;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart;

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
		else if (typeObject instanceof TypePart) {
			if (((TypePart)typeObject).getTypeName().getQualifiedName() == null)
				return TypeUtils._undefined ;
			return TypeFacadeFactory.eInstance.createVoidFacade(((TypePart)typeObject).getTypeName().getQualifiedName()) ;
		}
		else
			return super.createTypeFacade(typeObject);
	}
	
}
