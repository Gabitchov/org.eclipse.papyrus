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

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

public class DefaultConstructorFacade extends SignatureFacade {

	private Class classToBeConstructed ;
	private DataType datatypeToBeConstructed ;
	
	public DefaultConstructorFacade(Class c) {
		super(c) ;
		this.classToBeConstructed = c ;
		this.setReturnType(TypeExpressionFactory.eInstance.createTypeExpression(c)) ;
	}

	public DefaultConstructorFacade(DataType d) {
		super(d) ;
		this.datatypeToBeConstructed = d ;
		for (Property p : d.getAllAttributes()) {
			TypeExpression typeOfArgument = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
			parameters.add(TypeExpressionFactory.eInstance.createTypeExpression(p)) ;
			parametersMap.put(p.getName(), typeOfArgument) ;
		}
		this.setReturnType(TypeExpressionFactory.eInstance.createTypeExpression(d)) ;
	}
	
	@Override
	public String getName() {
		return classToBeConstructed.getName();
	}

	@Override
	public boolean hasReturnType() {
		return true;
	}

	@Override
	public String getLabel() {
		String label = classToBeConstructed != null ? classToBeConstructed.getName() : datatypeToBeConstructed.getName() ;
		label += "(" ;
		boolean first = true ;
		for (TypeExpression t : parameters) {
			if (first) first = false ; else label += ", " ;
			label += t.getLabel() ;
		}
		label += ") : " + this.getReturnType().getLabel() ;
		return label ;
	}

	@Override
	public boolean isAConstructor() {
		return true;
	}
	
	@Override
	public boolean isADestructor(){
		return false ;
	}
}
