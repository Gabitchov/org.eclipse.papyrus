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

public class TypeExpressionFactory {

	public static TypeExpressionFactory eInstance = new TypeExpressionFactory() ;
	
	public TypeExpression createTypeExpression(EObject typeExpressionSource) {
		TypeExpression result = new TypeExpression() ;
		result.setType(TypeFacadeFactory.eInstance.createTypeFacade(typeExpressionSource)) ;
		result.setMultiplicity(MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(typeExpressionSource)) ;
		return result ;
	}
	
	public TypeExpression createTypeExpression(TypeFacade type) {
		TypeExpression result = new TypeExpression() ;
		result.setType(type) ;
		result.setMultiplicity (MultiplicityFacadeFactory.eInstance.createMultiplicityFacade()) ;
		return result ;
	}
	
	public TypeExpression createTypeExpression(TypeFacade type, int lowerBound, int upperBound, boolean isUnique, boolean isOrdered) {
		TypeExpression result = new TypeExpression() ;
		result.setType(type) ;
		result.setMultiplicity (MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(lowerBound, upperBound, isUnique, isOrdered)) ;
		return result ;
	}
	
}
