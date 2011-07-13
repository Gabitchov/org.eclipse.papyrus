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

public class TypeExpression {

	private TypeFacade type ;
	private MultiplicityFacade multiplicity ;
	
	public String getLabel() {
		String label = "" ;
		label += type.getLabel() ;
		label += multiplicity.getLabel() ;
		return label ;
	}
	
	public TypeFacade getTypeFacade() {
		return type ;
	}
	
	public MultiplicityFacade getMultiplicityFacade() {
		return multiplicity ;
	}
	
	public int isCompatibleWithMe(TypeExpression t) {
		if (t == TypeUtils._nullExpression)
			return 3 ;
		int typeCompatibilityLevel = type.isCompatibleWithMe(t.type) ;
		if (typeCompatibilityLevel == 0)
			return 0 ;
		boolean isCompatible = multiplicity.isCompatibleWithMe(t.multiplicity) ;
		if (isCompatible)
			return typeCompatibilityLevel ;
		else
			return 0 ;
	}

	public void setType(TypeFacade type) {
		this.type = type;
	}

	public MultiplicityFacade getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(MultiplicityFacade multiplicity) {
		this.multiplicity = multiplicity;
	}

	public boolean isACollection() {
		boolean isACollection = 
			this.multiplicity.getUpperBound() == -1 || this.multiplicity.getUpperBound() > 1 ||
			this.type.isACollection();
			
		return isACollection ;
	}
	
	public boolean isOrdered() {
		return this.multiplicity.isOrdered() || this.type.isOrdered() ;
		// To be completed with collection classes
	}
	
}
