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
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.uml2.uml.MultiplicityElement;

public class MultiplicityFacadeFactory {
	
	public static MultiplicityFacadeFactory eInstance = new MultiplicityFacadeFactory() ;

	public MultiplicityFacade createMultiplicityFacade(int lowerBound, int upperBound, boolean isUnique, boolean isOrdered) {
		MultiplicityFacade result = new MultiplicityFacade() ;
		result.setLowerBound(lowerBound) ;
		result.setUpperBound(upperBound) ;
		result.setIsUnique(isUnique) ;
		result.setIsOrdered(isOrdered) ;
		return result ;
	}
	
	public MultiplicityFacade createMultiplicityFacade(int upperBound) {
		if (upperBound == -1)
			return createMultiplicityFacade(0, upperBound, false, true) ;
		else 
			return createMultiplicityFacade(upperBound, upperBound, true, false) ;
	}

	public MultiplicityFacade createMultiplicityFacade() {
		return createMultiplicityFacade(1, 1, true, false) ;
	}
	
	public MultiplicityFacade createMultiplicityFacade(EObject multiplicityElement) {
		// To be overriden
		if (multiplicityElement instanceof MultiplicityElement) {
			MultiplicityElement m = (MultiplicityElement)multiplicityElement ;
			return createMultiplicityFacade(m.getLower(), m.getUpper(), m.isUnique(), m.isOrdered()) ;
		}
		else if (multiplicityElement instanceof LocalNameDeclarationStatement) {
			LocalNameDeclarationStatement statement = (LocalNameDeclarationStatement)multiplicityElement ;
			int lower = statement.isMultiplicityIndicator() ? 0 : 1 ;
			int upper = statement.isMultiplicityIndicator() ? -1 : 1 ;
			boolean isUnique = statement.isMultiplicityIndicator() ? false : true ;
			boolean isOrdered = statement.isMultiplicityIndicator() ? true : false ;
			return createMultiplicityFacade(lower, upper, isUnique, isOrdered) ;
		}
		else if (multiplicityElement instanceof LoopVariableDefinition) {
			// Correctly handled by the following return statement
		}
		return createMultiplicityFacade() ;
	}
	
}
