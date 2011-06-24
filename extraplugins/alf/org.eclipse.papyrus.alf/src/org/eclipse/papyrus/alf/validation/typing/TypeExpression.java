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
	private TemplateBindingFacade binding ;
	
	public String getLabel() {
		String label = "" ;
		label += type.getLabel() ;
		if (binding != null)
			label += binding.getLabel() ;
		label += multiplicity.getLabel() ;
		return label ;
	}
	
	public TypeFacade getTypeFacade() {
		return type ;
	}
	
	public MultiplicityFacade getMultiplicityFacade() {
		return multiplicity ;
	}
	
	public TemplateBindingFacade getTemplateBindingFacade() {
		return binding ;
	}
	
	public int isCompatibleWithMe(TypeExpression t) {
		if (t == TypeUtils._nullExpression)
			return 3 ;
		int typeCompatibilityLevel = type.isCompatibleWithMe(t.type) ;
		if (typeCompatibilityLevel == 0)
			return 0 ;
		boolean isCompatible = multiplicity.isCompatibleWithMe(t.multiplicity) ;
		isCompatible &= 
				(binding != null ? binding.isCompatibleWithMe(t.binding) : true);
		if (isCompatible)
			return typeCompatibilityLevel ;
		else
			return 0 ;
	}

	public TypeFacade getType() {
		return type;
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

	public TemplateBindingFacade getBinding() {
		return binding;
	}

	public void setBinding(TemplateBindingFacade binding) {
		this.binding = binding;
	}

	public boolean isACollection() {
		return this.multiplicity.getUpperBound() == -1 || this.multiplicity.getUpperBound() > 1 ;
	}
	
	public boolean isOrdered() {
		return this.multiplicity.isOrdered() ;
	}
	
}
