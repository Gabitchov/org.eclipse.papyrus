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
package org.eclipse.papyrus.uml.alf.validation.typing;

public class DefaultDestructorFacade extends SignatureFacade {
	
	public DefaultDestructorFacade() {
		super() ;
	}
	
	@Override
	public String getName() {
		return "destroy";
	}

	@Override
	public boolean hasReturnType() {
		return true;
	}

	@Override
	public String getLabel() {
		return "destroy()" ;
	}

	@Override
	public boolean isAConstructor() {
		return false;
	}
	
	@Override
	public boolean isADestructor(){
		return true ;
	}
	
}
